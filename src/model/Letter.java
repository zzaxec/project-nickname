package model;
/**
 * The Letter-Class includes two Strings. One for the character and the other one for the sound. With Get-methods they
 * can get retrieved.
 * @author zzaxec
 *
 */
public class Letter {
	
	private final String buchstabe;
	private final String laut;
	
	// Constructor
	public Letter(String buchstabe, String laut) {
		this.buchstabe = buchstabe;
		this.laut = laut;
	}
	
	
	/*
	 * GETTER AND SETTER
	 */
	public String getBuchstabe() {
		return buchstabe;
	}
	public String getLaut() {
		return laut;
	}

}
