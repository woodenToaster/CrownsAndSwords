
public class Game {

	enum States {MENU, PLAYING, GAME_OVER}
	
	private Player[] players;
	private static Boolean running;
	private Screen screen;
	private States state;
	private int gameWidth;
	private int gameHeight;
	private Input input;
	
	public Game(int w, int h) {
		
		gameWidth = w;
		gameHeight = h;
		state = States.MENU;
		players = new Player[2];
		players[0] = new Player("player");
		players[1] = new Player("computer");
		running = true;
		screen = new Screen(gameWidth, gameHeight);
		input = new Input();
		
	}
	public String getState() {return state.toString();}
	public static void setRunning(Boolean b) {
		running = b;
	}
	public void changeState(States newState) {
		state = newState;
	}
	public void mainLoop() {
		
		while(!screen.isCloseRequested() && running) {
			
			input.update();
			screen.update();
			
		}
		
		screen.destroy();
		
	}
	
	
	
	
}
