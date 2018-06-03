//创建角色
function doCreateRole(){
    $.ajax({
        type: 'post',
        url: '/role/create',
        data: $('#createRoleForm').serialize(),
        success: function(result) {
            if (result.status != 0) {
                failHandler(result);
            } else {
                successConfirm();
                closeModal();
            }
        },
        error: errorHandler
    });
}

//更新角色
function doUpdateRole(){
    $.ajax({
        type: 'post',
        url: '/role/update',
        data: $('#updateRoleForm').serialize(),
        success: function(result) {
            if (result.status != 0) {
                failHandler(result);
            } else {
                successConfirm();
                closeModal();
            }
        },
        error: errorHandler
    });
}