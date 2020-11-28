package Domain;

import java.util.UUID;

public class Voucher {
	private double credit;
	private String voucherID;
	private String userID;
	
	public Voucher(double credit, String userID) {
		this.credit = credit;
		this.userID = userID;
		voucherID = UUID.randomUUID().toString();
	}
	
	Voucher(double credit, String userID, String voucherID) {
		this.credit = credit;
		this.userID = userID;
		this.voucherID = voucherID;
	}
	
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public String getVoucherID() {
		return voucherID;
	}
	public void setVoucherID(String voucherID) {
		this.voucherID = voucherID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
}
