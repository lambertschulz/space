package de.hsrw.space;

import de.hsrw.space.helpers.Debug;
import de.hsrw.space.screen.Level;
import de.hsrw.space.screen.Menu;
import de.hsrw.space.unused.MainMenu;
import processing.core.PApplet;

public class Space extends PApplet {

	// Objekte deklarieren
	private Level level;
	private MainMenu mm;
	private Menu m;
	private Debug debug;

	// Variablen deklarieren
	boolean isdebug = true;
	boolean loading = true;
	int ladebalkenDauerInFrames = 60;
	int ladebalkenProgress = 0;
	float ladebalkenProgessFactor = 0.0f;

	enum GameStates {
		MENU, LEVEL1, MAINMENU
	};

	GameStates gameState = GameStates.MENU;

	public void settings() {
		// fullScreen(); // allways 16/9
		size(1200, 675);
	}

	public void setup() {
		background(0, 0, 10);
	}

	public void draw() {

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
			case MAINMENU: {
				if (mm == null) {
					mm = new MainMenu(this, new String[] { "PLAY", "EXIT" });
				}
				mm.render();
				break;
			}
			case LEVEL1: {
				if (level == null) {
					level = new Level(this);
				}
				level.render();
				d();
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

	public static void main(String _args[]) {
		PApplet.main(new String[] { de.hsrw.space.Space.class.getName() });
	}

	public void d() {
		if (isdebug) {
			if (debug == null) {
				debug = new Debug(this, level.getPlayer(), level);
			}
			debug.render();
		}
	}

	public void mousePressed() {
		System.out.println(m.getFb());
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
			break;
		}
		}

	}

	public void keyPressed() {
		if (key == ESC) {
			key = DELETE;
		}
	}
}
