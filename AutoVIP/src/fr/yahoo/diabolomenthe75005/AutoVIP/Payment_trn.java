package fr.yahoo.diabolomenthe75005.AutoVIP;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "payment_trn")
public class Payment_trn implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1647176417320010661L;
	@Id private int idtrn;
	@Column private int idplayer;
	@Column(length=255) private String email;
	@Column(columnDefinition="Decimal(10,2) default '0.00'") private double amount;
	@Column(length=50) private String pay_trnid;
	@Column(length=50) private String type;
	@Column(columnDefinition="Timestamp default current_timestamp") private String date;
	
	//Getters and Setters
	
	public int getIdtrn() {
		return idtrn;
	}
	public void setIdtrn(int idtrn) {
		this.idtrn = idtrn;
	}
	public String getEmail() {
		return email;
	}
	public int getId() {
		return idtrn;
	}
	public void setId(int id) {
		this.idtrn = id;
	}
	public int getIdplayer() {
		return idplayer;
	}
	public void setIdplayer(int idplayer) {
		this.idplayer = idplayer;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPay_trnid() {
		return pay_trnid;
	}
	public void setPay_trnid(String pay_trnid) {
		this.pay_trnid = pay_trnid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
