package de.hsrw.space.screen;

import processing.core.PApplet;

public class Sterne {
	PApplet parent;
	private int anzahl = 200;
	private int minStoneSize = 1;
	private int maxStoneSize = 3;
	private float[] xPos, yPos, stoneSize;
	private int width;
	private int height;
	private int x, y;
	double[] richtung;

	private float speedvar = 1.0f;

	public Sterne(PApplet p, int x, int y, int width, int height) {
		parent = p;
		xPos = new float[anzahl];
		yPos = new float[anzahl];
		stoneSize = new float[anzahl];
		richtung = new double[anzahl];
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;

		for (int i = 0; i < anzahl; i++) {
			stoneSize[i] = parent.random(minStoneSize, maxStoneSize);
			xPos[i] = this.x + parent.random(0, this.width);
			yPos[i] = this.y + parent.random(0, this.height);
			richtung[i] = parent.round(parent.random(0.0f, 0.8f));
		}
	}

	public void render() {
		parent.fill(0);
		parent.rect(this.x, this.y, this.width, this.height);

		parent.fill(180);
		for (int i = 0; i < this.anzahl; i++) {

			parent.ellipse(this.xPos[i], this.yPos[i], this.stoneSize[i], this.stoneSize[i]);

			if (this.richtung[i] >= 0 && this.richtung[i] < 0.5) {
				this.xPos[i] += parent.random(0.1f, 0.2f);
			} else {
				this.xPos[i] -= parent.random(0.1f, 0.2f);
			}

			this.yPos[i] += (maxStoneSize + this.richtung[i] - this.maxStoneSize + this.stoneSize[i]) * speedvar;

			if (this.xPos[i] > this.width + this.x + this.stoneSize[i] / 2
					|| this.xPos[i] < this.x - this.stoneSize[i] / 2
					|| this.yPos[i] > this.y + this.height + this.stoneSize[i] / 2) {
				this.xPos[i] = parent.random(0, this.width) + this.x;
				this.yPos[i] = -this.stoneSize[i] / 2 + this.y;
			}

		}

	}

	public void setSpeed(float speed) {
		this.speedvar = speed;
	}

	public void resetSpeed() {
		this.speedvar = 1.0f;
	}
}