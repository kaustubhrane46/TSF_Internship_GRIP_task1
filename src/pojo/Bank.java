package pojo;

public class Bank {

	

	private int custId;
	private int custAccNo;
	private double Trans_amt;
	private String custName;
	private double custAccBal;
	private String custCity;
	private String Transactiondate;
	
	public String getTransactiondate() {
		return Transactiondate;
	}

	public void setTransactiondate(String transactiondate) {
		Transactiondate = transactiondate;
	}

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Transfer constructor
	public Bank(int custId, String custName, double custAccBal) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAccBal = custAccBal;
	}
	
	public Bank(int custId, int custAccNo, double Trans_amt, double custAccBal) {
		super();
		this.custId = custId;
		this.custAccNo = custAccNo;
		this.Trans_amt = Trans_amt;
		this.custAccBal = custAccBal;
	}

	public Bank(int custAccNo, double custAccBal) {
		super();
		this.custAccNo = custAccNo;
		this.custAccBal = custAccBal;
	}

	public Bank(int custId, int custAccNo, String custName, double custAccBal, String custCity) {
		super();
		this.custId = custId;
		this.custAccNo = custAccNo;
		this.custName = custName;
		this.custAccBal = custAccBal;
		this.custCity = custCity;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getCustAccNo() {
		return custAccNo;
	}

	public void setCustAccNo(int custAccNo) {
		this.custAccNo = custAccNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public double getCustAccBal() {
		return custAccBal;
	}

	public void setCustAccBal(double custAccBal) {
		this.custAccBal = custAccBal;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	
	public double getTrans_amt() {
		return Trans_amt;
	}

	public void setTrans_amt(double trans_amt) {
		this.Trans_amt = trans_amt;
	}

	@Override
	public String toString() {
		return "Bank [custId=" + custId + ", custAccNo=" + custAccNo + ", Trans_amt=" + Trans_amt + ", custName="
				+ custName + ", custAccBal=" + custAccBal + ", custCity=" + custCity + ", Transactiondate="
				+ Transactiondate + "]";
	}

	
	
}
