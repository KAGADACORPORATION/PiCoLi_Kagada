package modelo;

import java.util.ArrayDeque;
import java.util.Collection;

	public class Cola<T> {
		private ArrayDeque<T> cola = new ArrayDeque<>();
		
		public void encolar(T t) {
			this.cola.push(t);
		}
		public ArrayDeque<T> getCola() {
			return cola;
		}
		public T desencolar(){
			return this.cola.pop();
		}
		public Collection<T> getCollectionCola(){
			return cola;
		}
	}