package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * The NickWriter-Class includes just a method to write a String in a textfile.
 * Thus the single method of this Class writes every single nickname in a .txt-file with the nickname as Filename.
 * @author zzaxec
 *
 */
public class NickWriter {
	public static void writeIN(String nick) throws IOException{
	    FileWriter fw = new FileWriter(nick+".txt");
	    BufferedWriter bw = new BufferedWriter(fw);

	    bw.write(nick);
	    bw.newLine();
	    bw.close();
	}
}
