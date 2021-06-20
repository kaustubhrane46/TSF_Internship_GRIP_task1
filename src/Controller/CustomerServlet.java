package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Dao.BankDao;
import Dao.BankDaoImpl;
import pojo.Bank;



@MultipartConfig
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	
	BankDao bd=new BankDaoImpl();
	boolean flag;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		
		List<Bank> clist=new ArrayList<Bank>();
		
		
		
		if(action!=null && action.equals("select"))
		{
			int custId=Integer.parseInt(request.getParameter("id"));
			
			Bank bank=bd.searchCustById(custId);
			session.setAttribute("bank",bank);
			response.sendRedirect("Customer.jsp");
		}
		else if(action!=null && action.equals("transfer"))
		{
			int custId=Integer.parseInt(request.getParameter("id"));
			
			Bank bank=bd.searchCustById(custId);
			session.setAttribute("blist", clist);
			session.setAttribute("bank",bank);
			response.sendRedirect("Transaction.jsp");
		}
		else if(action!=null && action.equals("history"))
		{
			clist=bd.showAllTransactions();
			session.setAttribute("blist", clist);
			response.sendRedirect("TransactionHistory.jsp");
		}
		else 
		{

			clist=bd.showAllCustomers();
			session.setAttribute("blist", clist);
			response.sendRedirect("viewcustomers.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Bank> clist=new ArrayList<Bank>();
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		
		int custId,custAccNo;
		String custName;
		double custAccBal,Trans_amt=0;
		
		if(action!=null && action.contentEquals("update"))
		{

			custId=Integer.parseInt(request.getParameter("custId"));
			custAccNo=Integer.parseInt(request.getParameter("custAccNo1"));
			custName=request.getParameter("custName");
			custAccBal=Double.parseDouble(request.getParameter("custAccBal"));
			Trans_amt=Double.parseDouble(request.getParameter("Trans_amt"));
			
			if(custAccBal > Trans_amt)
			{
				custAccBal=custAccBal-Trans_amt;
				Bank b=new Bank(custId,custName,custAccBal);
				flag=bd.updateAccount(b);
				
				if(flag)
				{
				
					custAccNo =Integer.parseInt(request.getParameter("custAccNo2"));				
					custAccBal=Double.parseDouble(request.getParameter("Trans_amt"));
										
					Bank b1=new Bank(custAccNo,custAccBal);
					flag=bd.completeTransaction(b1);
					
					if(flag)
					{
						custId=Integer.parseInt(request.getParameter("custAccNo1"));
						custAccNo =Integer.parseInt(request.getParameter("custAccNo2"));
						Trans_amt=Double.parseDouble(request.getParameter("Trans_amt"));
											
						Bank b2=new Bank(custId,custAccNo,Trans_amt,custAccBal);
						flag=bd.insertHistory(b2);
					}
				}
			}
			else
			{
				out.print("Please check transfer amount...");
			}
			
		  }
			else
			{
				out.print("Failure occured... ");
			}

		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.forward(request, response);
			
		   
		}
		
	 
}

