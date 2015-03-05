<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<select custom="providerSelect" onchange="SaleBak.changeProvider(this);">
    <option value="">厂家</option>
    <c:forEach var="provider" items="${providerList}">
    <option providerProductId="${provider.providerProductId}" unitPrice="${myfn:fromF2Y(provider.unitPrice)}" value="${provider.providerId}">${provider.providerName}</option>
    </c:forEach>
</select>