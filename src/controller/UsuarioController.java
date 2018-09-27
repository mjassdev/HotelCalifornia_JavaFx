package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UsuarioController implements Initializable {

	@FXML
	private TextField tfPesquisar;

	@FXML
	private Button btPesquisar;

	@FXML
	private TableView<?> tvUsuarios;

	@FXML
	private TableColumn<?, ?> tcIdUsuario;

	@FXML
	private TableColumn<?, ?> tcCpfUsuario;

	@FXML
	private TableColumn<?, ?> tcNomeUsuario;

	@FXML
	private TableColumn<?, ?> tcEmailUsuario;

	@FXML
	private TableColumn<?, ?> tcEnderecoUsuario;

	@FXML
	private TableColumn<?, ?> tcPerfilUsuario;

	@FXML
	private JFXButton btCadastrarUsuario;


	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tcIdUsuario.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcCpfUsuario.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tcNomeUsuario.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tcEmailUsuario.setCellValueFactory(new PropertyValueFactory<>("email"));
		tcEnderecoUsuario.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		tcPerfilUsuario.setCellValueFactory(new PropertyValueFactory<>("perfilUsuario"));
	}

	// Abrir janela de castro de usuarios do sistema
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

}
