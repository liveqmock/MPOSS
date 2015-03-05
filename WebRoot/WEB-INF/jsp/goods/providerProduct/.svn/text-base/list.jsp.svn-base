<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/goods/providerProduct/list">
    <input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/goods/providerProduct/list" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					厂家：
					<input class="auto_providerId" name="provider.providerId" value="${provider.providerId}" type="hidden"/>
					<input class="auto_providerName" type="text" name="provider.providerName" value="${provider.providerName}"/>
				</td>
				<td>
					型号：
                    <input class="auto_productModel" type="text" name="product.productModel" value="${product.productModel}"/>
				</td>
				<td>
					产品名：
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
			<li><a class="add" href="/goods/providerProduct/add" target="navTab" rel="goods_providerProduct_add" title="添加厂家商品"><span>新增厂家产品</span></a></li>
			<li><a class="edit" href="/goods/provider/edit/{providerProductId}" target="navTab" title="编辑厂家产品"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="list" width="70%" layoutH=116">
		<thead>
			<tr>
			    <th>#</th>
			    <th>厂家</th>
			    <th>产品型号</th>
				<th>产品名称</th>
				<th>产品英文名</th>
				<th>计量单位</th>
				<th>单价</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="providerProduct" items="${providerProductList}" varStatus="i">
			<tr target="providerProductId" rel="${providerProduct.providerProductId}">
			    <td>${i.index+1}</td>
			    <td>${providerProduct.providerName}</td>
			    <td>${providerProduct.productModel}</td>
				<td>${providerProduct.productName}</td>
				<td>${providerProduct.productEngName}</td>
				<td>${providerProduct.unit}</td>
				<td>${myfn:fromF2YForShow(providerProduct.unitPrice)}</td>
				<td>
				    <a class="button" href="/goods/providerProduct/edit/${providerProduct.providerProductId}" target="navTab" title="编辑厂家产品"><span>修改</span></a>
				    <a class="button" href="/goods/providerProduct/del/${providerProduct.providerProductId}" target="ajaxTodo" title="删除厂家产品？"><span>删除</span></a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>