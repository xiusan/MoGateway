/* ============= ------设备管理列表 ============== */



//协议下拉框
function agreementList(){
    $.ajax({
        url :  '/getAgreements',
        type : "post",
        data : {
        },
        success : function (data) {
            //console.log(data);
            var agreementList = data.agreements;

           // console.log(agreementList);

            for (var i = 0; i < agreementList.length; i++) {

                $('#select-c').append('<option value="'+agreementList[i].agreementID+'">'+agreementList[i].agreementName+'</option>');

            }
        }
    });

}


//设备列表下拉框
function equipmentNo(){
    $.ajax({
        url :  '/equipment/equipmentList',
        type : "post",
        data : {
        },
        success : function (data) {
           // console.log(data);
            var equipmentlist = data.data.list;

           // console.log(equipmentlist);

            for (var i = 0; i < equipmentlist.length; i++) {

                $('#select-a').append('<option value="'+equipmentlist[i].equipmentNo+'">'+equipmentlist[i].equipmentNo+'</option>');

            }


        }
    });

}


//启用
function updateStart(){
    $('#start1').click(function(){

        var opts = $('#queipment-table').bootstrapTable('getSelections');
        if (opts == "") {
            parent.layer.alert("请选择要启用的数据");
        }
        else {
            parent.layer.confirm('确定要启用选中的数据么？', {
                btn: ['确定','取消'], //按钮
                shade: false //不显示遮罩
            }, function(){
                var idArray = [];
                for (var i = 0; i < opts.length; i++) {
                    idArray.push(opts[i].equipmentId);
                }

                //alert(idArray);
                $.ajax({
                    url :  '/equipment/putEquipment',
                    type : "post",
                    data : {
                        'idArray' : JSON.stringify(idArray) ,
                        'active': "true",
                    },
                    success : function (data) {
                        console.log(data);
                        if(data.code == "0"){
                            parent.layer.alert("启用成功");
                            $('#queipment-table').bootstrapTable('refresh', {url: '/equipment/equipmentList'});
                        }
                    }
                });
            }, function(){
                $('#queipment-table').bootstrapTable('refresh', {url: '/equipment/equipmentList'});
            });
        }
    })
}


//禁用
function updateStop(){
    $('#stop').click(function(){


        var opts = $('#queipment-table').bootstrapTable('getSelections');
        if (opts == "") {
            parent.layer.alert("请选择要禁用的数据");
        }
        else {
            parent.layer.confirm('确定要禁用选中的数据么？', {
                btn: ['确定','取消'], //按钮
                shade: false //不显示遮罩
            }, function(){
                var idArray = [];
                for (var i = 0; i < opts.length; i++) {
                    idArray.push(opts[i].equipmentId);
                }
                // alert(idArray);
                $.ajax({
                    url :  '/equipment/putEquipment',
                    type : "post",
                    data : {
                        'idArray' : JSON.stringify(idArray) ,
                        'active': "false",
                    },
                    success : function (data) {
                        console.log(data);
                        if(data.code == "0"){
                            parent.layer.alert("禁用成功");
                            $('#queipment-table').bootstrapTable('refresh', {url: '/equipment/equipmentList'});
                        }
                    }
                });
            }, function(){
                $('#queipment-table').bootstrapTable('refresh', {url: '/equipment/equipmentList'});
            });
        }
    })
}

//设备分配
    function addInfo(){

    //var count =  $("input[name=count]").val();
    var equipmentNo =  $("input[name=equipmentNo]").val();
    var equipmentName =  $("input[name=equipmentName]").val();
    var agreementId =  $("#agreementId").val();
    var ammeterId =  $("#ammeterId").val();
    var chargingStationId =  $("#chargingStationId").val();
    var equipmentType =  $("#equipmentType").val();
    var chargingConnectorType =  $("#chargingConnectorType").val();
    var manufacturer =  $("input[name=manufacturer]").val();
    var manufacturerDttm = $("input[name=manufacturerDttm]").val();
    var deliveryDttm = $("input[name=deliveryDttm]").val();
    var voltageUpperLimits = $("input[name=voltageUpperLimits]").val();
    var voltageLowerLimits = $("input[name=voltageLowerLimits]").val();
    var current = $("input[name=current]").val();
    var power = $("input[name=power]").val();
    var parkNo = $("input[name=parkNo]").val();
    var nationalStandard = $("input[name=nationalStandard]").val();
    var deviceId = $("input[name=deviceId]").val();
    var chargingGunNo = $("input[name=chargingGunNo]").val();


        var re = /^[0-9]+.?[0-9]*$/; //判断字符串是否为数字 //判断正整数 /^[1-9]+[0-9]*]*$/

        if(equipmentNo == ""){
            parent.layer.alert("设备号不能为空");
            return;
        }
        if(equipmentName == ""){
            parent.layer.alert("设备名称不能为空");
            return;
        }
        /**
         *         if (!re.test(count)) {

            parent.layer.alert("设备数量请输入数字");
            return;
        }
         */


    var bool = equipmentName.indexOf("#");
    if(bool < 0 ){
        parent.layer.alert('设备名称不规范，实例：1#充电桩');
        return;
    }


    if(equipmentType == ""){
        parent.layer.alert("设备类型不能为空");
        return;
    }
    if(manufacturer == ""){
        parent.layer.alert("生产厂家不能为空");
        return;
    }
    if(manufacturerDttm == ""){
        parent.layer.alert("请选择生产日期");
        return;
    }
    if(deliveryDttm == ""){
        parent.layer.alert("请选择投运日期");
        return;
    }




   // console.log(manufacturerdttm);
   // var equipmentname = $('#equipmentname').val();
    //var equipmenttype = $('#equipmenttype').val();
    //var agreementid = $('#agreementid').val();
    //var chargingstationid = $('#chargingstationid').val();
    //var manufacturerdttm = $('#manufacturerdttm').val();
    //var deliverydttm = $('#deliverydttm').val();

        //alert(equipmentno);
            $.ajax({
                url :  '/equipment/addEquipment',
                type : "post",
                data : {
                    //'count':count,
                    'equNo':equipmentNo,
                    'equName':equipmentName,
                    'equipmentType':equipmentType,
                    'agreementId':agreementId,
                    'ammeterId':ammeterId,
                    'manufacturer':manufacturer,
                    'manufacturerdttm_time':manufacturerDttm,
                    'deliverydttm_time':deliveryDttm,


                    'chargingStationId':chargingStationId,
                    'equipmentType':equipmentType,
                    'connectorType':chargingConnectorType,
                    'voltageUpperLimits':voltageUpperLimits,
                    'voltageLowerLimits':voltageLowerLimits,
                    'current':current,
                    'power':power,
                    'parkNo':parkNo,
                    'nationalStandard':nationalStandard,
                    'deviceId':deviceId,
                    'chargingGunNo':chargingGunNo
                },
                success : function (data) {
                    if(data.code == "0"){
                        parent.layer.alert("添加成功");
                        $('#modal-form').modal('hide');
                        $('#queipment-table').bootstrapTable('refresh', {url: '/equipment/equipmentList'});
                    }else{
                        parent.layer.alert(data.message);
                        $('#modal-form').modal('hide');
                        $('#queipment-table').bootstrapTable('refresh', {url: '/equipment/equipmentList'});
                    }
                }
            });
}


//设备分配 协议类型
function agreementType(){
    $.ajax({
        url :  '/getAgreements',
        type : "post",
        success : function (data) {
            //console.log(data);
            var agreementList = data.agreements;
            // console.log(agreementList);
            for (var i = 0; i < agreementList.length; i++) {
                $('#agreementId').append('<option value="'+agreementList[i].agreementID+'">'+agreementList[i].agreementName+'</option>');

            }
        }
    });

}


//电表下拉框
function ammeterList(){
    $.ajax({
        url :  '/equipment/ammters',
        type : "post",
        data : {
        },
        success : function (data) {
            console.log(data.data.ammeters);
            var ammeters = data.data.ammeters;

            // console.log(agreementList);

            for (var i = 0; i < ammeters.length; i++) {

                $('#ammeterId').append('<option value="'+ammeters[i].ammeterId+'">'+ammeters[i].ammeterName+'</option>');

            }
        }
    });

}


//设备类型
function equipmentTypeList(){
    $.ajax({
        url :  '/equipmentType/getEquipmentTypeList',
        type : "post",
        data : {
        },
        success : function (data) {
            console.log(data.data.equipmentTypes);
            var equipmentTypes = data.data.equipmentTypes;

            // console.log(agreementList);

            for (var i = 0; i < equipmentTypes.length; i++) {

                $('#equipmentType').append('<option value="'+equipmentTypes[i].equipmentType+'">'+equipmentTypes[i].equipmentTypeName+'</option>');

            }
        }
    });

}



//枪口类型
function charingConnectorTypeList(){
    $.ajax({
        url :  '/charingConnectorType/getCharingConnectorTypeList',
        type : "post",
        data : {
        },
        success : function (data) {
            console.log(data.data.charingConnectorTypes);
            var charingConnectorTypes = data.data.charingConnectorTypes;

            // console.log(agreementList);

            for (var i = 0; i < charingConnectorTypes.length; i++) {

                $('#chargingConnectorType').append('<option value="'+charingConnectorTypes[i].chargingConnectorType+'">'+charingConnectorTypes[i].chargingConnectorName+'</option>');

            }
        }
    });

}

//充电站类型
function chargingstationList(){
    $.ajax({
        url :  '/equipment/chargingstations',
        type : "post",
        data : {
        },
        success : function (data) {
            console.log(data.data.chargingstations);
            var chargingstations = data.data.chargingstations;

            // console.log(agreementList);

            for (var i = 0; i < chargingstations.length; i++) {

                $('#chargingStationId').append('<option value="'+chargingstations[i].chargingStationId+'">'+chargingstations[i].chargingStationName+'</option>');

            }
        }
    });

}
