package modelo;

import java.util.ArrayList;
import java.util.TreeSet;

public class Datos {

	private Cola cola;
	private Lista lista;
	private Pila pilaUno;
	private Pila pilaDos;
	private MemoriaSeleccionador memoriaSeleccionador;

	public Datos() {
		super();
		this.cola = new Cola();
		this.lista = new Lista();
		this.pilaUno = new Pila();
		this.pilaDos = new Pila();
		this.memoriaSeleccionador = new MemoriaSeleccionador();
	}
	
	
	
	public void encolar(Colores color) {
		cola.encolar(color);
	}



	public Colores desencolar() {
		return cola.desencolar();
	}



	public Cola getCola() {
		return cola;
	}

	public Lista getLista() {
		return lista;
	}

	public Pila getPilaUno() {
		return pilaUno;
	}

	public Pila getPilaDos() {
		return pilaDos;
	}
	
	public ArrayList<Colores> getMemoriaSeleccionador() {
		return memoriaSeleccionador.getMemoriaSeleccionador();
	}
}
