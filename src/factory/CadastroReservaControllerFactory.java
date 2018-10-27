package factory;

import java.io.IOException;

import controller.CadastroReservaController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class CadastroReservaControllerFactory {
	public static CadastroReservaController getInstance() throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(CadastroReservaControllerFactory.class.getClass().getResource("/view/quarto_open.fxml"));
    
		Parent root = loader.load();

		CadastroReservaController quarto = loader.getController();	
    	quarto.setParent(root);
		
		return quarto;
		
	}
}
