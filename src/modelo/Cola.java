package modelo;

import java.util.ArrayDeque;
import java.util.Collection;

import utiles.Constantes;
import vista.Casilla;

public class Cola<T> {
	private ArrayDeque<T> cola;
	private MemorizadorCola memoriaCola;

	public Cola() {
		super();
		this.cola = new ArrayDeque<>();
		this.memoriaCola = new MemorizadorCola();
	}

	public void encolar(T t) {
		this.cola.push(t);
		this.memoriaCola.encolar(t);
		if (this.memoriaCola.getTamanioMemoriaCola() > Constantes.TAMANO_HISTORICO) {
			this.memoriaCola.eliminarSextoDeMemoriaCola();
		}
	}

	public ArrayDeque<T> getCola() {
		return cola;
	}

	public T desencolar() {
		return this.cola.pop();
	}

	public Collection<T> getCollectionCola() {
		return cola;
	}
}