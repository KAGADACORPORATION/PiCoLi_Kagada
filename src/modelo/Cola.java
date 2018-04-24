package modelo;

import java.util.ArrayDeque;
import java.util.Collection;

import utiles.Constantes;
import vista.Casilla;

public class Cola{
	private ArrayDeque<Casilla> cola;
	private MemorizadorCola memoriaCola;
	
	
	public Cola() {
		super();
		this.cola = new ArrayDeque<>();
		this.memoriaCola = new MemorizadorCola();
	}
	
	public void encolar(Casilla t) {
		this.cola.push(t);
		this.memoriaCola.encolar(t);
		if(this.memoriaCola.getTamanioMemoriaCola()>Constantes.TAMANO_HISTORICO) {
			this.memoriaCola.eliminarSextoDeMemoriaCola();
		}
	}
	public ArrayDeque<Casilla> getCola() {
		return cola;
	}
	public Casilla desencolar(){
		return this.cola.pop();
	}
	public Collection<Casilla> getCollectionCola(){
		return cola;
	}
}