package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
	private TableColumn<?, ?> tcCheckin;

	@FXML
	private TableColumn<?, ?> tcCheckout;

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
		tcCheckin.setCellValueFactory(new PropertyValueFactory<>("dataEntrada"));
		tcCheckout.setCellValueFactory(new PropertyValueFactory<>("dataSaida"));
		tcQuantidadeHospedes.setCellValueFactory(new PropertyValueFactory<>("dataSaida"));
		tcHospedeResponsavel.setCellValueFactory(new PropertyValueFactory<>("hospedeResponsavel"));
		tcTipoQuarto.setCellValueFactory(new PropertyValueFactory<>("tipoQuarto"));
	}
}
