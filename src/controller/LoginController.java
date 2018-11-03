package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.SwingWorker;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import factory.ControllerFactory;
import factory.JPAFactory;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Usuario;
import repository.UsuarioRepository;

public class LoginController implements Initializable {
   
	private static BorderPane root;

	
	@FXML private JFXButton btEntrar;
    @FXML private FontAwesomeIcon btFechar;
    @FXML private JFXTextField tfUsuario;
    @FXML private JFXPasswordField tfSenha;
    @FXML private Label erro;
    @FXML private Label erropreenchimento;
    @FXML private FontAwesomeIcon excCpf;
    @FXML private FontAwesomeIcon excSenha;
    @FXML private JFXProgressBar progress;
    
    class bg_Thread implements Runnable{

		@Override
		public void run() {
			
			progress.setVisible(true);
			
			//Laço para adicionar progresso na barra
//			for(int i= 0; i<100 ; i++) {
//				try {
//					progress.setProgress(i/50.0);
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		erro.setVisible(false);
		erropreenchimento.setVisible(false);
		excCpf.setVisible(false);
		excSenha.setVisible(false);

		progress.setVisible(false);
	}
	

    @SuppressWarnings("deprecation")
	@FXML public void acessarSistema(ActionEvent event) throws IOException, InterruptedException {

    	Thread th = new Thread(new bg_Thread());
    	Platform.runLater(th);

		th.start();

		erro.setVisible(false);
		erropreenchimento.setVisible(false);
		excCpf.setVisible(false);
		excSenha.setVisible(false);

		UsuarioRepository repository = new UsuarioRepository(JPAFactory.getEntityManager());
			List<Usuario> usuario = repository.getLogin(tfUsuario.getText(), tfSenha.getText());
			
			progress.setVisible(true);
			
			if (!usuario.isEmpty()) {
				
				for (Usuario lista : usuario) {
					Usuario usuarioteste = lista;
					TemplateController abrir = new TemplateController();
					abrir.abrirMain(usuarioteste);
//					abrir.setarUsuario(usuarioteste);
//					abrir.setUsuario(usuarioteste);
					Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
					stage.close(); // Fechando Janela
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
			
			th.stop();

    }
    

    @FXML void handleFecharJanela(MouseEvent event) {
		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage
    }
}
