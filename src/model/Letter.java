package model;

public class Letter {
	
	private final String buchstabe;
	private final String laut;
	
	// Construktor
	public Letter(String buchstabe, String laut) {
		this.buchstabe = buchstabe;
		this.laut = laut;
	}
	
	
	/*
	 * GETTER UND SETTER
	 */
	public String getBuchstabe() {
		return buchstabe;
	}
	public String getLaut() {
		return laut;
	}

}
