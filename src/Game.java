
public class Game {

	enum state {MENU, PLAYING, GAME_OVER}
	private Player[] players;
	private Boolean running;
	private Screen screen;
	private int gameWidth;
	private int gameHeight;
	
	public Game(int w, int h) {
		
		gameWidth = w;
		gameHeight = h;
		players = new Player[2];
		players[0] = new Player("player");
		players[1] = new Player("computer");
		running = true;
		screen = new Screen(gameWidth, gameHeight);
		
	}
	public void mainLoop() {
		
		while(!screen.isCloseRequested()) {
			
			screen.update();
			
		}
		
		screen.destroy();
		
	}
	
	
	
}
