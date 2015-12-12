package space;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Level {
	PApplet parent; // The parent PApplet that we will render ourselves onto

	int f_w = 0;// Spielfeld breite
	int f_h = 0;// Spielfeld höhe
	int f_x = 0;
	int f_y = 0;

	PImage bgImage;
	Sterne st;
	EscMenu em;

	Player player;
	boolean running;

	public Level(PApplet p) {
		parent = p;
		f_w = parent.width / 2; // setze Spielfeldbreite
		f_h = (parent.height / 8) * 7; // setze Spielfeldhöhe
		f_x = (parent.width / 2) - (f_w / 2); // setze SpielfeldXposition
		f_y = parent.height / 16; // setze SpielfeldYposition
		bgImage = parent.loadImage("levelBG.png");
		bgImage.resize(parent.width, parent.height);
		player = new Player(p);
		st = new Sterne(p, this.f_x, this.f_y, this.f_w, this.f_h);
		running = true;
		em = new EscMenu(p);
	}

	void render() {
		if (running) {
			parent.noStroke();
			parent.background(50);
			parent.image(bgImage, 0, 0);
			parent.fill(240);
			parent.rect(f_x, f_y, f_w, f_h, 2);
			st.render();

			player.move();
			player.update(f_w);
			player.render();
			if (parent.keyPressed) {
				System.out.println("a");
				if (parent.key == PConstants.CODED) {
					System.out.println("b");
					if (parent.keyCode == PConstants.DELETE) {
						System.out.println("c");
						running = false;
						em.renderbg();
						parent.fill(123, 123, 0);
						parent.rect(100, 100, 100, 200);
					}
				}
			}
		} else {
			em.render();
			running = em.pressedContinue();
		}
	}

}
