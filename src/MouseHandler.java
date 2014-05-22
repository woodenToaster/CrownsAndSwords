import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {
	
	private Space clickedSpace;
	private boolean spaceSelected;
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		clickedSpace = ((Space)e.getSource());
		int id = clickedSpace.getID();
		if(id % 2 == 0) {
			if (clickedSpace.getClicked() == false) {
				clickedSpace.setClicked(true);
				clickedSpace.setBackground(Space.getDark().darker());
			}

			else {
				clickedSpace.setClicked(false);
				clickedSpace.setBackground(Space.getDark());
			}
		}
		else {
			if (clickedSpace.getClicked() == false) {
				clickedSpace.setClicked(true);
				clickedSpace.setBackground(Space.getLight().brighter());
			}

			else {
				clickedSpace.setClicked(false);
				clickedSpace.setBackground(Space.getLight());
			}
		}
		clickedSpace = null;
	}
}
