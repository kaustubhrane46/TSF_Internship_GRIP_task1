<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="pojo.Bank" %>
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Page</title>
</head>
<body>
<form action="CustomerServlet" method="post">
	<input type="hidden" name="action" value="update">
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
			<table border="0" cellspacing="1" style="color:white; width: 90%"; id="menu">
				<tr>
					<td>custId:</td>
					<td><input type="text" name="custId" placeholder="" value=<%= b.getCustId() %> readonly="readonly"></td>
				</tr>
				<tr>
					<td>customer Account No:</td>
					<td><input type="text" name="custAccNo1" placeholder="" value=<%= b.getCustAccNo() %> readonly="readonly"></td>
				</tr>
				<tr>
					<td>customer Name:</td>
					<td><input type="text" name="custName" placeholder="" value=<%= b.getCustName() %> readonly="readonly"></td>
				</tr>
				<tr>
					<td>Account Balance:</td>
					<td><input type="text" name="custAccBal" placeholder="" value=<%= b.getCustAccBal() %> readonly="readonly"></td>
				</tr>
				<tr>
					<td>Select Account No:</td>
					<td>
					<select>
				<option name="custAccNo" id="custAccNo">Select</option>
				 <%
				 		try{
				 			Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlbankmgmt","root","AND@123");
							
							Statement st=conn.createStatement();
							String query="select custAccNo from customers";				 			
							//get table data
							
							ResultSet rs=st.executeQuery(query);
							//get cust account number
							
							while(rs.next())
							{
								%>
								<option><%=rs.getInt("custAccNo") %>  </option>
								<%
							}
								
				 		}
				 		catch(Exception e)
				 {
				 			e.printStackTrace();
				 }
				 %>		 
			</select>
				</td>	
				</tr>
				<tr>
					<td>Please confirm account Number :</td>
					<td>
						<input type="text" name="custAccNo2" placeholder="Please confirm account no...">*						
					</td>
				</tr>
				<tr>
					<td>Enter Amount to be transferred:</td>
					<td><input type="text" name="Trans_amt" placeholder="0000.00">*</td>
				</tr>
				<tr>
					<td ><input type="submit" value="Submit"></td>
				</tr>
		</table>
</fieldset>
</form>
</body>
</html>