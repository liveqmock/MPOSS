<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/system/oper/list"></form>

<div class="pageContent">
    <div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="/system/oper/add" target="navTab" title="添加操作员"><span>添加</span></a></li>
		</ul>
	</div>
	<table class="list" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>#</th>
				<th>用户名</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>手机</th>
				<th>地址</th>
				<th>QQ</th>
				<th>微信</th>
				<th>Email</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="oper" items="${operList}" varStatus="s">
			<tr target="operId" rel="${oper.operId}">
				<td>${s.index + 1}</td>
				<td>${oper.userName}</td>
				<td>${oper.realName}</td>
				<td>${oper.sex}</td>
				<td>${oper.age}</td>
				<td>${oper.phone}</td>
				<td>${oper.address}</td>
				<td>${oper.qq}</td>
				<td>${oper.weixin}</td>
				<td>${oper.email}</td>
				<td>${myfn:getConstantName('SYS_OPER.STATUS', oper.status)}</td>
				<td>
				    <c:if test="${s.index!=0}">
				    <a title="编辑操作员" target="navTab" href="/system/oper/edit/${oper.operId}" class="button"><span>编辑</span></a>
				    </c:if>
				    <c:choose>
				    <c:when test="${oper.status=='1'}">
				    <c:if test="${s.index!=0}">
				    <a title="确定要停用吗？" target="ajaxTodo" href="/system/oper/disable/${oper.operId}" class="button"><span>停用</span></a>
				    </c:if>
				    </c:when>
				    <c:otherwise>
				    <a title="确定要启用吗？" target="ajaxTodo" href="/system/oper/enable/${oper.operId}" class="button"><span>启用</span></a>
				    <c:if test="${s.index!=0}">
				    <a title="你确定删除此操作员吗？" target="ajaxTodo" href="/system/oper/del/${oper.operId}" class="button"><span>删除</span></a>
				    </c:if>
				    </c:otherwise>
				    </c:choose>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
