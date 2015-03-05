<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" action="/sale/make/product">
	<input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return dwzSearch(this, 'dialog');" action="/sale/make/product" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
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

	<table class="list" layoutH="126" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th>产品型号<br/>MODEL</th>
				<th>产品名称<br/>ITEM</th>
				<th>规格<br/>STANDER</th>
				<th>单位<br/>UNIT</th>
				<th>选择</th>
			</tr>
		</thead>
		<tbody id="goodsTbody">
		    <c:forEach var="product" items="${productList}">
		    <tr productId="${product.productId}" pic="${product.pic}">
				<td>${product.productModel}</td>
				<td>${product.productName}</td>
				<td>${product.standard}</td>
				<td>${product.unit}</td>
				<td><a class="btnSelect" href="javascript:void(0);" onclick="SaleProduct.addData(this);">选择</a></td>
			</tr>
		    </c:forEach>
		</tbody>
	</table>
	<c:import url="/WEB-INF/jsp/_frag/pager/panelBarForDialog.jsp"></c:import>
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</div>
<script type="text/javascript">
var SaleProduct = {
	
    addData: function(link){
        
        var $tr = $(link).closest("tr");
    
        var $tds = $tr.children();
        
        var productId = $tr.attr("productId");
        var pic = $tr.attr("pic");
        var productModel = $tds.eq(0).html();
        var productName = $tds.eq(1).html();
        var standard = $tds.eq(2).html();
        var unit = $tds.eq(3).html();
        
        //create tr'html for target table
        var trHtml = "<tr>"+
                         "<td><input class=\"textInput\" type=\"text\" name=\"saleDetailList["+SaleAdd.index+"].saleDetailNo\" value=\""+SaleAdd.saleDetailNo+"\" size=\"4\"/></td>"+
                         "<td>"+productModel+"</td>"+
                         "<td>"+productName+"</td>"+
                         "<td>"+standard+"</td>"+
                         "<td>"+unit+"</td>"+
                         "<td><input type=\"text\" size=\"5\" class=\"required textInput digits\" name=\"saleDetailList["+SaleAdd.index+"].saleQuantity\" onblur=\"SaleAdd.changeSaleQuantity(this);\"/></td>"+
                         "<td><input type=\"text\" size=\"5\" class=\"textInput number\" name=\"saleDetailList["+SaleAdd.index+"].inputSaleUnitPrice\" onblur=\"SaleAdd.changeUnitPrice(this);\"/></td>"+
                         "<td custom=\"salePrice\"></td>"+
                         "<td><input class=\"textInput\" type=\"text\" name=\"saleDetailList["+SaleAdd.index+"].saleDesc\"/></td>"+
                         "<td>"+
                             "<a href=\"javascript:void(0);\" class=\"button\" onclick=\"SaleAdd.removeRow(this);\"><span>移除</span></a>"+
                             "<a href=\"javascript:void(0);\" class=\"button\" onclick=\"SaleAdd.upRow(this);\"><span>上移</span></a>"+
                             "<a href=\"javascript:void(0);\" class=\"button\" onclick=\"SaleAdd.downRow(this);\"><span>下移</span></a>"+
                         "</td>"+
                         "<input type=\"hidden\" name=\"saleDetailList["+SaleAdd.index+"].no\" value=\""+SaleAdd.no+"\"/>"+
                         "<input type=\"hidden\" name=\"saleDetailList["+SaleAdd.index+"].productId\" value=\""+productId+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleDetailList["+SaleAdd.index+"].productModel\" value=\""+productModel+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleDetailList["+SaleAdd.index+"].productName\" value=\""+productName+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleDetailList["+SaleAdd.index+"].standard\" value=\""+standard+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleDetailList["+SaleAdd.index+"].pic\" value=\""+pic+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleDetailList["+SaleAdd.index+"].inputSalePrice\"/>"+
                     "</tr>";
        
        SaleAdd.index++;
        SaleAdd.no++;
        SaleAdd.saleDetailNo++;
	        
	    
	    $("#saleCount", navTab.getPanel('sale_make_add')).before(trHtml);
	    dynamicBindEnter($("#saleCount", navTab.getPanel('sale_make_add')).prev());
	    
	    alertMsg.info("已添加到销售单！");
    }
    
};
</script>