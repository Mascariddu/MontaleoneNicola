package it.polito.gestionecontabilitàdirezionale;
	
import it.polito.contabilitàdirezionale.model.ModelMain;
import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private double x,y;
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GestioneContabilitàDirezionale.fxml"));
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root,1200,1200);
			
			ModelMain model= new ModelMain();
			GestioneContabilitàDirezionaleController controller= loader.getController();
			controller.setModelMain(model);
			root.setOnMousePressed(event-> {
				x=event.getSceneX();
				y=event.getSceneY();
			});
			root.setOnMouseDragged(event-> {
				primaryStage.setX(event.getScreenX()-x);
				primaryStage.setY(event.getSceneY()-y);
			});
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
