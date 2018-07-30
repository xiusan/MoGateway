/**
 * Created by Administrator on 2018-04-19.
 */
var eventRecords = undefined;
var eventRecordColumns = [{field: 'event',title: "事件"},{field: 'eventType',title: "事件类型"},{field: 'eventDTTM',title: "时间",formatter: timeStamp2String}]

$(function(){
    var start={elem:"#startDTTM",format:"YYYY-MM-DD hh:mm:ss",max:laydate.now(),istime:true,istoday:false,choose:function(datas){end.min=datas;end.start=datas}};
    var end={elem:"#endDTTM",format:"YYYY-MM-DD hh:mm:ss",max:laydate.now(),istime:true,istoday:false,choose:function(datas){start.max=datas}};
    laydate(start);
    laydate(end);
    $("#eventRecordTable").bootstrapTable('destroy');
    $("#eventRecordTable").bootstrapTable({
        //【发出请求的基础信息】
        url: 'getEventRecord',
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
                eventRecords = res.eventRecords;
                return {
                    "total": res.totalCnt,//总页数
                    "rows": eventRecords   //数据
                };
            } else if (res.result == "error") {
                layer.msg(messageContent["Search.Error"]);
            }
        },
        //【设置列】
        columns: eventRecordColumns
    });
    $ajaxCommon("getEventTypes", eventTypeOption, undefined, 'json', 'post');
});

function eventTypeOption(data) {
    if (data.result == "success") {
        var eventTypes = data.eventTypes;
        for (var i = 0;i < eventTypes.length;i++) {
            $("#eventType").append("<option value='" + eventTypes[i].eventType + "'>" + eventTypes[i].eventTypeName + "</option>");
        }
    }
}

function queryParams(params){
    return{
        pageNum: params.pageNumber,
        pageSize: params.pageSize,
        eventType: $("#eventType").val(),
        startDTTM: $("#startDTTM").val(),
        endDTTM: $("#endDTTM").val(),
    }
}

function search() {
    $('#eventRecordTable').bootstrapTable('refresh', {url: 'getEventRecord'});
}

function reset() {
    $("#eventType").val("");
    $("#startDTTM").val("");
    $("#endDTTM").val("");
}