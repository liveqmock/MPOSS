<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	
	<form method="post" action="/goods/providerProduct/update?navTabId=goods_providerProduct_list" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<input type="hidden" name="providerProductId" value="${providerProduct.providerProductId}"/>
		<div class="pageFormContent nowrap" layoutH="57">
			<dl>
				<dt>厂家：</dt>
				<dd>
				    <input type="text" name="providerName" value="${providerProduct.providerName}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>型号：</dt>
				<dd>
				    <input type="text" name="productModel" value="${providerProduct.productModel}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>产品名：</dt>
				<dd>
				    <input type="text" name="productName" value="${providerProduct.productName}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>英文名：</dt>
				<dd>
				    <input type="text" name="productEngName" value="${providerProduct.productEngName}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>计量单位：</dt>
				<dd>
				    <input type="text" name="unit" value="${providerProduct.unit}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>采购单价：</dt>
				<dd>
				    <input type="text" name="inputUnitPrice" class="required number" value="${myfn:fromF2Y(providerProduct.unitPrice)}"/>
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