package application;

import java.beans.EventHandler;
import java.io.IOException;
import java.util.List;

import com.jfoenix.controls.JFXButton;

import controller.TemplateController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import factory.JPAFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Usuario;
import repository.UsuarioRepository;

public class Main extends Application{

	public static void main(String[] args) {
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
