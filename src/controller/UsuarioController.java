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

public class UsuarioController implements Initializable {

	@FXML
	private TextField tfPesquisar;

	@FXML
	private Button btPesquisar;

	@FXML
	private TableView<?> tvClientes;

	@FXML
	private TableColumn<?, ?> tcIdClientes;

	@FXML
	private TableColumn<?, ?> tcCpfClientes;

	@FXML
	private TableColumn<?, ?> tcNomeClientes;

	@FXML
	private TableColumn<?, ?> tcEmailClientes;

	@FXML
	private TableColumn<?, ?> tcEnderecoClientes;

    @FXML
    private TableColumn<?, ?> tcPerfilUsuario;
    
    @FXML
    private JFXButton btCadastrarUsuario;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tcIdClientes.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcCpfClientes.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tcNomeClientes.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tcEmailClientes.setCellValueFactory(new PropertyValueFactory<>("email"));
		tcEnderecoClientes.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		tcPerfilUsuario.setCellValueFactory(new PropertyValueFactory<>("perfilUsuario"));
	}
	
	//Abrir janela de castro de usuários do sistema
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
		stage.setTitle("Usuários");
		stage.show();
	}

}
