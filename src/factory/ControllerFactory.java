package factory;

import java.io.IOException;

import controller.CadastroReservaController;
import controller.CheckController;
import controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import model.Usuario;

public class ControllerFactory {
	public static Controller getInstance(Usuario usuario) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(ControllerFactory.class.getClass().getResource("/view/main_view.fxml"));
		
//		System.out.println("Nome: " + usuario.getNome().toString());
		
		Parent root = loader.load();
		Controller controller = loader.getController();	

    	controller.setParent(root);
		
		return controller;
		
	}
}
