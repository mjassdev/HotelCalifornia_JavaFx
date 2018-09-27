package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastroReservaController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
    @FXML
    private FontAwesomeIcon btFechar;

    @FXML
    private DatePicker dpDataChegada, dpDataSaida;

    @FXML
    private JFXComboBox<?> tfQuantidadeHospede;

    @FXML
    private JFXComboBox<?> tcTipoQuarto;

    @FXML
    private JFXTextField tfHospedeResponsavel;

    @FXML
    private JFXButton btIncluir, btAlterar, btExcluir, btLimpar;

    @FXML
    void handleAlterar(ActionEvent event) {

    }

    @FXML
    void handleExcluir(ActionEvent event) {

    }

    @FXML
    void handleFecharJanela(MouseEvent event) {
		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage
    }

    @FXML
    void handleIncluir(ActionEvent event) {

    }

    @FXML
    void handleLimpar(ActionEvent event) {

    }


	
	
	
}
