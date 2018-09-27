package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javax.persistence.EntityManager;
import org.w3c.dom.events.EventException;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import factory.JPAFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import model.Cliente;

public class Hospede implements Initializable {
	private Cliente cliente;

    @FXML
    private FontAwesomeIcon btFechar;

	@FXML
	private TabPane tablePaneAbas;

	@FXML
	private TextField tfNome, tfCpf, tfEndereco, tfEmail;

	@FXML
	private Button btLimpar, btExcluir, btAlterar, btIncluir;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void handleAlterar(ActionEvent event) {

		String nome = tfNome.getText(), endereco = tfEndereco.getText(), cpf = tfCpf.getText(),
				email = tfEmail.getText();

		cliente.setCpf(tfCpf.getText());
		cliente.setNome(tfNome.getText());
		cliente.setEmail(tfEmail.getText());
		cliente.setEndereco(tfEndereco.getText());

		Alert al = new Alert(AlertType.CONFIRMATION);
		al.setHeaderText("Alterar Cadastro");
		al.setContentText("Nome: " + nome + "\nCPF: " + cpf + "\nEndereço: " + endereco + "\nEmail: " + email);
		Optional<ButtonType> result = al.showAndWait();
		if (result.get() == ButtonType.OK) {

			Alert alInfo = new Alert(AlertType.INFORMATION);
			alInfo.setHeaderText("Cadastro Alterado com Sucesso!");
			alInfo.show();
		}

		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		em.close();

		handleLimpar(event);

	}

	@FXML
	void handleExcluir(ActionEvent event) {
		String nome = tfNome.getText(), endereco = tfEndereco.getText(), cpf = tfCpf.getText(),
				email = tfEmail.getText();

		Alert al = new Alert(AlertType.CONFIRMATION);
		al.setHeaderText("Excluir Cadastro");
		al.setContentText("Nome: " + nome + "\nCPF: " + cpf + "\nEndereço: " + endereco + "\nEmail: " + email);
		Optional<ButtonType> result = al.showAndWait();
		if (result.get() == ButtonType.OK) {

			Alert alInfo = new Alert(AlertType.INFORMATION);
			alInfo.setHeaderText("Cadastro Removido com Sucesso!");
			alInfo.show();
		}

		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		cliente = em.merge(cliente);
		em.remove(cliente);
		em.getTransaction().commit();
		em.close();

		handleLimpar(event);
	}

	@FXML
	void handleIncluir(ActionEvent event) {

		String nome = tfNome.getText(), endereco = tfEndereco.getText(), cpf = tfCpf.getText(),
				email = tfEmail.getText();

		cliente = new Cliente(tfNome.getText(), tfCpf.getText(), tfEndereco.getText(), tfEmail.getText());
		if (nome == null || cpf == null || endereco == null) {

		} else {
			Alert al = new Alert(AlertType.CONFIRMATION);
			al.setHeaderText("Novo Cadastro");
			al.setContentText("Nome: " + nome + "\nCPF: " + cpf + "\nEndereço: " + endereco + "\nEmail: " + email);
			Optional<ButtonType> result = al.showAndWait();
			if (result.get() == ButtonType.OK) {
				try {
					EntityManager em = JPAFactory.getEntityManager();
					em.getTransaction().begin();
					em.persist(cliente);
					em.getTransaction().commit();
					em.close();

					Alert alInfo = new Alert(AlertType.INFORMATION);
					alInfo.setHeaderText("Cadastro Realizado com Sucesso!");
					alInfo.show();
				} catch (EventException e) {

				}

			}
		}
		handleLimpar(event);
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
		cliente = new Cliente();

		atualizarBotoes();
	}

	private void atualizarBotoes() {

		btIncluir.setDisable(cliente.getId() != null);
		btAlterar.setDisable(cliente.getId() == null);
		btExcluir.setDisable(cliente.getId() == null);

	}

}
