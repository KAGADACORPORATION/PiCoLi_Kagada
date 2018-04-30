package modelo;

import java.util.ArrayList;

public class MemoriaSeleccionador {
	private ArrayList<Colores> memoriaSeleccionador;

	public MemoriaSeleccionador() {
		super();
		this.setMemoriaSeleccionador(new ArrayList<Colores>());
	}

	public ArrayList<Colores> getMemoriaSeleccionador() {
		return memoriaSeleccionador;
	}

	public void setMemoriaSeleccionador(ArrayList<Colores> memoriaSeleccionador) {
		this.memoriaSeleccionador = memoriaSeleccionador;
	}
	
}
