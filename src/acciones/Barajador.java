package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import interfaces.Barajable;
import modelo.Colores;
import modelo.Datos;
import utiles.Constantes;
import utiles.Utiles;
import vista.Casilla;

public class Barajador implements ActionListener, Barajable {

	private Datos datos;
	private Actualizador actualizador;
	private JPanel pilaUno;
	private JPanel pilaDos;

	public Barajador(JPanel pilaUno, JPanel pilaDos, Datos datos, Actualizador actualizador) {
		super();
		this.datos = datos;
		this.actualizador = actualizador;
		this.pilaUno = pilaUno;
		this.pilaDos = pilaDos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.pilaUno.removeAll();
		this.pilaDos.removeAll();
		barajarColor(this.datos);
		for (int i = 0; i < this.datos.getPilaUno().getPila().size(); i++) {
			this.pilaUno.add(new Casilla(this.datos.getPilaUno().getPila().get(i).toString()));
		}
		for (int i = 0; i < this.datos.getPilaDos().getPila().size(); i++) {
			this.pilaDos.add(new Casilla(this.datos.getPilaDos().getPila().get(i).toString()));
		}
		this.actualizador.actualizar(this.pilaUno);
		this.actualizador.actualizar(this.pilaDos);
	}

	private void addToPila(Colores color, int numeroRandom, Datos datos) {
//		for (int i = 0; i < temporal.size(); i++) {
//			if (i % 2 == 0) {
//				datos.getPilaUno().enpilar((temporal.get(i)));
//			} else {
//				datos.getPilaDos().enpilar((temporal.get(i)));
//			}
//		}
		if (numeroRandom == 0) {
			if (datos.getPilaUno().getPila().size() < Constantes.TAMANO_PILA-1) {
				datos.getPilaUno().enpilar(color);
			} else
				datos.getPilaDos().enpilar(color);

		} else if (datos.getPilaDos().getPila().size() < Constantes.TAMANO_PILA-1) {
			datos.getPilaDos().enpilar(color);
		} else
			datos.getPilaUno().enpilar(color);
	}

	@Override
	public void barajarColor(Datos datos) {
		ArrayList<Colores> temporal = new ArrayList<Colores>();
		for (int i = 0; i < datos.getPilaUno().getPila().size(); i++) {
			temporal.add(datos.getPilaUno().getPila().get(i));
		}
		datos.getPilaUno().getPila().removeAllElements();
		
		for (int i = 0; i < datos.getPilaDos().getPila().size(); i++) {
			temporal.add(datos.getPilaDos().getPila().get(i));
		}
		datos.getPilaDos().getPila().removeAllElements();
		for (int i = 0; i < temporal.size(); i++) {
			int num=Utiles.numeroRandom01();
			addToPila(temporal.get(i), num, datos);
		}
		temporal.clear();
	}
}

