package dad.javafx.imc;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
	private TextField pesoText, alturaText;
	private Label pesoLabel1, pesoLabel2, alturaLabel1, alturaLabel2, imcLabel1, imcLabel2, pesoLabelT;
	private IMC imc = new IMC();

	public void start(Stage primaryStage) throws Exception {

		
		pesoLabel1 = new Label("Peso:");
		pesoLabel1.setAlignment(Pos.CENTER_LEFT);
		pesoText = new TextField();
		pesoText.setPrefColumnCount(4);
		pesoLabel2 = new Label("kg");
		pesoLabel2.setAlignment(Pos.CENTER_RIGHT);

		
		HBox pesoBox = new HBox();
		pesoBox.setAlignment(Pos.BASELINE_CENTER);
		pesoBox.setSpacing(5);
		pesoBox.getChildren().addAll(pesoLabel1, pesoText, pesoLabel2);

		
		alturaLabel1 = new Label("Altura:");
		alturaLabel1.setAlignment(Pos.CENTER_LEFT);
		alturaText = new TextField();
		alturaText.setPrefColumnCount(4);
		alturaLabel2 = new Label("cm");
		alturaLabel2.setAlignment(Pos.CENTER_LEFT);

		
		HBox alturaBox = new HBox();
		alturaBox.setAlignment(Pos.BASELINE_CENTER);
		alturaBox.setSpacing(5);
		alturaBox.getChildren().addAll(alturaLabel1, alturaText, alturaLabel2);

		
		imcLabel1 = new Label("IMC: ");
		imcLabel2 = new Label("(peso/altura^2)");
		
		
		HBox resultadoNumBox = new HBox(imcLabel1, imcLabel2);
		resultadoNumBox.setAlignment(Pos.BASELINE_CENTER);

		
		pesoLabelT = new Label("Bajo Peso | Normal | Sobrepeso | Obeso");

		
		HBox resultadoPeso = new HBox(pesoLabelT);
		resultadoPeso.setAlignment(Pos.BASELINE_CENTER);
		
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(pesoBox, alturaBox, resultadoNumBox, resultadoPeso);

		Scene escena = new Scene(root, 320, 200);

		primaryStage.setScene(escena);
		primaryStage.setTitle("Calcular IMC");
		primaryStage.show();

		
		pesoText.textProperty().addListener(event -> {
			imc.setPeso(Double.parseDouble(pesoText.textProperty().get()));
			imc.setIMC();
		});

		
		alturaText.textProperty().addListener(event -> {
			imc.setAltura(Double.parseDouble(alturaText.textProperty().get()));
			imc.setIMC();
		});

		
		imc.imcProperty().addListener(e ->{
			
			imcLabel2.textProperty().bind(imc.imcProperty().asString());
		});
		
		
		imcLabel2.textProperty().addListener(e -> {
			if (imc.imcProperty().doubleValue() < 18.5)
				pesoLabelT.setText(Peso.BAJOPESO.getString());
			else if (imc.imcProperty().doubleValue() >= 18.5 && imc.imcProperty().doubleValue() < 25)
				pesoLabelT.setText(Peso.NORMAL.getString());
			else if (imc.imcProperty().doubleValue() >= 25 && imc.imcProperty().doubleValue() < 30)
				pesoLabelT.setText(Peso.SOBREPESO.getString());
			else if (imc.imcProperty().doubleValue() > 30)
				pesoLabelT.setText(Peso.OBESO.getString());
		});

	}

	public static void main(String[] args) {
		launch(args);
	}

}

