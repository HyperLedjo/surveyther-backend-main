package com.hyperledjo.surveyther.DTO;

public class PaymentReady {

	private String cid = "TC0ONETIME";
	private String partner_order_id = "1001";
	private String partner_user_id = "surveyther";
	private String item_name;
	private int quantity = 1;
	private int total_amount;
	private int tax_free_amount = 0;
	private int vat_amount = 0;

	public String getCid() {
		return cid;
	}

	public String getPartner_order_id() {
		return partner_order_id;
	}

	public String getPartner_user_id() {
		return partner_user_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public int getTax_free_amount() {
		return tax_free_amount;
	}

	public int getVat_amount() {
		return vat_amount;
	}

	@Override
	public String toString() {
		return "PaymentReady [cid=" + cid + ", partner_order_id=" + partner_order_id + ", partner_user_id="
				+ partner_user_id + ", item_name=" + item_name + ", quantity=" + quantity + ", total_amount="
				+ total_amount + ", tax_free_amount=" + tax_free_amount + ", vat_amount=" + vat_amount + "]";
	}
}
