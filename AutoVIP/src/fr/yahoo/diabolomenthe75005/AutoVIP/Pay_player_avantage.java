package fr.yahoo.diabolomenthe75005.AutoVIP;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pay_player_avantage")
public class Pay_player_avantage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 371862985699903009L;
	@EmbeddedId private Player_avantagePK player_avantagePK;
	@Column(columnDefinition="Timestamp default current_timestamp") private String datedebut;
	@Column(columnDefinition="Timestamp") private String datefin;
	@Column(columnDefinition="Integer default 0") private int actif;
	
	public int getActif() {
		return actif;
	}
	public void setActif(int actif) {
		this.actif = actif;
	}
	public Player_avantagePK getPlayer_avantagePK() {
		return player_avantagePK;
	}
	public void setPlayer_avantagePK(Player_avantagePK player_avantagePK) {
		this.player_avantagePK = player_avantagePK;
	}
	public String getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}
	public String getDatefin() {
		return datefin;
	}
	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}
	
	
	

}
