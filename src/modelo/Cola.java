package modelo;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.LinkedList;

import utiles.Constantes;
import vista.Casilla;

public class Cola<T> {
	private LinkedList<T> cola;
	private MemorizadorCola memoriaCola;

	public Cola() {
		super();
		this.cola = new LinkedList<>();
		this.memoriaCola = new MemorizadorCola();
	}

	public void encolar(T t) {
		this.cola.push(t);
		this.memoriaCola.encolar(t);
		if (this.memoriaCola.getTamanioMemoriaCola() > Constantes.TAMANO_HISTORICO) {
			this.memoriaCola.eliminarSextoDeMemoriaCola();
		}
	}

	public LinkedList<T> getCola() {
		return cola;
	}

	public T desencolar() {
		return this.cola.pop();
	}

	public Collection<T> getCollectionCola() {
		return cola;
	}
	
	private boolean compararHistorial(Cola cola, Colores color) {
		for (int i = cola.getCola().size()-Constantes.TAMANO_HISTORICO; i < cola.getCola().size(); i++) {
			if (color==cola.getCola().get(i)) {
				return true;
			}
		}
		return false;
	}
}