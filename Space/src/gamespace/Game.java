package gamespace;

import processing.core.PApplet;

public class Game {

	private PApplet parent;
	private Level level;
	// private Menu menu;

	public Game(PApplet p) {
		this.parent = p;
		this.level = new Level(p);
	}

	public void render() {
		this.level.render();
	}

}
