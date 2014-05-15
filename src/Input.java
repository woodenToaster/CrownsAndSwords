import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;


public class Input {
	
	private int x;
	private int y;
	private Coordinate mouseCoord;
	
	class Coordinate {
		public int x;
		public int y;
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void Input() {
		mouseCoord = new Coordinate(0, 0);
	}
	
	public void update() {
		while(Mouse.next()) {
			if(Mouse.getEventButtonState()) {
				if(Mouse.getEventButton() == 0) {
					System.out.println("Button 0 clicked at " + Mouse.getX() + ", " + Mouse.getY());
					//handleMouseClick(mouseCoord);
				}
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			Game.setRunning(false);
		}
	}
	
	public void handleMouseClick(Coordinate coord) {
		
		//TODO: handle
	}
	
		
	
}
