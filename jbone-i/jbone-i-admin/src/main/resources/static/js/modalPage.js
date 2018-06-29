//关闭首页弹出框
//关闭后根据operation的值进行操作，callback/refresh
function closeModal(operation){
    debugger;
    var oper = "callback";
    if(operation){
        oper = operation;
    }

    var modalOperation = $('#modalOpration');
    var iframe =  $(".tab-pane.active iframe")[0];


    //根据选项清空对应内容
    var show_form_modal = $("input[name='show_form_modal']:checked").val();
    if(show_form_modal == "2"){
        $('#formBox').hide();
        $("#formContent").html("");
    }else if(show_form_modal == "1") {
        $('#parentModal').modal("hide");
        $("#modal-body").html("");
    }

    modalOperation.val(oper);

    //
    var op = modalOperation.val();
    if(op){
        if(op == "refresh"){
            iframe.attr('src',iframe.attr('src'));
        }else if(op == "callback"){
            iframe.contentWindow.madalCallback();
        }
    }

    modalOperation.val("");

}

//关闭后既不刷新也不回调
function closeModalNotRefresh(){
    closeModal("");
}