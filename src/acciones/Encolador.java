package acciones;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import control.Logica;
import modelo.Colores;
import utiles.Constantes;
import vista.Casilla;

public class Encolador implements ActionListener{

	private Logica logica;
	private JPanel cola;
	private JPanel pilaUno;
	private JPanel pilaDos;
	private Actualizador actualizador;
	private JPanel lista;
	private JButton botonSeleccionarColor;
	private JPanel panelSeleccionarColor;
	private JButton botonPedirColor;
	private JPanel panelPedirColor;
	private JLabel puntosMonedas;
	
	public Encolador(Logica logica, JPanel cola, JPanel pilaUno, JPanel pilaDos,
			Actualizador actualizador, JPanel lista, JButton botonSeleccionarColor, JPanel panelSeleccionarColor, JButton botonPedirColor, JPanel panelPedirColor, JLabel puntosMonedas) {
		super();
		this.logica = logica;
		this.cola = cola;
		this.pilaUno = pilaUno;
		this.pilaDos = pilaDos;
		this.actualizador = actualizador;
		this.lista = lista;
		this.botonSeleccionarColor = botonSeleccionarColor;
		this.panelSeleccionarColor = panelSeleccionarColor;
		this.panelPedirColor = panelPedirColor;
		this.botonPedirColor = botonPedirColor;
		this.puntosMonedas = puntosMonedas;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Casilla botonPulsado =((Casilla)e.getSource());
		boolean pedido = false;
		if(((JPanel)botonPulsado.getParent()).getComponentCount()==Colores.getCantidadElementos()+1) {
			pedido = true;
		}
		this.logica.encolar(Colores.valueOf(botonPulsado.getColor()),pedido);
		this.panelSeleccionarColor.removeAll();
		this.panelSeleccionarColor.add(botonSeleccionarColor);
		this.panelPedirColor.removeAll();
		this.panelPedirColor.add(botonPedirColor);
		actualizarColaVista();
		actualizarPilaVista();
		actualizarListaVista();
		actualizarListaMonedas();
		actualizarTextoBotonPedir();
		this.actualizador.actualizar(cola);
		this.actualizador.actualizar(pilaUno);
		this.actualizador.actualizar(pilaDos);
		this.actualizador.actualizar(lista);
		this.actualizador.actualizar(panelSeleccionarColor);
		this.actualizador.actualizar(panelPedirColor);
		this.actualizador.actualizar((JPanel)puntosMonedas.getParent());
	}

	private void actualizarTextoBotonPedir() {
		this.botonPedirColor.setText("Pedir Color (x"+this.logica.getPedirColor()+")");
		if(this.logica.getPedirColor()<=0)this.botonPedirColor.setEnabled(false);
	}

	private void actualizarListaMonedas() {
		this.puntosMonedas.setText(String.valueOf(this.logica.getMonedas()));
	}

	private void actualizarColaVista() {
		this.cola.removeAll();
		for (Iterator<Colores> iterator = this.logica.getDatos().getCola().getCola().iterator(); iterator.hasNext();) {
			Colores color = iterator.next();
				Casilla nuevaCasilla = new Casilla(color.toString());
				this.cola.add(nuevaCasilla);
		}
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
	
}
