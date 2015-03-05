<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/partner/consumer/list">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/partner/consumer/list" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					<select class="combox" name="consumerType">
						<option value="">客户类型</option>
						<c:forEach var="entry" items="${myfn:getConstantMap('CONSUMER_TYPE')}">
						<option value="${entry.key}" <c:if test="${entry.key==consumerType}">selected="selected"</c:if> >${entry.value}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					客户名：
					<input class="auto_consumerId" name="consumer.consumerId" value="${consumer.consumerId}" type="hidden"/>
					<input class="auto_consumerName" type="text" name="consumer.consumerName" value="${consumer.consumerName}"/>
				</td>
				<td>
					输订单查客户：<input class="textInput" type="text" name="orderNo" value="${orderNo}"/>
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
			<li><a class="add" href="/partner/consumer/add" target="navTab" rel="partner_consumer_add" title="添加客户"><span>添加</span></a></li>
			<li><a class="add" href="javascript:ConsumerList.goImport();"><span>批量导入</span></a></li>
			<li><a class="edit" href="/partner/consumer/edit/{consumerId}" target="navTab" title="编辑客户信息"><span>修改</span></a></li>
			<li><a class="delete" href="/partner/consumer/del/{consumerId}" target="ajaxTodo" title="你确定删除吗？"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="list" width="100%" layoutH="370">
		<thead>
			<tr>
			    <th>客户类型</th>
				<th>客户名</th>
				<th>联系人</th>
				<th>联系电话</th>
				<th>Email</th>
				<th>QQ</th>
				<th>MSN</th>
				<th>联系地址</th>
				<th>操作</th>
				<td></td>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="consumer" items="${consumerList}">
			<tr target="consumerId" rel="${consumer.consumerId}">
			    <td>${myfn:getConstantName('CONSUMER_TYPE', consumer.consumerType)}</td>
				<td>${consumer.consumerName}</td>
				<td>${consumer.linkMan}</td>
				<td>${consumer.phone}</td>
				<td>${consumer.email}</td>
				<td>${consumer.qq}</td>
				<td>${consumer.msn}</td>
				<td>${consumer.address}</td>
				<td>
				    <a title="修改客户信息" target="navTab" href="/partner/consumer/edit/${consumer.consumerId}" class="button"><span>修改</span></a>
				    <a title="你确定删除吗？" target="ajaxTodo" href="/partner/consumer/del/${consumer.consumerId}" class="button"><span>删除</span></a>
				</td>
				<td><a href="/partner/consumer/consumeDetail/${consumer.consumerId}" rel="sale_list" target="ajax"></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
	<div id="sale_list"></div>
</div>
<script type="text/javascript">
$(document).ready(function(){
    $("tr[target='consumerId']", navTab.getCurrentPanel()).bind("click", function(event){
        var $tr = $(event.target).parent();
        $tr.children().last().find("a[target='ajax']").click();
    });
});
var ConsumerList = {
    goImport: function(){
        showModal('/partner/consumer/goImport',{width:1000,height:700});
        var $pagerForm = $("#pagerForm", navTab.getCurrentPanel());
		var args = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {}
		navTabPageBreak(args, '');
    }
};
</script>