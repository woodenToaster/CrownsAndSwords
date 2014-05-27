import java.awt.Color;
import javax.swing.JPanel;


public class Space extends JPanel {
	
	private int id;
	private boolean occupied;
	private Piece piece;
	private boolean clicked;
	private static final Color dark = new Color(182, 109, 73);     //dark brown
	private static final Color light = new Color(255, 213, 148);   //light brown
	
	public Space(int id) {
		this.id = id;
		occupied = false;
		piece = null;
		clicked = false;
		addMouseListener(new MouseHandler());
	}
	public int getID() {return id;}
	public boolean getClicked() {return clicked;}
	public boolean isOccupied() {return occupied;}
	public static Color getDark() {return dark;}
	public static Color getLight() {return light;}
	public Piece getPiece() {return piece;}
	
	public void setOccupied(boolean b) {occupied = b;}
	public void setClicked(boolean b) {clicked = b;}
	public void setPiece(Piece p) {piece = p;}
}
