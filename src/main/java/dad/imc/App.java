package dad.imc;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

	private Label pesoLabel1, pesoLabel2, alturaLabel1, alturaLabel2, imcLabel1, saludLabel; 
	private TextField alturaText, pesoText;
	private VBox root;
	private HBox pesoHBox, alturaHBox, imcHBox;
	private DoubleProperty altura = new SimpleDoubleProperty() ;
	private DoubleProperty peso = new SimpleDoubleProperty();
	private DoubleProperty imc = new SimpleDoubleProperty();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		pesoLabel1 = new Label("Peso: ");
		pesoLabel1.setAlignment(Pos.CENTER_LEFT);
		
		pesoLabel2 = new Label("kg");
		pesoLabel2.setAlignment(Pos.CENTER_RIGHT);
		
		alturaLabel1= new Label("Altura:");
		alturaLabel1.setAlignment(Pos.CENTER_LEFT);
		
		alturaLabel2 = new Label("cm");
		alturaLabel2.setAlignment(Pos.CENTER_RIGHT);
	
		imcLabel1 = new Label("IMC: (peso/altura^2)");
		imcLabel1.setAlignment(Pos.CENTER);
		
		saludLabel = new Label("Bajo Peso | Normal | Sobrepeso | Obeso");
		saludLabel.setAlignment(Pos.CENTER);
		
		
		alturaText= new TextField();

		pesoText = new TextField();
		
		pesoHBox =  new HBox(pesoLabel1, pesoText, pesoLabel2);
		
		alturaHBox = new HBox(alturaLabel1, alturaText, alturaLabel2);
		
		imcHBox = new  HBox(imcLabel1);
		
		
		
		root = new VBox(5, pesoHBox, alturaHBox, imcHBox, saludLabel );
		root.setFillWidth(false);
		root.setAlignment(Pos.CENTER);
		
		 Scene scene = new Scene(root, 320, 200);
		 primaryStage.setTitle("IMC");
		 primaryStage.setScene(scene);
		 primaryStage.show();
		 
		 
		 

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
