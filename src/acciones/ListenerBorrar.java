package acciones;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import control.Logica;
import interfaces.Borrable;
import modelo.Colores;
import utiles.Constantes;
import vista.Casilla;

public class ListenerBorrar implements ActionListener{

	private Logica logica;
	private Actualizador actualizador;
	private JPanel lista;
	private JLabel puntosMonedas;
	private JButton botonBorrarColor;
	private JPanel panelBorrarColor;
	
	
	
	public ListenerBorrar(Logica logica, Actualizador actualizador, JPanel lista, JButton botonSeleccionarColor,
			JLabel puntosMonedas,JButton botonBorrarColor, JPanel panelBorrarColor) {
		super();
		this.logica = logica;
		this.actualizador = actualizador;
		this.lista = lista;
		this.puntosMonedas = puntosMonedas;
		this.botonBorrarColor = botonBorrarColor;
		this.panelBorrarColor = panelBorrarColor;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Casilla etiquetaActual = ((Casilla)e.getSource());
		logica.borrarColor(etiquetaActual.getColor());
		actualizarListaMonedas();
		repintarLista();
		this.panelBorrarColor.removeAll();
		this.panelBorrarColor.add(botonBorrarColor);
		actualizador.actualizar(panelBorrarColor);
		actualizador.actualizar(lista);
		
	}

	
	
	private void repintarLista() {
		this.lista.removeAll();
		for (int i = 0; i < logica.getDatos().getLista().getLista().size(); i++) {
			Colores color = logica.getDatos().getLista().getLista().get(i);
			Casilla nuevaCasilla = new Casilla(color.toString());
			int posicionX = (i + Constantes.TAMANO_LISTA_ANCHO) % Constantes.TAMANO_LISTA_ANCHO;
			int posicionY = i / Constantes.TAMANO_LISTA_ANCHO;
			lista.add(nuevaCasilla, new GridBagConstraints(posicionX, posicionY, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
	}
	private void actualizarListaMonedas() {
		this.puntosMonedas.setText(String.valueOf(this.logica.getMonedas()));
	}
}
