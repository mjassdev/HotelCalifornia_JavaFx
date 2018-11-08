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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Cliente;
import model.Produto;
import model.Unidade;
import repository.ClienteRepository;
import repository.ProdutoRepository;

public class ProdutosController extends ControllerSuper implements Initializable{
	private Produto produto;
	
    @FXML private TableView<Produto> tvProdutos;
    @FXML private JFXButton btNovoCadastro, btLancarProdutos, btAjusteEstoque, btRelatorioEstoque;
    @FXML private TableColumn<Produto, Integer> tcIdProduto;
    @FXML private TableColumn<Produto, String> tcDescricaoProduto;
    @FXML private TableColumn<Unidade, String> tcUnidade;
    @FXML private TableColumn<Produto, String> tcQuantidade;
    @FXML private TableColumn<Produto, String> tcPrecoUnitario;
    @FXML private TableColumn<Produto, String> tcPrecoTotal;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		tcIdProduto.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcDescricaoProduto.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tcUnidade.setCellValueFactory(new PropertyValueFactory<>("unidadeMedida"));
		tcQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		tcPrecoUnitario.setCellValueFactory(new PropertyValueFactory<>("precoUnitario"));
		tcPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));
		try {
			atualizar();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
    
	public void atualizar() throws IOException {

		ProdutoRepository repository = new ProdutoRepository(JPAFactory.getEntityManager());
		List<Produto> lista = repository.getProdutos();
		if (lista.isEmpty()) {
			super.dialogErro();
		}
		tvProdutos.setItems(FXCollections.observableList(lista));		
	}
	
}
