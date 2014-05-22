
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Game extends JFrame {

	enum States {MENU, PLAYING, GAME_OVER}
	
	private Player[] players;
	private static boolean running;
	private States gameState;
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
		players = new Player[] {new Player("player"), new Player("computer")};
		for(int i = 0; i < 25; i++) {
			squares[i] = new Space(i + 1);
			if(i < 5) squares[i].setOccupied(true);
			if(i > 19) squares[i].setOccupied(true);
			if(i < 5 && i != 2) squares[i].setPiece(players[0].getSwords()[i]);
			if(i > 19 && i != 22) squares[i].setPiece(players[1].getSwords()[i]);
			
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
		
		initBoard();
		
		setTitle("Crowns and Swords");
		setResizable(false);
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
	public void initBoard() {
		
		//Add starting swords
		ImageIcon swordUp = Sword.getPlayerSwordImage();
		ImageIcon swordDown = Sword.getComputerSwordImage();
		ImageIcon crown = Crown.getCrownImage();
		
		for(int i = 0; i < 25; i++) {
			JPanel p = (JPanel)board.getComponent(i);
			if(i < 5) {
				if(i != 2) {
					JLabel downSword = new JLabel("", swordDown, JLabel.CENTER);
					p.add(downSword);
				}
				else {
					JLabel c = new JLabel("", crown, JLabel.CENTER);
					p.add(c);
				}
					
			}
			else if(i > 19) {
				if(i != 22) {
					JLabel upSword = new JLabel("", swordUp, JLabel.CENTER);
					p.add(upSword);
				}
				else {
					JLabel c = new JLabel("", crown, JLabel.CENTER);
					p.add(c);
				}
			}
		}
	}
	public void mainLoop() {
		
		while(running) {
				
		}	
	}
}
