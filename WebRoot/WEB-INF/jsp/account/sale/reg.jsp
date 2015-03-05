<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
    <form method="post" action="/account/sale/doReg?navTabId=account_sale_list&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone,'您确定提交结账登记吗？')">
		<input type="hidden" name="targetId" value="${targetId}"/>
		<input type="hidden" name="billType" value="1"/> <!-- 销售收款 -->
		<div class="pageFormContent nowrap" layoutH="57">
		    <dl>
				<dt>支付客户：</dt>
				<dd>
				    <input type="text" name="targetName" class="required" readonly="readonly" value="${targetName}"/>
				</dd>
			</dl>
			<dl>
				<dt>支付日期：</dt>
				<dd>
				    <input type="text" name="payDate" class="required date" readonly="readonly" />
				</dd>
			</dl>
			<dl>
				<dt>支付方式：</dt>
				<dd>
				    <select class="combox required" name="payWay">
					    <option value="">请选择</option>
						<c:forEach var="entry" items="${myfn:getConstantMap('PAY_WAY')}">
						<option value="${entry.key}">${entry.value}</option>
						</c:forEach>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>支付金额：</dt>
				<dd>
				    <input type="text" name="inputPayPrice" class="required number"/>
				</dd>
			</dl>
			<dl>
				<dt>支付银行：</dt>
				<dd>
				    <input type="text" name="bankName"/>
				</dd>
			</dl>
			<dl>
				<dt>支付卡号：</dt>
				<dd>
				    <input type="text" name="bankCardNo" class="digits"/>
				</dd>
			</dl>
			<dl>
				<dt>凭证号：</dt>
				<dd>
				    <input type="text" name="payCertNo"/>
				</dd>
			</dl>
			<dl>
				<dt>收款账户：</dt>
				<dd>
					<input name="account.accountId" type="hidden"/>
					<input class="required" name="account.accountShow" type="text" postField="" suggestFields="accountShow" 
					suggestUrl="/suggest/suggestAccount" lookupGroup="account" autocomplete="on"/>
				</dd>
			</dl>
			<dl>
				<dt>备注：</dt>
				<dd><textarea name="regDesc" cols="80" rows="2"></textarea></dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
			    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	</form>
</div>