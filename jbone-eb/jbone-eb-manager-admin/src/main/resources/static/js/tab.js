var addTabs = function (obj) {
    id ="tab_"+ obj.id;

    $(".active").removeClass("active");

//如果TAB不存在，创建一个新的TAB
    if (!$("#"+ id)[0]) {
//固定TAB中IFRAME高度
        mainHeight = $(document.body).height() - 95;
//创建新TAB的title
        title = '<li role="presentation" id="tab_' + id + '"><a href="#' + id + '"aria-controls="' + id + '"role="tab"data-toggle="tab">' + obj.title;
//是否允许关闭
        if (obj.close) {
            title += ' <i class="fa fa-times-circle" tabclose="' + id + '"></i>';
        }
        title += '</a></li>';
//是否指定TAB内容
        if (obj.content) {
            content = '<div role="tabpanel" class="tab-pane" id="' + id + '">' + obj.content + '</div>';
        } else {//没有内容，使用IFRAME打开链接
            content = '<div role="tabpanel" class="tab-pane" id="' + id + '"><iframe src="' + obj.url + '"width="100%"height="' + mainHeight +
                '"frameborder="no"border="0"marginwidth="0"marginheight="0"scrolling="yes"allowtransparency="yes"></iframe></div>';
        }
//加入TABS
        $(".nav-tabs-title").append(title);
        $(".nav-tabs-content").append(content);
    }

//激活TAB
    $("#tab_"+ id).addClass('active');
    $("#"+ id).addClass("active");
};

var closeTab = function (id) {
//如果关闭的是当前激活的TAB，激活他的前一个TAB
    if ($("li.active").attr('id') =="tab_"+ id) {
        $("#tab_"+ id).prev().addClass('active');
        $("#"+ id).prev().addClass('active');
    }
//关闭TAB
    $("#tab_"+ id).remove();
    $("#"+ id).remove();
};

$(function () {
    $("[addtabs]").click(function () {
        addTabs({id: $(this).attr("id"), title: $(this).attr('title'), close: $(this).attr("closeable"), url:$(this).attr("url")});
    });

    $(".nav-tabs-title").on("click","[tabclose]", function (e) {
        id = $(this).attr("tabclose");
        closeTab(id);
    });

});
