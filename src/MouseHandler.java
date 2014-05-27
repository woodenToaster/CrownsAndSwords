import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.border.MatteBorder;


public class MouseHandler extends MouseAdapter {
	
	private Space clickedSpace;
	private Space enteredSpace;
	private static boolean spaceSelected = false;
	private MatteBorder border;
	private int[] moves;
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (!spaceSelected) {
			clickedSpace = (Space)e.getSource();
			if(clickedSpace.isOccupied()) {
				//We can select this space
				if(clickedSpace.getID() % 2 == 0) {
					clickedSpace.setBackground(clickedSpace.getBackground().darker());
					spaceSelected = true;
				}
				
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		enteredSpace = (Space)e.getSource();
		if(enteredSpace.isOccupied()) {
			border = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED);
			enteredSpace.setBorder(border);
		}
		if(spaceSelected) {
			moves = Game.getPossibleMoves(clickedSpace);
			for(int move: moves) {
				if(move >= 0 && move == enteredSpace.getID())
					enteredSpace.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.GREEN));
			}
		}
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		if(enteredSpace != null) {
			enteredSpace.setBorder(null);
			enteredSpace = null;
		}
	}
}
