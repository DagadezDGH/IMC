package dad.imc;

public enum Peso {
	BAJOPESO("Bajo Peso"),
	NORMAL("Normal"), 
	SOBREPESO("Sobrepeso"), 
	OBESO("Obeso");
	private final String peso;
	
	Peso(String string){
		this.peso = string;
	}
	
	public String getString() {
		return peso;
	}
}
