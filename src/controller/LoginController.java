package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import factory.ControllerFactory;
import factory.JPAFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
    @FXML private ProgressBar progress;
    Text txtState = new Text();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		erro.setVisible(false);
		erropreenchimento.setVisible(false);
		excCpf.setVisible(false);
		excSenha.setVisible(false);
		progress.setVisible(true);
	}
	
    @FXML public void acessarSistema(ActionEvent event) throws IOException {
		erro.setVisible(false);
		erropreenchimento.setVisible(false);
		excCpf.setVisible(false);
		excSenha.setVisible(false);

			UsuarioRepository repository = new UsuarioRepository(JPAFactory.getEntityManager());
			List<Usuario> usuario = repository.getLogin(tfUsuario.getText(), tfSenha.getText());
			
			if (!usuario.isEmpty()) {
				for (Usuario lista : usuario) {
					Usuario usuarioteste = lista;
					System.out.println(usuarioteste.getNome().toString());
					Controller passarNome = ControllerFactory.getInstance(usuarioteste);
					passarNome.passar(usuarioteste);
					Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
					stage.close();
				}

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
