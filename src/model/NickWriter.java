package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NickWriter {
	public static void writeIN(String nick) throws IOException{
	    FileWriter fw = new FileWriter(nick+".txt");
	    BufferedWriter bw = new BufferedWriter(fw);

	    bw.write(nick);
	    bw.newLine();
	    bw.close();
	}
}
