package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController implements Initializable {
    @FXML
    private JFXButton btEntrar;

    @FXML
    private FontAwesomeIcon btFechar;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
    @FXML
    void acessarSistema(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/main_view.fxml"));	
        Stage scene = new Stage();
		scene.setTitle("HOTEL CALIFORNIA");
        scene.setScene(new Scene(root, 1366, 768));
        scene.setResizable(true);
        //primaryStage.setFullScreen(true);
        scene.showAndWait();
        scene.close();
        
    }

    @FXML
    void handleFecharJanela(MouseEvent event) {
		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage
    }


    
    
}
