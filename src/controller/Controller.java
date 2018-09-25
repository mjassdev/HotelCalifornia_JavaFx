package controller;

import com.jfoenix.controls.JFXTabPane;
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
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.URL;

import javax.swing.GroupLayout.Alignment;

public class Controller {

    @FXML
    private JFXTabPane tabContainer;
    @FXML
    private Tab userProfileTab, settingsTab, logoutTab, tabReservas, tabProdutos, tabUsuarios, tabRelatorios, tabConfiguracoes ;
    @FXML
    private AnchorPane userProfileContainer, settingsContainer, reservasContainer, produtosContainer,  usuarioContainer, relatoriosContainer, configContainer ;
    @FXML
    private TextField tituloAba;
    
    private double tabWidth = 250.0;
    private double tabHeight = 60;
    public static int lastSelectedTabIndex = 0;

    /// Life cycle

    @FXML
    public void initialize() {
        configureView();
    }

    /// Private

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
            } else {
                currentTab.setStyle("-fx-background-color: -fx-accent;");
            }
        };

        EventHandler<Event> logoutHandler = event -> {
            Tab currentTab = (Tab) event.getTarget();
            if (currentTab.isSelected()) {
                tabContainer.getSelectionModel().select(lastSelectedTabIndex);

                // TODO: logout action
                // good place to show Dialog window with Yes / No question
                System.out.println("Logging out!");
            }
        };

        configureTab(userProfileTab, "Clientes", "/imagens/users.png", userProfileContainer, getClass().getResource("/view/cliente2.fxml"), replaceBackgroundColorHandler);
        configureTab(settingsTab, "Quartos", "/imagens/bed.png", settingsContainer, getClass().getResource("/view/quartos.fxml"), replaceBackgroundColorHandler);
        configureTab(tabProdutos, "Produtos", "/imagens/box.png", produtosContainer, getClass().getResource("/view/produtos.fxml"), replaceBackgroundColorHandler);
        configureTab(tabRelatorios, "Relatorios", "/imagens/config.png", relatoriosContainer, getClass().getResource("/view/relatorios.fxml"), replaceBackgroundColorHandler);
        configureTab(tabUsuarios, "Usuários", "/imagens/user.png", usuarioContainer, getClass().getResource("/view/usuarios.fxml"), replaceBackgroundColorHandler);
        configureTab(tabReservas, "Reservas", "/imagens/mala.png", reservasContainer, getClass().getResource("/view/reservas.fxml"), replaceBackgroundColorHandler);
        configureTab(tabConfiguracoes, "Configurações", "/imagens/config.png", configContainer, getClass().getResource("/view/settings.fxml"), replaceBackgroundColorHandler);

        configureTab(logoutTab, "Sair", "/imagens/logout.png", null, null, logoutHandler);

        //userProfileTab.setStyle("-fx-background-color: -fx-focus-color;");
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

}
