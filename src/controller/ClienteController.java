package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.w3c.dom.events.EventException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import factory.ClienteControllerFactory;
import factory.JPAFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cliente;
import repository.ClienteRepository;

public class ClienteController extends ControllerSuper implements Initializable {

	private Cliente cliente;
	private Stage stage;
	private Parent parent;

	@FXML private JFXDatePicker datePickerAniversario;
	@FXML private TitledPane tPCliente;
	@FXML private TabPane tablePaneAbas;
	@FXML private TextField tfNome, tfCpf, tfEndereco, tfEmail;
	@FXML private Button btLimpar, btIncluir, btExcluir, btAlterar;
	@FXML private TableView<Cliente> tvClientes;
	@FXML private TableColumn<Cliente, Integer> tcIdClientes;
	@FXML private TableColumn<Cliente, String> tcCpfClientes, tcNomeClientes, tcEmailClientes, tcEnderecoClientes;
	@FXML private TableColumn<Cliente, LocalDate> tcNascCliente;
	@FXML private TextField tfPesquisar;
	@FXML private Button btPesquisar;
	@FXML private JFXButton btCadastrarCliente;
    @FXML private AnchorPane paneClientes;
    @FXML private JFXTextField tfNomeTeste;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tcIdClientes.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcNomeClientes.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tcCpfClientes.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tcEmailClientes.setCellValueFactory(new PropertyValueFactory<>("email"));
		tcEnderecoClientes.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		tcNascCliente.setCellValueFactory(new PropertyValueFactory<>("dataAniversario"));
	}

	@FXML
	private void dialogCliente(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/hospede.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Usuarios");
		stage.show();
	}

	@FXML
	void handleMouseClicked(MouseEvent event) throws IOException {

    	if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
	    		Hospede listagem = ClienteControllerFactory.getInstance();
				cliente = tvClientes.getSelectionModel().getSelectedItem();
				System.out.println(cliente.getId());

	    		listagem.abrir(cliente);
	    		

			}
			
    	}
		
	}
	
	public Cliente getClienteSelecionado() {
		return cliente;
	}
	
	public Cliente getCliente() {
		if(cliente == null)
			cliente = new Cliente();
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@FXML
	void handleLimpar(ActionEvent event) {
		tfCpf.setText("");
		tfNome.setText("");
		tfEmail.setText("");
		tfEndereco.setText("");
		cliente = new Cliente();

		atualizarBotoes();
	}

	private void atualizarBotoes() {

		btIncluir.setDisable(cliente.getId() != null);
		btAlterar.setDisable(cliente.getId() == null);
		btExcluir.setDisable(cliente.getId() == null);
	}

	private List<Cliente> listaCliente;

	@FXML
	void handleBuscar(ActionEvent event) throws IOException {
		ClienteRepository repository = new ClienteRepository(JPAFactory.getEntityManager());
		List<Cliente> lista = repository.getClientes(tfPesquisar.getText());
		if (lista.isEmpty()) {
			super.dialogErro();
		}
		tvClientes.setItems(FXCollections.observableList(lista));
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	
	

}
