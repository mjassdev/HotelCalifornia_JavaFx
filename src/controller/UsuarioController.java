package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import factory.JPAFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cliente;
import model.Usuario;
import repository.ClienteRepository;
import repository.UsuarioRepository;

public class UsuarioController extends ControllerSuper implements Initializable {

	private Usuario usuario;
	
	@FXML private TextField tfPesquisar;
	@FXML private Button btPesquisar;
	@FXML private TableView<Usuario> tvUsuarios;
	@FXML private TableColumn<Usuario, Integer> tcIdUsuario;
	@FXML private TableColumn<Usuario, String> tcCpfUsuario;
	@FXML private TableColumn<Usuario, String> tcNomeUsuario;
	@FXML private TableColumn<Usuario, String> tcEmailUsuario;
	@FXML private TableColumn<Usuario, String> tcEnderecoUsuario;
	@FXML private TableColumn<Usuario, String> tcPerfilUsuario;
    @FXML private TableColumn<Usuario, LocalDate> tcDataNascimento;
    @FXML private TableColumn<Usuario, String> tcSenha;
	@FXML private JFXButton btCadastrarUsuario;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tcIdUsuario.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcCpfUsuario.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tcNomeUsuario.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tcDataNascimento.setCellValueFactory(new PropertyValueFactory<>("dataAniversario"));
		tcEmailUsuario.setCellValueFactory(new PropertyValueFactory<>("email"));
		tcSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
		tcEnderecoUsuario.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		tcPerfilUsuario.setCellValueFactory(new PropertyValueFactory<>("perfilUsuario"));
	}	

	// Abrir janela de cadastro de usuarios do sistema
	@FXML
	private void dialogUsuarios(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/cadastrousuarios.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Usuarios");
		stage.show();
	}
	
	private List<Usuario> listaUsuario;
	
	@FXML
	void handleBuscar(ActionEvent event) throws IOException {
		UsuarioRepository repository = new UsuarioRepository(JPAFactory.getEntityManager());
		List<Usuario> lista = repository.getUsuarios(tfPesquisar.getText());
		if (lista.isEmpty()) {
			super.dialogErro();
		}
		tvUsuarios.setItems(FXCollections.observableList(lista));
	}
	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
}
