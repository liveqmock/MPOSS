<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/goods/product/list">
    <input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/goods/product/list" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					产品型号：
                    <input class="auto_productModel" type="text" name="product.productModel" value="${product.productModel}"/>
				</td>
				<td>
					产品名称：
                    <input class="auto_productName" type="text" name="product.productName" value="${product.productName}"/>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
    <div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="/goods/product/add" target="navTab" rel="goods_product_add" title="添加基础产品"><span>添加</span></a></li>
			<li><a class="add" href="javascript:ProductList.goImport();"><span>批量导入</span></a></li>
			<li><a class="edit" href="/goods/product/edit/{productId}" target="navTab" title="编辑产品"><span>修改</span></a></li>
			<li><a class="delete" href="/goods/product/del/{productId}" target="ajaxTodo" title="你确定删除产品吗？"><span>删除</span></a></li>
		</ul>
	</div>
	<form method="post" action="/goods/product/upload?navTabId=goods_product_list" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);">
		<table class="list" width="80%" layoutH="116">
			<thead>
				<tr>
				    <th>#</th>
				    <th>产品型号</th>
					<th>产品名称</th>
					<th>产品英文名</th>
					<th>计量单位</th>
					<th>装箱数量</th>
					<th>装箱重量</th>
					<th>装箱体积</th>
					<th>图片</th>
					<th>上传图片</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			    <c:forEach var="product" items="${productList}" varStatus="i">
				<tr target="productId" rel="${product.productId}">
				    <td>${i.index+1}</td>
				    <td>${product.productModel}</td>
					<td>${product.productName}</td>
					<td>${product.productEngName}</td>
					<td>${product.unit}</td>
					<td>${product.packQuantity}</td>
					<td>${myfn:formatWeight(product.packWeight)}</td>
					<td>${myfn:formatVolume(product.packVolume)}</td>
					<td><img src="${product.picImg}" width="90" height="65"/></td>
					<td><input name="myfiles" type="file"/></td>
					<td>
					    <a class="button" href="/goods/product/edit/${product.productId}" target="navTab" title="编辑产品"><span>修改</span></a>
					    <a class="button" href="/goods/product/del/${product.productId}" target="ajaxTodo" title="删除产品？"><span>删除</span></a>
					</td>
					<input type="hidden" name="productList[${i.index}].productId" value="${product.productId}" />
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
		<div style="position:absolute;bottom:200px;right:100px;">
		    <input type="image" src="/styles/dwz/uploadify/img/upload.jpg" type="submit"/>
		</div>
	</form>
</div>
<script type="text/javascript">
var ProductList = {
    goImport: function(){
        showModal('/goods/product/goImport',{width:1000,height:700});
        var $pagerForm = $("#pagerForm", navTab.getCurrentPanel());
		var args = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {}
		navTabPageBreak(args, '');
    }
};
</script>