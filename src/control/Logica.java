package control;
import java.util.Vector;

import modelo.Datos;
import utiles.Constantes;

public class Logica implements InterfazLogica {

    Datos datos;
    private int monedas=0;
    
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
		monedas++;
	}
	
	public Datos getDatos() {
		return this.datos;
	}

	public int getMonedas() {
		return monedas;
	}

}