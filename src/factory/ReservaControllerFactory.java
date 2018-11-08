package factory;

import java.io.IOException;

import controller.CadastroReservaController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ReservaControllerFactory {
	public static CadastroReservaController getInstance() throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(ReservaControllerFactory.class.getClass().getResource("/view/cadastroreservas.fxml"));
    
		Parent root = loader.load();

		CadastroReservaController listagem = loader.getController();	
    	listagem.setParent(root);
		
		return listagem;
		
	}
}
