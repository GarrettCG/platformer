package display;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GLContext;


/**
 * Visit https://github.com/rosickteam/OpenGL for project info, updates and license terms.
 * 
 * @author integeruser
 */
public class LWJGLWindow {

	public final void start() {		
		start(500, 500);
	}
	protected void initialwh() {}
	public final void start(int width, int height) {

		targetDisplayMode= new DisplayMode(width,height);
		try {
			Display.setTitle("LWJGLWindow");
			Display.setDisplayMode(targetDisplayMode);
			//Display.setFullscreen(true);
			System.out.println("displaymode:"+Display.getDisplayMode());
			//Display.setVSyncEnabled(true);
			Display.create();
			
			if (!GLContext.getCapabilities().OpenGL33) {
				System.err.printf("You must have at least OpenGL 3.3 to run this tutorial.\n");
			}
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		Display.setResizable(true);
		long startTime = System.nanoTime();
		continueMainLoop = true;
		fullscreentoggle=false;
		initialHeight=Display.getHeight();
		initialWidth=Display.getWidth();
		init();

		//
		//MAIN LOOP
		//
		//////////////////////////////////////////////////////////////////////
		while (continueMainLoop && !Display.isCloseRequested()) {
			elapsedTime = (float) ((System.nanoTime() - startTime) / 1000000.0);

			now = System.nanoTime();
		    lastFrameDuration = (float) ((now - lastFrameTimestamp) / 1000000.0);
		    lastFrameTimestamp = now;

			update();//game logic
			if (fullscreentoggle){
				fullscreentoggle=false;
				if(Display.isFullscreen()){
					setDisplayMode(500,500,false);
					Display.setVSyncEnabled(false);
				}else{
					setDisplayMode(1920,1080,true);
					Display.setVSyncEnabled(true);
				}
			}
			Display.sync(60);
			display();//clears the screen

			Display.update();//swaps buffers; basically draws stuff that we set up in the backbuffer to the screen
			System.out.println(Display.getWidth()+" "+Display.getHeight());

			if (Display.wasResized()) {
				reshape(Display.getWidth(), Display.getHeight());
			}
		}
		///////////////////////////////////////////////////////////////////////
		//end of MAIN LOOP
		Display.destroy();
	}



	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	public void setDisplayMode(int width, int height, boolean fullscreen) {
		 
		// return if requested DisplayMode is already set
                if ((Display.getDisplayMode().getWidth() == width) && 
			(Display.getDisplayMode().getHeight() == height) && 
			(Display.isFullscreen() == fullscreen)) {
			return;
		}
 
		try {
			DisplayMode targetDisplayMode = null;
 
			if (fullscreen) {
				DisplayMode[] modes = Display.getAvailableDisplayModes();
				int freq = 0;
 
				for (int i=0;i<modes.length;i++) {
					DisplayMode current = modes[i];
 
					if ((current.getWidth() == width) && (current.getHeight() == height)) {
						if ((targetDisplayMode == null) || (current.getFrequency() >= freq)) {
							if ((targetDisplayMode == null) || (current.getBitsPerPixel() > targetDisplayMode.getBitsPerPixel())) {
								targetDisplayMode = current;
								freq = targetDisplayMode.getFrequency();
							}
						}
 
						// if we've found a match for bpp and frequence against the 
						// original display mode then it's probably best to go for this one
						// since it's most likely compatible with the monitor
						if ((current.getBitsPerPixel() == Display.getDesktopDisplayMode().getBitsPerPixel()) &&
						    (current.getFrequency() == Display.getDesktopDisplayMode().getFrequency())) {
							targetDisplayMode = current;
							break;
						}
					}
				}
			} else {
				targetDisplayMode = new DisplayMode(width,height);
			}
 
			if (targetDisplayMode == null) {
				System.out.println("Failed to find value mode: "+width+"x"+height+" fs="+fullscreen);
				return;
			}
 
			Display.setDisplayMode(targetDisplayMode);
			Display.setFullscreen(fullscreen);
			reshape(Display.getWidth(), Display.getHeight());
 
		} catch (LWJGLException e) {
			System.out.println("Unable to setup mode "+width+"x"+height+" fullscreen="+fullscreen + e);
		}
	}
	protected static final int FLOAT_SIZE = Float.SIZE / Byte.SIZE;



	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	protected void init() {
	};


	protected void update() {
		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
					leaveMainLoop();
				}else if(Keyboard.getEventKey() == Keyboard.KEY_F11){
					System.out.println("inside the key f11 update thingy");
					fullscreentoggle=true;
				}
			}
		}	
	};


	protected void display() {
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		glClear(GL_COLOR_BUFFER_BIT);
	};


	protected void reshape(int width, int height) {
		glViewport(0, 0, width, height);
	}



	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	protected final float getElapsedTime() {
		return elapsedTime;
	}

	protected final float getLastFrameDuration() {
		return lastFrameDuration;
	}


	protected final void leaveMainLoop() {
		continueMainLoop = false;
	}
	public float getInitialHeight(){
		return initialHeight;
	}
	public float getInitialWidth(){
		return initialWidth;
	}


	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	// Measured in milliseconds
	private float initialWidth;
	private float initialHeight;
	private float elapsedTime; 
	private float lastFrameDuration;
	private DisplayMode targetDisplayMode;
	private double lastFrameTimestamp, now;
	private boolean continueMainLoop;
	public boolean fullscreentoggle;
}