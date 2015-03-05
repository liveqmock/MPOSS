<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	
	<form method="post" action="/system/oper/update?navTabId=oper_list" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<input type="hidden" name="operId" value="${oper.operId}"/>
		<input id="roleIds" type="hidden" name="roleIds"/>
		<div class="pageFormContent nowrap" layoutH="57">
			<dl>
				<dt>用户名：</dt>
				<dd>
				    <input type="text" name="userName" class="required" readonly="readonly" value="${oper.userName}" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>姓名：</dt>
				<dd>
				    <input type="text" name="realName" class="required" value="${oper.realName}" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>性别：</dt>
				<dd>
				    <input type="radio" name="sex" value="1" <c:if test="${oper.sex=='1'}">checked="checked"</c:if> />男&nbsp;&nbsp;<input type="radio" name="sex" value="2" <c:if test="${oper.sex=='2'}">checked="checked"</c:if>/>女
				</dd>
			</dl>
			<dl>
				<dt>年龄：</dt>
				<dd>
				    <input type="text" name="age" class="digits" maxlength="20" value="${oper.age}"/>
				</dd>
			</dl>
			<dl>
				<dt>手机：</dt>
				<dd>
				    <input type="text" name="phone" class="digits" maxlength="20" value="${oper.phone}"/>
				</dd>
			</dl>
			<dl>
				<dt>地址：</dt>
				<dd>
				    <input type="text" name="address" maxlength="50" value="${oper.address}"/>
				</dd>
			</dl>
			<dl>
				<dt>QQ：</dt>
				<dd>
				    <input type="text" name="qq" class="digits" maxlength="20" value="${oper.qq}"/>
				</dd>
			</dl>
			<dl>
				<dt>微信号：</dt>
				<dd>
				    <input type="text" name="weixin" maxlength="20" value="${oper.weixin}"/>
				</dd>
			</dl>
			<dl>
				<dt>Email：</dt>
				<dd>
				    <input type="text" name="email" class="email" maxlength="20" value="${oper.email}"/>
				</dd>
			</dl>
			<dl>
				<dt>分配角色：</dt>
				<dd>
				    <ul id="treeDemo" class="ztree" style="border:1px solid #A2BAC0;height:300px;width:240px;overflow:auto;"></ul>
				</dd>
			</dl>
			<div id="resultBox"></div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>
<script type="text/javascript">
function onCheckRole(e, treeId, treeNode) {
    rememberCheckedRole();
}

function rememberCheckedRole(){
    var zTree = $.fn.zTree.getZTreeObj("treeDemo", navTab.getCurrentPanel());
	var checkedNodes = zTree.getCheckedNodes(true);
	var roleIds = "";
	$.each(checkedNodes,function(i,checkedNode){
	    if(roleIds==""){
	        roleIds += checkedNode.id;
	    }else{
	        roleIds += ","+checkedNode.id;
	    }
	});
	$("#roleIds", navTab.getCurrentPanel()).val(roleIds);
}
var OperEdit = {
    operId: ${oper.operId},
    setting: {
	    view: {
			selectedMulti: false
		},
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onCheck: onCheckRole
		}
	},
    loadCheckedRole: function(){
	    $.ajax({
	        cache: true,
	        async: false,
	        dataType: 'json', 
			type: 'post',
	        url: "/system/oper/findCheckedRoleForZTree/"+OperEdit.operId,
	        success: function(zNodes,status){
	            if(status=="success"){
	                $.fn.zTree.init($("#treeDemo", navTab.getCurrentPanel()), OperEdit.setting, zNodes);
	                rememberCheckedRole();
		        }
	        },
			error:DWZ.ajaxError
		});
	}
};
$(document).ready(function(){
    OperEdit.loadCheckedRole();
});
</script>