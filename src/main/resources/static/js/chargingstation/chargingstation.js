var chargingStationNameList = [];
var operatorInfoData = {};
var bootstrapTableOption = {
    url: 'getChargingstationfoList',
    queryParams: function(params) {
        return {
            pageNum: params.pageNumber,// 每页要显示的数据条数
            pageSize: params.pageSize,// 每页显示数据的开始行号
            equipmentid: $('#DiagnosisHistoryID').val() && $('#DiagnosisHistoryID').val().replace("ALL", ""),
            chargingstationid: $('#chargingStationID').val(),
        }
    },

    columns: [
        {checkbox: true}, // 显示一个勾选框
        {title: '序号', align: 'center', formatter: 'increases'},

        { field: 'chargingStationName', title: '名称'},
        { field: 'operatorName', title: '所属运营商'},
        { field: 'countryCode', title: '国家代码' },
        { field: 'areaCode', title: '省市辖区' },
        { field: 'chargingStationAddr', title: '详细地址' },
        { field: 'chargingStationTel', title: '站点电话' },
        { field: 'stationTypeName', title: '站点类型' },
        { field: 'stationStatusName', title: '站点状态' },
        { field: 'parkNums', title: '车位数量' },
        { field: 'chargingStationLng', title: '经度'  },
        { field: 'chargingStationLat',  title: '维度' },
        { field: 'siteGuide', title: '站点引导' },
        { field: 'constructionName', title: '建设场所' },
        { field: 'supportOrder', title: '是否支持预约' },
        { field: 'remark', title: '备注' },
        {title: '操作', formatter:function (value, row, index) {
        return ["<a><i class='' onclick='showSave(" + index + ")'>修改</i></a>","  &nbsp;<a><i class='' onclick='delConfirm(" + index + ")'>删除</i></a>"].join('');}
        }
    ],
    responseHandler: function (data) {
        operatorInfoData = data.list;
        return data;
    }
};

$(document).ready(function() {
    //初始化页面select框
    getselectMap("/getSelectChargingstation","constructionName","4");
    getselectMap("/getSelectChargingstation","operatorName","1");
    getselectMap("/getSelectChargingstation","stationTypeName","2");
    getselectMap("/getSelectChargingstation","stationStatusName","3");

	//$('title', parent.document).html($('title').text());
    //$("#DiagnosisHistoryIDDiv").hide();
    //getChargingStationName("#chargingStationID");  初始化查询条件
    setBootstrapTable('#operatorInfoTable', bootstrapTableOption);  //初始化页面table
});

function getChargingStationName(id) {
    changeSelectpicker(id, 'destroy');
    $(id).empty();
    if (chargingStationNameList && chargingStationNameList.length > 0) {
        setChargingStationName(id, chargingStationNameList);
    } else {
        $ajax("getChargingStationName", setChargingStationName, '', id, "get");
    }
};
function setChargingStationName(id, data) {
    var length = data.length;
    chargingStationNameList = data;
    for (var i = 0; i < length; i++) {
        $(id).append("<option value ='" + data[i].chargingStationID + "'>" + data[i].chargingStationName + "</option>");
    }
    changeSelectpicker(id, 'refresh');
    $(id).selectpicker('setStyle', 'select', 'add');
    if (length > 5) {
        setSelectpicker(id);
    }

    fromDiagnosisReport1()
};
//获取输入框详情
function getDiagnosisHistoryName(value, id) {
    $ajax("getChargingPileName?chargingstationid=" + value, setEquipmentName, '', id, "get");
};

function setEquipmentName(id, data) {
    var length = data.length;
    $(id).append("<option value='ALL'>全部桩</option>");
    for (var i = 0; i < length; i++) {
        $(id).append("<option value ='" + data[i].equipmentid + "'>" + data[i].equipmentName + "</option>");
    }
    changeSelectpicker(id, 'refresh');
    $(id).selectpicker('setStyle', 'select', 'add');
    if (length > 5) {
        setSelectpicker(id);
    }
    fromDiagnosisReport2()
};


function change(changeID, linkID, callback) {
    if (changeID && linkID) {
        var changeValue = $(changeID).val();
        $(linkID).empty();
        changeSelectpicker(linkID, 'destroy');
        if (changeValue) {
            $(linkID + "Div").show();
            if (callback && typeof callback === 'function') {
                callback(changeValue, linkID);
            }
        } else {
            $(linkID + "Div").hide();
        }
    }
};

//重置
function searchReset() {
    $("#DiagnosisHistoryID").empty();
    $("#DiagnosisHistoryIDDiv").hide();
    changeSelectpicker('#DiagnosisHistoryID', 'destroy');
    $('#chargingStationID')[0].selectedIndex = 0;
    changeSelectpicker('#chargingStationID', 'refresh');
};
//查询
function search() {
    operateBootstrapTable('#operatorInfoTable', 'selectPage', 1);
}

/*table内部操作*/

// 格式化操作按钮

function detailAction(id, time,name) {
    if(name=='null'){
        name='';
    }
    window.parent.test("goDiagnosisDetail?id=" + id+"&time="+time, 10, name + "充电桩详情");
}

//从故障诊断的诊断历史按钮跳转到此页面时会调用的方法，功能是在充电站搜索框中，回显故障诊断数据的充电站字段。
function fromDiagnosisReport1() {
    var baseURI = document.getElementById("DiagnosisHistoryID").baseURI;
    var part;
    var key;

    if (baseURI && baseURI.split("?")[1]) {
        part = baseURI.split("?")[1].split("&")[0];
    } else {
        return;
    }

    if (!part) {
        return;
    } else {
        key = part.split("=")[0];
    }


    if (!key || key != "ChargingStationID") {
        return;
    }

    var chargingStationIDVal = part.split("=")[1];

    $("#chargingStationID").val(chargingStationIDVal);
    changeSelectpicker("#chargingStationID", 'refresh');
    $("#chargingStationID").change();
}

//从故障诊断的诊断历史按钮跳转到此页面时会调用的方法，功能是在充电桩搜索框中，回显故障诊断数据的充电桩字段。
function fromDiagnosisReport2() {
    var baseURI = document.getElementById("DiagnosisHistoryID").baseURI;
    var part;
    var key;

    if (baseURI && baseURI.split("?")[1]) {
        part = baseURI.split("?")[1].split("&")[0];
    } else {
        return;
    }

    if (!part) {
        return;
    } else {
        key = part.split("=")[0];
    }

    if (!key || key != "EquipmentID") {
        return;
    }

    var DiagnosisHistoryIDVal = part.split("=")[1];
    $("#DiagnosisHistoryID").val(DiagnosisHistoryIDVal);
    changeSelectpicker("#DiagnosisHistoryID", 'refresh');
    console.log($("#DiagnosisHistoryID").selectpicker('size'));
    //search();
}





// 下来框公共方法
///getAgreements
function getselectMap(url,id,table){
    $.ajax({
        url :  url,
        type : "post",
        data: {keyId: table},
        success : function (data) {
             console.log(data.length);
            for (var i = 0; i < data.length; i++) {
                $('#'+id).append('<option value="'+data[i].keyId+'">'+data[i].valueName+'</option>');

            }
        }
    });

}