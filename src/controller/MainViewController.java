package controller;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Generator;
import model.NickWriter;

public class MainViewController {
	
	/*
	 * Daten
	 */
	Generator gen = new Generator();
	private boolean firstStart = false;
	private boolean firstNick = true;
	private boolean run = false;
	private boolean structRun = true;
	
	/*
	 * Interface
	 */
	@FXML
	TextField display;
	@FXML
	Button btn_konsonant;
	@FXML
	Button btn_vokal;
	@FXML
	Button btn_clear;
	@FXML
	Button btn_save;
	@FXML
	Button btn_copy;
	@FXML
	Button btn_generiere;
	
	
	/*
	 * 
	 * METHODS
	 * 
	 */
	
	@FXML
	public void addKonsonant(){
		if(structRun){
			if(!firstStart){
				display.setText("");
				display.setText(display.getText()+"k");
				firstStart = true;
				run = true;
			}else
				display.setText(display.getText()+"k");
		}
	}
	
	@FXML 
	public void addVokal(){
		if(structRun){
			if(!firstStart){
				display.setText("");
				display.setText(display.getText()+"v");
				firstStart = true;
				run = true;
			}else
				display.setText(display.getText()+"v");
		}
	}
	
	@FXML
	public void generateNewNick(){
		if(run){
			structRun = false;
			if(firstNick){
				gen.getStructure(display.getText());
				firstNick = false;
				display.setText(gen.generate());
			}else
				display.setText(gen.generate());
		}
	}
	
	@FXML
	public void clearButton(){
		display.setText("Eingaben gelöscht. Bitte neue Eingabe!");
		gen.löscheArrayList();
		firstNick = true;
		firstStart = false;
		run = false;
		structRun = true;
	}
	
	@FXML
	/**
	 * Writes the created nickname in a .txt-file
	 * @throws IOException
	 */
	public void saveButton() throws IOException{
		NickWriter.writeIN(display.getText());
	}
	
	@FXML
	public void copyButton(){
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(display.getText()), null);
	}
	
	

}
