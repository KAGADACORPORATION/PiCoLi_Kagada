package vista;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SizeSequence;
import javax.swing.border.LineBorder;

import modelo.Colores;

public class Casilla extends JLabel {

  public String Color;

public Casilla(String color) {
	super();
	Color = color;
	this.setMaximumSize(new Dimension(500, 500));
	JLabel NuevaCasilla= new JLabel(" ");
	NuevaCasilla.setBorder(new LineBorder(new java.awt.Color(0, 0, 0),2,true));
	NuevaCasilla.setOpaque(true);
	NuevaCasilla.setBackground(Colores.valueOf(color).getColor());
}

}