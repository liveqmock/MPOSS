<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
[
    <c:forEach var="sale" items="${saleList}" varStatus="li">
    <c:if test="${li.index > 0}">,</c:if>{"saleNo":"${sale.saleNo}","consumerName":"${sale.consumerName}"}
    </c:forEach>
]