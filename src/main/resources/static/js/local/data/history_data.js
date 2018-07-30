/* ============= ------历史数据列表 ============== */



//启用
function updateStart(){
    $('#start1').click(function(){

        var opts = $('#history-data-table').bootstrapTable('getSelections');
        if (opts == "") {
            parent.layer.alert("请选择要启用的数据");
        }
        else {

            parent.layer.confirm('确定要启用选中的数据么？', {
                btn: ['确定','取消'], //按钮
                shade: false //不显示遮罩
            }, function(){
                if($("#kjUrlAddress").prop("checked")==true){
                    var idArray = [];
                    for (var i = 0; i < opts.length; i++) {
                        idArray.push(opts[i].historyId);
                    }
                    //alert(idArray);
                    $.ajax({
                        url :  '/dataManager/putHistoryDataList',
                        type : "post",
                        data : {
                            'idArray' : JSON.stringify(idArray) ,
                            'isEnable': "1",
                            'isFlangKj': "1",
                        },
                        success : function (data) {
                            console.log(data);
                            if(data.code == "0"){
                                parent.layer.alert("启用成功");
                                $('#history-data-table').bootstrapTable('refresh', {url: '/dataManager/queryHistoryDataList'});
                            }
                        }
                    });
                }

                if($("#custUrlAddress").prop("checked")==true){
                    var idArray = [];
                    for (var i = 0; i < opts.length; i++) {
                        idArray.push(opts[i].historyId);
                    }
                    //alert(idArray);
                    $.ajax({
                        url :  '/dataManager/putHistoryDataList',
                        type : "post",
                        data : {
                            'idArray' : JSON.stringify(idArray) ,
                            'isEnable': "1",
                            'isFlangCust': "1",
                        },
                        success : function (data) {
                            console.log(data);
                            if(data.code == "0"){
                                parent.layer.alert("启用成功");
                                $('#history-data-table').bootstrapTable('refresh', {url: '/dataManager/queryHistoryDataList'});
                            }
                        }
                    });
                }
            }, function(){
                $('#queipment-table').bootstrapTable('refresh', {url: '/equipment/equipmentList'});
            });
        }
    })
}


//禁用
function updateStop(){
    $('#stop').click(function(){


        var opts = $('#history-data-table').bootstrapTable('getSelections');
        if (opts == "") {
            parent.layer.alert("请选择要禁用的数据");
        }
        else {
            parent.layer.confirm('确定要禁用选中的数据么？', {
                btn: ['确定','取消'], //按钮
                shade: false //不显示遮罩
            }, function(){
                if($("#kjUrlAddress").prop("checked")==true){
                    var idArray = [];
                    for (var i = 0; i < opts.length; i++) {
                        idArray.push(opts[i].historyId);
                    }
                    //alert(idArray);
                    $.ajax({
                        url :  '/dataManager/putHistoryDataList',
                        type : "post",
                        data : {
                            'idArray' : JSON.stringify(idArray) ,
                            'isFlangKj': "0",
                        },
                        success : function (data) {
                            console.log(data);
                            if(data.code == "0"){
                                parent.layer.alert("禁用成功");
                                $('#history-data-table').bootstrapTable('refresh', {url: '/dataManager/queryHistoryDataList'});
                            }
                        }
                    });
                }

                if($("#custUrlAddress").prop("checked")==true){
                    var idArray = [];
                    for (var i = 0; i < opts.length; i++) {
                        idArray.push(opts[i].historyId);
                    }
                    //alert(idArray);
                    $.ajax({
                        url :  '/dataManager/putHistoryDataList',
                        type : "post",
                        data : {
                            'idArray' : JSON.stringify(idArray) ,
                            'isFlangCust': "0",
                        },
                        success : function (data) {
                            console.log(data);
                            if(data.code == "0"){
                                parent.layer.alert("禁用成功");
                                $('#history-data-table').bootstrapTable('refresh', {url: '/dataManager/queryHistoryDataList'});
                            }
                        }
                    });
                }
            }, function(){
                $('#history-data-table').bootstrapTable('refresh', {url: '/dataManager/queryHistoryDataList'});
            });
        }
    })
}


//
function kjUrlAddress_cli(){
    if($("#kjUrlAddress").prop("checked")==true){
        $('#history-data-table').bootstrapTable('showColumn', 'isFlangKj');
        $('#history-data-table').bootstrapTable('hideColumn', 'isFlangCust');
    }
}

function kjUrlAddressonclick(){
    $('#kjUrlAddress').click(function(){
        if($("#kjUrlAddress").prop("checked")==true){
            $('#history-data-table').bootstrapTable('showColumn', 'isFlangKj');
            $('#history-data-table').bootstrapTable('hideColumn', 'isFlangCust');
        }
    })

}

function custUrlAddressonclick(){
    $('#custUrlAddress').click(function(){
        if($("#custUrlAddress").prop("checked")==true) {
            $('#history-data-table').bootstrapTable('hideColumn', 'isFlangKj');
            $('#history-data-table').bootstrapTable('showColumn', 'isFlangCust');
        }
    })

}




