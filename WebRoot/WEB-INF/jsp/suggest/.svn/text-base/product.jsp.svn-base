<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
[
    <c:forEach var="product" items="${productList}" varStatus="li">
    <c:if test="${li.index > 0}">,</c:if>{
        "productId":"${product.productId}", 
        "productModel":"${product.productModel}", 
        "productName":"${product.productModel}-${product.productName}", 
        "productEngName":"${product.productEngName}",
        "productSuggestShow":"${product.productSuggestShow}",
     }
    </c:forEach>
]