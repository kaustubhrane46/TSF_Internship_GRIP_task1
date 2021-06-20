<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="pojo.Bank" %>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Page</title>
</head>
<body>
<form>
<%
	  Bank b=(Bank)session.getAttribute("bank");
%>
<fieldset>
	<jsp:include page="Header.jsp"></jsp:include>
	
	<legend  style="color: white; font-size: 15px; font-weight: bold">View Profile</legend>
			<br><br>
			<table border="0" cellspacing="1" style="color:white; width: 90%"; id="menu">
				<tr>
					<td>custId:</td>
					<td><input type="text" name="" placeholder="" value=<%= b.getCustId() %> readonly="readonly"></td>
				</tr>
				<tr>
					<td>Account No:</td>
					<td><input type="text" name="" placeholder="" value=<%= b.getCustAccNo() %> readonly="readonly"></td>
				</tr>
				<tr>
					<td>custName:</td>
					<td><input type="text" name="" placeholder="" value=<%= b.getCustName() %> readonly="readonly"></td>	
				</tr>
				<tr>
					<td>Account Balance:</td>
					<td><input type="text" name="" placeholder="" value=<%= b.getCustAccBal() %> readonly="readonly"></td>
				</tr>
				<tr>
					<td>custCity</td>
					<td><input type="text" name="" placeholder="" value=<%= b.getCustCity() %> readonly="readonly"></td>
				</tr>
				<tr colspan=2>
					<td><a href="viewcustomers.jsp">Back</a> </td>
				</tr>
				</table>
</fieldset>
</form>
</body>
</html>