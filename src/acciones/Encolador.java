package acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Logica;
import modelo.Colores;
import modelo.Datos;
import utiles.Utiles;
import vista.Casilla;

public class Encolador implements ActionListener{

	private Datos datos;
	private Logica logica;
	private JPanel cola;
	private JPanel pilaUno;
	private JPanel pilaDos;
	private Actualizador actualizador;
	private JPanel lista;
	private JButton botonSeleccionarColor;
	private JPanel panelSeleccionarColor;
	
	

	public Encolador(Datos datos, Logica logica, JPanel cola, JPanel pilaUno, JPanel pilaDos,
			Actualizador actualizador, JPanel lista, JButton botonSeleccionarColor, JPanel panelSeleccionarColor) {
		super();
		this.datos = datos;
		this.logica = logica;
		this.cola = cola;
		this.pilaUno = pilaUno;
		this.pilaDos = pilaDos;
		this.actualizador = actualizador;
		this.lista = lista;
		this.botonSeleccionarColor = botonSeleccionarColor;
		this.panelSeleccionarColor = panelSeleccionarColor;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Casilla botonPulsado =((Casilla)e.getSource());
		this.datos.getCola().encolar(Colores.valueOf(botonPulsado.getColor()));
		this.empilar(this.datos.getCola().desencolar());
		this.panelSeleccionarColor.removeAll();
		this.panelSeleccionarColor.add(botonSeleccionarColor);
		actualizarColaVista();
		this.actualizador.actualizar(cola);
		this.actualizador.actualizar(pilaUno);
		this.actualizador.actualizar(pilaDos);
		this.actualizador.actualizar(lista);
		this.actualizador.actualizar(panelSeleccionarColor);
	}



	private void actualizarColaVista() {
		this.cola.removeAll();
		for (Iterator<Colores> iterator = this.datos.getCola().getCola().iterator(); iterator.hasNext();) {
			Colores color = iterator.next();
				Casilla nuevaCasilla = new Casilla(color.name());
				this.cola.add(nuevaCasilla);
		}
	}
		
	private void empilar(Colores color) {
		if(Utiles.genNumeroRandom(0, 1)==1)this.datos.getPilaUno().enpilar(color);
		else this.datos.getPilaDos().enpilar(color);
	}
	
}
