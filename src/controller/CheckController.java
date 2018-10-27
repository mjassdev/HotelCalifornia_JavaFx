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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cliente;
import model.Quarto;

public class CheckController extends ControllerSuper implements Initializable{
	private Quarto quarto;
	private Stage stage;
	private Parent parent;
	
    @FXML private FontAwesomeIcon btFechar;
    @FXML private Button addCliente;
    @FXML private TextField tfNumeroQuarto;
    @FXML private TextField tfHospede;
    @FXML private DatePicker dpEntradaHospede;
    @FXML private TextArea tfObservacaoHospede;
    @FXML private JFXButton btIniciarEstadia;
    
	
	@FXML void addCliente(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/hospede.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Clientes");
		stage.show();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	void handleFecharJanela(MouseEvent event) {
		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage
	}
	
    public void abrir(Quarto quarto) {
    	
    	setQuarto(quarto);
    	
    	stage = new Stage();
		Scene scene = new Scene(parent, 450, 440);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		
		tfNumeroQuarto.setText(quarto.getNumeroQuarto());
//		tfHospede.setText(quarto.getNomeHospede());
//		dpEntradaHospede.setValue(quarto.getEntradaHospede());
//		tfObservacaoHospede.setText(quarto.getObservacaoHospede());

    	stage.showAndWait();

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
