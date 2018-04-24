package modelo;

import java.util.ArrayDeque;
import java.util.Collection;
import vista.Casilla;

public class MemorizadorCola {
private ArrayDeque<Casilla> memoriaCola;
	
	
	public MemorizadorCola() {
		super();
		this.memoriaCola = new ArrayDeque<>();
	}
	
	public void encolar(Casilla t) {
		this.memoriaCola.push(t);
	}
	public ArrayDeque<Casilla> getCola() {
		return memoriaCola;
	}
	public Casilla desencolar(){
		return this.memoriaCola.pop();
	}
	public Collection<Casilla> getCollectionCola(){
		return memoriaCola;
	}
	public int getTamanioMemoriaCola() {
		return memoriaCola.size();
	}
	public void eliminarSextoDeMemoriaCola() {
		memoriaCola.removeLast();
	}
}
