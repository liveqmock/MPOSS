<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	
	<form method="post" action="/partner/provider/insert?navTabId=partner_provider_list" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="57">
			<dl>
				<dt>厂家类型：</dt>
				<dd>
					<select class="combox required" name="providerType">
					    <option value="">请选择</option>
					    <c:forEach var="entry" items="${myfn:getConstantMap('PROVIDER_TYPE')}">
						<option value="${entry.key}">${entry.value}</option>
						</c:forEach>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>厂家性质：</dt>
				<dd>
					<select class="combox required" name="providerProp" id="providerProp">
					    <option value="">请选择</option>
					    <c:forEach var="entry" items="${myfn:getConstantMap('PROVIDER_PROP')}">
						<option value="${entry.key}">${entry.value}</option>
						</c:forEach>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>厂家名：</dt>
				<dd>
				    <input type="text" name="providerName" class="required" maxlength="20" onkeyup="copyToLinkMan(this);"/><span class="info">个人厂家填写姓名，单位厂家请填写单位名</span>
				</dd>
			</dl>
			<dl>
				<dt>联系人：</dt>
				<dd>
				    <input type="text" name="linkMan" class="required" maxlength="20" id="linkMan"/><span class="info">个人厂家的联系人同厂家名</span>
				</dd>
			</dl>
			<dl>
				<dt>联系电话：</dt>
				<dd>
				    <input type="text" name="phone" class="required" maxlength="20"/>
				</dd>
			</dl>
			<dl>
				<dt>联系地址：</dt>
				<dd>
				    <input type="text" name="address" maxlength="100"/>
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
    var providerName = $(input).val();
    var providerProp = $("#providerProp", navTab.getCurrentPanel()).val();
    if(providerProp == "2") return; //PROVIDER_PROP(2-单位厂家)
    $("#linkMan", navTab.getCurrentPanel()).val(providerName);
}
</script>