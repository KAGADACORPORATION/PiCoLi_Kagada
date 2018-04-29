package acciones;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import modelo.Colores;
import modelo.Datos;
import modelo.MemorizadorCola;
import utiles.Constantes;
import utiles.Utiles;
import vista.Casilla;
import vista.VistaPrincipal;

public class Seleccionador implements ActionListener{
 private JPanel panelSeleccionarColor;
 private JButton botonSeleccionarColor;
 private Datos datos;
 private Actualizador actualizador;
 private JButton botonRetroceder;
 private Retroceso retroceso;
 private Encolador encolador;
 
	public Seleccionador(JPanel panelSeleccionarColor, JButton botonSeleccionarColor, Datos datos, Actualizador actualizador,Encolador encolador) {
		super();
		this.panelSeleccionarColor = panelSeleccionarColor;
		this.botonSeleccionarColor = botonSeleccionarColor;
		this.datos = datos;
		this.actualizador = actualizador;
		this.retroceso = new Retroceso(this.panelSeleccionarColor,this.botonSeleccionarColor,this.actualizador);
		this.encolador = encolador;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		panelSeleccionarColor.remove(botonSeleccionarColor);
		for (int i = 0; i < Constantes.PETICION_COLOR_MAX; i++) {
			Casilla casillaActual= new Casilla(obtenerColorValido().toString());
			casillaActual.addActionListener(encolador);
			panelSeleccionarColor.add(casillaActual);
		}
		this.botonRetroceder = new JButton(" ");
		this.botonRetroceder.setMaximumSize(new Dimension(222, 222));
		this.botonRetroceder.setMargin(new Insets(0, 0, 0, 0));
		this.botonRetroceder.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		this.botonRetroceder.addActionListener(retroceso);
		panelSeleccionarColor.add(this.botonRetroceder);
		this.actualizador.actualizar(this.panelSeleccionarColor);
	}

	//METODOS
	private Colores obtenerColorValido() {
		Colores nuevoColor;
		do {
			nuevoColor = generarColor();
		} while (!validarColor(this.datos.getHistorico(),nuevoColor));
		return nuevoColor;
	}



	private boolean validarColor(MemorizadorCola historico, Colores nuevoColor) {
		boolean retorno = true;
		for (int i = 0; i < historico.getTamanioMemoriaCola(); i++) {
			Colores color = historico.obtenerElementoPosicion(i);
			if (color.toString().equals(nuevoColor.toString())) {
				retorno=false;
			}
		}
		return retorno;
	}



	private Colores generarColor() {
		return Colores.getElement(Utiles.genNumeroRandom(0, Colores.getCantidadElementos()-1));
	}
}