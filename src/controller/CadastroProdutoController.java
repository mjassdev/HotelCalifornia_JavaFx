package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cliente;
import model.Produto;

public class CadastroProdutoController  extends ControllerSuper implements Initializable{

	private Produto produto;

    @FXML private JFXTextField tfItem;
    @FXML private JFXTextField tfDescricaoProduto;
    @FXML private JFXTextField tfGeneroProdutos;
    @FXML private JFXComboBox<Produto> tfUnidade;
    @FXML private FontAwesomeIcon btFechar;
    @FXML private JFXDatePicker tfDataCadastro;
	@FXML private Button btLimpar, btExcluir, btAlterar, btIncluir;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	@FXML
	void handleExcluir(ActionEvent event) {
		String item = tfItem.getText(), descricao = tfDescricaoProduto.getText(), genero = tfGeneroProdutos.getText();
		super.remove(produto);
		handleLimpar(event);
	}

	@FXML
	void handleIncluir(ActionEvent event) {
		produto = new Produto(tfItem.getText(), tfDescricaoProduto.getText(), tfGeneroProdutos.getText(), tfDataCadastro.getValue());
		super.save(produto);
		handleLimpar(event);
	}
	
	@FXML
	void handleLimpar(ActionEvent event) {
		tfItem.setText("");
		tfDescricaoProduto.setText("");
		tfGeneroProdutos.setText("");
		tfDataCadastro.setValue(null);
		produto = new Produto();
		
		atualizarBotoes();
	}
	
	private void atualizarBotoes() {
		btIncluir.setDisable(produto.getId() != null);
//		btAlterar.setDisable(produto.getId() == null);
		btExcluir.setDisable(produto.getId() == null);
	}
	
	@FXML
	void handleFecharJanela(MouseEvent event) {
		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage
	}
}
