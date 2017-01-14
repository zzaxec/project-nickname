package controller;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Generator;
import model.NickWriter;
/**
 * The Controller-Class of the Graphical User Interface
 * @author Hakan
 *
 */
public class MainViewController {
	
	Generator gen = new Generator();
	private boolean firstStart = false;
	private boolean firstNick = true;
	private boolean run = false;
	private boolean structRun = true;
	
	/*
	 * Interfacecomponents
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
	@FXML
	Button cntrl_random;
	
	
	/*
	 * 
	 * METHODS
	 * 
	 */
	@FXML
	public void switchStage(){
		Stage randomStage = new Stage();
		Parent randomParent;
		try {
			randomParent = FXMLLoader.load(getClass().getResource("/view/RandomView.fxml"));
			Scene sc = new Scene(randomParent);
			randomStage.setScene(sc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		randomStage.show();
	}
	
	@FXML
	/**
	 * Adds a consonant in the structure. The current structure will be shown in the display.
	 */
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
	/**
	 * Adds a vocal in the structure. The current structure will be shown in the display.
	 */
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
	/**
	 * Generates a new nickname with help of the instance of the Generator-Class
	 */
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
	/**
	 * Clears the created nickname and goes into the initial state. The Structure will be cleared 
	 * and the necessary variables get set.
	 */
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
	/**
	 * Copies the current nickname to the clipboard.
	 */
	public void copyButton(){
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(display.getText()), null);
	}
	
	

}
