var logHistorys = undefined;
var logHistoryColumns = [{field: 'moduleID',title: "功能模块"},{field: 'fileDateStart',title: "时间",formatter: timeStamp2String},{field: 'fileAddress',title: "文件"}, {title:"操作", formatter: operateRows}]
$(function () {
    var start={elem:"#startDTTM",format:"YYYY-MM-DD hh:mm:ss",max:laydate.now(),istime:true,istoday:false,choose:function(datas){end.min=datas;end.start=datas}};
    var end={elem:"#endDTTM",format:"YYYY-MM-DD hh:mm:ss",max:laydate.now(),istime:true,istoday:false,choose:function(datas){start.max=datas}};
    laydate(start);
    laydate(end);
    $("#logHistoryTable").bootstrapTable('destroy');
    $("#logHistoryTable").bootstrapTable({
        //【发出请求的基础信息】
        url: 'getLogHistory',
        method: 'post',
        contentType: "application/x-www-form-urlencoded",
        //【查询设置】
        queryParamsType:'',
        queryParams: queryParams,
        //【其它设置】
        locale:'zh-CN',//中文支持
        pagination: true,//是否开启分页（*）
        pageNumber:1,//初始化加载第一页，默认第一页
        pageSize: 10,//每页的记录行数（*）
        pageList: pageSize,//可供选择的每页的行数（*）
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        showRefresh:true,//刷新按钮
        dataType: "json",
        uniqueId: "timedTaskId",
        sortable: true,
        sortOrder: "asc",//排序方式
        showColumns: true,//是否显示所有的列（选择显示的列）
        showRefresh: true,//是否显示刷新按钮
        //bFilter: true,//过滤功能
        //bSort: true,//排序功能
        responseHandler: function(res) {
            if (res.result == "success") {
                logHistorys = res.logHistorys;
                return {
                    "total": res.totalCnt,//总页数
                    "rows": logHistorys   //数据
                };
            } else if (res.result == "error") {
                layer.msg(messageContent["Search.Error"]);
            }
        },
        //【设置列】
        columns: logHistoryColumns
    });
    $ajaxCommon("moduleList", moduleOption, undefined, 'json', 'post');
});

function moduleOption(data) {
    if (data.result == "error") {
        return;
    }
    var html = '';
    var modules = data.modules;
    for (var i = 0; i < modules.length; i++) {
        html += '<option value="' + modules[i].moduleID + '">' + modules[i].moduleName + '</option>';
    }
    $('#moduleID').append(html);
}

function queryParams(params){
    return{
        pageNum: params.pageNumber,
        pageSize: params.pageSize,
        moduleID: $("#moduleID").val(),
        fileDateStart: $("#startDTTM").val(),
        fileDateEnd: $("#endDTTM").val(),
    }
}

function resetForm() {
    $("#moduleId").val("");
    $("#startDTTM").val("");
    $("#endDTTM").val("");
}

function searchLogHistory() {
    $('#logHistoryTable').bootstrapTable('refresh', {url: 'getLogHistory'});
}

function operateRows(value, row, index) {
    value = "<a onclick='sureOperateRows(" + index + ")'>下载</a>";
    return value;
}

function sureOperateRows(index) {
    fileDownload(logHistorys[index].fileAddress, "/logFileDownLoad");
}


