$(function () {
    // var main = $(window.parent.document).find("#modal-iframe");
    // var thisheight = $(document).height();
    // var thiswidth = $(document).width();
    //
    // main.height(thisheight);
    // main.width(thiswidth);
});

function closeModal(operation){
    var oper = "callback";
    if(operation){
        oper = operation;
    }
    parent.$('#modalOpration').val(oper);
    parent.$('#parentModal').modal("hide");
}

function closeModalNotRefresh(){
    closeModal("");
}