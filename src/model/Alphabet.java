package model;
/**
 * The Alphabet-Class includes an Array of objects of the Letter-Class. It initialize the array with a length of 26 thus the whole alphabet
 * and offers methods to get the character or the sound of the letter.
 * @author zzaxec
 *
 */
public class Alphabet {
	
	Letter[] alph;
	
	// Constructor
	public Alphabet() {
		alph = new Letter[26];
		alph[0] = new Letter("a","v");
		alph[1] = new Letter("b","k");
		alph[2] = new Letter("c","k");
		alph[3] = new Letter("d","k");
		alph[4] = new Letter("e","v");
		alph[5] = new Letter("f","k");
		alph[6] = new Letter("g","k");
		alph[7] = new Letter("h","k");
		alph[8] = new Letter("i","v");
		alph[9] = new Letter("j","k");
		alph[10] = new Letter("k","k");
		alph[11] = new Letter("l","k");
		alph[12] = new Letter("m","k");
		alph[13] = new Letter("n","k");
		alph[14] = new Letter("o","v");
		alph[15] = new Letter("p","k");
		alph[16] = new Letter("q","k");
		alph[17] = new Letter("r","k");
		alph[18] = new Letter("s","k");
		alph[19] = new Letter("t","k");
		alph[20] = new Letter("u","v");
		alph[21] = new Letter("v","k");
		alph[22] = new Letter("w","k");
		alph[23] = new Letter("x","k");
		alph[24] = new Letter("y","k");
		alph[25] = new Letter("z","k");
		
	}
	
	/*
	 * GETTER AND SETTER
	 */
	
	public String getBuchstabe(int x){
		return alph[x].getBuchstabe();
	}
	
	public String getLaut(int x){
		return alph[x].getLaut();
	}

}
