package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Usuario;

public class TemplateController implements Initializable{
	
	private static BorderPane root;
	private Usuario usuario;
	
    @FXML private TextField usuarioLogado;
    @FXML private Label titulo;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		titulo.setText("QUARTOS");
//		usuarioLogado.setText("TESTE");
	}


    @FXML
    void handleQuarto(ActionEvent event) throws IOException {
    	trocaTela(1);
    	titulo.setText("QUARTOS");
    }
    
    @FXML
    void handleCliente(ActionEvent event) throws IOException {
    	trocaTela(2);
    	titulo.setText("CLIENTES");
    }
    
    @FXML
    void handleReservas(ActionEvent event) throws IOException {
    	trocaTela(3);
    	titulo.setText("RESERVAS");
    }

    @FXML
    void handleProdutos(ActionEvent event) throws IOException {
    	trocaTela(4);
    	titulo.setText("PRODUTOS");
    }

    @FXML
    void handleUsuario(ActionEvent event) throws IOException {
    	trocaTela(5);
    	titulo.setText("USUÁRIOS");
    }
    
    @FXML
    void handleConfiguracoes(ActionEvent event) throws IOException {
    	trocaTela(6);
    	titulo.setText("CONFIGURAÇÕES");
    }

    @FXML
    void handleSair(ActionEvent event) throws IOException {
    	trocaTela(7);
    }
    
	public void trocaTela(int numero) throws IOException {
		Parent clienteView = null;
		
		if(numero == 1) {
			clienteView = FXMLLoader.load(getClass().getResource("/view/quartos2.fxml"));
		}
		if(numero == 2) {
			clienteView = FXMLLoader.load(getClass().getResource("/view/cliente2.fxml"));
		}
		if(numero == 3) {
			clienteView = FXMLLoader.load(getClass().getResource("/view/reservas.fxml"));
		}
		if(numero == 4) {
			clienteView = FXMLLoader.load(getClass().getResource("/view/produtos.fxml"));
		}
		if(numero == 5) {
			clienteView = FXMLLoader.load(getClass().getResource("/view/usuarios.fxml"));
		}
		if(numero == 6) {
			clienteView = FXMLLoader.load(getClass().getResource("/view/settings.fxml"));
		}
		if(numero == 7) {
			System.out.println("SAIR");
		}

			//SCROLLPANE
			ScrollPane scroll = (ScrollPane) root.getChildren().get(3);
			scroll.setFitToHeight(true);
			scroll.setFitToWidth(true);
			VBox vbox = new VBox();
			vbox.setAlignment(Pos.CENTER.TOP_CENTER);
			vbox.getChildren().add(clienteView);
			
			scroll.setContent(vbox);
		


		
	}
	
	public void abrirMain(Usuario usuario2) throws IOException {
		setUsuario(usuario2);
//		usuarioLogado.setText("TESTE");
		
		root = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		Stage primaryStage = new Stage();	
		
		Parent clienteView = FXMLLoader.load(getClass().getResource("/view/quartos2.fxml"));
    	
		//SCROLLPANE
		ScrollPane scroll = (ScrollPane) root.getChildren().get(3);
		scroll.setFitToHeight(true);
		scroll.setFitToWidth(true);
		scroll.setContent(clienteView);

		Scene scene = new Scene(root, 600, 400);
		
		primaryStage.setTitle("HOTEL CALIFÓRNIA");
		primaryStage.setScene(scene);
		primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
		primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
    	
		primaryStage.show();
		
    	String nomeCompleto = usuario2.getNome();
    	System.out.println("Nome: " + nomeCompleto);
//    	usuarioLogado.setText("Olá, " + nomeCompleto.substring(0, nomeCompleto.indexOf(' ')));	


	}
	
	public void setarUsuario(Usuario usuarioMain) {
		setUsuario(usuarioMain);
    	String nomeCompleto = usuarioMain.getNome();
    	System.out.println("Nome: " + nomeCompleto);
    	usuarioLogado.setText("Olá, " + nomeCompleto.substring(0, nomeCompleto.indexOf(' ')));
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	
	
}
