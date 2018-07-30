/**
 * Created by ChenKuan on 2018-04-10.
 */
var agreementUploader = undefined;
var agreements = undefined;
var tableObj = undefined;
var operateFlag = undefined;
var retryCount = 0;
var agreementID = undefined;

$(function(){
    $ajaxCommon('getAgreements', agreementSuccess, undefined ,'json', 'post');
    $('#addAgreementModal').on('hidden.bs.modal', function () {
        if (agreementUploader != undefined) {
            agreementUploader.destroy();
            document.getElementById("fileList").innerHTML = "";
        }
    });
});

function agreementSuccess (data) {
    if (data.result == "success") {
        if (data.agreements != null) {
            agreements = data.agreements;
            if (tableObj != undefined) {
                tableObj.fnClearTable();
                tableObj.fnDestroy();
            }
            $("#agreementTable").empty();
            if (agreements.length == 0) {
                layer.msg(messageContent["Search.NoResultFound"]);
            } else {
                tableObj = fillDataTable('agreementTable', agreementManageColumns, agreements, agreementManageKeyArrays, true);
            }
        }
    } else {
        layer.msg(messageContent["Search.Error"]);
    }
}

function addAgreement() {
    agreementUploader = getWebUploader('addAgreement', 'picker','fileList',addAgreementResult);
    $("#addAgreementModal").modal("show");
}

function addAgreementResult(type, arg1, arg2) {
    if (arg1) {
        if (arg1.result == "success") {
            agreementUploader.removeFile(type.id);
            $ajaxCommon('getAgreements', agreementSuccess, undefined ,'json', 'post');
            $("#addAgreementModal").modal("hide");
            layer.msg(messageContent["Insert.Success"]);
        } else if (arg1.result == "failed") {
            layer.msg(messageContent["Insert.Failed"]);
        } else {
            layer.msg(messageContent["Insert.Error"]);
        }
    }
}

function confirmAdd(){
    if(validform('addAgreementForm').form()) {
        agreementUploader.options.formData = arrayToJson($("#addAgreementForm").serializeArray());
        agreementUploader.upload();
    }
}

function initLayer(flag) {
    operateFlag = flag;
    var checkbox = getCheckbox('chk');
    if (checkbox.count == 0) {
        layer.msg(messageContent["Select.NotFound"]);
    } else if (checkbox.count > 1) {
        layer.msg(messageContent["Select.OnlyOne"]);
    }else {
        var title = undefined;
        if (flag == "start") {
            title = messageContent["Equipment.StartConfirm"];
        } else if (flag == "stop") {
            title = messageContent["Equipment.StopConfirm"];
        } else {
            title = messageContent["Delete.Confirm"];
        }
        confirm(title, "确定", "取消");
    }
}

function sure() {
    retryCount = 0;
    parent.layer.closeAll();
    var checkbox = getCheckbox('chk');
    agreementID = agreements[checkbox.row_index[0]].agreementID;
    $ajaxCommon('operateAgreement', operateResult, {operation:operateFlag, agreementID:agreementID},'json','post');
}

function cancel() {
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
        getOperateResult();
    } else if (data.result == "failed") {
        layer.msg(operation + "失败");
    } else if (data.result == "error") {
        layer.msg(operation + "异常");
    }
}

function getOperateResult() {
    $ajaxCommon('getOperateAgreementResult', operationResult, {operation:operateFlag, agreementID:agreementID} ,'json', 'post');
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
        $ajaxCommon('getAgreements', agreementSuccess, undefined ,'json', 'post');
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