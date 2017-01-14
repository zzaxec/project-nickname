package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * The Main-Class of the Project.
 * @author zzaxec
 * @version 2.2
 *
 */
public class Main extends Application {
	public void start(Stage primaryStage) {
		try {
			Parent content = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
			Scene scene = new Scene(content);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}