package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import factory.JPAFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cliente;
import model.Produto;
import repository.ClienteRepository;

public class ProdutosController implements Initializable{
	private Produto produto;
	
    @FXML private JFXButton btNovoCadastro, btLancarProdutos, btAjusteEstoque, btRelatorioEstoque;
    @FXML private TableColumn<Produto, Integer> tcIdProduto;
    @FXML private TableColumn<Produto, String> tcDescricaoProduto;
    @FXML private TableColumn<Produto, String> tcUnidade;
    @FXML private TableColumn<Produto, String> tcQuantidade;
    @FXML private TableColumn<Produto, String> tcPrecoUnitario;
    @FXML private TableColumn<Produto, String> tcPrecoTotal;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

    @FXML
    void AjustarEstoque(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/ajusteestoque.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("AJUSTAR ESTOQUE");
		stage.show();
    }

    @FXML
    void CadastrarProduto(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/novoproduto.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("NOVO PRODUTO");
		stage.show();
    }

    @FXML
    void RelatorioEstoque(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/relatorioestoque.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("RELATORIO DE ESTOQUE");
		stage.show();
    }

    @FXML
    void lancarprodutos(ActionEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/lancarproduto.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("LANÇAR");
		stage.show();
    }
    
	
}
