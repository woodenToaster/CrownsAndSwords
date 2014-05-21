import java.awt.Color;

import javax.swing.JPanel;


public class Space extends JPanel {
	
	private int id;
	private final int width = 128;
	private final int height = 128;
	private boolean occupied;
	private Piece piece;
	private boolean clicked;
	private static final Color dark = new Color(182, 109, 73);
	private static final Color light = new Color(255, 213, 148);
	
	public Space(int id) {
		this.id = id;
		occupied = false;
		piece = null;
		clicked = false;
		addMouseListener(new MouseHandler());
	}
	public int getID() {return id;}
	public boolean getClicked() {return clicked;}
	public static Color getDark() {return dark;}
	public static Color getLight() {return light;}
	
	public void setClicked(boolean b) {
		clicked = b;
	}
}
