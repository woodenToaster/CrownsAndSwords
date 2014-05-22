import javax.swing.ImageIcon;


class Crown extends Piece {
	
	private static ImageIcon crown = new ImageIcon("res/crown.png");
	
	public Crown(String owner) {
		super(owner);
		y = 3;
	}
	public static ImageIcon getCrownImage() {return crown;}
	
	@Override
	void movePiece(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void attack(Piece piece) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void captured(Piece capturedBy) {
		// TODO Auto-generated method stub
		
	}

}
