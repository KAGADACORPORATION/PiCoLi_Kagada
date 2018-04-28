package modelo;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.LinkedList;

import vista.Casilla;

public class MemorizadorCola {
private LinkedList<Colores> memoriaCola;
	
	
	public MemorizadorCola() {
		super();
		this.memoriaCola = new LinkedList<>();
	}
	
	public void encolar(Colores cosa) {
		this.memoriaCola.push(cosa);
	}
	public LinkedList<Colores> getCola() {
		return memoriaCola;
	}
	public Colores desencolar(){
		return this.memoriaCola.pop();
	}
	public Collection<Colores> getCollectionCola(){
		return memoriaCola;
	}
	public int getTamanioMemoriaCola() {
		return memoriaCola.size();
	}
	public void eliminarSextoDeMemoriaCola() {
		memoriaCola.removeLast();
	}
	public Colores obtenerElementoPosicion (int posicion) {
		return (Colores) this.memoriaCola.get(posicion);
	}
}
