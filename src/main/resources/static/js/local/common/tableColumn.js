/**
 * Created by Administrator on 2018-04-26.
 */
/*连接管理*/
var connectManageColumns = [{title:'<input id="chkAll" type="checkbox" class="i-checks" name="input[]">',className:"td_center",orderable:false},{title: "类型"},{title: "IP"},{title: "端口"},{title: "波特率"},{title: "串口号"},{title: "方向"}, {title: "文件"},{title: "状态"},{title: "连接数"}, {title: "启用/禁用"}, {title: "访问地址"}];
var connectManageKeyArrays = ['connectType','connectIP','connectPort','connectBaudRate','connectSerialPort','connectDirection','connectFile','connectStatus','connectCount', 'enabled','connectHomeUrl']
/*事件管理*/
var eventTypeColumns = [{title:'<input id="chkAll" type="checkbox" class="i-checks" name="input[]">',className:"td_center",orderable:false},{title: "事件类型"},{title: "描述"}];
var eventTypeKeyArrays = ['eventTypeName','eventDescription'];
/*协议管理*/
var agreementManageColumns = [{title:'<input id="chkAll" type="checkbox" class="i-checks" name="input[]">',className:"td_center",orderable:false},{title: "协议ID"},{title: "协议名称"},{title: "文件地址"},{title: "访问地址"},{title: "状态"},{title: "设备数量"},{title: "启用/禁用"}];
var agreementManageKeyArrays = ['agreementID','agreementName','agreementAddr','agreementHomeUrl','agreementStatus','agreementCount','enabled']