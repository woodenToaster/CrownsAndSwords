import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Screen {
	
	public void start() {
		
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("Crowns and Swords");
			Display.create();
		}
		catch(LWJGLException lwjgle) {
			
			lwjgle.printStackTrace();
			System.exit(0);
		}
		
		while(!Display.isCloseRequested()) {
			Display.update();
		}
		Display.destroy();
	}
}
