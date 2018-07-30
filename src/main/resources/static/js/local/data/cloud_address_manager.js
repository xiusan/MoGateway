/* ============= ------云平台地址管理 ============== */


//添加云地址
function addCloudAddressManager(){

    var kjCloudAddress =  $("input[name=kjCloudAddress]").val();
    var customerCloudAddress =  $("input[name=customerCloudAddress]").val();
    //var isSynchronization =  $("input[name=isSynchronization]:checked").val();
    var isCertificate =  $("input[name=isCertificate]:checked").val();
    var RegUrl = new RegExp();


    RegUrl.compile("^(http|https|ftp)\\://([a-zA-Z0-9\\.\\-]+(\\:[a-zA-Z0-9\\.&%\\$\\-]+)*@)*((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|localhost|([a-zA-Z0-9\\-]+\\.)*[a-zA-Z0-9\\-]+\\.(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{2}))(\\:[0-9]+)*(/($|[a-zA-Z0-9\\.\\,\\?\\'\\\\\\+&%\\$#\\=~_\\-]+))*$");

    if(kjCloudAddress == ""){
        parent.layer.alert('科佳云地址不能为空');
        return;
    }
        /**
         *     if(customerCloudAddress == ""){
        parent.layer.alert('客户云地址不能为空');
        return window.location.Reload();
    }
         */

    if(!RegUrl.test(kjCloudAddress)){
        parent.layer.alert(kjCloudAddress+"这网址不是以http://https://开头，或者不是网址！");
        return false;
    }
    if(!RegUrl.test(customerCloudAddress)){
        parent.layer.alert(customerCloudAddress+"这网址不是以http://https://开头，或者不是网址！");
        return false;
    }



        $.ajax({
            url :  '/dataManager/addCloudAddressManager',
            type : "post",
            data : {
                'kjCloudAddress':kjCloudAddress,
                'customerCloudAddress':customerCloudAddress,
               // 'isSynchronization':isSynchronization,
                'isCertificate':isCertificate,
            },
            success : function (data) {
                if(data.code == "0"){
                    parent.layer.alert('添加成功');
                }else{
                    parent.layer.alert('添加失败');
                }
            }

        });

}

//修改云地址
function putCloudAddressManager(){

    var cloudId =  $("input[name=cloudId]").val();
    var kjCloudAddress =  $("input[name=kjCloudAddress]").val();
    var customerCloudAddress =  $("input[name=customerCloudAddress]").val();
    var isCertificate =  $("input[name=isCertificate]:checked").val();
    var RegUrl = new RegExp();


    RegUrl.compile("^(http|https|ftp)\\://([a-zA-Z0-9\\.\\-]+(\\:[a-zA-Z0-9\\.&%\\$\\-]+)*@)*((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|localhost|([a-zA-Z0-9\\-]+\\.)*[a-zA-Z0-9\\-]+\\.(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{2}))(\\:[0-9]+)*(/($|[a-zA-Z0-9\\.\\,\\?\\'\\\\\\+&%\\$#\\=~_\\-]+))*$");

    if(kjCloudAddress == ""){
        parent.layer.alert('科佳云地址不能为空');
        return ;
    }


    if(!RegUrl.test(kjCloudAddress)){
        parent.layer.alert(kjCloudAddress+"这网址不是以http://https://开头，或者不是网址！");
        return false;
    }
    if(!RegUrl.test(customerCloudAddress)){
        parent.layer.alert(customerCloudAddress+"这网址不是以http://https://开头，或者不是网址！");
        return false;
    }



    $.ajax({
        url :  '/dataManager/putCloudAddressManager',
        type : "post",
        data : {
            'cloudId':cloudId,
            'kjCloudAddress':kjCloudAddress,
            'customerCloudAddress':customerCloudAddress,
            'isCertificate':isCertificate,
        },
        success : function (data) {
            if(data.code == "0"){
                parent.layer.alert('修改成功');
                return ;
            }else{
                parent.layer.alert('修改失败');
                return ;
            }
        }

    });

}

//查询云地址信息
function queryCloudAddressManager(){
    $.ajax({
        url :  '/dataManager/queryCloudAddressManager',
        type : "post",
        data : {
        },
        success : function (data) {
            console.log(data.data[0].cloudId);
            $("input[id=cloudId]").val(data.data[0].cloudId);
            $("input[id=kjCloudAddress]").val(data.data[0].kjCloudAddress);
            $("input[id=customerCloudAddress]").val(data.data[0].customerCloudAddress);
            if(data.data[0].isCertificate == "1"){
                $("#isCertificate1").prop("checked",true);
            }else {
                $("#isCertificate2").prop("checked",true);
            }


        }
    });

}



