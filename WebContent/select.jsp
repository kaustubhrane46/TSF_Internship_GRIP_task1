<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Customer</title>
</head>
<body>
		<center>
			<select>
				<option name="custAccNo2" id="id">Select</option>
				 <%
				 		try{
				 			Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlbankmgmt","root","AND@123");
							
							Statement st=conn.createStatement();
							String query="select * from customers";				 			
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
	 	<select>
	 			<option name="custAccNo2">Select</option>
	 				<table>
	 				<tr><td>custAccNo</td><td><input type="text" id="id" name="id" onkeyup="showData();"></td></tr>
	 				</table>
				 <%
				 		
				 		try{
				 			Class.forName("com.mysql.jdbc.Driver");
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlbankmgmt","root","AND@123");
							
							Statement st=conn.createStatement();
							String query="select custAccBal from customers where custAccNo=";				 			
							//get table data							
							
							ResultSet rs=st.executeQuery(query);
							//get cust account balance
							
							while(rs.next())
							{
								%>
								<option><%=rs.getInt("custAccBal") %>  </option>
								<%
							}
								
				 		}
				 		catch(Exception e)
				 {
				 			e.printStackTrace();
				 }
				 %>
			</select>  
		</center>


</body>
</html>