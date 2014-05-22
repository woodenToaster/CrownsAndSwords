import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


class Sword extends Piece {
	
	private int id;
	private static final ImageIcon playerSword = new ImageIcon("res/hugeSwordUp.png");
	private static final ImageIcon computerSword = new ImageIcon("res/hugeSwordDown.png");
	
	Sword(int id, String owner) {
		super(owner);
		this.id = id;
		y = this.id > 2 ? this.id + 1 : this.id;
	}
	
	public static ImageIcon getPlayerSwordImage() {return playerSword;}
	public static ImageIcon getComputerSwordImage() {return computerSword;}
	
	@Override
	public void movePiece(int x, int y) {
		//check for valid move
		
		//update Board state
	}
	@Override
	public void attack(Piece piece) {
		//check for valid attack
		
		//resolve attack
		
		//update board state
	}
	@Override
	public void captured(Piece capturedBy) {
		alive = false;
		//check for win
		
	}
}
