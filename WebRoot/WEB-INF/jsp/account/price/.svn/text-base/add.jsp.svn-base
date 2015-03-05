<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	
	<form method="post" action="/account/price/insert?navTabId=account_price_list" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="57">
			<dl>
				<dt>账户类型：</dt>
				<dd>
					<select class="combox readonly required" name="accountType">
					    <option value="">请选择</option>
					    <c:forEach var="entry" items="${myfn:getConstantMap('ACCOUNT_TYPE')}">
						<option value="${entry.key}" <c:if test="${entry.key=='2'}">selected="selected"</c:if> >${entry.value}</option>
						</c:forEach>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>开户行：</dt>
				<dd>
				    <select class="combox required" name="bankId">
					    <option value="">请选择</option>
						<c:forEach var="entry" items="${myfn:getColumnMap('ACC_BANK.BANK_NAME')}">
						<option value="${entry.key}">${entry.value}</option>
						</c:forEach>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>开户网点：</dt>
				<dd>
				    <input type="text" name="openNet" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>户名：</dt>
				<dd>
				    <input type="text" name="accountName" class="required" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>卡号：</dt>
				<dd>
				    <input type="text" name="accountNo" class="required digits" minlength="12" maxlength="19"/>
				</dd>
			</dl>
			<dl>
				<dt>金额：</dt>
				<dd>
				    <input type="text" name="inputPrice" class="required number"/>
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