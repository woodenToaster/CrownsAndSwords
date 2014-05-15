import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Screen {
	
	int height;
	int width;
	
	public Screen(int x, int y) {
		
		height = y;
		width = x;
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle("Crowns and Swords");
			Display.create();
		}
		catch(LWJGLException lwjgle) {
			
			lwjgle.printStackTrace();
			System.exit(0);
		}
	}
	public int getHeight() {return height;}
	public int getWidth() {return width;}
	public void setHeight(int h) {
		height = h;
	}
	public void setWidth(int w) {
		width = w;
	}
	public Boolean isCloseRequested() {
		return Display.isCloseRequested();
	}
	public void update() {
		Display.update();
	}
	public void destroy() {
		Display.destroy();
	}
}
