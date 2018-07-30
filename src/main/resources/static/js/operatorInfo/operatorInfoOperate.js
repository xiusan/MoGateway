var saveFlag = undefined;
function showSave(index) {
   // getChargingStationName("#saveChargingStationID");
    $("#saveChargingStationID").addClass('pop-select').selectpicker('setStyle');
    $("#saveChargingStationID").selectpicker('setStyle', 'pop-select', 'add');
    if (index != undefined) {
        saveFlag = "UPDATE";
        $(".modal-title").text("运营厂商修改");
        $("#operatorId").attr("readonly", "readonly");
        $("#operatorName").val(operatorInfoData[index].operatorName);
        $("#operatorTel1").val(operatorInfoData[index].operatorTel1);
        $("#operatorTel2").val(operatorInfoData[index].operatorTel2);
        $("#operatorRegAddress").val(operatorInfoData[index].operatorRegAddress);
        $("#operatorNote").val(operatorInfoData[index].operatorNote);
        $("#aesSecret").val(operatorInfoData[index].aesSecret);
        $("#operatorSecret").val(operatorInfoData[index].operatorSecret);
        $("#aesIv").val(operatorInfoData[index].aesIv);
        $("#sigSecret").val(operatorInfoData[index].sigSecret);
        $("#operatorId").val(operatorInfoData[index].operatorId);
    } else {
        saveFlag = "INSERT";
        $(".modal-title").text("运营厂商添加");
        formReset('saveForm');
        $("#operatorId").attr("readonly", false);
    }
    $("#save").modal('show');
}
function closeSave() {
    $("#save").modal('hide');
    formReset('saveForm');
}

function save() {
//    if(!saveChargingStationID){
//        showInfo("请选择充电站！")
//        return;
//    }
    if (checkForm("#saveForm")) {
        if (saveFlag == "INSERT") {
            //获取到i
            $ajax('saveOperatorInfo', saveEquipmentCallback, ($("#saveForm").serialize() || "").replace(/save/g, ""));
        } else if (saveFlag == "UPDATE") {
            $ajax('updateOperatorInfo', saveEquipmentCallback, ($("#saveForm").serialize() || "").replace(/save/g, ""));
        }
    }
}

function saveEquipmentCallback(data) {
    var result = data && data.result;
    var message = "";
    if (saveFlag == "INSERT") {
        message += "Insert.";
    } else if (saveFlag == "UPDATE") {
        message += "Update.";
    }
    if (result == "Success"){
        $('#operatorInfoTable').bootstrapTable('refresh');
        closeSave();
        showSuccess(messageContent[message + "Success"]);
    } else if (result == "ChargingStationIDEmpty") {
        showError(messageContent[message + "Failed"] + result);
    } else if (result == "OperatorIdEmpty") {
        showError(messageContent[message + "Failed"] + result);
    } else if (result == "EquipmentIDExist") {
        showError(messageContent["Equipment.EquipmentExist"]);
    } else if (result == "EquipmentNameExist") {
        showError(messageContent["Equipment.EquipmentNameExist"]);
    } else if (result == "DuplicateError") {
        showError(messageContent[message + "Duplicate"]);
    } else if (result == "NotFound") {
        showError(messageContent[message + "NotFound"]);
    } else {
        showError(messageContent[message + "Error"]);
    }
}

function delConfirm(index) {
    if (index != undefined) {
        showWarn(messageContent["Delete.Confirm"], delone, operatorInfoData[index]);
    }
    else {
        var selectData = $('#operatorInfoTable').bootstrapTable('getSelections');
        if (selectData.length == 0) {
            showInfo(messageContent["Delete.Select"]);
        } else {
            showWarn(messageContent["Delete.Confirm"], del, selectData);
        }



    }

}

function del(data) {
    var operatorInfoList = [];
    for (var i in data) {
        operatorInfoList.push(data[i].operatorId);
    }
    $ajax('delOperatorInfo', delEquipmentCallback, {operatorId: operatorInfoList.join(',')});
}

function delone(data) {
    var operatorInfoList = [];
        operatorInfoList.push(data.operatorId);

    $ajax('delOperatorInfo', delEquipmentCallback, {operatorId: operatorInfoList.join(',')});
}

function delEquipmentCallback(data) {
    var result = data && data.result;
    if (result == "Success"){
        $('#operatorInfoTable').bootstrapTable('refresh');
        showSuccess(messageContent["Delete.Success"]);
    } else if (result == "EquipmentIDEmpty") {
        showError(messageContent["Delete.Failed"] + result);
    } else if (result == "NotFound") {
        showError(messageContent["Delete.NotFound"]);
    } else {
        showError(messageContent["Delete.Error"]);
    }
}
