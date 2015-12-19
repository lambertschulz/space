package de.hsrw.space;

import de.hsrw.space.helpers.Debug;
import de.hsrw.space.helpers.Keys;
import de.hsrw.space.scenes.Level;
import de.hsrw.space.screen.Menu;
import processing.core.PApplet;

public class Space extends PApplet {

	private int ladebalkenDauerInFrames;
	private int ladebalkenProgress;
	private float ladebalkenProgessFactor;
	enum GameStates {
		MENU, LEVEL1
	};

	// Objekte deklarieren
	private Level level;
	private Menu m;
	private Debug debug;
	// Variablen deklarieren
	boolean isdebug;
	boolean loading;

	GameStates gameState;

	public Space() {
		ladebalkenDauerInFrames = 60;
		ladebalkenProgress = 0;
		ladebalkenProgessFactor = 0.0f;
		isdebug = true;
		loading = true;

		gameState = GameStates.LEVEL1;

	}

	public void settings() {
		// fullScreen(); // allways 16/9
		size(1200, 675, P2D);
	}

	public void setup() {
		background(0, 0, 10);
		Space space = new Space();
	}

	public void draw() {
		
		System.out.println(Keys.keys[0] + " " + Keys.keys[1] + " " + Keys.keys[2] + " " + Keys.keys[3] + " " + Keys.keys[4] + " ");

		if (!loading) {

			switch (gameState) {
			case MENU: {
				if (m == null) {
					m = new Menu(this);
				}
				m.render();
				m.mouseInputCheck();
				break;
			}
			case LEVEL1: {
				if (level == null) {
					level = new Level(this);
				}
				level.render();
				/*if (level.pressedMenu()) {
					gameState = GameStates.MENU;
				}*/
				debug();
				break;
			}
			}
		} else {
			renderLoading();
			ladebalkenProgress++;
			if (ladebalkenProgress == ladebalkenDauerInFrames) {
				loading = false;
			}
		}
	}

	private void renderLoading() {
		int loadingButtonHeight = 4;
		int loadingButtonWidth = 9 * (width / 10);
		int loadingButtonY = height - (height / 3);
		int loadingButtonX = (width / 2) - (loadingButtonWidth / 2);
		int loadingButtonBorderWidth = 1;
		noStroke();
		fill(10);
		rect(loadingButtonX - loadingButtonBorderWidth, loadingButtonY - loadingButtonBorderWidth,
				loadingButtonWidth + 2 * loadingButtonBorderWidth, loadingButtonHeight + 2 * loadingButtonBorderWidth,
				4);
		fill(0, 0, ladebalkenProgress * 255 / ladebalkenDauerInFrames);
		rect(loadingButtonX, loadingButtonY, ladebalkenProgress * loadingButtonWidth / ladebalkenDauerInFrames,
				loadingButtonHeight, 4);
	}

	public void debug() {
		if (isdebug) {
			if (debug == null) {
				debug = new Debug(this, level.getPlayer(), level);
			}
			debug.render();
		}
	}

	public void mousePressed() {
		if (!loading) {
			if (gameState == GameStates.MENU) {
				switch (m.getFb()) {
				case 0: {
					break;
				}
				case 1: {
					gameState = GameStates.LEVEL1;
					break;
				}
				case 2: {
					stop();
					exit();
					break;
				}
				}
			} else if (gameState == GameStates.LEVEL1) {
				if (!level.isRunning()) {
					level.mouseIsPressed();
				}
			}

		}
	}
	public void keyPressed() {

		if (key == ESC) {
			key = 0;
		}
		if (key == 'w' || key == 'W' || key == UP) {
			Keys.keys[0] = true;
		}
		if (key == 'a' || key == 'A' || key == LEFT) {
			Keys.keys[1] = true;
		}
		if (key == 's' || key == 'S' || key == DOWN) {
			Keys.keys[2] = true;
		}
		if (key == 'd' || key == 'D' || key == RIGHT) {
			Keys.keys[3] = true;
		}
		if (key == 'p' || key == 'P' || key == 0) {
			Keys.keys[4] = true;
		}
	}

	public void keyReleased() {
		if (key == ESC) {
			key = 0;
		}
		if (key == 'w' || key == 'W' || key == UP) {
			Keys.keys[0] = false;
		}
		if (key == 'a' || key == 'A' || key == LEFT) {
			Keys.keys[1] = false;
		}
		if (key == 's' || key == 'S' || key == DOWN) {
			Keys.keys[2] = false;
		}
		if (key == 'd' || key == 'D' || key == RIGHT) {
			Keys.keys[3] = false;
		}
		if (key == 'p' || key == 'P' || key == 0) {
			Keys.keys[4] = false;
		}
	}



	public static void main(String _args[]) {
		PApplet.main(new String[] { de.hsrw.space.Space.class.getName() });
	}

}
