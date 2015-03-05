<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<link href="/styles/dwz/themes/default/style.css" rel="stylesheet" type="text/css" />
<link href="/styles/dwz/themes/css/core.css" rel="stylesheet" type="text/css" />
<link href="/styles/dwz/themes/css/jquery.autocomplete.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="/styles/theme/css/zTree/zTreeStyle.css" />

<!--[if IE]>
<link href="/styles/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" />
<![endif]-->
<style type="text/css">
html,body{
    overflow:auto;
}
body{background: none repeat scroll 0 0 #FFFFFF;}
</style>
<script src="/styles/dwz/js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="/styles/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.core.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="/styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
<div class="page unitBox" style="display: block;">
<div class="pageHeader">
	<form rel="pagerForm" action="/partner/consumer/import" method="post"  enctype="multipart/form-data">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					客户数据文件：
					<input type="file" name="file"/>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">导入</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<form method="post" action="/partner/consumer/doImport" class="pageForm required-validate" onsubmit="return ConsumerImport.validateCallback(this, ConsumerImport.navTabAjaxDone, '你确定提交吗？');">
	    <div id="mycontainer">
		    <table class="list" width="100%">
				<thead>
					<tr>
					    <th>#</th>
					    <th>客户类型</th>
						<th>客户性质</th>
						<th>客户名</th>
						<th>联系人</th>
						<th>联系电话</th>
						<th>收货地址</th>
						<th>EMAIL</th>
						<th>QQ</th>
						<th>MSN</th>
						<th></th>
					</tr>
				</thead>
				<tbody id="tbody">
				    <c:forEach var="consumer" items="${consumerList}" varStatus="i">
					<tr>
					    <td>${i.index+1}</td>
					    <td>${myfn:getConstantName('CONSUMER_TYPE',consumer.consumerType)}</td>
						<td>${myfn:getConstantName('CONSUMER_PROP',consumer.consumerProp)}</td>
						<td>${consumer.consumerName}</td>
						<td>${consumer.linkMan}</td>
						<td>${consumer.phone}</td>
						<td>${consumer.address}</td>
						<td>${consumer.email}</td>
						<td>${consumer.qq}</td>
						<td>${consumer.msn}</td>
						<td>
						    <a class="button" href="javascript:void(0);" onclick="ConsumerImport.removeRow(this);"><span>移除</span></a>
						</td>
						<input type="hidden" name="consumerList[${i.index}].consumerType" value="${consumer.consumerType}"/>
						<input type="hidden" name="consumerList[${i.index}].consumerProp" value="${consumer.consumerProp}"/>
						<input type="hidden" name="consumerList[${i.index}].consumerName" value="${consumer.consumerName}"/>
						<input type="hidden" name="consumerList[${i.index}].linkMan" value="${consumer.linkMan}"/>
						<input type="hidden" name="consumerList[${i.index}].phone" value="${consumer.phone}"/>
						<input type="hidden" name="consumerList[${i.index}].address" value="${consumer.address}"/>
						<input type="hidden" name="consumerList[${i.index}].email" value="${consumer.email}"/>
						<input type="hidden" name="consumerList[${i.index}].qq" value="${consumer.qq}"/>
						<input type="hidden" name="consumerList[${i.index}].msn" value="${consumer.msn}"/>
					</tr>
					</c:forEach>
				</tbody>
			</table>
	    </div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close" onclick="window.close();">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>
<script type="text/javascript">
$(function(){	
	DWZ.init("/styles/dwz/dwz.frag.xml", {
		loginUrl:"/login_dialog", loginTitle:"登录",	// 弹出登录对话框
		//loginUrl:"/login",	// 跳到登录页面
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"/styles/dwz/themes"});
		}
	});
	
	var docHeight = $(document).height();
    $("#mycontainer").height(docHeight-99);
});
var ConsumerImport = {
    removeRow: function(link){
        $(link).closest("tr").remove();
    },
    validateCallback: function (form, callback, confirmMsg) {
		var $form = $(form);
	
		var _submitFn = function(){
			$.ajax({
				type: form.method || 'POST',
				url:$form.attr("action"),
				data:$form.serializeArray(),
				dataType:"json",
				cache: false,
				success: callback || DWZ.ajaxDone,
				error: DWZ.ajaxError
			});
		}
		
		if (confirmMsg) {
			alertMsg.confirm(confirmMsg, {okCall: _submitFn});
		} else {
			_submitFn();
		}
		
		return false;
	},
	navTabAjaxDone: function(json){
	    ConsumerImport.ajaxDone(json);
	},
	ajaxDone:function(json){
		if(json.statusCode == DWZ.statusCode.error) {
			if(json.message && alertMsg) {
			    var array = json.message.split("#");
			    alertMsg.error(array[0]);
			    if(array[1]){
			        var highLightRowArray = array[1].split(",");
			        for(index in highLightRowArray){
				        $("#tbody tr").eq(highLightRowArray[index]).css("background-color","#EAD48B");
				    }
			    }
			}
		} else {
			if(json.message && alertMsg){
				alertMsg.correct(json.message,{okCall:function(){
				    window.close();
				}});
			} 
		};
	}
	
};
</script>
</div>
