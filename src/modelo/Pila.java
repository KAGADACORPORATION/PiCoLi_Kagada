package modelo;

import java.util.Stack;

public class Pila {

	private Stack<Colores> pila = new Stack<>();

	public Stack<Colores> getPila() {
		return pila;
	}

	public void enpilar(Colores t) {
		this.pila.push(t);
	}

	public Colores desenpilar() {
		return this.pila.pop();
	}
}
