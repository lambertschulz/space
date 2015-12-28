package de.hsrw.space.screen;

import de.hsrw.space.GlobalVariables;
import de.hsrw.space.gameobjects.Player;
import processing.core.PApplet;
import processing.core.PImage;

public class Level {
	private PApplet parent;
	private PImage bgImage;
	private Sterne st;
	private EscMenu em;
	private Player player;
	private boolean running;

	public Level(PApplet p) {
		this.parent = p;
		bgImage = parent.loadImage("textures//backgrounds//levelBG.png");
		bgImage.resize(parent.width, parent.height);
		this.player = new Player(p, "adrian");
		this.st = new Sterne(p, GlobalVariables.FELDXPOS, GlobalVariables.FELDYPOS, GlobalVariables.FELDWIDTH, GlobalVariables.FELDHEIGHT);
		running = true;
		em = new EscMenu(p);
	}

	public void render() {
		if (running) {
			parent.noStroke();
			parent.background(50);
			parent.image(bgImage, 0, 0);
			parent.fill(240);
			parent.rect(GlobalVariables.FELDXPOS, GlobalVariables.FELDYPOS, GlobalVariables.FELDWIDTH, GlobalVariables.FELDHEIGHT, 2);
			st.render();
			player.render();
		}

	}

	public boolean isRunning() {
		return running;
	}

	public void mouseIsPressed() {
		em.mouseClick();
	}

	public boolean pressedMenu() {
		return em.pressedMenu();
	}
}
