package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cliente;
import model.Quarto;

public class CadastroReservaController extends ControllerSuper implements Initializable{
	private Quarto quarto;
	private Stage stage;
	private Parent parent;
	
    @FXML private FontAwesomeIcon btFechar;
    @FXML private DatePicker dpDataChegada, dpDataSaida;
    @FXML private JFXComboBox<?> tfQuantidadeHospede;
    @FXML private JFXComboBox<?> tcTipoQuarto;
    @FXML private JFXTextField tfHospedeResponsavel;
    @FXML private JFXButton btIncluir, btAlterar, btExcluir, btLimpar;
    @FXML private TextField tfNumeroQuarto;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

    public void abrir(Quarto quarto) {
    	
    	setQuarto(quarto);
    	
    	stage = new Stage();
		Scene scene = new Scene(parent, 450, 440);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.WINDOW_MODAL);
		
		tfNumeroQuarto.setText(quarto.getNumeroQuarto());
//    	tfCpf.setText(cliente.getCpf());
//    	tfEndereco.setText(cliente.getEndereco());
//    	tfEmail.setText(cliente.getEmail());
//    	datePickerAniversario.setValue(cliente.getDataAniversario());
//    	atualizarBotoes();
    	stage.show();

    }
	
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


	public Parent getParent() {
		return parent;
	}


	public void setParent(Parent parent) {
		this.parent = parent;
	}


	public Quarto getQuarto() {
		return quarto;
	}


	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}


	
	
	
}
