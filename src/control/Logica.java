package control;
import java.util.Vector;

import modelo.Colores;
import modelo.Datos;
import utiles.Constantes;
import utiles.Utiles;

public class Logica implements InterfazLogica {

    private Datos datos;
    private int monedas=0;
    
    
    
	public Logica(Datos datos) {
		super();
		this.datos = datos;
	}
	@Override
	public boolean comprobarGanador() {
		if (monedas>=Constantes.CANTIDAD_MAX_MONEDAS) {
			return true;
		}
		return false;
	}
	@Override
	public void disminuirIntentos() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void incrementarMonedas(int monedas) {
		this.monedas++;
	}
	
	public Datos getDatos() {
		return this.datos;
	}

	public int getMonedas() {
		return this.monedas;
	}
	public void iniciarCola() {
		for (int i = 0; i < Constantes.TAMANO_COLA; i++) {
			int numero = Utiles.genNumeroRandom(0,Colores.getCantidadElementos()-1);
			datos.getCola().encolar(Colores.getElement(numero));
		}
	}

}