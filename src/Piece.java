

abstract class Piece {

	protected int x;
	protected int y;
	protected int attackPower;
	protected Boolean alive;
	protected Boolean selected;
	protected String owner;
	
	protected Piece(String owner) {
		
		attackPower = 1;
		this.owner = owner;
		alive = true;
		selected = false;
		x = this.owner.equals("player") ? 1 : 5;
	}
	public int getX() { return x; }
	public int getY() { return y; }
	public Boolean isAlive() { return alive; }
	public Boolean isSelected() { return selected; }
	public String getOwne() { return owner; }
	
	public void setX(int x) {
		
		this.x = x;
	}
	public void setY(int y) {
		
		this.y = y;
	}
	public void setAlive(Boolean b) {
		
		this.alive = b;
	}
	public void setSelected(Boolean b) {
		
		this.selected = b;
	}
	public void setOwner(String owner) {
		
		this.owner = owner;
	}
	
	abstract void move(int x, int y);
	abstract void attack(Piece piece);
	abstract void captured(Piece capturedBy);
}
