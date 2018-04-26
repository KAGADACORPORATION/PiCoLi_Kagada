package modelo;

import java.util.Collection;
import java.util.Stack;

public class Pila<T> {

	private Stack<T> pila = new Stack<>();

	public Stack<T> getPila() {
		return pila;
	}

	public void enpilar(T t) {
		this.pila.push(t);
	}

	public T desenpilar() {
		return this.pila.pop();
	}

	public Collection<T> getCollectionCola() {
		return pila;
	}
}
