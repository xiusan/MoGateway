var saveFlag = undefined;
function showSave(index) {
   // getChargingStationName("#saveChargingStationID");
    $("#saveChargingStationID").addClass('pop-select').selectpicker('setStyle');
    $("#saveChargingStationID").selectpicker('setStyle', 'pop-select', 'add');
    if (index != undefined) {
        saveFlag = "UPDATE";
        $(".modal-title").text("添加商品信息修改");
        $("#numId").val(operatorInfoData[index].numId);
        $("#title").val(operatorInfoData[index].title);
        $("#pictUrl").val(operatorInfoData[index].pictUrl);
        $("#smallImages").val(operatorInfoData[index].smallImages);
        $("#reservePrice").val(operatorInfoData[index].reservePrice);
        $("#zkFinalPrice").val(operatorInfoData[index].zkFinalPrice);
        $("#userType").val(operatorInfoData[index].userType);
        $("#provcity").val(operatorInfoData[index].provcity);
        $("#itemUrl").val(operatorInfoData[index].itemUrl);
        $("#nick").val(operatorInfoData[index].nick);
        $("#sellerId").val(operatorInfoData[index].sellerId);
        $("#volume").val(operatorInfoData[index].volume);
        $("#creatTime").val(operatorInfoData[index].creatTime);
        $("#popularity").val(operatorInfoData[index].popularity);
        $("#voucherAddress").val(operatorInfoData[index].voucherAddress);
        $("#creatUser").val(operatorInfoData[index].creatUser);

    } else {
        saveFlag = "INSERT";
        $(".modal-title").text("添加商品信息添加");
        formReset('saveForm');
    }
    $("#save").modal('show');
}
//关闭（添加或更新）添加商品信息
function closeSave() {
    $("#save").modal('hide');
    formReset('saveForm');
}

// 添加或更新
function save() {
//    if(!saveChargingStationID){
//        showInfo("请选择充电站！")
//        return;
//    }
    if (checkForm("#saveForm")) {
        if (saveFlag == "INSERT") {
            //获取到i
            $ajax('saveShengdaojia', saveEquipmentCallback, ($("#saveForm").serialize() || "").replace(/save/g, ""));
        } else if (saveFlag == "UPDATE") {
            $ajax('updateShengdaojia', saveEquipmentCallback, ($("#saveForm").serialize() || "").replace(/save/g, ""));
        }
    }
}

//回调函数
function saveEquipmentCallback(data) {
    var result = data && data.result;
    var message = "";
    if (saveFlag == "INSERT") {
        message += "Insert.";
    } else if (saveFlag == "UPDATE") {
        message += "Update.";
    }
    if (result == "Success"){
        $('#operatorShengdaojia').bootstrapTable('refresh');
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
        var selectData = $('#operatorShengdaojia').bootstrapTable('getSelections');
        if (selectData.length == 0) {
            showInfo(messageContent["Delete.Select"]);
        } else {
            showWarn(messageContent["Delete.Confirm"], del, selectData);
        }



    }

}
//删除添加商品信息
function del(data) {
    var operatorInfoList = [];
    for (var i in data) {
        operatorInfoList.push(data[i].operatorId);
    }
    $ajax('delShengdaojia', delEquipmentCallback, {id: operatorInfoList.join(',')});
}

function delone(data) {
    var operatorInfoList = [];
        operatorInfoList.push(data.operatorId);

    $ajax('delShengdaojia', delEquipmentCallback, {id: operatorInfoList.join(',')});
}

function delEquipmentCallback(data) {
    var result = data && data.result;
    if (result == "Success"){
        $('#operatorShengdaojia').bootstrapTable('refresh');
        showSuccess(messageContent["Delete.Success"]);
    } else if (result == "EquipmentIDEmpty") {
        showError(messageContent["Delete.Failed"] + result);
    } else if (result == "NotFound") {
        showError(messageContent["Delete.NotFound"]);
    } else {
        showError(messageContent["Delete.Error"]);
    }
}
