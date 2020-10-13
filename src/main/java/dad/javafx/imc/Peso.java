package dad.javafx.imc;

public enum Peso {
	BAJOPESO("Bajo Peso"),
	NORMAL("Normal"), 
	SOBREPESO("Sobrepeso"), 
	OBESO("Obeso");
	private final String string;
	
	Peso(String st){
		this.string = st;
	}
	
	public String getString() {
		return string;
	}
}
