package space;

import processing.core.PApplet;
import processing.core.PConstants;

public class Player {

	PApplet parent;
	int p_x = 0;
	int p_y = 0;

	int p_width = 10;
	int p_height = 10;

	int p_color = 0;

	float speed = 0.0f;
	float speedCap = 4.0f;
	float wallBounce = 2.0f;
	float speedFalloffDividor = 1.1f;

	public Player(PApplet p) {
		parent = p;
		p_y = 9 * parent.height / 10;
		p_x = (parent.width / 2) - (p_width / 2);
		p_color = parent.color(123, 0, 0);
	}

	public void render() {
		parent.noStroke();
		parent.fill(p_color);
		parent.rect(p_x - (p_width / 2), parent.height - (parent.height / 10), p_width, p_height, 2);
	}

	void move() {
		if (parent.keyPressed) {
			if (parent.key == PConstants.CODED) {
				if (parent.keyCode == PConstants.UP) {
					// fire
				}
				if (parent.keyCode == PConstants.DOWN) {
					// absorb
				}
				if (parent.keyCode == PConstants.LEFT) {
					if (speed > -speedCap) {
						speed--;
					}
				}
				if (parent.keyCode == PConstants.RIGHT) {
					if (speed < speedCap) {
						speed++;
					}
				}
			}
		}
	}

	void update(int feldBreite) {
		// check if in Playable Area
		if (p_x > (parent.width / 2) + (feldBreite / 2) - (p_width / 2)) {
			p_x = (parent.width / 2) + (feldBreite / 2) - (p_width / 2);
			speed = -wallBounce;
		}
		if (p_x < (parent.width / 2) - (feldBreite / 2) + (p_width / 2)) {
			p_x = (parent.width / 2) - (feldBreite / 2) + (p_width / 2);
			speed = wallBounce;
		}
		// if speed is to small to be visible set speed to 0
		if (speed < 0.001f && speed > 0.0f) {
			speed = 0.0f;
		}
		if (speed > -0.001f && speed < 0.0f) {
			speed = 0.0f;
		}

		// movement
		p_x = p_x + (int) speed;
		speed /= speedFalloffDividor;
	}

}
