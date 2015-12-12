package de.hsrw.space.entity;

import processing.core.PApplet;
import processing.core.PConstants;

public class Player {

	PApplet parent;
	private int p_x = 0;
	int p_y = 0;

	int p_width = 10;
	int p_height = 10;

	int p_color = 0;

	private float speed = 0.0f;
	float speedCap = 4.0f;
	float wallBounce = 2.0f;
	float speedFalloffDividor = 1.1f;

	public Player(PApplet p) {
		parent = p;
		p_y = 9 * parent.height / 10;
		setP_x((parent.width / 2) - (p_width / 2));
		p_color = parent.color(123, 0, 0);
	}

	public void render() {
		parent.noStroke();
		parent.fill(p_color);
		parent.rect(getP_x() - (p_width / 2), parent.height - (parent.height / 10), p_width, p_height, 2);
	}

	public void move() {
		if (parent.keyPressed) {
			if (parent.key == PConstants.CODED) {
				if (parent.keyCode == PConstants.UP) {
					// fire
				}
				if (parent.keyCode == PConstants.DOWN) {
					// absorb
				}
				if (parent.keyCode == PConstants.LEFT) {
					if (getSpeed() > -speedCap) {
						setSpeed(getSpeed() - 1);
					}
				}
				if (parent.keyCode == PConstants.RIGHT) {
					if (getSpeed() < speedCap) {
						setSpeed(getSpeed() + 1);
					}
				}
			}
		}
	}

	public void update(int feldBreite) {
		// check if in Playable Area
		if (getP_x() > (parent.width / 2) + (feldBreite / 2) - (p_width / 2)) {
			setP_x((parent.width / 2) + (feldBreite / 2) - (p_width / 2));
			setSpeed(-wallBounce);
		}
		if (getP_x() < (parent.width / 2) - (feldBreite / 2) + (p_width / 2)) {
			setP_x((parent.width / 2) - (feldBreite / 2) + (p_width / 2));
			setSpeed(wallBounce);
		}
		// if speed is to small to be visible set speed to 0
		if (getSpeed() < 0.001f && getSpeed() > 0.0f) {
			setSpeed(0.0f);
		}
		if (getSpeed() > -0.001f && getSpeed() < 0.0f) {
			setSpeed(0.0f);
		}

		// movement
		setP_x(getP_x() + (int) getSpeed());
		setSpeed(getSpeed() / speedFalloffDividor);
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getP_x() {
		return p_x;
	}

	public void setP_x(int p_x) {
		this.p_x = p_x;
	}

}
