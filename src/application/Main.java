package application;

import java.io.IOException;
import java.util.List;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import factory.JPAFactory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Usuario;
import repository.UsuarioRepository;

public class Main extends Application{

	
	public static void main(String[] args) {
		new Splash();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
//		Parent root = FXMLLoader.load(getClass().getResource("/view/login.fxml"));	
//        primaryStage.setTitle("HOTEL CALIFORNIA");
//        primaryStage.setScene(new Scene(root, 300, 400));
//        primaryStage.setResizable(false);
//		primaryStage.initStyle(StageStyle.UNDECORATED);
//        primaryStage.show();
        
        
		Parent root = FXMLLoader.load(getClass().getResource("/view/main_view.fxml"));
		Stage scene = new Stage();
		scene.setTitle("HOTEL CALIFORNIA");
		scene.setScene(new Scene(root, 1366, 768));
		scene.setResizable(true);

		scene.showAndWait();
	}
	
    
	
	
	
	
}
