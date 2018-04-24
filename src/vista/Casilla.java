package vista;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SizeSequence;
import javax.swing.border.LineBorder;

import modelo.Colores;

public class Casilla extends JLabel {

  private String color;

public Casilla(String color) {
	super();
	this.color = color;
	this.setMaximumSize(new Dimension(500, 500));
	this.setText(" ");
	this.setBorder(new LineBorder(new java.awt.Color(0, 0, 0),2,true));
	this.setOpaque(true);
	this.setBackground(Colores.valueOf(color).getColor());
}

public String getColor() {
	return color;
}

}