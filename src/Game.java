
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Game extends JFrame {

	enum States {MENU, PLAYING, GAME_OVER}
	
	private Player[] players;
	private static boolean running;
	private States gameState;
	private int gameWidth;
	private int gameHeight;
	private Input input;
	private JLayeredPane layeredPane;
	private JPanel board;
	private List<Space> spaces;
	
	public Game(int w, int h) {
		
		Dimension boardSize = new Dimension(600, 600);
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		
		board = new JPanel();
		layeredPane.add(board, JLayeredPane.DEFAULT_LAYER);
		board.setLayout(new GridLayout(5,5));
		board.setPreferredSize(boardSize);
		board.setBounds(0, 0, boardSize.width, boardSize.height);
		Space[] squares = new Space[25];
		for(int i = 0; i < 25; i++) {
			squares[i] = new Space(i + 1);
		}
		spaces = new ArrayList<>(25);
		for(Space s: squares) {
			spaces.add(s);
			board.add(s);
			if(s.getID() % 2 == 0) 
				s.setBackground(Space.getDark());
			else
				s.setBackground(Space.getLight());
		}
		
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	public String getGameState() {return gameState.toString();}
	public static void setRunning(boolean b) {
		running = b;
	}
	public void setGameState(States newState) {
		gameState = newState;
	}
	public void mainLoop() {
		
		while(running) {
				
		}	
	}
}
