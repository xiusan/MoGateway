var saveFlag = undefined;
function showSave(index) {
   // getChargingStationName("#saveChargingStationID");
    $("#saveChargingStationID").addClass('pop-select').selectpicker('setStyle');
    $("#saveChargingStationID").selectpicker('setStyle', 'pop-select', 'add');
    if (index != undefined) {
        saveFlag = "UPDATE";
        $(".modal-title").text("充电站修改");
        //$("#operatorId").attr("readonly", "readonly");
        $("#chargingStationName").val(operatorInfoData[index].chargingStationName);
        $("#operatorName").val(operatorInfoData[index].operatorName);
        $("#countryCode").val(operatorInfoData[index].countryCode);
        $("#areaCode").val(operatorInfoData[index].areaCode);
        $("#chargingStationAddr").val(operatorInfoData[index].chargingStationAddr);
        $("#chargingStationTel").val(operatorInfoData[index].chargingStationTel);
        $("#stationTypeName").val(operatorInfoData[index].stationTypeName);
        $("#stationStatusName").val(operatorInfoData[index].stationStatusName);
        $("#parkNums").val(operatorInfoData[index].parkNums);
        $("#chargingStationLat").val(operatorInfoData[index].chargingStationLat);
        $("#siteGuide").val(operatorInfoData[index].siteGuide);
        $("#constructionName").val(operatorInfoData[index].constructionName);
        $("#supportOrder").val(operatorInfoData[index].supportOrder);
        $("#remark").val(operatorInfoData[index].remark);
        $("#chargingStationId").val(operatorInfoData[index].chargingStationId);
    } else {
        saveFlag = "INSERT";
        $(".modal-title").text("充电站添加");
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
            $ajax('saveChargingstation', saveEquipmentCallback, ($("#saveForm").serialize() || "").replace(/save/g, ""));
        } else if (saveFlag == "UPDATE") {
            $ajax('updateChargingstation', saveEquipmentCallback, ($("#saveForm").serialize() || "").replace(/save/g, ""));
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
    $ajax('delChargingstation', delEquipmentCallback, {chargingStationId: operatorInfoList.join(',')});
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
