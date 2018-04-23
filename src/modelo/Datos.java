package modelo;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Datos {

  public Cola cola;
  public Lista lista;
  public Pila pilaUno;
  public Pila pilaDos;

	public Datos(Cola cola, Lista lista, Pila pilaUno, Pila pilaDos) {
	super();
	this.cola = cola;
	this.lista = lista;
	this.pilaUno = pilaUno;
	this.pilaDos = pilaDos;
}

	public Cola getCola() {
		return cola;
	}

	public void setCola(Cola cola) {
		this.cola = cola;
	}


	public Lista getLista() {
		return lista;
	}


	public void setLista(Lista lista) {
		this.lista = lista;
	}


	public Pila getPilaUno() {
		return pilaUno;
	}


	public void setPilaUno(Pila pilaUno) {
		this.pilaUno = pilaUno;
	}


	public Pila getPilaDos() {
		return pilaDos;
	}


	public void setPilaDos(Pila pilaDos) {
		this.pilaDos = pilaDos;
	}

}

 