package gamespace;

import engine.io.Keys;
import processing.core.PApplet;

public class Space extends PApplet {

	private Game game;

	public void settings() {
		size(GV.WIDTH, GV.HEIGHT, P2D);
		//fullScreen(P2D);
	}

	public void setup() {
		surface.setResizable(false);
		game = new Game(this);
	}

	public void draw() {
		game.render();
	}

	public static void main(String _args[]) {
		PApplet.main(new String[] { gamespace.Space.class.getName() });
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
}