/* ============= ------数据管理列表 ============== */

//数据管理--实时状态
/**
 function dataManagerRealTime(){
    $.ajax({
        url :  '/dataManager/dataManagerRealTime',
        type : "post",
        data : {
        },
        success : function (data) {

            var chargeRecord = data.data;
            // console.log(chargeRecord);

            for(var key in chargeRecord)
            {
               // alert("Key是:" + key);
               // alert("对应的值是:" + chargeRecord[key]);
                if (chargeRecord[key] == "equipmentNo"){
                    $('#realTimeCloum').append('<li ><input  id="'+chargeRecord[key]+'"  name="realTime"  type="checkbox" checked="checked" value="'+chargeRecord[key]+'"  >'+chargeRecord[key]+'</li>');
                }else if(chargeRecord[key] != "equipmentNo"){
                    $('#realTimeCloum').append('<li ><input  id="'+chargeRecord[key]+'"  name="realTime"  type="checkbox" value="'+chargeRecord[key]+'"  >'+chargeRecord[key]+'</li>');
                }


            }
        }
    });
}
 */

function dataManagerRealTime(){
    $.ajax({
        url :  '/dataManager/dataManagerRealTime',
        type : "post",
        data : {
        },
        success : function (data) {

            var dataManagerRealTimes = data.data;
            for(var i=0;i<dataManagerRealTimes.length;i++){
                    $('#realTimeCloum').append('<li ><input  id="'+dataManagerRealTimes[i].id+'"  name="realTime"  type="checkbox" value= "'+ dataManagerRealTimes[i].id +'"  >'+dataManagerRealTimes[i].keyName +'</li>');
            }

        }
    });
}



//添加数据管理--添加实时状态
function addRealTime(){
    obj = document.getElementsByName("realTime");
    check_val = [];
    for(k in obj){
        if(obj[k].checked){
            check_val.push(obj[k].value);
        }
    }

    //console.log(check_val);
    if(check_val.length==0){
        parent.layer.alert('请选择要同步的字段');
        return ;
    }

    $.ajax({
        url :  '/dataManager/addDataManagerRealTime',
        type : "post",
        data : {
            'checkVal':JSON.stringify(check_val),
        },
        success : function (data) {
            if(data.code=="0"){
                parent.layer.alert('保存成功');
                return ;
            }else {
                parent.layer.alert(data.message);
                return ;
            }
        }
    });
}


//添加数据管理--修改实时状态
function putRealTime(){
    obj = document.getElementsByName("realTime");
    check_val = [];
    for(k in obj){
        if(obj[k].checked){
            check_val.push(obj[k].value);
        }
    }

    //console.log(check_val);
    if(check_val.length==0){
        parent.layer.alert('请选择要同步的字段');
        return ;
    }

    $.ajax({
        url :  '/dataManager/putDataManagerRealTime',
        type : "post",
        data : {
            'checkVal':JSON.stringify(check_val),
        },
        success : function (data) {
            if(data.code=="0"){
                parent.layer.alert('修改成功');
                return ;
            }else {
                parent.layer.alert(data.message);
                return ;
            }
        }
    });
}

