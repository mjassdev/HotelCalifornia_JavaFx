package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import factory.JPAFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Usuario;
import repository.UsuarioRepository;

public class LoginController implements Initializable {
   
	@FXML private JFXButton btEntrar;
    @FXML private FontAwesomeIcon btFechar;
    @FXML private TextField tfUsuario;
    @FXML private PasswordField tfSenha;
    @FXML private Label erro;
    @FXML private Label erropreenchimento;
    @FXML private FontAwesomeIcon excCpf;
    @FXML private FontAwesomeIcon excSenha;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		erro.setVisible(false);
		erropreenchimento.setVisible(false);
		excCpf.setVisible(false);
		excSenha.setVisible(false);
		
	}
	
    @FXML public void acessarSistema(ActionEvent event) throws IOException {
		erro.setVisible(false);
		erropreenchimento.setVisible(false);
		excCpf.setVisible(false);
		excSenha.setVisible(false);

			UsuarioRepository repository = new UsuarioRepository(JPAFactory.getEntityManager());
			List<Usuario> usuario = repository.getLogin(tfUsuario.getText(), tfSenha.getText());
			if (!usuario.isEmpty()) {
				Parent root = FXMLLoader.load(getClass().getResource("/view/main_view.fxml"));
				Stage scene = new Stage();
				scene.setTitle("HOTEL CALIFORNIA");
				scene.setScene(new Scene(root, 1366, 768));
				scene.setResizable(true);
				// Mudar quando criar metodo de validação de acesso
				Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
				stage.close();
				scene.showAndWait();

			}else if (tfUsuario.getText().isEmpty() || tfSenha.getText().isEmpty()) {

				if(tfUsuario.getText().isEmpty()) {
					erropreenchimento.setVisible(true);
					excCpf.setVisible(true);
				}if(tfSenha.getText().isEmpty()) {
					erropreenchimento.setVisible(true);
					excSenha.setVisible(true);
				}
			}
			else{
				erro.setVisible(true);
			}

    }

    @FXML void handleFecharJanela(MouseEvent event) {
		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage
    }
}
