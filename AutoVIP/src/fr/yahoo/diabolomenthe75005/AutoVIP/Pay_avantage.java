package fr.yahoo.diabolomenthe75005.AutoVIP;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pay_avantage")
public class Pay_avantage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1015824824024941799L;
	@Id private int idavantage;
	@Column(length = 255) private String descr;
	@Column(length = 50) private String groupe;
	@Column private int token_price;
	
	
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	public int getIdavantage() {
		return idavantage;
	}
	public void setIdavantage(int idavantage) {
		this.idavantage = idavantage;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getGroup() {
		return groupe;
	}
	public void setGroup(String groupe) {
		this.groupe = groupe;
	}
	public int getToken_price() {
		return token_price;
	}
	public void setToken_price(int token_price) {
		this.token_price = token_price;
	}
	
	
}
