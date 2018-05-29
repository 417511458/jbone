//关闭首页弹出框
//关闭后根据operation的值进行操作，callback/refresh
function closeModal(operation){
    debugger;
    var oper = "callback";
    if(operation){
        oper = operation;
    }
    $('#modalOpration').val(oper);
    $('#parentModal').modal("hide");

    //
    var op =$('#modalOpration').val();
    if(op){
        $(".tab-pane.active").each(function(){
            debugger;
            //回调当前iframe中的方法
            var iframe = $(this).find("iframe")[0];
            if(op == "refresh"){
                iframe.attr('src',iframe.attr('src'));
            }else if(op == "callback"){
                iframe.contentWindow.madalCallback();
            }
        });
    }
    $('#modalOpration').val("");

}

//关闭后既不刷新也不回调
function closeModalNotRefresh(){
    closeModal("");
}