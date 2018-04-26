package modelo;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.LinkedList;

import vista.Casilla;

public class MemorizadorCola<T> {
private LinkedList<T> memoriaCola;
	
	
	public MemorizadorCola() {
		super();
		this.memoriaCola = new LinkedList<>();
	}
	
	public void encolar(T cosa) {
		this.memoriaCola.push(cosa);
	}
	public LinkedList<T> getCola() {
		return memoriaCola;
	}
	public T desencolar(){
		return this.memoriaCola.pop();
	}
	public Collection<T> getCollectionCola(){
		return memoriaCola;
	}
	public int getTamanioMemoriaCola() {
		return memoriaCola.size();
	}
	public void eliminarSextoDeMemoriaCola() {
		memoriaCola.removeLast();
	}
}
