<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="pojo.Bank" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction History</title>
</head>
<body>
<form>
	<center>
<%
	List<Bank> clist=(List<Bank>)session.getAttribute("blist");
	Bank b=(Bank)session.getAttribute("bank");
%>
<fieldset>
	<jsp:include page="Header.jsp"></jsp:include>
			<legend  style="color: white; font-size: 15px; font-weight: bold">View Profile</legend>
			<br><br>
			<table border="1 px" cellspacing="1" style="color:white; width: 90%"; id="menu">
					<tr>
						<th>Sender Account Number </th>
						<th>Reciever Account Number </th>
						<th>Transaction Amount </th>
						<th>Transaction Date </th>
					</tr>
					<%for(Bank b1:clist){ %>
						<td><%=b1.getCustId() %></td>
						<td><%=b1.getCustAccNo() %></td>
						<td><%=b1.getTrans_amt() %></td>
						<td><%=b1.getTransactiondate() %></td>
					<tr>
					<%} %>
			</table>
</fieldset>
	
	</center>
</form>

</body>
</html>