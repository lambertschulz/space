package space;

import processing.core.PApplet;
import processing.core.PConstants;

public class Debug {
	PApplet parent;
	Player player;
	Level level;

	public Debug(PApplet p, Player player, Level level) {
		parent = p;
		this.player = player;
		this.level = level;
	}

	public void render() {
		debugMode("" + player.p_x, 1);
		debugMode("" + player.speed, 2);
	}

	private void debugMode(String s, int n) {
		parent.fill(255, 100, 100);
		parent.textSize(20);
		parent.textAlign(PConstants.LEFT);
		parent.text(s, 10, 25 * n, 100, 25);
	}
}
