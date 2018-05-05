package acciones;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import control.Logica;
import modelo.Colores;
import utiles.Constantes;
import vista.Casilla;
import vista.VistaPrincipal;

public class Actualizador {
	private Logica logica;
	private JPanel cola;
	private JPanel pilaUno;
	private JPanel pilaDos;
	private JPanel lista;
	private JLabel puntosMonedas;
	private JLabel puntuacionMaxima;
	private JButton botonPedirColor;
	private JButton botonSeleccionarColor;
	private JButton botonBorrarColor;
	private JButton botonBarajarPila;
	
	
	public Actualizador(Logica logica, JPanel cola, JPanel pilaUno, JPanel pilaDos, JPanel lista, JLabel puntosMonedas,
			JButton botonPedirColor,JButton botonSeleccionarColor, JButton botonBorrarColor, JButton botonBarajarPila,JLabel puntuacionMaxima) {
		super();
		this.logica = logica;
		this.cola = cola;
		this.pilaUno = pilaUno;
		this.pilaDos = pilaDos;
		this.lista = lista;
		this.puntosMonedas = puntosMonedas;
		this.botonPedirColor = botonPedirColor;
		this.botonBarajarPila = botonBarajarPila;
		this.botonBorrarColor = botonBorrarColor;
		this.botonSeleccionarColor = botonSeleccionarColor;
		this.puntuacionMaxima = puntuacionMaxima;
	}

	public void actualizar(){
  		actualizarColaVista();
		actualizarPilaVista();
		actualizarListaVista();
		actualizarVistaMonedas();
		actualizarVistaPuntuacionMaxima();
		actualizarTextoBotonPedir();
		actualizarTextoBotonBarajar();
		actualizarTextoBotonBorrar();
  		SwingUtilities.updateComponentTreeUI(cola.getParent());
  	}
  	
  	private void actualizarColaVista() {
		this.cola.removeAll();
		for (Iterator<Colores> iterator = this.logica.getDatos().getCola().getCola().iterator(); iterator.hasNext();) {
			Colores color = iterator.next();
				Casilla nuevaCasilla = new Casilla(color.toString());
				this.cola.add(nuevaCasilla);
		}
	}
  	
	private void actualizarVistaMonedas() {
		this.puntosMonedas.setText(String.valueOf(this.logica.getMonedas()));
	}
	private void actualizarVistaPuntuacionMaxima() {
		this.puntuacionMaxima.setText(String.valueOf(this.logica.getPuntuacionMaxima()));
	}
	private void actualizarTextoBotonPedir() {
		this.botonPedirColor.setText("Pedir Color (x"+this.logica.getPedirColor()+")");
		if(this.logica.getPedirColor()<=0)this.botonPedirColor.setEnabled(false);
	}
	
	private void actualizarTextoBotonBorrar() {
		this.botonBorrarColor.setText("Borrar Color (x"+this.logica.getBorrarColor()+")");
		if(this.logica.getBorrarColor()<=0)this.botonBorrarColor.setEnabled(false);
	}
	
	private void actualizarTextoBotonBarajar() {
		this.botonBarajarPila.setText("Barajar Color (x"+this.logica.getBarajarPila()+")");
		if(this.logica.getBarajarPila()<=0)this.botonBarajarPila.setEnabled(false);
	}
	
	private void actualizarPilaVista() {
		this.pilaUno.removeAll();
		for (Iterator<Colores> iterator = this.logica.getDatos().getPilaUno().getPila().iterator(); iterator.hasNext();) {
			Colores color = iterator.next();
				Casilla nuevaCasilla = new Casilla(color.toString());
				this.pilaUno.add(nuevaCasilla);
		}
		this.pilaDos.removeAll();
		for (Iterator<Colores> iterator = this.logica.getDatos().getPilaDos().getPila().iterator(); iterator.hasNext();) {
			Colores color = iterator.next();
				Casilla nuevaCasilla = new Casilla(color.toString());
				this.pilaDos.add(nuevaCasilla);
		}
	}	
	
	private void actualizarListaVista() {
		this.lista.removeAll();
		for (int i = 0; i < logica.getDatos().getLista().getLista().size(); i++) {
			Colores color = logica.getDatos().getLista().getLista().get(i);
			Casilla nuevaCasilla = new Casilla(color.toString());
			int posicionX = (i + Constantes.TAMANO_LISTA_ANCHO) % Constantes.TAMANO_LISTA_ANCHO;
			int posicionY = i / Constantes.TAMANO_LISTA_ANCHO;
			lista.add(nuevaCasilla, new GridBagConstraints(posicionX, posicionY, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
	}

	public void activarBotones() {
		this.botonBarajarPila.setEnabled(true);
		this.botonBorrarColor.setEnabled(true);
		this.botonPedirColor.setEnabled(true);
		this.botonSeleccionarColor.setEnabled(true);
	}

}