package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jfoenix.controls.JFXButton;

import factory.JPAFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Cliente;

public class ClienteController implements Initializable{
	
	private Cliente cliente;
	
    @FXML
    private TabPane tablePaneAbas;
    @FXML
    private TextField tfNome, tfCpf, tfEndereco, tfEmail;
    @FXML
    private Button btLimpar, btIncluir, btExcluir, btAlterar;
    @FXML
    private TableView<Cliente> tvClientes;
    @FXML
    private TableColumn<Cliente, Integer> tcIdClientes;
    @FXML
    private TableColumn<Cliente, String> tcCpfClientes, tcNomeClientes, tcEmailClientes, tcEnderecoClientes;
    @FXML
    private TextField tfPesquisar;
    @FXML
    private Button btPesquisar;
    @FXML
    private JFXButton btCadastrarCliente;
	

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		tcIdClientes.setCellValueFactory(new PropertyValueFactory<>("id"));
		tcCpfClientes.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tcNomeClientes.setCellValueFactory(new PropertyValueFactory<>("nome"));	
		tcEmailClientes.setCellValueFactory(new PropertyValueFactory<>("email"));
		tcEnderecoClientes.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		
	}
	
    @FXML
    private void dialogCliente(MouseEvent event) throws IOException {
    	
    	Parent cenaCliente = FXMLLoader.load(getClass().getResource("/view/hospede.fxml"));
    	Dialog dialog = new Dialog();
    	dialog.getDialogPane().setContent(cenaCliente);
    	dialog.show();
    } 
    
    
    @FXML
    void handleMouseClicked(MouseEvent event) {
    	if(event.getButton().equals(MouseButton.PRIMARY)) {
    		if(event.getClickCount() == 2) {
    	    	cliente = tvClientes.getSelectionModel().getSelectedItem();
    	    	tfCpf.setText(cliente.getCpf());
    	    	tfNome.setText(cliente.getNome());
    	    	tfEndereco.setText(cliente.getEndereco());
    	    	tfEmail.setText(cliente.getEmail());
    	    	
    	    	//selecionando a primeira Aba
    	    	tablePaneAbas.getSelectionModel().select(0);
    	    	
    	    	tfCpf.requestFocus();
    			atualizarBotoes();
    		}
    	}
    }
    

    
	
    @FXML
    void handleBuscar(ActionEvent event) {
    	
    	System.out.println("Pesquisar");
    	EntityManager em = JPAFactory.getEntityManager();
    	
    	Query query = em.createQuery("Select c From Cliente c WHERE lower(c.nome) like lower(:nome)");
    	query.setParameter("nome", "%" + tfPesquisar.getText() + "%");
    	List<Cliente> lista = query.getResultList();
    	    	
    	if(lista == null || lista.isEmpty()) {
    		Alert alerta = new Alert(AlertType.INFORMATION);
    		alerta.setTitle("Informação");
    		alerta.setHeaderText(null);
    		alerta.setContentText("A lista não retornou dados");
    		alerta.show();
    		lista = new ArrayList<Cliente>();
    	}
    	

    	
    	tvClientes.setItems(FXCollections.observableList(lista));
    }
	
    @FXML
    void handleAlterar(ActionEvent event) {

    	
		String nome = tfNome.getText(),
				endereco = tfEndereco.getText(),
				cpf = tfCpf.getText(),
				email = tfEmail.getText();
    	
		cliente.setCpf(tfCpf.getText());
		cliente.setNome(tfNome.getText());
		cliente.setEmail(tfEmail.getText());
		cliente.setEndereco(tfEndereco.getText());
		
		Alert al = new Alert(AlertType.CONFIRMATION);
		al.setHeaderText("Alterar Cadastro");
		al.setContentText("Nome: " + nome + "\nCPF: "+cpf+"\nEndereço: "+endereco+"\nEmail: "+email);
		Optional<ButtonType> result = al.showAndWait();
		if(result.get() == ButtonType.OK) {

			
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
		String nome = tfNome.getText(),
				endereco = tfEndereco.getText(),
				cpf = tfCpf.getText(),
				email = tfEmail.getText();
    	
		
		Alert al = new Alert(AlertType.CONFIRMATION);
		al.setHeaderText("Excluir Cadastro");
		al.setContentText("Nome: " + nome + "\nCPF: "+cpf+"\nEndereço: "+endereco+"\nEmail: "+email);
		Optional<ButtonType> result = al.showAndWait();
		if(result.get() == ButtonType.OK) {

			
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
    	

    		String nome = tfNome.getText(),
    				endereco = tfEndereco.getText(),
    				cpf = tfCpf.getText(),
    				email = tfEmail.getText();
        	
    		cliente = new Cliente(tfNome.getText(),tfCpf.getText(),tfEndereco.getText(),tfEmail.getText());
    		
    		Alert al = new Alert(AlertType.CONFIRMATION);
    		al.setHeaderText("Novo Cadastro");
    		al.setContentText("Nome: " + nome + "\nCPF: "+cpf+"\nEndereço: "+endereco+"\nEmail: "+email);
    		Optional<ButtonType> result = al.showAndWait();
    		if(result.get() == ButtonType.OK) {
    			Alert alInfo = new Alert(AlertType.INFORMATION);
    			alInfo.setHeaderText("Cadastro Realizado com Sucesso!");
    			alInfo.show();
    		}
    		
    		
    		EntityManager em = JPAFactory.getEntityManager();
    		em.getTransaction().begin();
    		em.persist(cliente);
    		em.getTransaction().commit();
    		em.close();
    		
    		handleLimpar(event);



    	
    	
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
