<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	
	<form method="post" action="/partner/consumer/insert?navTabId=partner_consumer_list" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="57">
			<dl>
				<dt>客户类型：</dt>
				<dd>
					<select class="combox required" name="consumerType">
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
					<select class="combox required" name="consumerProp" id="consumerProp">
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
				    <input type="text" name="consumerName" class="required" maxlength="20" onkeyup="copyToLinkMan(this);"/>
				</dd>
			</dl>
			<dl>
				<dt>联系人：</dt>
				<dd>
				    <input type="text" name="linkMan" class="required" maxlength="20" id="linkMan"/>
				</dd>
			</dl>
			<dl>
				<dt>联系电话：</dt>
				<dd>
				    <input type="text" name="phone" class="required" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>收货地址：</dt>
				<dd>
				    <input type="text" name="address" maxlength="100" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>Email：</dt>
				<dd>
				    <input type="text" name="email" maxlength="50"/>
				</dd>
			</dl>
			<dl>
				<dt>QQ：</dt>
				<dd>
				    <input type="text" name="qq" class="digits" maxlength="15"/>
				</dd>
			</dl>
			<dl>
				<dt>MSN：</dt>
				<dd>
				    <input type="text" name="msn" class="digits" maxlength="15"/>
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
function copyToLinkMan(input){
    var consumerName = $(input).val();
    var consumerProp = $("#consumerProp", navTab.getCurrentPanel()).val();
    if(consumerProp == "2") return; //CONSUMER_PROP(2-单位客户)
    $("#linkMan", navTab.getCurrentPanel()).val(consumerName);
}
</script>