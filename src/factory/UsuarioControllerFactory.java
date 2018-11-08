package factory;

import java.io.IOException;

import controller.CadastraUsuarioController;
import controller.Hospede;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class UsuarioControllerFactory {
	public static CadastraUsuarioController getInstance() throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(ClienteControllerFactory.class.getClass().getResource("/view/cadastrousuarios.fxml"));
    
		Parent root = loader.load();

		CadastraUsuarioController listagem = loader.getController();	
    	listagem.setParent(root);
		
		return listagem;
		
	}
}
