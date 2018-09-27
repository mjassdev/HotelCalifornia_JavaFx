package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ReservaController implements Initializable {

	@FXML
	private TextField tfPesquisar;

	@FXML
	private Button btPesquisar;

	@FXML
	private TableView<?> tvReservas;

	@FXML
	private TableColumn<?, ?> tcIdReserva;

	@FXML
	private TableColumn<?, ?> tcDataChegada;

	@FXML
	private TableColumn<?, ?> tcDataSaida;
	@FXML
	private TableColumn<?, ?> tcQuantidadeHospedes;

	@FXML
	private TableColumn<?, ?> tcHospedeResponsavel;

	@FXML
	private TableColumn<?, ?> tcTipoQuarto;

	@FXML
	private JFXButton btCadastrarReserva;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		tcIdReserva.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcDataChegada.setCellValueFactory(new PropertyValueFactory<>("dataEntrada"));
		tcDataSaida.setCellValueFactory(new PropertyValueFactory<>("dataSaida"));
		tcQuantidadeHospedes.setCellValueFactory(new PropertyValueFactory<>("dataSaida"));
		tcHospedeResponsavel.setCellValueFactory(new PropertyValueFactory<>("hospedeResponsavel"));
		tcTipoQuarto.setCellValueFactory(new PropertyValueFactory<>("tipoQuarto"));
	}

	@FXML
	private void dialogReservas(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/cadastroreservas.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Usuarios");
		stage.show();
	}

}
