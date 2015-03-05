<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/system/log/list">
    <input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageContent">
	<table class="list" width="50%" layoutH="27">
		<tbody>
		    <c:forEach var="log" items="${logList}">
			<tr>
				<td><fmt:formatDate value="${log.logTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${log.userName}</td>
				<td>${log.logContent}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
</div>
