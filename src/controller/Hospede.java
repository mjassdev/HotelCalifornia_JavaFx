package controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXDatePicker;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;
import model.Cliente;
import tools.TextFieldFormatter;

public class Hospede extends ControllerSuper implements Initializable {
	private Cliente cliente;
	private Stage stage;
	private Parent parent;

	@FXML private FontAwesomeIcon btFechar;
	@FXML private JFXDatePicker datePickerAniversario;
	@FXML private TabPane tablePaneAbas;
	@FXML private TextField tfNome, tfCpf, tfEndereco, tfEmail;
	@FXML private Button btLimpar, btExcluir, btAlterar, btIncluir;

	@Override
	public void initialize(URL location, ResourceBundle resources) {


	}

    public void abrir(Cliente cliente) {
    	
    	setCliente(cliente);
    	
    	stage = new Stage();
		Scene scene = new Scene(parent, 400, 345);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.WINDOW_MODAL);
		
    	tfNome.setText(cliente.getNome());
    	tfCpf.setText(cliente.getCpf());
    	tfEndereco.setText(cliente.getEndereco());
    	tfEmail.setText(cliente.getEmail());
    	datePickerAniversario.setValue(cliente.getDataAniversario());

    	stage.showAndWait();
    }
	
	@FXML
	void handleAlterar(ActionEvent event) {
    	
		try {
			getCliente().getId();
			getCliente().setNome(tfNome.getText());
			getCliente().setNome(tfNome.getText());
	    	getCliente().setEndereco(tfEndereco.getText());
	    	getCliente().setEmail(tfEmail.getText());
	    	getCliente().setCpf(tfCpf.getText());
	    	getCliente().setDataAniversario(datePickerAniversario.getValue());
		
		super.save(getCliente());

		dialogConfirmaAlteracao();
		
    	handleLimpar(event);
	}
	catch(Exception e) {
		
	}
		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage
	}

	@FXML
	void handleExcluir(ActionEvent event) {
		String nome = tfNome.getText(), endereco = tfEndereco.getText(), cpf = tfCpf.getText(), email = tfEmail.getText();
		super.remove(cliente);
		handleLimpar(event);
	}

	@FXML
	void handleIncluir(ActionEvent event) {
		
		
		
		cliente = new Cliente(tfNome.getText(), tfCpf.getText(), tfEndereco.getText(), tfEmail.getText(), datePickerAniversario.getValue());
		String nome = tfNome.getText(), endereco = tfEndereco.getText(), cpf = tfCpf.getText(), email = tfEmail.getText();
		super.save(cliente);
		handleLimpar(event);
	}

	@FXML
	void handleFecharJanela(MouseEvent event) {
		Stage stage = (Stage) btFechar.getScene().getWindow(); // Obtendo a janela atual
		stage.close(); // Fechando o Stage
	}

	@FXML
	void handleLimpar(ActionEvent event) {
		tfCpf.setText("");
		tfNome.setText("");
		tfEmail.setText("");
		tfEndereco.setText("");
		datePickerAniversario.setValue(null);
		cliente = new Cliente();
		atualizarBotoes();
	}
	
    @FXML
    private void tfCpfReleased()  {
    	TextFieldFormatter tff = new TextFieldFormatter();
    	tff.setMask("###.###.###-##");
    	tff.setCaracteresValidos("0123456789");
    	tff.setTf(tfCpf);
    	tff.formatter();
    }

    

	private void atualizarBotoes() {
		btIncluir.setDisable(cliente.getId() != null);
		btAlterar.setDisable(cliente.getId() == null);
		btExcluir.setDisable(cliente.getId() == null);
	}
	
	public Cliente getCliente() {
		if(cliente == null)
			cliente = new Cliente();
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	

}
