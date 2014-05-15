import org.newdawn.slick.Image;

abstract class Piece {

	protected int x;
	protected int y;
	protected Boolean alive;
	protected Boolean selected;
	protected Image image;
	protected String owner;
	
	protected Piece() {
		
		alive = true;
		selected = false;
		image = null;
	}
	public int getX() { return x; }
	public int getY() { return y; }
	public Boolean isAlive() { return alive; }
	public Boolean isSelected() { return selected; }
	public Image getImage() { return image; }
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
