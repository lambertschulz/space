package de.hsrw.space;

import de.hsrw.space.helpers.Debug;
import de.hsrw.space.screen.Level;
import de.hsrw.space.screen.Menu;
import processing.core.PApplet;
import space.MainMenu;

public class Space extends PApplet {

	Level level;
	MainMenu mm;
	Menu m;
	Debug debug;
	boolean playing = false;
	boolean isdebug = true;
	int stopaudio = 60 * 10;
	boolean loading = true;
	int loadingTime = 60;
	int t = 0;
	float loadingProcessFactor = 0.0f;

	enum gameStates {
		MENU, LEVEL1, MAINMENU
	};

	gameStates gameState = gameStates.MENU;

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
				level.getSt().setSpeed(10.0f);
				d();
				break;
			}
			}
		} else {
			renderLoading();
			t++;
			if (t == loadingTime) {
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
		fill(0, 0, t * 255 / loadingTime);
		rect(loadingButtonX, loadingButtonY, t * loadingButtonWidth / loadingTime, loadingButtonHeight, 4);
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
			gameState = gameStates.LEVEL1;
			break;
		}
		case 2: {
			exit();
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
