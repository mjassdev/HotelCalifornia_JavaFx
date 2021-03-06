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
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;

import application.Main;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import factory.JPAFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Cliente;
import model.Usuario;
import repository.UsuarioRepository;

public class CadastraUsuarioController extends ControllerSuper implements Initializable {
	private Usuario usuario;
	private Stage stage;
	private Parent parent;
	
    @FXML private JFXDatePicker datePickerAniversario;
    @FXML private FontAwesomeIcon btFechar;
	@FXML private TabPane tablePaneAbas;
	@FXML private TextField tfNome, tfCpf, tfEndereco, tfEmail;
	@FXML private Button btLimpar, btExcluir, btAlterar, btIncluir;
    @FXML private JFXPasswordField pfSenha;
    @FXML private JFXPasswordField pfSenha1;
    
    @FXML private JFXComboBox<?> cbPerfilUsuario;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void handleAlterar(ActionEvent event) {

		String nome = tfNome.getText(), cpf = tfCpf.getText(), endereco = tfEndereco.getText(),
				email = tfEmail.getText(), dataAniversario = datePickerAniversario.getValue().toString();

		usuario.setCpf(tfCpf.getText());
		usuario.setNome(tfNome.getText());
		usuario.setEmail(tfEmail.getText());
		usuario.setEndereco(tfEndereco.getText());
		usuario.setDataAniversario(datePickerAniversario.getValue());

		Alert al = new Alert(AlertType.CONFIRMATION);
		al.setHeaderText("Alterar Cadastro");
		al.setContentText("Nome: " + nome + "\nCPF: " + cpf + "\nEndere�o: " + endereco + "\nEmail: " + email + "\nAnivers�rio: " + dataAniversario);
		Optional<ButtonType> result = al.showAndWait();
		if (result.get() == ButtonType.OK) {

			Alert alInfo = new Alert(AlertType.INFORMATION);
			alInfo.setHeaderText("Cadastro Alterado com Sucesso!");
			alInfo.show();
		}

		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();

		handleLimpar(event);

	}

	@FXML
	void handleExcluir(ActionEvent event) {
		String nome = tfNome.getText(), endereco = tfEndereco.getText(), cpf = tfCpf.getText(),
				email = tfEmail.getText(), senha = pfSenha.getText();
		super.remove(usuario);
		handleLimpar(event);
	}

	@FXML
	void handleIncluir(ActionEvent event) throws IOException {
		usuario = new Usuario(tfNome.getText(), tfCpf.getText(), tfEndereco.getText(), tfEmail.getText(), datePickerAniversario.getValue(), pfSenha.getText());
		if(pfSenha.getText().equals(pfSenha1.getText())) {
			super.save(usuario);
			super.dialogConfirma();
			handleLimpar(event);
		}else if(!pfSenha.getText().equals(pfSenha1.getText())){
			super.dialogErroSenhas();
		}
		else {
			super.dialogErro();
		}
	}

	@FXML
	void handleFecharJanela(MouseEvent event) {
		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage
	}

	@FXML
	void handleLimpar(ActionEvent event) {
		tfCpf.setText("");
		tfNome.setText("");
		tfEmail.setText("");
		tfEndereco.setText("");
		datePickerAniversario.setValue(null);
		pfSenha.setText("");
		pfSenha1.setText("");
		usuario = new Usuario();
		atualizarBotoes();
	}
	
    public void abrir(Usuario usuario) {
    	
    	setUsuario(usuario);
    	
    	stage = new Stage();
		Scene scene = new Scene(parent, 400, 345);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.WINDOW_MODAL);
		
    	tfNome.setText(usuario.getNome());
    	tfCpf.setText(usuario.getCpf());
    	tfEndereco.setText(usuario.getEndereco());
    	tfEmail.setText(usuario.getEmail());
    	datePickerAniversario.setValue(usuario.getDataAniversario());
    	atualizarBotoes();
    	stage.show();

    }

	private void atualizarBotoes() {
		btIncluir.setDisable(usuario.getId() != null);
		btAlterar.setDisable(usuario.getId() == null);
		btExcluir.setDisable(usuario.getId() == null);
	}
	
	public Usuario getUsuario() {
		if(usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

