package fr.yahoo.diabolomenthe75005.AutoVIP;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_header")
public class Payment_header implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4817469288849113287L;
	@Id private int idplayer;
	@Column(unique=true,length=50) private String forumname;
	@Column(unique=true,length=50) private String playername;
	@Column(unique=true,length=36) private String UUID;
	@Column(columnDefinition="Decimal(10,2) default '0.00'") private double amount;
	@Column(columnDefinition="Integer default '0'") private int token;
	
	//Getter et setter
	public int getIdplayer() {
		return idplayer;
	}
	public void setIdplayer(int idplayer) {
		this.idplayer = idplayer;
	}
	public String getForumname() {
		return forumname;
	}
	public void setForumname(String forumname) {
		this.forumname = forumname;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getPlayername() {
		return playername;
	}
	public void setPlayername(String playername) {
		this.playername = playername;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	
	
	
	
}
