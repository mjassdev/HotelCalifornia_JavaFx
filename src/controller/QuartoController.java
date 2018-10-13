package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.sun.prism.paint.Color;

import factory.JPAFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Quarto;
import model.Usuario;
import repository.QuartoRepository;
import repository.UsuarioRepository;

public class QuartoController implements Initializable{
	
	private Quarto quarto;
    @FXML private AnchorPane quartosPane;
	
	GridPane grid = new GridPane();
	Scene scene = new Scene(grid, 1024,768);

    @FXML
    void abrirQuarto(MouseEvent event) throws IOException {
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/quarto_open.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("QUARTO");
		stage.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		QuartoRepository repository = new QuartoRepository(JPAFactory.getEntityManager());
		Object contagem = repository.getCountQuartos();	
		List<Quarto> ocupado = repository.getOcupado();
		
		
		int totalQuartos=Integer.parseInt(contagem.toString());
		
		System.out.println(totalQuartos);
		
		int i = 1;
		int indexRow = 0;
		int indexColuna = 0;
		
		while(i<=totalQuartos) {
			
			for(indexColuna = 0 ; indexColuna<9; indexColuna++) {
				JFXButton botaoQuarto = new JFXButton();
				botaoQuarto.setPrefWidth(100);
				botaoQuarto.setPrefHeight(100);
				botaoQuarto.setStyle("-fx-background-color: #6ca6cd; -fx-background-radius: 0px; -fx-border-color: #000000");
				botaoQuarto.setText("100");
				i++;
				grid.addColumn(indexColuna, botaoQuarto);
				if(i > totalQuartos) {
					break;
				}

			}
			if(i > totalQuartos) {
				break;
			}
			JFXButton botaoQuarto = new JFXButton();
			botaoQuarto.setPrefWidth(100);
			botaoQuarto.setPrefHeight(100);
			botaoQuarto.setStyle("-fx-background-color: #6ca6cd; -fx-background-radius: 0px; -fx-border-color: #000000");
			botaoQuarto.setText("100");
			grid.addRow(indexRow, botaoQuarto);
			
			indexRow++;
			i++;
			
		}
		quartosPane.getChildren().addAll(grid);
	}	
	
	
	
	

}
