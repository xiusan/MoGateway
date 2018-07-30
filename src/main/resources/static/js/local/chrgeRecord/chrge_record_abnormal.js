/* ============= ------充电记录管理列表 ============== */

//车号，卡号下拉框
function number(){
    $.ajax({
        url :  '/chargeRecord/chargeRecordList',
        type : "post",
        success : function (data) {
           // console.log(data);
            var chargeRecordList = data.data.list;

           // console.log(equipmentlist);

            for (var i = 0; i < chargeRecordList.length; i++) {

                //$('#select-a').append('<option value="'+chargeRecordList[i].equipmentNo+'">'+chargeRecordList[i].equipmentNo+'</option>');
                $('#select-b').append('<option value="'+chargeRecordList[i].carNumber+'">'+chargeRecordList[i].carNumber+'</option>');
                $('#select-c').append('<option value="'+chargeRecordList[i].cardNumber+'">'+chargeRecordList[i].cardNumber+'</option>');

            }


        }
    });
}
//设备号
function equipmentNo(){
    $.ajax({
        url :  '/equipment/equipmentList',
        type : "post",
        data : {
        },
        success : function (data) {
            // console.log(data);
            var chargeRecordList = data.data.list;

            // console.log(equipmentlist);

            for (var i = 0; i < chargeRecordList.length; i++) {

                $('#select-a').append('<option value="'+chargeRecordList[i].equipmentNo+'">'+chargeRecordList[i].equipmentNo+'</option>');

            }


        }
    });
}

//充电记录度数，次数，时长
function chargeRecordCount(){
    $.ajax({
        url :  '/chargeRecord/chargeRecordStatistics',
        type : "post",
        data : {
            'isAbnormal':0,
        },
        success : function (data) {
            //console.log(data);
            var chargeRecord = data.data;
            //console.log(chargeRecord);
                $('#totalChargingKwh').append('<li ><h1><strong>'+chargeRecord.totalChargingKwh+'度</strong></h1></li>');
                $('#chargeCount').append('<li ><h1><strong>'+chargeRecord.chargeCount+'次</strong></h1></li>');
                $('#totalChargingDttm').append('<li ><h1><strong>'+chargeRecord.totalChargingDttm+'</strong></h1></li>');



        }
    });
}

