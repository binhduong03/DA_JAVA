package model;

public class Payment_Details {
	private int detail_id;
	private Payments payment;
	private Carts cart;
	private Double amount;
	
	public Payment_Details() {
		
	}

	public Payment_Details(int detail_id, Payments payment, Carts cart, Double amount) {
		super();
		this.detail_id = detail_id;
		this.payment = payment;
		this.cart = cart;
		this.amount = amount;
	}

	public int getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}

	public Payments getPayment() {
		return payment;
	}

	public void setPayment(Payments payment) {
		this.payment = payment;
	}

	public Carts getCart() {
		return cart;
	}

	public void setCart(Carts cart) {
		this.cart = cart;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment_Details [detail_id=" + detail_id + ", payment=" + payment + ", cart=" + cart + ", amount="
				+ amount + "]";
	}
	
}
