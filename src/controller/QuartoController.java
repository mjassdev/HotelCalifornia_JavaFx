package controller;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import factory.CadastroReservaControllerFactory;
import factory.ClienteControllerFactory;
import factory.JPAFactory;
import factory.QuartoControllerFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Quarto;
import model.Usuario;
import repository.QuartoRepository;
import repository.UsuarioRepository;

public class QuartoController extends ControllerSuper implements Initializable{
	
	private Quarto quarto;
    @FXML private FlowPane quartosPane;
	private Parent parent;
	private JFXButton botaoQuarto;	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		quartosPane.setPrefHeight(height);
		quartosPane.setPrefWidth(width);
		preencherBotoes();
	}	
	
	public void preencherBotoes() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();		
		QuartoRepository repository = new QuartoRepository(JPAFactory.getEntityManager());
		List<Quarto> listaQuarto = repository.getQuartos();		
		for(Quarto lista : listaQuarto) {
			
			botaoQuarto = new JFXButton();
			botaoQuarto.setPrefWidth(width/15);
			botaoQuarto.setPrefHeight(height/9);
			atualizaBotoes(botaoQuarto, lista);
			botaoQuarto.setText(lista.getNumeroQuarto());
			botaoQuarto.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
	            public void handle(ActionEvent event) {
					try {
						abrirJanelaQuarto(lista);
						atualizaBotoes(botaoQuarto, lista);

					} catch (IOException e) {
						e.printStackTrace();
					}
	            }
			});
			quartosPane.getChildren().add(botaoQuarto);
		}
	}
	
	public static Button atualizaBotoes(Button botaoQuarto, Quarto lista){
		double imageWidth = 18.0;
			if(lista.isOcupado() == false) {
				
				botaoQuarto.setGraphic(null);
				botaoQuarto.setStyle("-fx-background-color: #87CEFF; -fx-background-radius: 0px; -fx-border-color: #ffffff");
			}
			else {
		        ImageView imageView = new ImageView(new Image("/imagens/user.png"));
		        imageView.setFitHeight(imageWidth);
		        imageView.setFitWidth(imageWidth);
		        botaoQuarto.setGraphic(imageView);
				botaoQuarto.setStyle("-fx-background-color: #00688B; -fx-text-fill: white; -fx-background-radius: 0px; -fx-border-color: #ffffff");
			}
		return botaoQuarto;
	}
	
	private void abrirJanelaQuarto(Quarto quarto) throws IOException {
		CheckController abrirQuarto = QuartoControllerFactory.getInstance();
		abrirQuarto.abrir(quarto);
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
}
