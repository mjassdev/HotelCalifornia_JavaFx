package controller;

import java.io.IOException;
import factory.JPAFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DefaultEntity;
import repository.Repository;

public class ControllerSuper<T extends DefaultEntity<? super T>> {

	public T save(T entity) {

		Repository<T> repository = new Repository<T>(JPAFactory.getEntityManager());

		repository.getEntityManager().getTransaction().begin();
		repository.save(entity);
		repository.getEntityManager().getTransaction().commit();
		repository.getEntityManager().close();

		return entity;
	}
	
	public T remove(T entity) {

		Repository<T> repository = new Repository<T>(JPAFactory.getEntityManager());

		repository.getEntityManager().getTransaction().begin();
		repository.remove(entity);
		repository.getEntityManager().getTransaction().commit();
		repository.getEntityManager().close();

		return entity;
	}
	
	public T alter(T entity) {
		Repository<T> repository = new Repository<T>(JPAFactory.getEntityManager());

		repository.getEntityManager().getTransaction().begin();
		repository.save(entity);
		repository.getEntityManager().getTransaction().commit();
		repository.getEntityManager().close();

		return entity;
	}
	
	protected void dialogConfirma() throws IOException{
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/confirmacao.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
	}
	protected void dialogErroSenhas() throws IOException{
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/senhas.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
	}
	protected void dialogErro() throws IOException{
		FXMLLoader fXMLLoader = new FXMLLoader();
		fXMLLoader.setLocation(getClass().getResource("/view/erro.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(fXMLLoader.load());
		stage.setScene(scene);
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
	}

}
	

