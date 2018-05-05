package acciones;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import control.Logica;
import interfaces.Borrable;
import modelo.Colores;
import vista.Casilla;
import vista.VistaPrincipal;

public class Borrador implements ActionListener{

	 private JPanel panelBorrarColor;
	 private JButton botonBorrarColor;
	 private Actualizador actualizador;
	 private JButton botonRetroceder;
	 private Retroceso retroceso;
	 private ListenerBorrar listenerBorrar;
	 private Logica logica;
	 private JButton mensaje;
	
	
	public Borrador(JPanel panelBorrarColor, JButton botonBorrarColor, Actualizador actualizador,
		Retroceso retroceso, ListenerBorrar listenerBorrar, Logica logica, JButton mensaje) {
		super();
		this.panelBorrarColor = panelBorrarColor;
		this.botonBorrarColor = botonBorrarColor;
		this.actualizador = actualizador;
		this.retroceso = retroceso;
		this.listenerBorrar = listenerBorrar;
		this.logica = logica;
		this.mensaje = mensaje;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.logica.setBorrarColor(this.logica.getBorrarColor()-1);
		this.panelBorrarColor.remove(botonBorrarColor);
		for (int i = 0; i < Colores.getCantidadElementos(); i++) {
			Casilla casillaActual= new Casilla(Colores.getElement(i).toString());
			casillaActual.addActionListener(listenerBorrar);
			this.panelBorrarColor.add(casillaActual);
		}
		this.botonRetroceder = new JButton(" ");
		this.botonRetroceder.setMaximumSize(new Dimension(222, 222));
		this.botonRetroceder.setMargin(new Insets(0, 0, 0, 0));
		this.botonRetroceder.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		this.botonRetroceder.addActionListener(retroceso);
		this.panelBorrarColor.add(this.botonRetroceder);
		this.actualizador.actualizar();
		this.mensaje.setVisible(false);
	}

}