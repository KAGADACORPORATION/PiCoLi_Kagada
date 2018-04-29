package modelo;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Datos {

	private Cola cola;
	private Lista lista;
	private Pila pilaUno;
	private Pila pilaDos;
	private MemorizadorCola memoriaCola;

	public Datos() {
		super();
		this.cola = new Cola();
		this.lista = new Lista();
		this.pilaUno = new Pila();
		this.pilaDos = new Pila();
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


}
