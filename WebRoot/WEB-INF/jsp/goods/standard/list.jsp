<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/goods/standard/list">
    <input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/goods/standard/list" method="post">
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
			<li><a class="add" href="/goods/standard/add" target="dialog" rel="goods_standard_add" width="600" height="350" title="添加产品规格" mask="true"><span>添加</span></a></li>
			<li><a class="delete" href="/goods/standard/del/{standardId}" target="ajaxTodo" title="你确定删除产品规格吗？"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="list" width="50%" layoutH="116">
		<thead>
			<tr>
			    <th>#</th>
			    <th>产品型号</th>
				<th>产品名称</th>
				<th>规格</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="standard" items="${standardList}" varStatus="i">
			<tr target="standardId" rel="${standard.standardId}">
			    <td>${i.index+1}</td>
			    <td>${standard.productModel}</td>
				<td>${standard.productName}</td>
				<td>${standard.standard}</td>
				<td>
				    <a class="button" href="/goods/standard/del/${standard.standardId}" target="ajaxTodo" title="删除产品规格？"><span>删除</span></a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>