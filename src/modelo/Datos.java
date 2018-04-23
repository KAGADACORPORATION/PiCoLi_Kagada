package modelo;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Datos {

  public ArrayDeque Cola;

  public List Lista;

  public Stack PilaUno;

  public Stack PilaDos;

    public Vector  myPuente;
	private Cola<Colores> cola;

	public Datos() {
		super();
		cola=new Cola<>();
	}

	public Cola<Colores> getCola() {
		return cola;
	}
	
	
}

 