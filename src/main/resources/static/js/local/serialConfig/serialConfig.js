/* ============= ------电表配置管理 ============== */
$(function(){
    $ajaxCommon('getSerialPorts', getSerialPorts, undefined ,'json', 'post');
})

function getSerialPorts(data) {
    for (var i = 0;i < data.length;i++) {
        $("#serialName").append("<option value='" + data[i] + "'>" + data[i] + "</option>");
    }
}
//串口号下拉框
function serialNames(){
    $.ajax({
        url :  '/serialConfig/serialConfigNames',
        type : "post",
        data : {
        },
        success : function (data) {
            //console.log(data.data.ammeters);
            var serialConfigs = data.data.serialConfigs;

            // console.log(agreementList);

            for (var i = 0; i < serialConfigs.length; i++) {
                $('#select-a').append('<option value="'+serialConfigs[i].serialName+'">'+serialConfigs[i].serialName+'</option>');

            }
        }
    });
}

//添加电表配置
    function addInfo(){

    var serialName =  $("#serialName").val();
    var serialBaudRate =  $("#serialBaudRate").val();
    var serialCheckoutId =  $("#serialCheckoutId").val();
        var re = /^[0-9]+.?[0-9]*$/; //判断字符串是否为数字 //判断正整数 /^[1-9]+[0-9]*]*$/

        if(serialName == ""){
            parent.layer.alert("串口号不能为空");
            return;
        }
        if(serialBaudRate == ""){
            parent.layer.alert("串口波特率不能为空");
            return;
        }
        if(serialCheckoutId == ""){
            parent.layer.alert("串口校验位不能为空");
            return;
        }

            $.ajax({
                url :  '/serialConfig/addSerialConfig',
                type : "post",
                data : {
                    'serialName':serialName,
                    'serialBaudRate':serialBaudRate,
                    'serialCheckoutId':serialCheckoutId
                },
                success : function (data) {
                    if(data.code == "0"){
                        parent.layer.alert("添加成功");
                        $('#modal-form').modal('hide');
                        $('#serial-config-table').bootstrapTable('refresh', {url: '/serialConfig/serialConfigs'});
                    }else{
                        parent.layer.alert(data.message);
                        $('#modal-form').modal('hide');
                        $('#serial-config-table').bootstrapTable('refresh', {url: '/serialConfig/serialConfigs'});
                    }
                }
            });
}




//获取电表配置
function getSerial() {

    var data =  $('#serial-config-table').bootstrapTable('getSelections');
    if (data == "") {
        parent.layer.alert('请选择要修改的数据');
        return    $('#serial-config-table').bootstrapTable('refresh', {url: '/serialConfig/serialConfigs'});
    }
    if (data.length>1) {
        parent.layer.alert('只能选择一条数据');
        return    $('#serial-config-table').bootstrapTable('refresh', {url: '/serialConfig/serialConfigs'});
    }
    for(var i = 0; i < data.length; i++){
        $("input[id=put-serialName]").val(data[i].serialName);
        $("input[id=put-serialBaudRate]").val(data[i].serialBaudRate);
        $("input[id=put-serialCheckoutId]").val(data[i].serialCheckoutId);
    }
    $('#modal-form1').modal();
}



//修改电表配置
function putSerial(){
    var serialName = $("input[id=put-serialName]").val();
    var serialBaudRate = $("input[id=put-serialBaudRate]").val();
    var serialCheckoutId = $("input[id=put-serialCheckoutId]").val();

    if(serialName == ""){
        parent.layer.alert("串口号号不能为空");
        return;
    }
    if(serialBaudRate == ""){
        parent.layer.alert("串口波特率不能为空");
        return;
    }
    if(serialCheckoutId == ""){
        parent.layer.alert("串口校验位不能为空");
        return;
    }

    $.ajax({
        url :  '/serialConfig/putSerialConfig',
        type : "post",
        data : {
            'serialName' : serialName,
            'serialBaudRate': serialBaudRate,
            'serialCheckoutId': serialCheckoutId
        },
        success : function (data) {
            //console.log(data);
            if(data.code == "0"){
                parent.layer.alert('修改成功');
                $('#modal-form1').modal('hide');
                $('#serial-config-table').bootstrapTable('refresh', {url: '/serialConfig/serialConfigs'});
            }else{
                parent.layer.alert(data.message);
                $('#modal-form1').modal('hide');
                $('#serial-config-table').bootstrapTable('refresh', {url: '/serialConfig/serialConfigs'});
            }
        }
    });
}




//删除电表配置
function delSerial(){

    var opts = $('#serial-config-table').bootstrapTable('getSelections');
    if (opts == "") {
        parent.layer.alert('请选择要删除的数据');
    }
    else {
        parent.layer.confirm('确定要删除选择的数据么？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
            var idArray = [];
            for (var i = 0; i < opts.length; i++) {
                idArray.push(opts[i].serialName);
            }
            //alert(idArray);
            $.ajax({
                url :  '/serialConfig/delSerialConfig',
                type : "post",
                data : {
                    'idArray' : JSON.stringify(idArray)
                },
                success : function (data) {
                   // console.log(data);
                    if(data.code == "0"){
                        parent.layer.alert('删除成功');
                        $('#serial-config-table').bootstrapTable('refresh', {url: '/serialConfig/serialConfigs'});
                    }else{
                        parent.layer.alert(data.message);
                        $('#modal-form1').modal('hide');
                        $('#serial-config-table').bootstrapTable('refresh', {url: '/serialConfig/serialConfigs'});
                    }
                }
            });
        }, function(){
            $('#serial-config-table').bootstrapTable('getSelections');
        });
    }
}

