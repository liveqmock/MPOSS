<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" action="/lookup/lookupUsableProvider">
	<input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageContent">

	<table class="table" layoutH="30" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th>厂家类型</th>
				<th>厂家名称</th>
				<th>联系人</th>
				<th>联系电话</th>
				<th>地址</th>
				<th>查找带回</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="provider" items="${providerList}">
		    <tr>
				<td>${provider.providerType}</td>
				<td>${provider.providerName}</td>
				<td>${provider.linkMan}</td>
				<td>${provider.phone}</td>
				<td>${provider.address}</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({providerId:'${provider.providerId}', providerName:'${provider.providerName}', engLetter:'${provider.engLetter}'})" title="查找带回">选择</a>
				</td>
			</tr>
		    </c:forEach>
		</tbody>
	</table>
</div>