package acciones;

import control.Logica;
import interfaces.Iniciable;
import modelo.Cola;
import modelo.Colores;
import modelo.Datos;
import modelo.Lista;
import modelo.Pila;
import utiles.Constantes;
import utiles.Utiles;

public class IniciarPrograma implements Iniciable{
	Cola cola;
	Pila pila, pilaDos;
	Lista lista;
	Logica logica;
	
	@Override
	public void iniciarPrograma() {
		cola = new Cola<Colores>();
		for (int i = 0; i < Constantes.TAMANO_COLA; i++) {
			int numero = Utiles.genNumeroRandom();
			cola.getCola().add(Colores.getElement(numero));
		}
		pila = new Pila();
		pilaDos = new Pila();
		lista = new Lista();
		
	}

	@Override
	public void mostrarCambios() {
		// TODO Auto-generated method stu
		
	}

	public Logica crearLogica() {
		logica=new Logica();
		return logica;
	}
	public Datos crearDatos() {
		Datos datos=new Datos(cola,lista,pila,pilaDos);
		return datos;
	}
}