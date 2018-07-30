/* ============= ------定时任务管理列表 ============== */

//添加定时任务
    function addTask(){

    var timedTaskName =  $("input[name=timedTaskName]").val();
    var cycle =  $("input[name=cycle]:checked").val();
    var startTime =  $("input[name=startTime]").val();
    var execuCycle =  $("input[name=execuCycle]").val();
    var cronExpression =  $("input[name=cronExpression]").val();
    var stopTime =  $("#stopTime").val();
    //var taskMethod =  $("input[name=taskMethod]").val();
    var method =  $("input[name=method]").val();
        if (startTime > stopTime) {
            parent.layer.alert("开始时间不能大于结束时间");
            return;
        }

    if (cronExpression == "") {
        parent.layer.alert("执行周期不能为空");
        return;
    }
    if(timedTaskName == ""){
        parent.layer.alert('任务名称不能为空');
        return;
    }


    var cron = "*/"+cronExpression+" * * * * ?";
            $.ajax({
                url :  '/task/addTask',
                type : "post",
                data : {
                    'timedTaskName':timedTaskName,
                    'cycle':cycle,
                    'startDateTime':startTime,
                   // 'execuCycle':execuCycle,
                    'cronExpression':cronExpression,
                    'stopDateTime':stopTime,
                    'method':method,
                },
                success : function (data) {
                    if(data.code == "0"){
                        parent.layer.alert('添加成功');
                        $('#modal-form').modal('hide');
                        $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
                    }else{
                        parent.layer.alert(data.message);
                        $('#modal-form').modal('hide');
                        $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
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

function timestampToTime(timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear() + '-';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    D = date.getDate() + ' ';
    h = date.getHours() + ':';
    m = date.getMinutes() + ':';
    s = date.getSeconds();
    return Y+M+D+h+m+s;
}




//获取定时任务详细信息
function getTask() {

    var data = $('#task-table').bootstrapTable('getSelections');
    if (data == "") {
        parent.layer.alert('请选择要修改的数据');
        return $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
    }
    if (data.length>1) {
        parent.layer.alert('只能选择一条数据');
        return $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
    }
    //console.log(data);

    for(var i = 0; i < data.length; i++){

        //console.log(data[i].timedTaskName);
        $("input[id=put-timedTaskId]").val(data[i].timedTaskId);
        $("input[id=put-timedTaskName]").val(data[i].timedTaskName);
        if(timestampToTime(data[i].startTime) == "1970-01-1 8:0:0"){
            $("input[id=put-startTime]").val("");
        }else {
            $("input[id=put-startTime]").val(timestampToTime(data[i].startTime));
        }

        if(timestampToTime(data[i].stopTime) == "1970-01-1 8:0:0"){
            $("input[id=put-stopTime]").val("");
        }else {
            $("input[id=put-stopTime]").val( timestampToTime(data[i].stopTime) );
        }



        $("input[id=put-taskMethod]").val(data[i].taskMethod);
        $("input[id=put-method]").val(data[i].method);
        $("input[id=put-cronExpression]").val(data[i].cronExpression);
        $("input[id=put-jobGroupName]").val(data[i].jobGroupName);
        //$("input[id=put-execuCycle]").val(data[i].execuCycle);
        //console.log(data[i].cycle);

        if(data[i].cycle == "0"){
            $("#put-cycle1").prop("checked",true);
        }else{
            $("#put-cycle2").prop("checked",true);
        }
    }
    $('#modal-form1').modal();
}

//修改定时任务信息
function putTask(){
    var timedTaskId = $("input[id=put-timedTaskId]").val();
    var jobGroupName = $("input[id=put-jobGroupName]").val();
    var timedTaskName=  $("input[id=put-timedTaskName]").val();
    var startDateTime=$("input[id=put-startTime]").val();
    var stopDateTime=$("input[id=put-stopTime]").val(  );
    var taskMethod=$("input[id=put-taskMethod]").val();
    var method=$("input[id=put-method]").val();
    var cronExpression= $("input[id=put-cronExpression]").val();
    var cycle =  $("input[name=cycle]").val();

    if (startDateTime > stopDateTime) {
        parent.layer.alert("开始时间不能大于结束时间");
        return;
    }
    if (cronExpression == "") {
        parent.layer.alert("执行周期不能为空");
        return;
    }
    if(timedTaskName == ""){
        parent.layer.alert('任务名称不能为空');
        return ;
    }

    //alert(idArray);
    $.ajax({
        url :  '/task/putTask',
        type : "post",
        data : {
            'timedTaskId' : timedTaskId,
            'timedTaskName': timedTaskName,
            'startDateTime': startDateTime,
            'stopDateTime': stopDateTime,
            'cronExpression': cronExpression,
            //'cycle': cycle,
            'jobGroupName': jobGroupName,
            //'taskMethod': taskMethod,
            'method': method
        },
        success : function (data) {
            //console.log(data);
            if(data.code == "0"){
                parent.layer.alert('修改成功');

                $('#modal-form1').modal('hide');
                $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
            }else{
                parent.layer.alert(data.message);
                $('#modal-form1').modal('hide');
                $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
            }
        }
    });
}

//删除任务
function delTask(){

        var opts = $('#task-table').bootstrapTable('getSelections');
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
                    idArray.push(opts[i].timedTaskId);
                }
                //alert(idArray);
                $.ajax({
                    url :  '/task/delTask',
                    type : "post",
                    data : {
                        'idArray' : JSON.stringify(idArray)
                    },
                    success : function (data) {
                        console.log(data);
                        if(data.code == "0"){
                            parent.layer.alert('删除成功');
                            $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
                        }else{
                            parent.layer.alert('删除失败');
                            $('#modal-form1').modal('hide');
                            $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
                        }
                    }
                });
            }, function(){
                $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
            });
        }
}


//暂停任务
function stopTask(){

    var opts = $('#task-table').bootstrapTable('getSelections');
    if (opts == "") {
        parent.layer.alert('请选择要暂停的数据');
    }
    else {
        parent.layer.confirm('确定要暂停选择的数据么？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
            var idArray = [];
            for (var i = 0; i < opts.length; i++) {
                idArray.push(opts[i].timedTaskId);
            }
            //alert(idArray);
            $.ajax({
                url :  '/task/putTaskStatus',
                type : "post",
                data : {
                    'idArray' : JSON.stringify(idArray),
                    'taskStatus':"1",
                },
                success : function (data) {
                    console.log(data);
                    if(data.code == "0"){
                        parent.layer.alert('暂停成功');
                        $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
                    }else{
                        parent.layer.alert('暂停失败');
                        $('#modal-form1').modal('hide');
                        $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
                    }
                }
            });
        }, function(){
            $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
        });
    }
}

//恢复任务
function recoveryTask(){

    var opts = $('#task-table').bootstrapTable('getSelections');
    if (opts == "") {
        parent.layer.alert('请选择要恢复的数据');
    }
    else {
        parent.layer.confirm('确定要恢复选择的数据么？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
            var idArray = [];
            for (var i = 0; i < opts.length; i++) {
                idArray.push(opts[i].timedTaskId);
            }
            //alert(idArray);
            $.ajax({
                url :  '/task/putTaskStatus',
                type : "post",
                data : {
                    'idArray' : JSON.stringify(idArray),
                    'taskStatus':"0",
                },
                success : function (data) {
                    console.log(data);
                    if(data.code == "0"){
                        parent.layer.alert('恢复成功');
                        $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
                    }else{
                        parent.layer.alert('恢复失败');
                        $('#modal-form1').modal('hide');
                        $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
                    }
                }
            });
        }, function(){
            $('#task-table').bootstrapTable('refresh', {url: '/task/taskList'});
        });
    }
}

