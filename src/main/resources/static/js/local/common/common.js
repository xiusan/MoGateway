/**
 * Created by Administrator on 2018-03-29.
 */
function getCheckbox(checkboxName) {
    var checkbox = {
        count: 0,
        row_index: []
    };
    var checkboxName = document.getElementsByName(checkboxName);
    var length = checkboxName && checkboxName.length || 0;
    for (i = 0; i < length; i++) {
        if (checkboxName[i] && checkboxName[i].checked == true) {
            checkbox.count += 1;
            checkbox.row_index.push(i);
        }
    }
    return checkbox;
}

function checkAll(checkAllID, checkboxName) {
    var checkAllDom = "#" + checkAllID;
    var checkboxNameDom = "input[name=" + checkboxName + "]";
    $(checkAllDom).on('ifChecked', function(event){
        $(checkboxNameDom).iCheck('check');
    });
    $(checkAllDom).on('ifUnchecked', function(event){
        $(checkboxNameDom).iCheck('uncheck');
    });
}

function fillDataTable(dataTableID, columns, jsonData, keyArray, checkbox) {
    var arrays = [];
    for (var i = 0;i < jsonData.length;i++) {
        var array = [];
        if (checkbox) {
            array.push('<input type="checkbox" class="i-checks" name="chk">');
        }
        for (var j = 0;j < keyArray.length;j++) {
            var key = keyArray[j];
            array.push(jsonData[i][key]);
        }
        arrays.push(array);
    }
    var tableObj = $("#" + dataTableID).dataTable ({
        data : arrays,
        columns : columns,
        destroy:true,
        bDestroy:true,
        bRetrieve:true,
        order: []
    })
    if (checkbox) {
        $(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",});
        checkAll('chkAll', 'chk');
    }
    return tableObj;
}

function $ajaxCommon(url, callback, dataJson, dataType, type) {
    $.ajax({
        url : url,
        type : type || 'post',
        dataType : dataType || 'json',
        data: dataJson,
        success : function(data) {
            if (typeof callback === 'function') {
                callback(data);
            }
        },
        error : function(data) {
            setTimeout(hideLoading, 500);
            if (data.status == "403" && data.statusText == "Forbidden") {
                layer.msg(messageContent["Access.Forbidden"]);
            } else {
                if (duplicateLoginFlag) {
                    layer.msg(messageContent["Login.DuplicateLogin"], "model3");
                } else {
                    if (data.responseText) {
                        if (data.responseText.indexOf("duplicateLogin") >= 0) {
                            layer.msg(messageContent["Login.DuplicateLogin"], "model3");
                            duplicateLoginFlag = true;
                        } else if (data.responseText.indexOf("loginTimeout") >= 0) {
                            layer.msg(messageContent["Login.Timeout"], "model3");
                        }
                    } else {
                        layer.msg(messageContent["Access.Failed"]);
                    }
                }
            }
        },
        timeout: function(data){
            setTimeout(hideLoading, 500);
            layer.msg(messageContent["Access.Timeout"]);
        }
    })
}

function getWebUploader(uploadPath, pickID, fileListID, callback) {
    var uploader = WebUploader.create({
        auto : false,
        duplicate : false,
        method: 'POST',
        // 文件接收服务端。
        server: uploadPath,
        // 选择文件的按钮。可选。
        pick: '#' + pickID,
        accept:{
            title:'jars',
            extensions: 'jar',
            mimeTypes: 'jar'
        }
    });
    uploader.on( 'fileQueued', function( file ) {
        var $list = $("#" + fileListID), //获取文件列表
            $li = $('<div id="' + file.id + '" class="file-item thumbnail">' +  '<div class="info">' + file.name + '</div>' + '</div>');
        $list.append( $li );
    });
    //成功事件,  针对一个文件
    uploader.on('uploadSuccess', callback);
    uploader.on('uploadError',function (type, arg1, arg2) {
        layer.msg("文件类型错误");
    });
    uploader.on('uploadComplete',function (type, arg1, arg2) {
        document.getElementById(fileListID).innerHTML = "";
    });
    return uploader;
}
function validform(formID){
    return $("#" + formID).validate();
}

function arrayToJson(formArray){
    var dataArray = {};
    $.each(formArray,function(){
        if(dataArray[this.name]){
            if(!dataArray[this.name].push){
                dataArray[this.name] = [dataArray[this.name]];
            }
            dataArray[this.name].push(this.value || '');
        }else{
            dataArray[this.name] = this.value || '';
        }
    });
    return JSON.parse(JSON.stringify(dataArray));
}

function confirm(title,btnVal1,btnval2) {
    //询问框
    parent.layer.confirm(title, {
        btn: [btnVal1,btnval2], //按钮
        shade: false //不显示遮罩
    }, sure, cancel)
}

//数据库时间转化为JSON在页面显示
function timeStamp2String(time){
    if (time) {
        var datetime = new Date();
        datetime.setTime(time);
        var year = datetime.getFullYear();
        var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : "" + (datetime.getMonth() + 1);
        var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : "" + datetime.getDate();
        var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : "" + datetime.getHours();
        var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : "" + datetime.getMinutes();
        var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : "" + datetime.getSeconds();
        return year + "-" + month + "-" + date +" "+ hour + ":" + minute + ":" + second;
    }
}


function fileDownload(filePath, url) {
    var turnForm = document.createElement("form");
    document.body.appendChild(turnForm);
    turnForm.method = 'post';
    turnForm.action = url;
    turnForm.target = '_blank';

    var newElement = document.createElement("input");
    newElement.setAttribute("name", "filePath");
    newElement.setAttribute("type", "hidden");
    newElement.setAttribute("value", filePath);
    turnForm.appendChild(newElement);
    turnForm.submit();
}
