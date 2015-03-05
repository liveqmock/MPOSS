<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
[
    <c:forEach var="consumer" items="${consumerList}" varStatus="li">
    <c:if test="${li.index > 0}">,</c:if>{"consumerId":"${consumer.consumerId}", "consumerName":"${consumer.consumerName}", "engLetter":"${consumer.engLetter}", "linkMan":"${consumer.linkMan}", "address":"${consumer.address}", "phone":"${consumer.phone}"}
    </c:forEach>
]