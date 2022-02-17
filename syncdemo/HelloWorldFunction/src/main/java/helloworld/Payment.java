package helloworld;

public class Payment {
	private String payType;
	private Double amount;
	public Payment() {}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [payType=" + payType + ", amount=" + amount + "]";
	}
	
	

}
