/* ============= ------实时状态列表 ============== */
function equipmentNo(){
    $.ajax({
        url :  '/realTime/realTimeList',
        type : "post",
        data : {
        },
        success : function (data) {
            // console.log(data);
            var realTimeList = data.data.list;
            // console.log(equipmentlist);
            for (var i = 0; i < realTimeList.length; i++) {

                $('#select-a').append('<option value="'+realTimeList[i].equipmentNo+'">'+realTimeList[i].equipmentNo+'</option>');

            }
        }
    });

}




//数据库日期转化为JSON在页面显示
function date2String(time){
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();;
    return year + "-" + month + "-" + date;
}


function dateString(value) {
        if(value == null ){
            return "-"
        }
        //日期时间戳转换
        var time = new Date(value);
        var y = time.getFullYear();//年
        var m = time.getMonth() + 1;//月
        var d = time.getDate();//日
        var h = time.getHours();//时
        var mm = time.getMinutes();//分
        var s = time.getSeconds();//秒
        return y+"-"+m+"-"+d+" "+h+":"+mm+":"+s;
}

function isNull(value) {
    if(value == 0){
        return "0";
    }else if(value == null || value == "-"){
        return "0";
    }else {
        return value;
    }

}

//数据库时间转化为JSON在页面显示
function timeStamp2String(time){
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
}

function realTimeList(){
    $.ajax({
        url :  '/realTime/realTimeList',
        type : "post",
        data : {
        },
        success : function (data) {
            //console.log(data);
            var realTimes = data.data.list;
            //  $('.demandlist ul').empty();
            // console.log(equipmentlist);
            for(var i=0;i<realTimes.length;i++){
                //alert("asd");
                //console.log(equipmentlist[i].equipmentid);
                $('.realTimes  ul').append(
                    '<li style="width: 500px;height: 250px;background-color: #F0F9FF;float: left;margin-top: 20px;margin-left: 20px">'+
                   // '<input id="workStatus" name="workStatus" onload="imgStatus(realTimes[i].workStatus)"   hidden="hidden">'+
                        '<p style="width: 600px;float: left">'+
                            '<h3 class="equipmentNo" style="float: left"><label >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +realTimes[i].equipmentNo+'</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3>'+
                            ' <h3 class="communicateStatus" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通讯状态:&nbsp;&nbsp;&nbsp; <label  style="color: #1BBB9E">' +communicateStatus(realTimes[i].communicateStatus)+'</label></h3>'+
                            '<h3 class="workStatus" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工作状态:&nbsp;&nbsp;&nbsp;<label  style="color: #1BBB9E">' +workStatus(realTimes[i].workStatus)+'</label></h3>'+
                            //'<h3 class="chargingGunStatus" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;枪连接状态:&nbsp;&nbsp;&nbsp;<label class="chargingGunStatus" style="color: #1BBB9E">' +realTimes[i].chargingGunStatus+'</label></h3>'+
                            '<h3 class="faultStatus" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;故障状态:&nbsp;&nbsp;&nbsp;<label >' +faultStatus(realTimes[i].faultStatus)+'</label></h3>'+
                        '</p>'+
                        '<p class="p2" style="width: 600px;margin-top: 20px;float: left">'+
                            ' <h3  class="chargedKwh"  style="float: left"><label style="color: #1BBB9E">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +isNull(realTimes[i].chargedKwh)+"%"+'</label><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
                    '' +
                    '' +
                    '' +
                    '<img    id="realTimeImg" name="realTimeImg" src="/img/real_time/'+imgStatus(realTimes[i].workStatus,realTimes[i].faultStatus,realTimes[i].communicateStatus)+'.png">' +
                    '' +
                    '' +
                    '' +
                    '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h3>'+
                            // '<h3 id="outputVoltage" class="outputVoltage" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电压(V):&nbsp;&nbsp;&nbsp;<label  style="color: #1f90d8">' +isNull(realTimes[i].outputVoltage)+'</label></h3>'+
                            // '<h3 id="startChargingDttm" class="startChargingDttm" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开始时间:&nbsp;&nbsp;&nbsp;<label style="color: #1f90d8">' +dateString(realTimes[i].startChargingDttm)+'</label></h3>'+
                            // '<h3 id="chargedTime" class="chargedTime" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已充时间:&nbsp;&nbsp;&nbsp;<label style="color: #1f90d8">' +isNull(realTimes[i].chargedTime)+'</label></h3>'+
                            // '<h3 id="outputCurrent" class="outputCurrent" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电流(A):&nbsp;&nbsp;&nbsp;<label  style="color: #1f90d8">' +isNull(realTimes[i].outputCurrent)+'</label></h3>'+
                            // '<h3 id="startChargingAmmeterNo" class="startChargingAmmeterNo" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开始表数:&nbsp;&nbsp;&nbsp;<label  style="color: #1f90d8">' +isNull(realTimes[i].startChargingAmmeterNo)+'</label></h3>'+
                            // '<h3 id="chargedKwh" class="chargedKwh" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已充电量:&nbsp;&nbsp;&nbsp;<label style="color: #1f90d8">' +isNull(realTimes[i].chargedKwh)+'</label></h3>'+
                            // '<h3 id="outputPower" class="outputPower" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;功率(KW):&nbsp;&nbsp;&nbsp;<label  style="color: #1f90d8">' +isNull(realTimes[i].outputPower)+'</label></h3>'+


                    '<h3 id="outputVoltage" class="outputVoltage" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电压(V):&nbsp;&nbsp;&nbsp;<label  style="color: #1f90d8">' +imgStatus2(realTimes[i].workStatus,realTimes[i].faultStatus,realTimes[i].communicateStatus,isNull(realTimes[i].outputVoltage)) +'</label></h3>'+
                    '<h3 id="startChargingDttm" class="startChargingDttm" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开始时间:&nbsp;&nbsp;&nbsp;<label style="color: #1f90d8">' +dateString(realTimes[i].startChargingDttm)+'</label></h3>'+
                    '<h3 id="chargedTime" class="chargedTime" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已充时间:&nbsp;&nbsp;&nbsp;<label style="color: #1f90d8">' +isNull(realTimes[i].chargedTime)+'</label></h3>'+
                    '<h3 id="outputCurrent" class="outputCurrent" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电流(A):&nbsp;&nbsp;&nbsp;<label  style="color: #1f90d8">' +isNull(realTimes[i].outputCurrent)+'</label></h3>'+
                    '<h3 id="startChargingAmmeterNo" class="startChargingAmmeterNo" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开始表数:&nbsp;&nbsp;&nbsp;<label  style="color: #1f90d8">' +isNull(realTimes[i].startChargingAmmeterNo)+'</label></h3>'+
                    '<h3 id="chargedKwh" class="chargedKwh" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已充电量:&nbsp;&nbsp;&nbsp;<label style="color: #1f90d8">' +isNull(realTimes[i].chargedKwh)+'</label></h3>'+
                    '<h3 id="outputPower" class="outputPower" style="float: left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;功率(KW):&nbsp;&nbsp;&nbsp;<label  style="color: #1f90d8">' +isNull(realTimes[i].outputPower)+'</label></h3>'+


                    '</p>'+
                    '</li>'

                );
            }


        }
    });
}


function communicateStatus(communicateStatus) {
    var str= communicateStatus;
    var ok = "正常";
    var  no = "断开";
    var  nothing = "-";
    if(str == "0"){
        return ok;
    }
    if(str == "1"){
        return no;
    }
    if(str == "3"){
        return nothing;
    }
}

function workStatus(workStatus) {
    var str= workStatus;
    var ok = "充电中";
    var  free = "空闲";
    var  stop = "充电结束";

    var  nothing = "-";
    if(str == "0"){
        return free;
    }
    if(str == "1"){
        return ok;
    }
    if(str == "2"){
        return stop;
    }
    if(str == "3"){
        return free;
    }
    return "-";


}

function faultStatus(faultStatus) {
    var str= faultStatus;
    var ok = "正常";
    var  no = "故障";
    var  nothing = "-";
    if(str == "0"){
        return ok;
    }
    if(str == "1"){
        return no;
    }
    if(str == "3"){
        return nothing;
    }
}



function imgStatus(workStatus,faultStatus,communicateStatus) {
    if (faultStatus == 1){
        // $("#outputVoltage").hide();
        // $("#startChargingDttm").hide();
        // $("#chargedTime").hide();
        // $("#outputCurrent").hide();
        // $("#startChargingAmmeterNo").hide();
        // $("#chargedKwh").hide();
        // $("#outputPower").hide();
        return "failure"
    }else if(workStatus ==0 && faultStatus==0 && communicateStatus==0){

        return "idling"
    }else if(workStatus ==1 && faultStatus==0 && communicateStatus==0){
        return "chongdian"
    }else if(workStatus ==2 && faultStatus==0 && communicateStatus==0){
        return "aftercharge"
    }else {

        return "failure"
    }
}



function imgStatus2(workStatus,faultStatus,communicateStatus,outputVoltage) {
    if (faultStatus == 1){

        return outputVoltage
    }else if(workStatus ==0 && faultStatus==0 && communicateStatus==0){

        return outputVoltage
    }else if(workStatus ==1 && faultStatus==0 && communicateStatus==0){
        return outputVoltage
    }else if(workStatus ==2 && faultStatus==0 && communicateStatus==0){
        return outputVoltage
    }else {
        $("#outputVoltage").hide();
        return outputVoltage
    }
}