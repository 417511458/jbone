$(function () {
    // var main = $(window.parent.document).find("#modal-iframe");
    // var thisheight = $(document).height();
    // var thiswidth = $(document).width();
    //
    // main.height(thisheight);
    // main.width(thiswidth);
});

function closeModal(){
    parent.$('#modalOpration').val("refresh");
    parent.$('#parentModal').modal("hide");
}

function closeModalNotRefresh(){
    parent.$('#parentModal').modal("hide");
}