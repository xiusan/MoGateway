var logSettings = undefined;
var tableObj = undefined;
var operateFlag = undefined;
var logSettingColumns = [{title:'<input id="chkAll" type="checkbox" class="i-checks" name="input[]">',className:"td_center",orderable:false},{title: "模块名称"},{title: "是否存储",render:confirmFlag},{title: "存储方式", render:storeStyleFlag},{title: "存储周期(S)", render:emptyFlag},{title: "文件大小(M)",render:emptyFlag}, {title: "是否压缩", render:confirmFlag},{title: "压缩方式", render:compressStyleFlag}];
var logSettingKeyArrays = ['moduleName','logFlag','storeStyle','storePeriod','storeFileSize','compressFlag','compressStyle'];

$(function(){
    $ajaxCommon('getLogSetting', logSetting, undefined ,'json', 'post');
    $ajaxCommon("moduleList", moduleOption, undefined, 'json', 'post');
    $('#addLogSettingModal').on('hidden.bs.modal', function () {
        formReset();
    });
});

function moduleOption(data) {
    if (data.result == "error") {
        return;
    }
    var html = '';
    var modules = data.modules;
    for (var i = 0; i < modules.length; i++) {
        html += '<option value="' + modules[i].moduleID + '">' + modules[i].moduleName + '</option>';
    }
    $('#moduleID').append(html);
}

function logSetting(data) {
    if (data.result == "success") {
        if (data.logSettings != null) {
            logSettings = data.logSettings;
            if (tableObj != undefined) {
                tableObj.fnClearTable();
                tableObj.fnDestroy();
            }
            $("#logSettingTable").empty();
            if (logSettings.length == 0) {
                layer.msg(messageContent["Search.NoResultFound"]);
            } else {
                tableObj = fillDataTable('logSettingTable', logSettingColumns, logSettings, logSettingKeyArrays, true);
            }
        }
    } else {
        layer.msg(messageContent["Search.Error"]);
    }
}

function confirmFlag(data, type, full, callback) {
    if (data == 0) {
        return "是";
    } else {
        return "否";
    }
}

function emptyFlag(data, type, full, callback) {
    if (data != null && data != undefined && data != "") {
        return data;
    } else {
        return "-";
    }
}

function storeStyleFlag(data, type, full, callback) {
    return storeStyle[data];
}

function compressStyleFlag(data, type, full, callback) {
    return compressStyle[data];
}

function addLogSetting() {
    operateFlag = "add";
    $('#moduleID').removeAttr("disabled");
    $("#addLogSettingModal").modal("show");
}

function confirmAdd(){
    if(validform('addLogSettingForm').form()) {
        var data = arrayToJson($("#addLogSettingForm").serializeArray());
        if (operateFlag == "add") {
            $ajaxCommon("addLogSetting", addLogSettingResult, data, 'json', 'post');
        } else {
            $ajaxCommon("updateLogSetting", updateLogSettingResult, data, 'json', 'post');
        }
    }
}

function addLogSettingResult(data) {
    if (data.result == "success") {
        $ajaxCommon('getLogSetting', logSetting, undefined ,'json', 'post');
        $("#addLogSettingModal").modal("hide");
        layer.msg(messageContent["Insert.Success"]);
    }  else if (data.result == "failed") {
        layer.msg(messageContent["Insert.Failed"]);
    } else {
        layer.msg(messageContent["Insert.Error"]);
    }
}

function checkBoxCount() {
    var chkBox = getCheckbox("chk");
    if (chkBox.count == 0) {
        layer.msg(messageContent["Select.NotFound"]);
    } else if (chkBox.count > 1) {
        layer.msg(messageContent["Select.OnlyOne"]);
    } else {
        operateFlag = "update";
        var logSetting = logSettings[chkBox.row_index[0]];
        $("#moduleID").val(logSetting.moduleID);
        $('#moduleID').attr("disabled","disabled");
        $("#logFlag").val(logSetting.logFlag);
        $("#storeStyle").val(logSetting.storeStyle);
        $("#storePeriod").val(logSetting.storePeriod);
        $("#storeFileSize").val(logSetting.storeFileSize);
        $("#compressFlag").val(logSetting.compressFlag);
        $("#compressStyle").valueOf(logSetting.compressStyle);
        $("#addLogSettingModal").modal("show");
    }
}

function updateLogSettingResult(data) {
    if (data.result == "success") {
        $ajaxCommon('getLogSetting', logSetting, undefined ,'json', 'post');
        $("#addLogSettingModal").modal("hide");
        layer.msg(messageContent["Update.Success"]);
    }  else if (data.result == "failed") {
        layer.msg(messageContent["Update.Failed"]);
    } else {
        layer.msg(messageContent["Update.Error"]);
    }
}

function initLayer() {
    var checkbox = getCheckbox('chk');
    if (checkbox.count == 0) {
        layer.msg(messageContent["Select.NotFound"]);
    }  else {
        confirm(messageContent["Delete.Confirm"], "确定", "取消");
    }
}

function sure() {
    parent.layer.closeAll();
    var checkbox = getCheckbox('chk');
    var ids = [];
    for (var i = 0;i < checkbox.row_index.length;i++) {
        ids.push(logSettings[checkbox.row_index[i]].moduleID);
    }
    connectTypeIDS = ids;
    $ajaxCommon('deleteLogSetting', deleteLogSettingResult, {moduleIDs:ids.toString()},'json','post');
}

function cancel() {
    parent.layer.closeAll();
}

function deleteLogSettingResult(data) {
    if (data.result == "success") {
        $ajaxCommon('getLogSetting', logSetting, undefined ,'json', 'post');
        layer.msg(messageContent["Delete.Success"]);
    }  else if (data.result == "failed") {
        layer.msg(messageContent["Delete.Failed"]);
    } else {
        layer.msg(messageContent["Delete.Error"]);
    }
}

function formReset() {
    $("#moduleID").val("");
    $("#logFlag").val("0");
    $("#storeStyle").val("1");
    $("#storePeriod").val("");
    $("#storeFileSize").val("");
    $("#compressFlag").val("0");
    $("#compressStyle").valueOf("1");
}

