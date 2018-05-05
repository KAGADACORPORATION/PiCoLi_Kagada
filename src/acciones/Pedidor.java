package acciones;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.Logica;
import modelo.Colores;
import utiles.Constantes;
import vista.Casilla;
import vista.VistaPrincipal;

public class Pedidor implements ActionListener{

	 private JPanel panelPedirColor;
	 private JButton botonPedirColor;
	 private Actualizador actualizador;
	 private JButton botonRetroceder;
	 private Retroceso retroceso;
	 private Encolador encolador;
	 

	public Pedidor(JPanel panelPedirColor, JButton botonPedirColor, Actualizador actualizador,
			Encolador encolador, Retroceso retroceso) {
		super();
		this.panelPedirColor = panelPedirColor;
		this.botonPedirColor = botonPedirColor;
		this.actualizador = actualizador;
		this.encolador = encolador;
		this.retroceso = retroceso;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		this.panelPedirColor.remove(botonPedirColor);
		for (int i = 0; i < Colores.getCantidadElementos(); i++) {
			Casilla casillaActual= new Casilla(Colores.getElement(i).toString());
			casillaActual.addActionListener(encolador);
			this.panelPedirColor.add(casillaActual);
		}
		this.botonRetroceder = new JButton(" ");
		this.botonRetroceder.setMaximumSize(new Dimension(222, 222));
		this.botonRetroceder.setMargin(new Insets(0, 0, 0, 0));
		this.botonRetroceder.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		this.botonRetroceder.addActionListener(retroceso);
		this.panelPedirColor.add(this.botonRetroceder);
		this.actualizador.actualizar();
	}
}