package gamespace;

import engine.Collision;
import engine.Stars;
import engine.gameobjects.Bullet;
import engine.gameobjects.Hobby;
import engine.gameobjects.Player;
import engine.gameobjects.RectObj;
import engine.gameobjects.RectObjTex;
import processing.core.PApplet;

public class Level {

	private RectObjTex background;
	private RectObj feld;
	private Stars stars;
	private Player player;
	private PApplet parent;

	private int hobbyCooldownMax = 30;
	private int hobbyCooldown = 0;

	public Level(PApplet p) {
		this.background = new RectObjTex(p, p.loadImage(GV.TEXTUREPATH + "backgrounds//levelBG.png"));
		this.feld = new RectObj(p, GV.FELD_X_POS, GV.FELD_Y_POS, GV.FELD_WIDTH, GV.FELD_HEIGHT,
				GV.FELD_BACKGROUND_COLOR);
		this.stars = new Stars(p, GV.FELD_X_POS, GV.FELD_Y_POS, GV.FELD_WIDTH, GV.FELD_HEIGHT);
		this.player = new Player(p, "adrian");
		this.parent = p;
	}

	public void render() {
		/*
		 * render background
		 */
		background.render();
		feld.render();
		stars.render();
		if (hobbyCooldown < 1) {
			spawnHobby();
			hobbyCooldown = hobbyCooldownMax;
		} else {
			hobbyCooldown--;
		}

		for (Hobby h : GV.hobbies) {
			if (h != null && h.isAlive()) {
				h.render();
			}
		}

		for (Bullet b : GV.bullets) {
			if (b != null && b.isAlive()) {
				b.render();
			}
		}

		player.render();

		collision();
	}

	private void collision() {
		for (int i = 0; i < GV.hobbies.length - 1; i++) {
			if (GV.hobbies[i] != null) {
				if (Collision.colRectRect(this.player, GV.hobbies[i])) {
					this.player.hit(GV.hobbies[i]);
					GV.hobbies[i].die();
				}

				for (int j = 0; j < GV.bullets.length - 1; j++) {
					if(GV.bullets[j]!=null){
						if(Collision.colRectRect(GV.bullets[j], GV.hobbies[i])){
							GV.bullets[j].alive = false;
							GV.hobbies[i].hit();
						}
					}
				}
			}
		}

	}

	private void spawnHobby() {

		int l_player = (int) parent.random(0, 5);
		int l_hobby = (int) parent.random(0, 4);

		GV.hobbies[GV.hobbyIndex] = new Hobby(parent, (int) parent.random(GV.FELD_X_POS + GV.HOBBY_WIDTH,
				GV.FELD_X_POS + GV.FELD_WIDTH - (2 * GV.HOBBY_WIDTH)), GV.FELD_Y_POS - GV.HOBBY_HEIGHT, l_player, l_hobby);

		nextHobby();
	}

	private void nextHobby() {
		if (GV.hobbyIndex < GV.hobbies.length - 1) {
			GV.hobbyIndex++;
		} else {
			GV.hobbyIndex = 0;
		}
	}

}