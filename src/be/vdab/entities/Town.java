package be.vdab.entities;

import java.io.Serializable;

/**
 *
 * @author guillaume.vandecasteele
 */
public class Town implements Serializable {
private static final long serialVersionUID = 1L;
	private String naam;
	private int postCode;
	
	public Town(String naam, int postCode) {
		this.naam = naam;
		this.postCode = postCode;
	}

	public String getNaam() {
		return naam;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}


}
