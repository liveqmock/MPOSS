<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
[
    <c:forEach var="account" items="${accountList}" varStatus="li">
    <c:choose>
    <c:when test="${account.accountType=='1'}">
    <c:if test="${li.index > 0}">,</c:if>{"accountId":"${account.accountId}", "accountShow":"现金账户","accountName":"${account.accountName}","accountNo":",${account.accountNo}"}
    </c:when>
    <c:otherwise>
    <c:if test="${li.index > 0}">,</c:if>{"accountId":"${account.accountId}", "accountShow":"${account.accountNo}"}
    </c:otherwise>
    </c:choose>
    </c:forEach>
]