package factory;

import java.io.IOException;

import controller.Hospede;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ClienteControllerFactory {
	public static Hospede getInstance() throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(ClienteControllerFactory.class.getClass().getResource("/view/hospede.fxml"));
    
		Parent root = loader.load();

		Hospede listagem = loader.getController();	
    	listagem.setParent(root);
		
		return listagem;
		
	}
}
