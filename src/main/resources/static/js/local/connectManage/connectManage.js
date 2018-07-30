/**
 * Created by Administrator on 2018-03-29.
 */
var connectTypeUploader = undefined;
var connectTypeDatas = undefined;
var tableObj = undefined;
var operateFlag = undefined;
var connectTypeIDS = [];
var retryCount = 0;
$(function(){
    $ajaxCommon('getConnectTypes', ajaxSuccess, undefined ,'json', 'post');
    $ajaxCommon('getSerialPorts', getSerialPorts, undefined ,'json', 'post');
    $('#addConnectTypeModal').on('hidden.bs.modal', function () {
        connectTypeUploader.destroy();
        document.getElementById("fileList").innerHTML = "";
    });
});

function getSerialPorts(data) {
    for (var i = 0;i < data.length;i++) {
        $("#connectSerialPort").append("<option value='" + data[i] + "'>" + data[i] + "</option>");
    }
}

function ajaxSuccess(data) {
    if (data.result == "success") {
        if (data.connectTypes != null) {
            var connectTypes = data.connectTypes;
            connectTypeDatas = connectTypes;
            if (tableObj != undefined) {
                tableObj.fnClearTable();
                tableObj.fnDestroy();
            }
            $("#connectTypeTable").empty();
            if (connectTypes.length == 0) {
                layer.msg(messageContent["Search.NoResultFound"]);
            } else {
                tableObj = fillDataTable('connectTypeTable', connectManageColumns, connectTypes, connectManageKeyArrays, true);
            }
        }
    } else {
        layer.msg(messageContent["Search.Error"]);
    }
}

function addConnectType() {
    connectTypeUploader = getWebUploader('addConnectType', 'picker','fileList',addConnectTypeResult);
    $("#addConnectTypeModal").modal("show");
}

function confirmAdd(){
    if(validform('addConnectTypeForm').form()) {
        connectTypeUploader.options.formData = arrayToJson($("#addConnectTypeForm").serializeArray());
        connectTypeUploader.upload();
    }
}

function addConnectTypeResult(type, arg1, arg2) {
    if (arg1) {
        if (arg1.result == "success") {
            connectTypeUploader.removeFile(type.id);
            $ajaxCommon('getConnectTypes', ajaxSuccess, undefined ,'json', 'post');
            $("#addConnectTypeModal").modal("hide");
            layer.msg("添加成功");
        } else if (arg1.result == "failed") {
            layer.msg("添加失败");
        } else {
            layer.msg("添加异常");
        }
    } else {
        layer.msg("添加异常");
    }
}

function initLayer(flag) {
    operateFlag = flag;
    var checkbox = getCheckbox('chk');
    if (checkbox.count == 0) {
        layer.msg('请选择数据');
    } else if (checkbox.count > 1){
        layer.msg('只能选择一条数据');
    } else {
        var title = undefined;
        if (flag == "start") {
            title = "您确定启用吗?";
        } else if (flag == "stop") {
            title = "您确定禁用吗?";
        } else {
            title = "您确定删除吗?";
        }
        confirm(title, "确定", "取消");
    }
}

function sure() {
    retryCount = 0;
    parent.layer.closeAll();
    var checkbox = getCheckbox('chk');
    var ids = [];
    for (var i = 0;i < checkbox.row_index.length;i++) {
        ids.push(connectTypeDatas[checkbox.row_index[i]].connectType);
    }
    connectTypeIDS = ids;
    $ajaxCommon('operateConnectType', operateResult, {operation:operateFlag, connectTypeID:ids.toString()},'json','post');
}

function cancel(){
    parent.layer.closeAll();
}

function operateResult(data) {
    var operation = undefined;
    if (data.operation == "start") {
        operation = "启用";
    } else if (data.operation == "stop") {
        operation = "禁用";
    } else {
        operation = "删除";
    }
    if (data.result == "success") {
        var index = parent.layer.load(1, {
            shade: [0.1,'#fff'] //0.1透明度的白色背景
        });
        getOperateResult();
    } else if (data.result == "failed") {
        layer.msg(operation + "失败");
    } else if (data.result == "error") {
        layer.msg(operation + "异常");
    }
}

function getOperateResult() {
    $ajaxCommon('getOperateResult', operationResult, {operation:operateFlag, connectTypeID:connectTypeIDS.toString()} ,'json', 'post');
}

function operationResult(data) {
    var operation = undefined;
    if (data.operation == "start") {
        operation = "启用";
    } else if (data.operation == "stop") {
        operation = "禁用";
    } else {
        operation = "删除";
    }
    if (data.result == "success") {
        parent.layer.closeAll();
        layer.msg(operation + "成功");
        $ajaxCommon('getConnectTypes', ajaxSuccess, undefined ,'json', 'post');
    } else {
        if (retryCount < 50) {
            setTimeout(getOperateResult, 5000);
            retryCount++;
        } else {
            parent.layer.closeAll();
            layer.msg(operation + "失败");
        }
    }
}