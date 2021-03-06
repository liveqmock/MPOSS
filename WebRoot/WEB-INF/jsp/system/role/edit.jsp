<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	
	<form method="post" action="/system/role/update?navTabId=role_list" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
	    <input type="hidden" name="roleId" value="${role.roleId}"/>
	    <input id="resourceIds" type="hidden" name="resourceIds"/>
		<div class="pageFormContent nowrap" layoutH="57">
			<dl>
				<dt>角色名：</dt>
				<dd>
				    <input type="text" name="roleName" class="required" readonly="readonly" value="${role.roleName}" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>角色描述：</dt>
				<dd><textarea name="roleDesc" cols="40" rows="2">${role.roleDesc}</textarea></dd>
			</dl>
			<dl>
				<dt>分配权限：</dt>
				<dd>
				    <ul id="treeDemo" class="ztree" style="border:1px solid #A2BAC0;height:300px;width:240px;overflow:auto;"></ul>
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
function onCheckResource(e, treeId, treeNode) {
    rememberCheckedResource();
}

function rememberCheckedResource(){
    var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	var checkedNodes = zTree.getCheckedNodes(true);
	var resoruceIds = "";
	$.each(checkedNodes,function(i,checkedNode){
	    if(resoruceIds==""){
	        resoruceIds += checkedNode.id;
	    }else{
	        resoruceIds += ","+checkedNode.id;
	    }
	});
	$("#resourceIds", navTab.getCurrentPanel()).val(resoruceIds);
}
var RoleEdit = {
    roleId: ${role.roleId},
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
			onCheck: onCheckResource
		}
	},
    loadCheckedResource: function(){
	    $.ajax({
	        cache: true,
	        async: false,
	        dataType: 'json', 
			type: 'post',
	        url: "/system/role/findCheckedResourceForZTree/"+RoleEdit.roleId,
	        success: function(zNodes,status){
	            if(status=="success"){
	                $.fn.zTree.init($("#treeDemo", navTab.getCurrentPanel()), RoleEdit.setting, zNodes);
	                rememberCheckedResource();
		        }
	        },
			error:DWZ.ajaxError
		});
	}
};
$(document).ready(function(){
    RoleEdit.loadCheckedResource();
});
</script>