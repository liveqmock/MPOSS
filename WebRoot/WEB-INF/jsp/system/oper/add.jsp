<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	
	<form method="post" action="/system/oper/insert?navTabId=oper_list" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<input id="roleIds" type="hidden" name="roleIds"/>
		<div class="pageFormContent nowrap" layoutH="57">
			<dl>
				<dt>用户名：</dt>
				<dd>
				    <input type="text" name="userName" class="required" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>密码：</dt>
				<dd>
				    <input type="text" name="passwd" class="required" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>姓名：</dt>
				<dd>
				    <input type="text" name="realName" class="required" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>性别：</dt>
				<dd>
				    <input type="radio" name="sex" value="1"/>男&nbsp;&nbsp;<input type="radio" name="sex" value="2"/>女
				</dd>
			</dl>
			<dl>
				<dt>年龄：</dt>
				<dd>
				    <input type="text" name="age" class="digits" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>手机：</dt>
				<dd>
				    <input type="text" name="phone" class="digits" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>地址：</dt>
				<dd>
				    <input type="text" name="address" maxlength="50"/>
				</dd>
			</dl>
			<dl>
				<dt>QQ：</dt>
				<dd>
				    <input type="text" name="qq" class="digits" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>微信号：</dt>
				<dd>
				    <input type="text" name="weixin" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>Email：</dt>
				<dd>
				    <input type="text" name="email" class="email" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>分配角色：</dt>
				<dd>
				    <ul id="treeDemo" class="ztree" style="border:1px solid #A2BAC0;height:200px;width:180px;overflow:auto;"></ul>
				</dd>
			</dl>
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
var OperAdd = {
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
    loadRole: function(){
	    $.ajax({
	        cache: true,
	        async: false,
	        dataType: 'json', 
			type: 'post',
	        url: "/system/oper/findRoleForZTree",
	        success: function(zNodes,status){
	            if(status=="success"){
	                $.fn.zTree.init($("#treeDemo", navTab.getCurrentPanel()), OperAdd.setting, zNodes);
		        }
	        },
			error:DWZ.ajaxError
		});
	}
};
$(document).ready(function(){
    OperAdd.loadRole();
});
</script>