package cn.jbone.cms.portal.ui;

import cn.jbone.cms.api.AdvertisementApi;
import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.dataobject.AdvertisementDO;
import cn.jbone.cms.common.dataobject.search.AdvertisementSearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IOpenElementTag;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring5.context.SpringContextUtils;
import org.thymeleaf.templatemode.TemplateMode;
import org.unbescape.html.HtmlEscape;

import java.util.List;

public class AdvertisementElementTagProcessor extends AbstractElementTagProcessor {

    private static final String TAG_NAME = "advertisement";
    private static final int PRECEDENCE = 1000;

    public AdvertisementElementTagProcessor(final String dialectPrefix){
        super(
                TemplateMode.HTML, // This processor will apply only to HTML mode
                dialectPrefix,     // Prefix to be applied to name for matching
                TAG_NAME,          // Tag name: match specifically this tag
                true,              // Apply dialect prefix to tag name
                null,              // No attribute name: will match by tag name
                false,             // No prefix to be applied to attribute name
                PRECEDENCE);       // Precedence (inside dialect's own precedence)
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag elementTag, IElementTagStructureHandler structureHandler) {
        final IModelFactory modelFactory = context.getModelFactory();

        final IModel model = modelFactory.createModel();

        final ApplicationContext appCtx = SpringContextUtils.getApplicationContext(context);

        String location =  elementTag.getAttributeValue("location");

        if(StringUtils.isBlank(location)){
            return;
        }
        AdvertisementApi advertisementApi = appCtx.getBean(AdvertisementApi.class);
        Result<PagedResponseDO<AdvertisementDO>> pagedResponseDO = advertisementApi.commonRequest(AdvertisementSearchDO.build(location).enable());

        if(pagedResponseDO != null && pagedResponseDO.isSuccess() && pagedResponseDO.getData() != null && !CollectionUtils.isEmpty(pagedResponseDO.getData().getDatas())){
            List<AdvertisementDO> list = pagedResponseDO.getData().getDatas();


            for (AdvertisementDO advertisementDO : list){
                model.add(modelFactory.createOpenElementTag("div", "class", "ads-widget"));
                if(DictionaryConstant.ITEM_ADS_TYPE_TEXT.equalsIgnoreCase(advertisementDO.getType())){
                    IModel a = getAModel(modelFactory,advertisementDO);
                    a.add(modelFactory.createText(HtmlEscape.escapeHtml5(advertisementDO.getText())));
                    a.add(modelFactory.createCloseElementTag("a"));
                    model.addModel(a);
                }else if(DictionaryConstant.ITEM_ADS_TYPE_IMG.equalsIgnoreCase(advertisementDO.getType())){
                    IModel a = getAModel(modelFactory,advertisementDO);
                    a.add(modelFactory.createStandaloneElementTag("img","src",advertisementDO.getImg()));
                    a.add(modelFactory.createCloseElementTag("a"));
                    model.addModel(a);
                }else if(DictionaryConstant.ITEM_ADS_TYPE_CODE.equalsIgnoreCase(advertisementDO.getType())){
                    structureHandler.setBody(advertisementDO.getContent(),false);
                    model.add(modelFactory.createText(HtmlEscape.unescapeHtml(advertisementDO.getContent())));
                }else if(DictionaryConstant.ITEM_ADS_TYPE_IMG_AND_TEXT.equalsIgnoreCase(advertisementDO.getType())){
                    IModel a = getAModel(modelFactory,advertisementDO);
                    a.add(modelFactory.createStandaloneElementTag("img","src",advertisementDO.getImg()));
                    IModel h4 = modelFactory.createModel();
                    h4.add(modelFactory.createOpenElementTag("h4"));
                    h4.add(modelFactory.createText(HtmlEscape.escapeHtml5(advertisementDO.getText())));
                    h4.add(modelFactory.createCloseElementTag("h4"));
                    a.addModel(h4);
                    a.add(modelFactory.createCloseElementTag("a"));
                    model.addModel(a);
                }
                model.add(modelFactory.createCloseElementTag("div"));
                structureHandler.replaceWith(model, false);
            }
        }

    }

    private IModel getAModel(IModelFactory modelFactory,AdvertisementDO advertisementDO){
        IModel a = modelFactory.createModel();
        IOpenElementTag openElementTag = modelFactory.createOpenElementTag("a","href",advertisementDO.getUrl());
        modelFactory.setAttribute(openElementTag,"target","_blank");
        a.add(openElementTag);
        return a;
    }
}
