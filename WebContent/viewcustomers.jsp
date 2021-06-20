<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="pojo.Bank" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Customers</title>
</head>
<body background="WebContent/images/header-image-bg.jpg">
<form>
<center>
<%
	List<Bank> clist=(List<Bank>)session.getAttribute("blist");
	Bank b=(Bank)session.getAttribute("bank");
%>
<%
	String status=(String)request.getAttribute("status");
		if(status!=null)
		{
			out.print("<b style='color:red'>"+status+"</b>");
		}
%>
		<fieldset>
			<jsp:include page="Header.jsp"></jsp:include>
			<legend  style="color: white; font-size: 15px; font-weight: bold">View Profile</legend>
			<br><br>
			<table border="1px solid" cellpadding ="1" cellspacing="1" style="color:white; width: 90% " id="menu">
					<tr>
						<th>custId </th>
						<th>custAccNo</th>
						<th>custName</th>
						<th>custAccBal</th>
						<th>custCity</th>
						<th colspan=2>Action</th>
					</tr>
					<%for(Bank b1:clist){ %>
					<tr>
						<td><%=b1.getCustId() %></td>
						<td><%=b1.getCustAccNo() %></td>
						<td><%=b1.getCustName() %></td>
						<td><%=b1.getCustAccBal() %></td>
						<td><%=b1.getCustCity() %></td>
						<td><a href="CustomerServlet?action=select&id=<%= b1.getCustId() %>">Select & view </a></td>
						<td><a href="CustomerServlet?action=transfer&id=<%= b1.getCustId() %>">Transfer</a></td>
					</tr>
					<%} %>	
			</table>
		
		</fieldset>

</form>
</center>
</body>
</html>