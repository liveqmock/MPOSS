<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" action="/sale/search/product">
	<input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return dwzSearch(this, 'dialog');" action="/sale/search/product" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					型号：
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
				<td><a class="btnSelect" href="javascript:void(0);" onclick="SaleEditProduct.addData(this);">选择</a></td>
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
var SaleEditProduct = {
	
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
                         "<td><input class=\"textInput\" type=\"text\" name=\"saleDetailList["+SaleEdit.index+"].saleDetailNo\" value=\""+SaleEdit.saleDetailNo+"\" size=\"4\"/></td>"+
                         "<td>"+productModel+"</td>"+
                         "<td>"+productName+"</td>"+
                         "<td>"+standard+"</td>"+
                         "<td>"+unit+"</td>"+
                         "<td><input type=\"text\" size=\"8\" class=\"textInput digits\" name=\"saleDetailList["+SaleEdit.index+"].saleQuantity\" onblur=\"SaleEdit.changeSaleQuantity(this);\"/></td>"+
                         "<td><input type=\"text\" size=\"6\" class=\"textInput number\" name=\"saleDetailList["+SaleEdit.index+"].inputSaleUnitPrice\" onblur=\"SaleEdit.changeUnitPrice(this);\"/></td>"+
                         "<td custom=\"salePrice\"></td>"+
                         "<td><input class=\"textInput\" type=\"text\" name=\"saleDetailList["+SaleEdit.index+"].saleDesc\"/></td>"+
                         "<td custom=\"hadBakQuantity\">0</td>"+
                         "<td>"+
                             "<a href=\"javascript:void(0);\" class=\"button\" onclick=\"Sale.removeRow(this);\"><span>移除</span></a>"+
                             "<a href=\"javascript:void(0);\" class=\"button\" onclick=\"Sale.upRow(this);\"><span>上移</span></a>"+
                             "<a href=\"javascript:void(0);\" class=\"button\" onclick=\"Sale.downRow(this);\"><span>下移</span></a>"+
                         "</td>"+
                         "<input type=\"hidden\" name=\"saleDetailList["+SaleEdit.index+"].no\" value=\""+SaleEdit.no+"\"/>"+
                         "<input type=\"hidden\" name=\"saleDetailList["+SaleEdit.index+"].productId\" value=\""+productId+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleDetailList["+SaleEdit.index+"].productModel\" value=\""+productModel+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleDetailList["+SaleEdit.index+"].productName\" value=\""+productName+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleDetailList["+SaleEdit.index+"].standard\" value=\""+standard+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleDetailList["+SaleEdit.index+"].pic\" value=\""+pic+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleDetailList["+SaleEdit.index+"].inputSalePrice\"/>"+
                     "</tr>";
        
        SaleEdit.index++;
        SaleEdit.no++;
        SaleEdit.saleDetailNo++;
        
	        
	    $("#saleCount", navTab.getPanel('sale_edit')).before(trHtml);
	    dynamicBindEnter($("#saleCount", navTab.getPanel('sale_edit')).prev());
	    
	    alertMsg.info("已添加到销售单！");
    }
    
};
</script>