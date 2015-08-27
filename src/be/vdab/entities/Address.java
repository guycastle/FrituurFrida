package be.vdab.entities;

import java.io.Serializable;

/**
 *
 * @author guillaume.vandecasteele
 */
public class Address implements Serializable {
private static final long serialVersionUID = 1L;
	private Town town;
	private String straat;
	private String huisNr;
        
        public Address() {}
	
	public Address(Town town, String straat, String huisNr) {
		this.town = town;
		this.straat = straat;
		this.huisNr = huisNr;
	}

	public Town getTown() {
		return town;
	}
	
	public String getStraat() {
		return straat;
	}
	
	public String getHuisNr() {
		return huisNr;
	}
	
	public void setTown(Town town) {
		this.town = town;
	}
	
	public void setStraat(String straat) {
		this.straat = straat;
	}
	
	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}
}
