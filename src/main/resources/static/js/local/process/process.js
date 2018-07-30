$(function () {
    $.ajax({
        type: "POST",
        url: "../process/select",
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
            var html = '<option value="全部">全部</option>';
            var dataList = data.list;
            for (var i = 0; i < dataList.length; i++) {
                html += '<option value="' + dataList[i].equipmentId + '">' + dataList[i].equipmentName + '</option>';
            }
            $('#select_id_1').append(html);
        }
    });
});

$(".query-reset").click(function () {
    $("#startDate").val("");
    $("#endDate").val("");
});

$(".query-btn").click(function () {
    selectData({
        "mk": $("#select_id_1").val(),
        "startDate": $("#startDate").val(),
        "endDate": $("#endDate").val(),
        "type": "car"
    });
});


function selectData(obj) {
    $.ajax({
        type: "POST",
        url: "../process/list",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(obj),
        success: function (data) {
            $('#tbodyList').html("");
            var html = '';
            var dataList = data.list;
            for (var i = 1; i <= dataList.length; i++) {
                html += '<tr>  ' +
                    '       <td>' + dataList[i - 1].equipment_id + '</td>  ' +
                    '       <td>' + dataList[i - 1].file_path + '</td>  ' +
                    '       <td>' + dataList[i - 1].file_size + '</td>  ' +
                    '       <td>' + dataList[i - 1].fc + '</td>  ' +
                    '       <td><button type="button" class="btn btn-outline btn-info" onclick="xz_process(' + dataList[i - 1].id + ')">下载</button></td>  ' +
                    '   </tr>';
            }
            $('#tbodyList').append(html);

            var page = data.page;
            $("#pagination").pagination({
                currentPage: page.currentPage,
                totalPage: page.totalPage,
                isShow: true,
                count: 7,
                homePageText: "首页",
                endPageText: "尾页",
                prevPageText: "上一页",
                nextPageText: "下一页",
                callback: function(current) {
                    selectData({
                        "mk": $("#select_id_1").val(),
                        "startDate": $("#startDate").val(),
                        "currentPage": current,
                        "endDate": $("#endDate").val()
                    })
                }
            });
        }
    });
}



function xz_process(filePath){
    var turnForm = document.createElement("form");
    document.body.appendChild(turnForm);
    turnForm.method = 'post';
    turnForm.action = '../process/processFileDownLoad';
    turnForm.target = '_blank';

    var newElement = document.createElement("input");
    newElement.setAttribute("name", "id");
    newElement.setAttribute("type", "hidden");
    newElement.setAttribute("value", filePath);
    turnForm.appendChild(newElement);
    turnForm.submit();
}

