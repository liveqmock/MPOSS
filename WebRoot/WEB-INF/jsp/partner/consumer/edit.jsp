<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	
	<form method="post" action="/partner/consumer/update?navTabId=partner_consumer_list" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<input type="hidden" name="consumerId" value="${consumer.consumerId}"/>
		<div class="pageFormContent nowrap" layoutH="57">
			<dl>
				<dt>客户类型：</dt>
				<dd>
					<select class="combox readonly required" name="consumerType" remember="${consumer.consumerType}">
					    <option value="">请选择</option>
					    <c:forEach var="entry" items="${myfn:getConstantMap('CONSUMER_TYPE')}">
						<option value="${entry.key}">${entry.value}</option>
						</c:forEach>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>客户性质：</dt>
				<dd>
					<select class="combox readonly required" name="consumerProp" remember="${consumer.consumerProp}">
					    <option value="">请选择</option>
					    <c:forEach var="entry" items="${myfn:getConstantMap('CONSUMER_PROP')}">
						<option value="${entry.key}">${entry.value}</option>
						</c:forEach>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>客户名：</dt>
				<dd>
				    <input type="text" name="consumerName" value="${consumer.consumerName}" class="required" readonly="readonly" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>联系人：</dt>
				<dd>
				    <input type="text" name="linkMan" class="required" maxlength="20" value="${consumer.linkMan}"/><span class="info">个人客户的联系人同客户名</span>
				</dd>
			</dl>
			<dl>
				<dt>联系电话：</dt>
				<dd>
				    <input type="text" name="phone" value="${consumer.phone}" class="required" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>收货地址：</dt>
				<dd>
				    <input type="text" name="address" value="${consumer.address}" maxlength="100" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>Email：</dt>
				<dd>
				    <input type="text" name="email" value="${consumer.email}" maxlength="50"/>
				</dd>
			</dl>
			<dl>
				<dt>QQ：</dt>
				<dd>
				    <input type="text" name="qq" value="${consumer.qq}" class="digits" maxlength="15"/>
				</dd>
			</dl>
			<dl>
				<dt>MSN：</dt>
				<dd>
				    <input type="text" name="msn" value="${consumer.msn}" class="digits" maxlength="15"/>
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