package application;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		new Splash();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/main_view.fxml"));
		
        primaryStage.setTitle("HOTEL CALIFÓRNIA");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(true);
        primaryStage.setFullScreen(true);
        primaryStage.show();
	}

}
