package fr.yahoo.diabolomenthe75005.AutoVIP;

import javax.persistence.Embeddable;

@Embeddable
public class Player_avantagePK {
	private int idplayer;
	private int idavantage;
	public int getIdplayer() {
		return idplayer;
	}
	public void setIdplayer(int idplayer) {
		this.idplayer = idplayer;
	}
	public int getIdavantage() {
		return idavantage;
	}
	public void setIdavantage(int idavantage) {
		this.idavantage = idavantage;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idavantage;
		result = prime * result + idplayer;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player_avantagePK other = (Player_avantagePK) obj;
		if (idavantage != other.idavantage)
			return false;
		if (idplayer != other.idplayer)
			return false;
		return true;
	}
	
	

}
