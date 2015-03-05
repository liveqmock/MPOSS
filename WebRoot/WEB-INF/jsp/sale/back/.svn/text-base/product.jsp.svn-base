<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" action="/sale/back/product">
	<input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return dwzSearch(this, 'dialog');" action="/sale/back/product" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
			                    厂家：
					<input class="auto_providerId" name="provider.providerId" value="${provider.providerId}" type="hidden"/>
					<input class="auto_providerName" type="text" name="provider.providerName" value="${provider.providerName}"/>
			    </td>
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
			    <th>厂家</th>
				<th>产品型号<br/>MODEL</th>
				<th>产品名称<br/>ITEM</th>
				<th>规格<br/>STANDER</th>
				<th>单位<br/>UNIT</th>
				<th>选择</th>
			</tr>
		</thead>
		<tbody id="goodsTbody">
		    <c:forEach var="providerProduct" items="${providerProductList}">
		    <tr providerProductId="${providerProduct.providerProductId}" pic="${providerProduct.pic}">
		        <td>${providerProduct.providerName}</td>
		        <td>${providerProduct.productModel}</td>
				<td>${providerProduct.productName}<br/>${product.productEngName}</td>
				<td>${providerProduct.standard}</td>
				<td>${providerProduct.unit}</td>
				<td><a class="btnSelect" href="javascript:void(0);" onclick="SaleBackProduct.addData(this);">选择</a></td>
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
var SaleBackProduct = {
	
    addData: function(link){
        
        var $tr = $(link).closest("tr");
    
        var $tds = $tr.children();
        
        var providerProductId = $tr.attr("providerProductId");
        var pic = $tr.attr("pic");
        var providerName = $tds.eq(0).html();
        var productModel = $tds.eq(1).html();
        var productName = $tds.eq(2).html();
        var standard = $tds.eq(3).html();
        var unit = $tds.eq(4).html();
        
        //create tr'html for target table
        var trHtml = "<tr>"+
                         "<td><input class=\"textInput\" type=\"text\" name=\"saleBackDetailList["+SaleBack.index+"].saleBackDetailNo\" value=\""+SaleBack.saleBackDetailNo+"\" size=\"4\"/></td>"+
                         "<td>"+providerName+"</td>"+
                         "<td>"+productModel+"</td>"+
                         "<td>"+productName+"</td>"+
                         "<td>"+standard+"</td>"+
                         "<td>"+unit+"</td>"+
                         "<td><input type=\"text\" size=\"5\" class=\"textInput digits\" name=\"saleBackDetailList["+SaleBack.index+"].backQuantity\" onblur=\"SaleBack.changeSaleQuantity(this);\"/></td>"+
                         "<td><input type=\"text\" size=\"5\" class=\"textInput number\" name=\"saleBackDetailList["+SaleBack.index+"].inputBackUnitPrice\" onblur=\"SaleBack.changeUnitPrice(this);\"/></td>"+
                         "<td custom=\"backPrice\"></td>"+
                         "<td><input class=\"textInput\" type=\"text\" name=\"saleBackDetailList["+SaleBack.index+"].backDesc\"/></td>"+
                         "<td>"+
                             "<a href=\"javascript:void(0);\" class=\"button\" onclick=\"SaleBack.removeRow(this);\"><span>移除</span></a>"+
                             "<a href=\"javascript:void(0);\" class=\"button\" onclick=\"SaleBack.upRow(this);\"><span>上移</span></a>"+
                             "<a href=\"javascript:void(0);\" class=\"button\" onclick=\"SaleBack.downRow(this);\"><span>下移</span></a>"+
                         "</td>"+
                         "<input type=\"hidden\" name=\"saleBackDetailList["+SaleBack.index+"].no\" value=\""+SaleBack.no+"\"/>"+
                         "<input type=\"hidden\" name=\"saleBackDetailList["+SaleBack.index+"].providerProductId\" value=\""+providerProductId+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleBackDetailList["+SaleBack.index+"].productModel\" value=\""+productModel+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleBackDetailList["+SaleBack.index+"].productName\" value=\""+productName+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleBackDetailList["+SaleBack.index+"].standard\" value=\""+standard+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleBackDetailList["+SaleBack.index+"].pic\" value=\""+pic+"\"/>"+
	                     "<input type=\"hidden\" name=\"saleBackDetailList["+SaleBack.index+"].inputBackPrice\"/>"+
                     "</tr>";
        
        SaleBack.index++;
        SaleBack.no++;
        SaleBack.saleBackDetailNo++;
	        
	    
	    $("#saleBackCount", navTab.getPanel('sale_back_add')).before(trHtml);
	    dynamicBindEnter($("#saleBackCount", navTab.getPanel('sale_back_add')).prev());
	    
	    alertMsg.info("已添加到销售退货单！");
    }
    
};
</script>