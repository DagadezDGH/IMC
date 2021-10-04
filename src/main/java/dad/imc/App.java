package dad.imc;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class App extends Application {

	private Label pesoLabel1, pesoLabel2, alturaLabel1, alturaLabel2, imcLabel1, imcLabel2, saludLabel; 
	private TextField alturaText, pesoText;
	private VBox root;
	private HBox pesoHBox, alturaHBox, imcHBox;
	private DoubleProperty altura = new SimpleDoubleProperty() ;
	private DoubleProperty peso = new SimpleDoubleProperty();
	private DoubleProperty imc = new SimpleDoubleProperty();
	

	public void start(Stage primaryStage) throws Exception {
		
		pesoLabel1 = new Label("Peso: ");
		pesoLabel1.setAlignment(Pos.CENTER_LEFT);
		
		pesoLabel2 = new Label("kg");
		pesoLabel2.setAlignment(Pos.CENTER_RIGHT);
		
		alturaLabel1= new Label("Altura:");
		alturaLabel1.setAlignment(Pos.CENTER_LEFT);
		
		alturaLabel2 = new Label("cm");
		alturaLabel2.setAlignment(Pos.CENTER_RIGHT);
	
		imcLabel1 = new Label("IMC: ");
		imcLabel1.setAlignment(Pos.CENTER);
		
		imcLabel2 = new Label("(peso/altura^2)");
		imcLabel2.setAlignment(Pos.CENTER);
		
		saludLabel = new Label("Bajo Peso | Normal | Sobrepeso | Obeso");
		saludLabel.setAlignment(Pos.CENTER);
		
		
		alturaText= new TextField();

		pesoText = new TextField();
		
		pesoHBox =  new HBox(pesoLabel1, pesoText, pesoLabel2);
		
		alturaHBox = new HBox(alturaLabel1, alturaText, alturaLabel2);
		
		imcHBox = new  HBox(imcLabel1, imcLabel2);
		
		
		
		root = new VBox(5, pesoHBox, alturaHBox, imcHBox, saludLabel );
		root.setFillWidth(false);
		root.setAlignment(Pos.CENTER);
		
	    Scene scene = new Scene(root, 320, 200);
		primaryStage.setTitle("IMC");
		primaryStage.setScene(scene);
		primaryStage.show();
		 
		Bindings.bindBidirectional(
				
					pesoText.textProperty(),
					
					peso,
					
					new NumberStringConverter());
		
		Bindings.bindBidirectional(
				
					alturaText.textProperty(),
					
					altura,
					
					new NumberStringConverter());
		
		imc.bind(
				peso.divide
				
				(altura.divide(100).multiply(altura.divide(100))
				
				));
		
		imc.addListener(e -> {
			imcLabel2.textProperty().bind(imc.asString());
		});
		
		 
		 imcLabel2.textProperty().addListener(e -> {
			 
			 if (imc.doubleValue()< 18.5)
				 saludLabel.setText(Peso.BAJOPESO.getString());
			 
			 else if (imc.doubleValue() >= 18.5 && imc.doubleValue() < 25)
				 saludLabel.setText(Peso.NORMAL.getString());
			 
			 else if (imc.doubleValue() >= 25 && imc.doubleValue() < 30)
				 saludLabel.setText(Peso.SOBREPESO.getString());
			 
			 else if (imc.doubleValue() > 30)
				 saludLabel.setText(Peso.OBESO.getString());
			 
		 });
		 
		 

	}

	public static void main(String[] args) {
		
		launch(args);
	}

}
