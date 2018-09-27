package application;

import java.net.URL;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{

    
    
	public static void main(String[] args) {
		new Splash();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));	
        primaryStage.setTitle("HOTEL CALIFORNIA");
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
	}
	




}
