/**
 * Created by Administrator on 2018-04-18.
 */
var eventTypes = undefined;
var tableObj = undefined;
var operate = undefined;

$(function(){
    $ajaxCommon('getEventTypes', eventTypeSuccess, undefined ,'json', 'post');
});

function eventTypeSuccess(data) {
    if (data.result == "success") {
        if (data.eventTypes != null) {
            eventTypes = data.eventTypes;
            if (tableObj != undefined) {
                tableObj.fnClearTable();
                tableObj.fnDestroy();
            }
            $("#eventTypeTable").empty();
            if (eventTypes.length == 0) {
                layer.msg(messageContent["Search.NoResultFound"]);
            } else {
                tableObj = fillDataTable('eventTypeTable', eventTypeColumns, eventTypes, eventTypeKeyArrays, true);
            }
        }
    } else {
        layer.msg(messageContent["Search.Error"]);
    }
}

function addEventType() {
    $("#modal-title").html("添加事件类型");
    $('#eventType').removeAttr("disabled");
    $("#addEventTypeModal").modal("show");
    operate = "add";
}

function confirmAdd(){
    if(validform('addEventTypeForm').form()) {
        if (operate == "add") {
            $ajaxCommon("addEventType", addResult, arrayToJson($("#addEventTypeForm").serializeArray()), 'json', 'post');
        } else if (operate == "update") {
            $ajaxCommon("updateEventType", updateResult, arrayToJson($("#addEventTypeForm").serializeArray()), 'json', 'post');
        } else {
            return;
        }
    }
}

function addResult(data) {
    if (data.result == "success") {
        $("#addEventTypeModal").modal("hide");
        $ajaxCommon('getEventTypes', eventTypeSuccess, undefined ,'json', 'post');
        layer.msg(messageContent["Insert.Success"]);
    } else if (data.result == "failed") {
        layer.msg(messageContent["Insert.Failed"]);
    } else {
        layer.msg(messageContent["Insert.Error"]);
    }
}

function updateResult(data) {
    if (data.result == "success") {
        $("#addEventTypeModal").modal("hide");
        $ajaxCommon('getEventTypes', eventTypeSuccess, undefined ,'json', 'post');
        layer.msg(messageContent["Update.Success"]);
    } else if (data.result == "failed") {
        layer.msg(messageContent["Update.Failed"]);
    } else {
        layer.msg(messageContent["Update.Error"]);
    }
}

function checkCount(flag) {
    var checkbox = getCheckbox('chk');
    if (checkbox.count == 0) {
        layer.msg("请选择数据");
        return;
    } else {
        if (flag == "update") {
            if (checkbox.count > 1) {
                layer.msg("只能选择一条数据");
            } else {
                $("#modal-title").html("修改事件类型");
                var eventType = eventTypes[checkbox.row_index[0]];
                $("#eventType").val(eventType.eventType);
                $("#eventTypeName").val(eventType.eventTypeName);
                $("#eventDescription").val(eventType.eventDescription);
                $('#eventType').attr("disabled","disabled");
                $("#addEventTypeModal").modal("show");
                operate = "update";
            }
        } else {
            confirmCheckbox(messageContent["Delete.Confirm"], "确定", "取消");
        }
    }
}

function sure() {
    parent.layer.closeAll();
    var checkbox = getCheckbox('chk');
    var eventType = [];
    for (var i = 0;i < checkbox.count;i++) {
        eventType.push(eventTypes[checkbox.row_index[i]].eventType);
    }
    $ajaxCommon("deleteEventType", deleteSuccess, {eventTypes:eventType.toString()}, 'json', 'post');
}

function cancel() {
    parent.layer.closeAll();
}

function deleteSuccess(data) {
    if (data.result == "success") {
        $ajaxCommon('getEventTypes', eventTypeSuccess, undefined ,'json', 'post');
        layer.msg(messageContent["Delete.Success"]);
    } else if (data.result == "failed") {
        layer.msg(messageContent["Delete.Failed"]);
    } else {
        layer.msg(messageContent["Delete.Error"]);
    }
}