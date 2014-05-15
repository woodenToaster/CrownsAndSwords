
class Sword extends Piece {
	
	int id;
	Sword(int id, String owner) {
		
		super();
		//set image
		this.id = id;
		this.owner = owner;
		x = this.owner.equals("player") ? 1 : 5;
		y = this.id > 2 ? this.id + 1 : this.id;
	}
	@Override
	public void move(int x, int y) {
		
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
		
	}
}
