package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utility.DBConnection;
import pojo.Bank;


public class BankDaoImpl implements  BankDao{

	Connection con=DBConnection.getConnection();
	java.sql.PreparedStatement ps=null;
	ResultSet rs=null;
	int result;
	String sql;
	boolean flag;
	Bank b;
	
	@Override
	public List<Bank> showAllCustomers() {
		// TODO Auto-generated method stub
		
		List<Bank> list=new ArrayList<Bank>();
		
		try {
			
			sql="SELECT * FROM customers c";
			
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				b=new Bank();
				b.setCustId(rs.getInt(1));
				b.setCustAccNo(rs.getInt(2));
				b.setCustName(rs.getString(3));
				b.setCustAccBal(rs.getDouble(4));
				b.setCustCity(rs.getString(5));
				
				list.add(b);
			}		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Bank> showAllTransactions() {
		
		List<Bank> list=new ArrayList<Bank>();
		try {
			
			sql="SELECT custId,custAccNo,Trans_amt,Transactiondate FROM history ";
			
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				b=new Bank();
				b.setCustId(rs.getInt(1));
				b.setCustAccNo(rs.getInt(2));
				b.setTrans_amt(rs.getDouble(3));
				b.setTransactiondate(rs.getString(4));			
		
				list.add(b);
			}		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Bank searchCustById(int custId) {
		
		try {
			sql="select * from customers where custid=?";
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, custId);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				b=new Bank();
				b.setCustId(rs.getInt(1));
				b.setCustAccNo(rs.getInt(2));
				b.setCustName(rs.getString(3));
				b.setCustAccBal(rs.getDouble(4));
				b.setCustCity(rs.getString(5));		
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean updateAccount(Bank b) {
		
		try {
			
			sql="update customers set custId=?, custName=?, custAccBal=? where custId=? ";
			ps=con.prepareStatement(sql);

			
			ps.setInt(1, b.getCustId());
			ps.setString(2, b.getCustName());
			ps.setDouble(3, b.getCustAccBal());
			ps.setInt(4, b.getCustId());
			
						
			result=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	if(result>0) {
		return true;
	}
	else {
		return false;
		}
	}

	@Override
	public boolean completeTransaction(Bank b) {
		try {
			
			sql="update customers set custAccBal= custAccBal + ? where CustAccNo=?";
			ps=con.prepareStatement(sql);

			ps.setDouble(1, b.getCustAccBal());
			ps.setInt(2, b.getCustAccNo());
			
									
			result=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	if(result>0) {
		return true;
	}
	else {
		return false;
		}
	}

	@Override
	public boolean insertHistory(Bank b) {
	
		try {
			
			sql="insert into history(custId, custAccNo, Trans_amt, Transactiondate) values(?,?,?,now())";
			ps=con.prepareStatement(sql);

			
			ps.setInt(1, b.getCustId());
			ps.setInt(2, b.getCustAccNo());
			ps.setDouble(3, b.getTrans_amt());
			
			result=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	if(result>0) {
		return true;
	}
	else {
		return false;
		}
	}

	


}
