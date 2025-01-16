package model;

import java.util.Date;

public class Payments {
	private int payment_id;
	private User user;
	private Double amount;
	private String payment_method;
	private int payment_status;
	private Date payment_date;
	public Payments() {
		
	}
	public Payments(int payment_id, User user, Double amount, String payment_method, int payment_status,
			Date payment_date) {
		super();
		this.payment_id = payment_id;
		this.user = user;
		this.amount = amount;
		this.payment_method = payment_method;
		this.payment_status = payment_status;
		this.payment_date = payment_date;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public int getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}
	public Date getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	@Override
	public String toString() {
		return "Payments [payment_id=" + payment_id + ", user=" + user + ", amount=" + amount + ", payment_method="
				+ payment_method + ", payment_status=" + payment_status + ", payment_date=" + payment_date + "]";
	}	
}
