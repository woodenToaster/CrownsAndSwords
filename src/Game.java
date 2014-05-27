
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
	private static List<Space> spaces;
	
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
		}
		//Assign crowns to spaces
		squares[2].setPiece(players[1].getCrown());
		squares[22].setPiece(players[0].getCrown());
		//Assign player's swords to spaces
		squares[0].setPiece(players[0].getSwords()[0]);
		squares[1].setPiece(players[0].getSwords()[1]);
		squares[3].setPiece(players[0].getSwords()[2]);
		squares[4].setPiece(players[0].getSwords()[3]);
		//Assign computer's swords to spaces
		squares[20].setPiece(players[1].getSwords()[0]);
		squares[21].setPiece(players[1].getSwords()[1]);
		squares[23].setPiece(players[1].getSwords()[2]);
		squares[24].setPiece(players[1].getSwords()[3]);
		
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
	
	public static int[] getPossibleMoves(Space s) {
		int[] moves = new int[] {-1, -1, -1, -1};
		int id = s.getID();
		if(id % 5 != 0) {
			//We can move left from here
			if(!isOccupiedByFriendly(s, spaces.get(id - 1))) 
				moves[0] = id - 1;
			else 
				moves[0] = -1;
		}
		if(id % 5 != 4) {
			//We can move right from here
			if(!isOccupiedByFriendly(s, spaces.get(id + 1))) 
				moves[1] = id + 1;
			else 
				moves[1] = -1;
		}
		if(id != 0 && id != 1 && id != 2 && id != 3 && id != 4) {
			//We can move up from here
			if(!isOccupiedByFriendly(s, spaces.get(id - 5))) 
				moves[2] = id - 5;
			else 
				moves[2] = -1;
		}
		if(id != 20 && id != 21 && id != 22 && id != 23 && id != 24) {
			//We can move down from here
			if(!isOccupiedByFriendly(s, spaces.get(id + 5))) 
				moves[3] = id + 5;
			else 
				moves[3] = -1;
		}
		return moves;
	}
	
	public static boolean isOccupiedByFriendly(Space current, Space next) {
		return next.isOccupied() && next.getPiece().getOwner() == current.getPiece().getOwner();
	}
	public void mainLoop() {
		
		while(running) {
				
		}	
	}
}
