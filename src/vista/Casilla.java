package vista;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SizeSequence;
import javax.swing.border.LineBorder;

import modelo.Colores;
import java.awt.Insets;

public class Casilla extends JButton implements Comparable<Colores>{

  private String color;

public Casilla(String color) {
	super();
	setPreferredSize(new Dimension(25, 22));
	setMargin(new Insets(2, 2, 2, 2));
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

@Override
public int compareTo(Colores o) {
	return this.getColor().toString().compareTo(o.getColor().toString());
}


}