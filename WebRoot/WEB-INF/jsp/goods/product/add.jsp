<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	
	<form method="post" action="/goods/product/insert?navTabId=goods_product_list" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone)">
		<div class="pageFormContent nowrap" layoutH="57">
			<dl>
				<dt>产品型号：</dt>
				<dd>
					<input type="text" name="productModel" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>产品名称：</dt>
				<dd>
				    <input type="text" name="productName" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>产品英文名：</dt>
				<dd>
				    <input type="text" name="productEngName"/>
				</dd>
			</dl>
			<dl>
				<dt>计量单位：</dt>
				<dd>
				    <input type="text" name="unit" class="required"/>
				</dd>
			</dl>
			<dl>
				<dt>装箱数量：</dt>
				<dd>
				    <input type="text" name="packQuantity" class="required digits"/>
				</dd>
			</dl>
			<dl>
				<dt>装箱重量：</dt>
				<dd>
				    <input type="text" name="packWeight" class="required number"/>
				</dd>
			</dl>
			<dl>
				<dt>装箱体积：</dt>
				<dd>
				    <input type="text" name="packVolume" class="required number"/>
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