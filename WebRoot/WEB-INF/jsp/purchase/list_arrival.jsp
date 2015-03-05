<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="/purchase/listArrival">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/purchase/listArrival" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					厂家：
					<input class="auto_providerId" name="provider.providerId" value="${provider.providerId}" type="hidden"/>
					<input class="auto_providerName" type="text" name="provider.providerName" value="${provider.providerName}"/>
				</td>
				<td>
					按采购单查：<input class="textInput" type="text" name="purchaseNo" value="${purchaseNo}"/>
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
	<table class="list" width="100%" layoutH="62">
		<thead>
			<tr>
			    <th>#</th>
			    <th>采购单号</th>
			    <th>采购性质</th>
			    <th>关联销售单</th>
			    <th>厂家</th>
				<th>采购总额</th>
				<th>合同号</th>
			    <th>制单人</th>
				<th>制单时间</th>
				<th>采购备注</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach var="purchase" items="${purchaseList}" varStatus="i">
			<tr>
			    <td>${i.index+1}</td>
			    <td>${purchase.purchaseNo}</td>
			    <td>${myfn:getConstantName('PURCHASE_PROP', purchase.purchaseProp)}</td>
			    <td>
			        <c:set value="${fn:split(purchase.saleNos, ',')}" var="saleNos" />
			        <c:forEach var="saleNo" items="${saleNos}">${saleNo}<br/></c:forEach>
			    </td>
			    <td>${purchase.providerName}</td>
			    <td>${myfn:fromF2YForShow(purchase.totalPrice)}</td>
			    <td>${purchase.contractNo}</td>
			    <td>${myfn:getColumnValue('SYS_OPER.REAL_NAME', purchase.createOperId)}</td>
			    <td><fmt:formatDate value="${purchase.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			    <td>${myfn:substring(purchase.createDesc)}</td>
			    <td>${myfn:getConstantName('PURCHASE_STATUS', purchase.status)}</td>
			    <td>
			        <a bind="custom" purchaseId="${purchase.purchaseId}" class="button" href="/purchase/arrival/${purchase.purchaseId}" title="到货登记" target="dialog" mask="true" width="1000" height="700"><span>到货登记</span></a>
			    </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script type="text/javascript">
$(document).ready(function(){
    $("a[target='dialog']", navTab.getCurrentPanel()).click(function(event){
        
        event.preventDefault();
	    
	    var $this = $(this);
	    var purchaseId = $this.attr("purchaseId");
	    
	    var doArrival = false;
	    $.ajax({
            async: false,
            dataType: "json",
            type : "POST",
            url: "/purchase/arrivalCheck/"+purchaseId,
            success: function(data){
                if(data=='0'){
                    doArrival = true;
                }
            }
        });
        if(!doArrival){
            alertMsg.error("SORRY，为避免到货登记的重复误操作，请先将本采购单的历史到货数据进行确认！");
            return;
        }
	    
		var title = $this.attr("title") || $this.text();
		var rel = $this.attr("rel") || "_blank";
		var options = {};
		var w = $this.attr("width");
		var h = $this.attr("height");
		if (w) options.width = w;
		if (h) options.height = h;
		options.max = eval($this.attr("max") || "false");
		options.mask = eval($this.attr("mask") || "false");
		options.maxable = eval($this.attr("maxable") || "true");
		options.minable = eval($this.attr("minable") || "true");
		options.fresh = eval($this.attr("fresh") || "true");
		options.resizable = eval($this.attr("resizable") || "true");
		options.drawable = eval($this.attr("drawable") || "true");
		options.close = eval($this.attr("close") || "");
		options.param = $this.attr("param") || "";

		var url = unescape($this.attr("href")).replaceTmById($(event.target).parents(".unitBox:first"));
		DWZ.debug(url);
		if (!url.isFinishedTm()) {
			alertMsg.error($this.attr("warn") || DWZ.msg("alertSelectMsg"));
			return false;
		}
		$.pdialog.open(url, rel, title, options);
		
		return false;
    });
});
</script>