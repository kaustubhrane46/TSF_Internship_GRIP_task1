package Dao;
import java.util.List;

import pojo.Bank;



public interface BankDao {
	List<Bank> showAllCustomers();
	Bank searchCustById(int custId);
	boolean updateAccount(Bank b);
	boolean completeTransaction(Bank b);
	boolean insertHistory(Bank b);
	List<Bank> showAllTransactions();
}
