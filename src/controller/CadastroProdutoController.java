package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cliente;
import model.Produto;
import model.Unidade;
import repository.ProdutoRepository;
import repository.Repository;
import repository.UnidadeRepository;

public class CadastroProdutoController  extends ControllerSuper implements Initializable{

	private Produto produto;

    @FXML private JFXTextField tfItem;
    @FXML private JFXTextField tfDescricaoProduto;
    @FXML private JFXTextField tfGeneroProdutos;
    @FXML private JFXComboBox<Unidade> tfUnidade;
    @FXML private FontAwesomeIcon btFechar;
    @FXML private JFXDatePicker tfDataCadastro;
	@FXML private Button btLimpar, btExcluir, btAlterar, btIncluir;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		carregarComboBox();
	}
	
	@FXML
	void handleExcluir(ActionEvent event) {
		String item = tfItem.getText(), descricao = tfDescricaoProduto.getText(), genero = tfGeneroProdutos.getText();
		super.remove(produto);
		handleLimpar(event);
	}

	@FXML
	void handleIncluir(ActionEvent event) {
		produto = new Produto(tfItem.getText(), tfDescricaoProduto.getText(), tfGeneroProdutos.getText(), tfUnidade.getValue(), tfDataCadastro.getValue());
		/*getProduto().setItem(tfItem.getText());
		getProduto().setDescricao(tfDescricaoProduto.getText());
		getProduto().setGenero(tfGeneroProdutos.getText());
		getProduto().setUnidadeMedida(tfUnidade.getValue());
		getProduto().setDataCaddastro(tfDataCadastro.getValue());*/
		
		super.save(produto);
		handleLimpar(event);
	}

	@FXML
	void handleLimpar(ActionEvent event) {
		tfItem.setText("");
		tfDescricaoProduto.setText("");
		tfGeneroProdutos.setText("");
		tfDataCadastro.setValue(null);
		tfUnidade.setValue(null);
		produto = new Produto();
		
		atualizarBotoes();
	}
	
	@FXML
	void handleAlterar(ActionEvent event) {
		String item = tfItem.getText(), descricao = tfDescricaoProduto.getText(), genero = tfGeneroProdutos.getText(), dataCadastro = tfDataCadastro.getValue().toString();
		super.remove(produto);

		produto.setItem(tfItem.getText());
		produto.setDescricao(tfDescricaoProduto.getText());
		produto.setGenero(tfGeneroProdutos.getText());
		produto.setDataCaddastro(tfDataCadastro.getValue());
		
		Alert al = new Alert(AlertType.CONFIRMATION);
		al.setHeaderText("Alterar Cadastro");
		al.setContentText("Item: " + item + "\nDescri��o: " + descricao + "\nG�nero: " + genero + "\nData Cadastro: " + dataCadastro);
		Optional<ButtonType> result = al.showAndWait();
		
		if (result.get() == ButtonType.OK) {

			Alert alInfo = new Alert(AlertType.INFORMATION);
			alInfo.setHeaderText("Cadastro Alterado com Sucesso!");
			alInfo.show();
		}
		
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		em.close();

		handleLimpar(event);

	}
	
	private void atualizarBotoes() {
		btIncluir.setDisable(produto.getId() != null);
//		btAlterar.setDisable(produto.getId() == null);
		btExcluir.setDisable(produto.getId() == null);
	}
	
	public void carregarComboBox() {

		UnidadeRepository repository = new UnidadeRepository(JPAFactory.getEntityManager());

		List<Unidade> lista = repository.getListUnidades();

		tfUnidade.setItems(FXCollections.observableList(lista));
	}
	
	@FXML
	void handleFecharJanela(MouseEvent event) {
		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}