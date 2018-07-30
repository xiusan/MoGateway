/* ============= ------电表管理 ============== */



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

                $('#select-b').append('<option value="'+agreementList[i].agreementID+'">'+agreementList[i].agreementName+'</option>');
                $('#put-agreementId').append('<option value="'+agreementList[i].agreementID+'">'+agreementList[i].agreementName+'</option>');

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
           // console.log(data.data.ammeters);
            var ammeters = data.data.ammeters;

            // console.log(agreementList);

            for (var i = 0; i < ammeters.length; i++) {
                $('#select-a').append('<option value="'+ammeters[i].ammeterId+'">'+ammeters[i].ammeterName+'</option>');
                $('#ammeterId').append('<option value="'+ammeters[i].ammeterId+'">'+ammeters[i].ammeterName+'</option>');

            }
        }
    });
}





//添加电表
    function addInfo(){

    var ammeterId =  $("input[name=ammeterId]").val();
    var ammeterName =  $("input[name=ammeterName]").val();

    var agreementId =  $("#agreementId").val();
    var enable =  $("#select-c").val();
       // console.log(ammeterId);
       // console.log(ammeterName);
       // console.log(agreementId);
       // console.log(enable);


        if(ammeterId == ""){
            parent.layer.alert("电表号不能为空");
            return;
        }
        if(ammeterName == ""){
            parent.layer.alert("电表名称不能为空");
            return;
        }
            $.ajax({
                url :  '/ammter/addAmmter',
                type : "post",
                data : {
                    'ammeterId':ammeterId,
                    'ammeterName':ammeterName,
                    'agreementId':agreementId,
                    'enable':enable
                },
                success : function (data) {
                    if(data.code == "0"){
                        parent.layer.alert("添加成功");
                        $('#modal-form').modal('hide');
                        $('#ammter-table').bootstrapTable('refresh', {url: '/ammter/ammters'});
                    }else{
                        parent.layer.alert(data.message);
                        $('#modal-form').modal('hide');
                        $('#ammter-table').bootstrapTable('refresh', {url: '/ammter/ammters'});
                    }
                }
            });
}


// 协议
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


//获取电表信息
function getAmmter() {

    var data = $('#ammter-table').bootstrapTable('getSelections');
    if (data == "") {
        parent.layer.alert('请选择要修改的数据');
        return  $('#ammter-table').bootstrapTable('refresh', {url: '/ammter/ammters'});
    }
    if (data.length>1) {
        parent.layer.alert('只能选择一条数据');
        return  $('#ammter-table').bootstrapTable('refresh', {url: '/ammter/ammters'});
    }
    //console.log(data);

    for(var i = 0; i < data.length; i++){
        $("input[id=put-ammeterId]").val(data[i].ammeterId);
        $("input[id=put-ammeterName]").val(data[i].ammeterName);
        $("#put-agreementId").find("option[value='"+data[i].agreementId+"']").attr("selected",true);
        $("#put-select-c").find("option[value='"+data[i].enable+"']").attr("selected",true);
    }
    $('#modal-form1').modal();
}



//修改电表
function putAmmter(){
    var ammeterId = $("input[id=put-ammeterId]").val();
    var ammeterName = $("input[id=put-ammeterName]").val();
    var agreementId =  $("#put-agreementId").val();
    var enable =  $("#put-select-c").val();

    if(ammeterId == ""){
        parent.layer.alert("电表号不能为空");
        return;
    }
    if(ammeterName == ""){
        parent.layer.alert("电表名称不能为空");
        return;
    }

    $.ajax({
        url :  '/ammter/putAmmter',
        type : "post",
        data : {
            'ammeterId' : ammeterId,
            'ammeterName': ammeterName,
            'agreementId': agreementId,
            'enable': enable
        },
        success : function (data) {
            //console.log(data);
            if(data.code == "0"){
                parent.layer.alert('修改成功');

                $('#modal-form1').modal('hide');
                $('#ammter-table').bootstrapTable('refresh', {url: '/ammter/ammters'});
            }else{
                parent.layer.alert(data.message);
                $('#modal-form1').modal('hide');
                $('#ammter-table').bootstrapTable('refresh', {url: '/ammter/ammters'});
            }
        }
    });
}




//删除电表
function delAmmter(){

    var opts = $('#ammter-table').bootstrapTable('getSelections');
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
                idArray.push(opts[i].ammeterId);
            }
            //alert(idArray);
            $.ajax({
                url :  '/ammter/delAmmter',
                type : "post",
                data : {
                    'idArray' : JSON.stringify(idArray)
                },
                success : function (data) {
                   // console.log(data);
                    if(data.code == "0"){
                        parent.layer.alert('删除成功');
                        $('#ammter-table').bootstrapTable('refresh', {url: '/ammter/ammters'});
                    }else{
                        parent.layer.alert(data.message);
                        $('#modal-form1').modal('hide');
                        $('#ammter-table').bootstrapTable('refresh', {url: '/ammter/ammters'});
                    }
                }
            });
        }, function(){
            $('#ammter-table').bootstrapTable('getSelections');
        });
    }
}

