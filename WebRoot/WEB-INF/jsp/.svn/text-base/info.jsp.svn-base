<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	
	<form method="post" action="/updInfo?callbackType=closeCurrent" class="pageForm" onsubmit="return validateCallback(this, dialogAjaxDone)">
	    <input type="hidden" name="operId" value="${oper.operId}"/>
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label>用户名：</label>
				<input type="text" name="userName" class="required" value="${oper.userName}" readonly="readonly"/>
			</div>
			<div class="unit">
				<label>真实姓名：</label>
				<input type="text" name="realName" class="required" value="${oper.realName}"/>
			</div>
			<div class="unit">
				<label>性别：</label>
				<input type="radio" name="sex" class="required" value="1" <c:if test="${oper.sex=='1'}">checked="checked"</c:if>/>男
				<input type="radio" name="sex" class="required" value="2" <c:if test="${oper.sex=='2'}">checked="checked"</c:if>/>女
			</div>
			<div class="unit">
				<label>年龄：</label>
				<input type="text" name="age" class="digits" value="${oper.age}"/>
			</div>
			<div class="unit">
				<label>手机：</label>
				<input type="text" name="phone" class="required" class="digits" value="${oper.phone}"/>
			</div>
			<div class="unit">
				<label>邮箱：</label>
				<input type="text" name="email" class="email" value="${oper.email}"/>
			</div>
			<div class="unit">
				<label>QQ：</label>
				<input type="text" name="qq" class="digits" value="${oper.qq}"/>
			</div>
			<div class="unit">
				<label>微信号：</label>
				<input type="text" name="weixin" value="${oper.weixin}"/>
			</div>
			<div class="unit">
				<label>地址：</label>
				<input type="text" name="address" size="50" value="${oper.address}"/>
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

