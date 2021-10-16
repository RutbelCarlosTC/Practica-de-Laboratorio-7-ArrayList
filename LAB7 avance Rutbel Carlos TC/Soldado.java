package laboratorio7;

public class Soldado {
	private String nombre;
	private int fila;
	private int columna;
	private int puntosVida;

	
	public Soldado(String nombre,int puntos, int fila, int col ) {
		setNombre(nombre);
		setpuntosVida(puntos);
		setFila(fila);
		setColumna(col);
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setColumna(int col) {
		this.columna = col;
	}

	public void setpuntosVida(int puntos) {
		this.puntosVida = puntos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getFila() {
		return this.fila;
	}

	public int getColumna() {
		return this.columna;
	}
	public int getpuntosVida() {
		return this.puntosVida;
	}
	
}
