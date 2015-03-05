<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/partner/provider/list">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/partner/provider/list" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					<select class="combox" name="providerType" remember="${providerType}">
						<option value="">厂家类型</option>
						<c:forEach var="entry" items="${myfn:getConstantMap('PROVIDER_TYPE')}">
						<option value="${entry.key}">${entry.value}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					厂家：
					<input class="auto_providerId" name="provider.providerId" value="${provider.providerId}" type="hidden"/>
					<input class="auto_providerName" type="text" name="provider.providerName" value="${provider.providerName}"/>
				</td>
				<td>
					按订单查：<input class="textInput" type="text" name="orderNo" value="${orderNo}"/>
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
			<li><a class="add" href="/partner/provider/add" target="navTab" rel="partner_provider_add" title="添加厂家"><span>添加</span></a></li>
			<li><a class="add" href="javascript:ProviderList.goImport();"><span>批量导入</span></a></li>
			<li><a class="edit" href="/partner/provider/edit/{providerId}" target="navTab" title="编辑厂家信息"><span>修改</span></a></li>
			<li><a class="delete" href="/partner/provider/del/{providerId}" target="ajaxTodo" title="你确定删除吗？"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="list" width="100%" layoutH="370">
		<thead>
			<tr>
			    <th>厂家类型</th>
				<th>厂家名</th>
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
		    <c:forEach var="provider" items="${providerList}">
			<tr target="providerId" rel="${provider.providerId}">
			    <td>${myfn:getConstantName('PROVIDER_TYPE', provider.providerType)}</td>
				<td>${provider.providerName}</td>
				<td>${provider.linkMan}</td>
				<td>${provider.phone}</td>
				<td>${provider.email}</td>
				<td>${provider.qq}</td>
				<td>${provider.msn}</td>
				<td>${provider.address}</td>
				<td>
				    <a title="修改厂家信息" target="navTab" href="/partner/provider/edit/${provider.providerId}" class="button"><span>修改</span></a>
				    <a title="确定删除吗？" target="ajaxTodo" href="/partner/provider/del/${provider.providerId}" class="button"><span>删除</span></a>
				</td>
				<td><a href="/partner/provider/consumeDetail/${provider.providerId}" rel="purchase_list" target="ajax"></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBar.jsp"></c:import>
	<div id="purchase_list"></div>
</div>
<script type="text/javascript">
$(document).ready(function(){
    $("tr[target='providerId']", navTab.getCurrentPanel()).bind("click", function(event){
        var $tr = $(event.target).parent();
        $tr.children().last().find("a[target='ajax']").click();
    });
});
var ProviderList = {
    goImport: function(){
        showModal('/partner/provider/goImport',{width:1000,height:700});
        var $pagerForm = $("#pagerForm", navTab.getCurrentPanel());
		var args = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {}
		navTabPageBreak(args, '');
    }
};
</script>