$(function() {
	// Waves初始化
	Waves.displayEffect();
	// 数据表格动态高度
	$(window).resize(function () {
		$('#table').bootstrapTable('resetView', {
			height: getHeight()
		});

	});
	// 设置input特效
	$(document).on('focus', 'input[type="text"]', function() {
		$(this).parent().find('label').addClass('active');
	}).on('blur', 'input[type="text"]', function() {
		if ($(this).val() == '') {
			$(this).parent().find('label').removeClass('active');
		}
	});

});
// 动态高度
function getHeight() {
	return $(window).height() - 20;
}
// 数据表格展开内容
function detailFormatter(index, row) {
	var html = [];
	$.each(row, function (key, value) {
		html.push('<p><b>' + key + ':</b> ' + value + '</p>');
	});
	return html.join('');
}
// 初始化input特效
function initMaterialInput() {
	$('form input[type="text"]').each(function () {
		if ($(this).val() != '') {
			$(this).parent().find('label').addClass('active');
		}
	});
}

// 加载表单数据
function loadData(obj){
    var key,value,tagName,type,arr;
    for(x in obj){
        key = x;
        value = obj[x];

        $("[name='"+key+"']").each(function(){
        	tagName = $(this)[0].tagName;
            type = $(this).attr('type');
            if(tagName=='INPUT'){
                if(type=='radio'){
                    $(this).prop('checked',$(this).val()==value);
                }else if(type=='checkbox'){
                    arr = value.split(',');
                    for(var i =0;i<arr.length;i++){
                        if($(this).val()==arr[i]){
                            $(this).prop('checked',true);
                            break;
                        }
                    }
                }else{
                    $(this).val(value);
                }
            }else if(tagName=='SELECT' || tagName=='TEXTAREA'){
                $(this).val(value);
            }
        });
    }
}

function errorHandler(XMLHttpRequest, textStatus, errorThrown) {
    parent.$.confirm({
        theme: 'dark',
        animation: 'rotateX',
        closeAnimation: 'rotateX',
        title: false,
        content: textStatus,
        buttons: {
            confirm: {
                text: '确认',
                btnClass: 'waves-effect waves-button waves-light'
            }
        }
    });
}

function failHandler(result) {
    parent.$.confirm({
        theme: 'dark',
        animation: 'rotateX',
        closeAnimation: 'rotateX',
        title: false,
        content: result.msg,
        buttons: {
            confirm: {
                text: '确认',
                btnClass: 'waves-effect waves-button waves-light'
            }
        }
    });
}

function successConfirm(){
    parent.$.confirm({
        theme: 'light',
        animation: 'rotateX',
        closeAnimation: 'rotateX',
        title: false,
        content: '操作成功',
        buttons: {
            confirm: {
                text: '确认',
                btnClass: 'waves-effect waves-button waves-light'
            }
        }
    });
}

function childSuccessConfirm(){
    parent.$.confirm({
        theme: 'light',
        animation: 'rotateX',
        closeAnimation: 'rotateX',
        title: false,
        content: '操作成功',
        buttons: {
            confirm: {
                text: '确认',
                btnClass: 'waves-effect waves-button waves-light'
            }
        }
    });
}

function chooseConfirm(content){
    var c = "请至少选择一条记录！";
    if(content){
        c = content;
    }
    parent.$.confirm({
        title: false,
        content: c,
        autoClose: 'cancel|3000',
        backgroundDismiss: true,
        buttons: {
            cancel: {
                text: '取消',
                btnClass: 'waves-effect waves-button'
            }
        }
    });
}


function openModal(title,url){
    parent.$("#modal-title").text(title);
    parent.$("#modal-iframe").attr("src",url);
    parent.$('#iframe-loading').show();
    var dialog = parent.$('#parentModal');
    dialog.modal();
}

// 删除
function deleteAction(url) {
    var rows = $table.bootstrapTable('getSelections');
    if (rows.length == 0) {
        chooseConfirm();
    } else {
        var ids = new Array();
        for (var i in rows) {
            ids.push(rows[i].id);
        }
        commonDelete(url,ids.join(","));
    }
}

function commonDelete(url,ids){
    parent.$.confirm({
        type: 'red',
        animationSpeed: 300,
        title: false,
        content: '确认删除该记录吗？',
        buttons: {
            confirm: {
                text: '确认',
                btnClass: 'waves-effect waves-button',
                action: function () {
                    $.ajax({
                        type: 'post',
                        url: url + ids,
                        success: function(result) {
                            if (result.status != 0) {
                                failHandler(result);
                            } else {
                                successConfirm();
                                $table.bootstrapTable('refresh');
                            }
                        },
                        error: errorHandler
                    });
                }
            },
            cancel: {
                text: '取消',
                btnClass: 'waves-effect waves-button'
            }
        }
    });
}

//选择表格中的一条数据
function chooseOne(){
    var rows = $table.bootstrapTable('getSelections');
    if (rows.length != 1) {
        chooseConfirm();
        return null;
    }else{
        return rows[0];
    }
}