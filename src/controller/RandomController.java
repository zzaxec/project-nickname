package controller;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Generator;
import model.NickWriter;

/**
 * 
 * @author zzaxec
 *
 */
public class RandomController {
	
	
	private int length;
	private boolean run = false;
	private String randomNickName;

	Generator gen = new Generator();
	
	/*
	 * Interfacecomponents
	 */
	@FXML
	ComboBox cntrl_combobox;
	@FXML
	TextField display;
	@FXML
	Button btn_clear;
	@FXML
	Button btn_save;
	@FXML
	Button btn_copy;
	@FXML
	Button btn_generiere;
	@FXML
	Button turnBack;
	
	ObservableList<Integer> options = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
	

	/*
	 * METHODS
	 */
	
	@FXML
	/**
	 * Initialization-Method. This Method gets executed when the Controller is generated.
	 */
	private void initialize(){
		cntrl_combobox.setItems(options);
		turnBack.setOnAction(evhandler);
	}
	
	@FXML
	/**
	 * Start over method
	 */
	public void clear(){
		display.setText("Start over");
		run = false;
	}
	
	@FXML
	/**
	 * Writes the created nickname in a .txt-file
	 * @throws IOException
	 */
	public void saveButton() throws IOException{
		if(run)
			NickWriter.writeIN(display.getText());
	}
	
	@FXML
	/**
	 * Copies the current nickname to the clipboard.
	 */
	public void copyButton(){
		if(run)
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(display.getText()), null);
	}
	
	@FXML
	/**
	 * Generates a random nickname. The length is given through the Combobox in the User Interface.
	 */
	public void randomGeneration(){
		length = Integer.parseInt(cntrl_combobox.getSelectionModel().selectedItemProperty().getValue().toString());
		randomNickName = gen.randomGenerator(length);
		display.setText(randomNickName);
		run = true;
	}
	
	/**
	 * Eventhandler for closing the current Stage through turnBack-Button
	 */
	EventHandler evhandler = new EventHandler<ActionEvent>() {
		  @Override public void handle(ActionEvent actionEvent) {
		    Node  source = (Node)  actionEvent.getSource(); 
		    Stage stage  = (Stage) source.getScene().getWindow();
		    stage.close();
		  }
		};
}
