package factory;

import java.io.IOException;

import controller.CheckController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class QuartoControllerFactory {
	public static CheckController getInstance() throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(QuartoControllerFactory.class.getClass().getResource("/view/quarto_open.fxml"));
    
		Parent root = loader.load();

		CheckController quarto = loader.getController();	
    	quarto.setParent(root);
		
		return quarto;
		
	}
}
