package modelo;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Datos {

	private Cola<Colores> cola;
	private Lista<Colores> lista;
	private Pila<Colores> pilaUno;
	private Pila<Colores> pilaDos;
	private MemorizadorCola memoriaCola;

	public Datos() {
		super();
		this.cola = new Cola<>();
		this.lista = new Lista<>();
		this.pilaUno = new Pila<>();
		this.pilaDos = new Pila<>();
		this.memoriaCola = new MemorizadorCola();
	}
	
	public Cola<Colores> getCola() {
		return cola;
	}
	
	public MemorizadorCola getHistorico() {
		return memoriaCola;
	}

	public Lista<Colores> getLista() {
		return lista;
	}

	public Pila<Colores> getPilaUno() {
		return pilaUno;
	}

	public Pila<Colores> getPilaDos() {
		return pilaDos;
	}


}
