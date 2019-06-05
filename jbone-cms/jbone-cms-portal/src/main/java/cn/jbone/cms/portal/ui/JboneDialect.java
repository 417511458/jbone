package cn.jbone.cms.portal.ui;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

@Component
public class JboneDialect extends AbstractProcessorDialect {
    private static final String DIALECT_NAME = "Jbone Dialect";

    public JboneDialect(){
        super(DIALECT_NAME, "jbone", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(new AdvertisementElementTagProcessor(dialectPrefix));
        return processors;
    }
}
