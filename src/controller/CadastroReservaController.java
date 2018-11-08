package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import factory.JPAFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cliente;
import model.Quarto;
import model.Reserva;
import repository.ClienteRepository;
import tools.TextFieldFormatter;

public class CadastroReservaController extends ControllerSuper implements Initializable{
	private Reserva reserva;
	private Stage stage;
	private Parent parent;
	

    @FXML private FontAwesomeIcon btFechar;
    @FXML private JFXDatePicker dpDataChegada, dpDataSaida;
    @FXML private JFXComboBox<Integer> tfQuantidadeHospede;
    @FXML private JFXComboBox<Quarto> tcTipoQuarto;
    @FXML private JFXComboBox<Cliente> tfHospedeResponsavel;
    @FXML private JFXButton btIncluir, btAlterar, btExcluir, btLimpar;
    @FXML private TextField tfNumeroQuarto;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		carregarClientes();
		
	}

	public void carregarClientes() {
		ClienteRepository repository = new ClienteRepository(JPAFactory.getEntityManager());
		List<Cliente> listaCliente = repository.getClientesGeral();

		for(Cliente lista : listaCliente) {
			

		}
		
		tfHospedeResponsavel.setItems(FXCollections.observableArrayList(listaCliente));
	}
	
    public void abrir(Reserva reserva) {
    	
    	setReserva(reserva);
    	
    	stage = new Stage();
		Scene scene = new Scene(parent, 450, 440);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.WINDOW_MODAL);
		
//		tfNumeroQuarto.setText(reserva.getNumeroQuarto());
//    	tfCpf.setText(cliente.getCpf());
//    	tfEndereco.setText(cliente.getEndereco());
//    	tfEmail.setText(cliente.getEmail());
//    	datePickerAniversario.setValue(cliente.getDataAniversario());
//    	atualizarBotoes();
    	stage.show();

    }
	
	@FXML
	void handleAlterar(ActionEvent event) {
    	
		try {
			getReserva().getId();
//			getReserva().getDataPrevisaoEntrada(dpDataChegada.getValue());
//			getReserva().getDataPrevisaoSaida(dpDataSaida.getValue());
//			getReserva().getAcompanhantes(tfQuantidadeHospede.getValue());
//			getReserva().getCliente(tfHospedeResponsavel.getText());
//			getReserva().getQuarto(tfNumeroQuarto.getText());
		
		super.save(getReserva());

		dialogConfirmaAlteracao();
		
		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage

	}
	catch(Exception e) {
		
	}
		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage
	}

	@FXML
	void handleExcluir(ActionEvent event) throws IOException {
//		String entrada = dpDataChegada.getValue(), saida = dpDataSaida.getValue(), acompanhantes = tfQuantidadeHospede.getValue(), hospede = tfHospedeResponsavel.getText();
		super.remove(reserva);

		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage

	}

	@FXML
	void handleIncluir(ActionEvent event) throws IOException {
		
		reserva = new Reserva(tfHospedeResponsavel.getValue(), dpDataChegada.getValue(),
				dpDataSaida.getValue(), tfQuantidadeHospede.getValue(), tcTipoQuarto.getValue());
//		String nome = tfNome.getText(), endereco = tfEndereco.getText(), cpf = tfCpf.getText(), email = tfEmail.getText();
		super.save(reserva);
		handleLimpar(event);
		
	}

	@FXML
	void handleFecharJanela(MouseEvent event) {
		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage
	}

	@FXML
	void handleLimpar(ActionEvent event) {
//		tfCpf.setText("");
//		tfNome.setText("");
//		tfEmail.setText("");
//		tfEndereco.setText("");
//		datePickerAniversario.setValue(null);
//		cliente = new Cliente();
	}
	
    @FXML
    private void tfCpfReleased()  {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("###.###.###-##");
    	tff.setCaracteresValidos("0123456789");
//    	tff.setTf(tfCpf);
    	tff.formatter();
    }

	private void atualizarBotoes() {
			btIncluir.setDisable(reserva.getId() != null);
			btAlterar.setDisable(reserva.getId() == null);
			btExcluir.setDisable(reserva.getId() == null);
			btLimpar.setDisable(reserva.getId() != null);	
	}


	public Parent getParent() {
		return parent;
	}


	public void setParent(Parent parent) {
		this.parent = parent;
	}


//	public Quarto getQuarto() {
//		return quarto;
//	}


	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}


	
	
	
}
