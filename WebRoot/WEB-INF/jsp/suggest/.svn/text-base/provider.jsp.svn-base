<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
[
    <c:forEach var="provider" items="${providerList}" varStatus="li">
    <c:if test="${li.index > 0}">,</c:if>{"providerId":"${provider.providerId}", "providerName":"${provider.providerName}", "engLetter":"${provider.engLetter}"}
    </c:forEach>
]