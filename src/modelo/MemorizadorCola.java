package modelo;

import java.util.ArrayDeque;
import java.util.Collection;
import vista.Casilla;

public class MemorizadorCola<T> {
private ArrayDeque<T> memoriaCola;
	
	
	public MemorizadorCola() {
		super();
		this.memoriaCola = new ArrayDeque<>();
	}
	
	public void encolar(T cosa) {
		this.memoriaCola.push(cosa);
	}
	public ArrayDeque<T> getCola() {
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
