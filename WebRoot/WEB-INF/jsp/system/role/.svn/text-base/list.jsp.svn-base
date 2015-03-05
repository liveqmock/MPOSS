<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/system/role/list"></form>

<div class="pageContent">
    <div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="/system/role/add" target="navTab" title="添加角色"><span>添加</span></a></li>
		</ul>
	</div>
	<table class="list" width="70%" layoutH="138">
		<thead>
			<tr>
				<th align="center">#</th>
				<th>角色名</th>
				<th>角色描述</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="role" items="${roleList}" varStatus="s">
			<tr target="roleId" rel="${role.roleId}">
				<td>${s.index + 1}</td>
				<td>${role.roleName}</td>
				<td>${role.roleDesc}</td>
				<td>
				    <a title="编辑角色" target="navTab" href="/system/role/edit/${role.roleId}" class="button"><span>修改</span></a>
				    <c:if test="${s.index!=0&&s.index!=1}">
				    <a title="你确定删除此角色吗？" target="ajaxTodo" href="/system/role/del/${role.roleId}" class="button"><span>删除</span></a>
				    </c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
