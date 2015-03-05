<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	
	<form method="post" action="/updPasswd?callbackType=closeCurrent" class="pageForm" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label>旧密码：</label>
				<input type="text" name="passwd" size="30" class="required"/>
			</div>
			<div class="unit">
				<label>新密码：</label>
				<input type="password" id="newPasswd" name="newPasswd" size="30" class="required alphanumeric" minlength="6" maxlength="20"/>
			</div>
			<div class="unit">
				<label>重复新密码：</label>
				<input type="password" size="30" class="required" equalto="#newPasswd"/>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>

