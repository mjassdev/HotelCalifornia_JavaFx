package controller;

import com.jfoenix.controls.JFXTabPane;

import factory.QuartoControllerFactory;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Quarto;
import model.Usuario;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.swing.GroupLayout.Alignment;


public class Controller {
	private Usuario usuario;
	private Stage stage;
	private Parent parent;
    private Tab currentTab = new Tab();
    @FXML private JFXTabPane tabContainer;
    @FXML private Tab CLIENTES, QUARTOS, logoutTab, RESERVAS, PRODUTOS, USUARIOS, RELATORIOS, SETTINGS ;
    @FXML private AnchorPane userProfileContainer, settingsContainer, reservasContainer, produtosContainer,  usuarioContainer, relatoriosContainer, configContainer ;
    @FXML private TextField tituloAba;
    @FXML private TextField nomeUsuario;
    @FXML private TextField tfTitulo;
    
    private double tabWidth = 250.0;
    private double tabHeight = 70;
    public static int lastSelectedTabIndex = 0;

    /// Life cycle

    @FXML
    public void initialize() {
        configureView();
        tfTitulo.setText("QUARTOS");
    }
    
    public void passar(Usuario usuario) {
    	setUsuario(usuario);
    	stage = new Stage();
		Scene scene = new Scene(parent, 1366, 768);
		stage.setScene(scene);
		stage.setFullScreen(true);
    	stage.show();
    	String nomeCompleto = usuario.getNome();
    	nomeUsuario.setText("Olá, "+nomeCompleto.substring(0, nomeCompleto.indexOf(' ')));
    }

    public void mudarTitulo(Tab currentTab) {
    	System.out.println("TAB: " + currentTab.getId().toString());
		tfTitulo.setText(currentTab.getId().toString());
    }

    private void configureView() {
        tabContainer.setTabMinWidth(60);
        tabContainer.setTabMaxWidth(tabHeight);
        tabContainer.setTabMinHeight(tabWidth);
        tabContainer.setTabMaxHeight(tabWidth);
        tabContainer.setRotateGraphic(true);

        EventHandler<Event> replaceBackgroundColorHandler = event -> {
            lastSelectedTabIndex = tabContainer.getSelectionModel().getSelectedIndex();

            Tab currentTab = (Tab) event.getTarget();
            if (currentTab.isSelected()) {
                currentTab.setStyle("-fx-background-color: -fx-focus-color;");
                mudarTitulo(currentTab);
            } else {
                currentTab.setStyle("-fx-background-color: -fx-accent;");
            }
        };

        EventHandler<Event> logoutHandler = event -> {
            Tab currentTab = (Tab) event.getTarget();
            if (currentTab.isSelected()) {
                tabContainer.getSelectionModel().select(lastSelectedTabIndex);
                System.out.println("Logging out!");
            }
        };

        configureTab(CLIENTES, "Clientes", "/imagens/users.png", userProfileContainer, getClass().getResource("/view/cliente2.fxml"), replaceBackgroundColorHandler);
        configureTab(QUARTOS, "Quartos", "/imagens/bed.png", settingsContainer, getClass().getResource("/view/quartos2.fxml"), replaceBackgroundColorHandler);
        configureTab(PRODUTOS, "Produtos", "/imagens/box.png", produtosContainer, getClass().getResource("/view/produtos.fxml"), replaceBackgroundColorHandler);
        configureTab(RELATORIOS, "Relatorios", "/imagens/report.png", relatoriosContainer, getClass().getResource("/view/relatorios.fxml"), replaceBackgroundColorHandler);
        configureTab(USUARIOS, "Usuarios", "/imagens/user.png", usuarioContainer, getClass().getResource("/view/usuarios.fxml"), replaceBackgroundColorHandler);
        configureTab(RESERVAS, "Reservas", "/imagens/mala.png", reservasContainer, getClass().getResource("/view/reservas.fxml"), replaceBackgroundColorHandler);
        configureTab(SETTINGS, "Configuracoes", "/imagens/config.png", configContainer, getClass().getResource("/view/settings.fxml"), replaceBackgroundColorHandler);
        configureTab(logoutTab, "Sair", "/imagens/door.png", configContainer, getClass().getResource("/view/login.fxml"), logoutHandler);
    

    }

    private void configureTab(Tab tab, String title, String iconPath, AnchorPane containerPane, URL resourceURL, EventHandler<Event> onSelectionChangedEvent) {
        double imageWidth = 18.0;
        
        ImageView imageView = new ImageView(new Image(iconPath));
        imageView.setFitHeight(imageWidth);
        imageView.setFitWidth(imageWidth);

        Label label = new Label(title);
        label.setMaxWidth(tabWidth);
        label.setPadding(new Insets(0, 0, 0, 10));
        label.setStyle("-fx-text-fill: #7c8184; -fx-font-size: 9pt; -fx-font-weight: normal;");
        label.setTextAlignment(TextAlignment.CENTER);

        BorderPane tabPane = new BorderPane();
        tabPane.setRotate(90.0);
        tabPane.setMaxWidth(tabWidth);
        tabPane.setLeft(imageView);
        tabPane.setRight(label);

        tab.setText("");
        tab.setGraphic(tabPane);

        tab.setOnSelectionChanged(onSelectionChangedEvent);

        if (containerPane != null && resourceURL != null) {
            try {
                Parent contentView = FXMLLoader.load(resourceURL);
                containerPane.getChildren().add(contentView);
                AnchorPane.setTopAnchor(contentView, 0.0);
                AnchorPane.setBottomAnchor(contentView, 0.0);
                AnchorPane.setRightAnchor(contentView, 0.0);
                AnchorPane.setLeftAnchor(contentView, 0.0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Tab getCurrentTab() {
		return currentTab;
	}

	public void setCurrentTab(Tab currentTab) {
		this.currentTab = currentTab;
	}



}
