<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@ include file="/include.inc.jsp"%>
<%@ page import="java.util.Map,java.util.Set,dwz.common.util.ParameterUtil" %>
<form id="pagerForm" method="post" action="/rpt/listCostColl">
    <input type="hidden" name="pageNum" value="1" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="/rpt/listCostColl" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					<select class="combox" name="transItem" remember="${transItem}">
						<option value="">交易类型</option>
						<c:forEach var="entry" items="${myfn:getConstantMap('TRANS_ITEM')}">
						<option value="${entry.key}">${entry.value}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					日期：<input type="text" name="startDate" value="${startDate}" class="date" readonly="readonly" />至<input type="text" name="endDate" value="${endDate}" class="date" maxDate="%y-%M-%d" readonly="readonly" />
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
    <%
    Map<String,String> transItemMap = (Map<String,String>)ParameterUtil.getConstantMap("TRANS_ITEM");
    Set<String> dateSet = (Set<String>)request.getAttribute("dateSet");
    Map<String,Integer> dataMap = (Map<String,Integer>)request.getAttribute("dataMap");
    Map<String,Integer> colCountMap = new HashMap<String,Integer>();
    %>
	<table class="list" width="100%" layoutH="68">
		<thead>
			<tr>
			    <th rowspan="2">时间</th>
			    <%
		        for(Map.Entry<String,String> entry : transItemMap.entrySet()){
		        %>
		        <th colspan="2"><%=entry.getValue() %></th>
		        <%
		        }
		        %>
				<th colspan="2">小计</th>
			</tr>
			<tr>
			    <%
		        for(Map.Entry<String,String> entry : transItemMap.entrySet()){
		            String transItem = entry.getKey();
		            colCountMap.put(transItem+"#1",0);
		            colCountMap.put(transItem+"#2",0);
		        %>
		        <td>收入</td>
			    <td>支出</td>
		        <%
		        }
		        %>
			    <th>收入</th>
			    <th>支出</th>
			</tr>
		</thead>
		<tbody>
		    <%
		    for(String transDate : dateSet){
		        int rowInCount = 0;
		    	int rowOutCount = 0;
		    %>
		    <tr>
		        <td><%=transDate %></td>
		        <%
		        for(Map.Entry<String,String> entry : transItemMap.entrySet()){
		            String transItem = entry.getKey();
		        %>
		        <td>
		        <%
		            String transDire = "1";
		            String key = transDate+"#"+transItem+"#"+transDire;
		            if(dataMap.containsKey(key)){
		                String href = "/rpt/findCostCollDetail/"+transDate+"/"+transItem+"/"+transDire;
		        %>
		        <a style="color:green;" href="<%=href %>" class="custom" target="dialog" width="1100" height="700" title="收支明细"><%=ParameterUtil.fromF2Y(dataMap.get(key)) %></a>
		        <%       
			            rowInCount += dataMap.get(key);
			            int colInCount = colCountMap.get(transItem+"#"+transDire);
			            colCountMap.put(transItem+"#"+transDire, colInCount + dataMap.get(key));
		            }
		        %>
		        </td>
			    <td>
			    <%
		            transDire = "2";
		            key = transDate+"#"+transItem+"#"+transDire;
		            if(dataMap.containsKey(key)){
		                String href = "/rpt/findCostCollDetail/"+transDate+"/"+transItem+"/"+transDire;
		        %>
		        <a style="color:red;" href="<%=href %>" class="custom" target="dialog" width="1100" height="700" title="收支明细"><%=ParameterUtil.fromF2Y(dataMap.get(key)) %></a>
		        <%      
		            	rowOutCount += dataMap.get(key); 
		            	int colOutCount = colCountMap.get(transItem+"#"+transDire);
			            colCountMap.put(transItem+"#"+transDire, colOutCount + dataMap.get(key));
		            }
		        %>
		        </td>
		        <%
		        }
		        %>
			    <td style="color:green;"><%=ParameterUtil.fromF2Y(rowInCount) %></td>
			    <td style="color:red;"><%=ParameterUtil.fromF2Y(rowOutCount) %></td>
		    </tr>
		    <%
		    }
		    %>
		    <tr>
		      <td>合计：</td>
		      <%
		        int totalIn = 0;
		        int totalOut = 0;
		        for(Map.Entry<String,String> entry : transItemMap.entrySet()){
		            String transItem = entry.getKey();
		            totalIn += colCountMap.get(transItem+"#1");
		            totalOut += colCountMap.get(transItem+"#2");
		        %>
		        <td style="color:green;">
		        <%=ParameterUtil.fromF2Y(colCountMap.get(transItem+"#1")) %>
		        </td>
			    <td style="color:red;">
			    <%=ParameterUtil.fromF2Y(colCountMap.get(transItem+"#2")) %>
		        </td>
		        <%
		        }
		        %>
			    <td style="color:green;"><%=ParameterUtil.fromF2Y(totalIn) %></td>
			    <td style="color:red;"><%=ParameterUtil.fromF2Y(totalOut) %></td>
		    </tr>
		</tbody>
	</table>
</div>