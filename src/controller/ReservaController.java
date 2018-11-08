package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import factory.ClienteControllerFactory;
import factory.JPAFactory;
import factory.ReservaControllerFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cliente;
import model.Produto;
import model.Reserva;
import repository.ClienteRepository;
import repository.ProdutoRepository;
import repository.ReservaRepository;
import tools.TextFieldFormatter;

public class ReservaController extends ControllerSuper implements Initializable {

	private Reserva reserva;
//	private Stage stage;
//	private Parent parent;
	
	@FXML private TextField tfPesquisar;
	@FXML private Button btPesquisar;
	@FXML private TableView<Reserva> tvReservas;
	@FXML private TableColumn<Reserva, Integer> tcIdReserva;
	@FXML private TableColumn<Reserva, LocalDate> tcDataChegada;
	@FXML private TableColumn<Reserva, LocalDate> tcDataSaida;
	@FXML private TableColumn<Reserva, Integer> tcQuantidadeHospedes;
	@FXML private TableColumn<Reserva, String> tcHospedeResponsavel;
	@FXML private TableColumn<Reserva, String> tcTipoQuarto;
	@FXML private JFXButton btCadastrarReserva;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		tcIdReserva.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcDataChegada.setCellValueFactory(new PropertyValueFactory<>("dataPrevisaoEntrada"));
		tcDataSaida.setCellValueFactory(new PropertyValueFactory<>("dataPrevisaoSaida"));
		tcQuantidadeHospedes.setCellValueFactory(new PropertyValueFactory<>("acompanhantes"));
		tcHospedeResponsavel.setCellValueFactory(new PropertyValueFactory<>("cliente"));
		tcTipoQuarto.setCellValueFactory(new PropertyValueFactory<>("quarto"));
		
		try {
			atualizar();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//	@FXML
//	void handleMouseClicked(MouseEvent event) throws IOException {
//
//    	if (event.getButton().equals(MouseButton.PRIMARY)) {
//			if (event.getClickCount() == 2) {
//	    		CadastroReservaController listagem = ReservaControllerFactory.getInstance();
//				setReserva(tvReservas.getSelectionModel().getSelectedItem());
//	    		listagem.abrir(reserva);
//	    		atualizar();
//			}
//    	}
//	}
	
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
		stage.showAndWait();
		atualizar();
	}

	@FXML
	void handleMouseClicked(MouseEvent event) throws IOException {

    	if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
	    		CadastroReservaController listagem = ReservaControllerFactory.getInstance();
				Reserva reserva = tvReservas.getSelectionModel().getSelectedItem();
	    		listagem.abrir(reserva);
	    		atualizar();
			}
    	}
	}
	
	
//	private List<Reserva> listaReserva;
	
	@FXML
	void handleBuscar(ActionEvent event) throws IOException {
		ReservaRepository repository = new ReservaRepository(JPAFactory.getEntityManager());
		List<Reserva> lista = repository.getReservas();
		
		if (lista.isEmpty()) {
			super.dialogErro();
		}
		
		tvReservas.setItems(FXCollections.observableList(lista));
	}
	
	public void atualizar() throws IOException {
		ReservaRepository repository = new ReservaRepository(JPAFactory.getEntityManager());
		List<Reserva> lista = repository.getReservas();
		if (lista.isEmpty()) {
			super.dialogErro();
		}
		tvReservas.setItems(FXCollections.observableList(lista));		
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}



}
