package model;

import java.util.ArrayList;
import java.util.Random;

public class Generator {
	
	Alphabet alphabet;
	private ArrayList<String> nickStrukt;
	private String nickname;
	
	// Constructor
	public Generator() {
		alphabet = new Alphabet();
	}

	
	/*
	 * GETTER UND SETTER
	 */
	public Alphabet getAlphabet() {
		return alphabet;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/*
	 * METHODEN ZUR BERECHNUNG
	 */
	public String generate(){
		Random r = new Random();
		int zufall;
		String newNickname = "";
		for(int i=0; i<nickStrukt.size(); i++){
			zufall = r.nextInt(26);
			while(!alphabet.getLaut(zufall).equals(nickStrukt.get(i))){
				zufall = r.nextInt(26);
			}
			newNickname += alphabet.getBuchstabe(zufall);
		}
		return newNickname;
	}
	
	public void getStructure(String zeichen){
		nickStrukt = new ArrayList<String>();
		for(int i=0; i<zeichen.length(); i++){
			nickStrukt.add(zeichen.substring(i, i+1));
		}
	}
	
	public void löscheArrayList(){
		nickStrukt.clear();
	}
}
