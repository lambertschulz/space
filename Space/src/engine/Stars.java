package engine;

import processing.core.PApplet;

public class Stars {
	PApplet parent;
	private final int ANZAHL = 200;
	private final int MINSTONESIZE = 1;
	private final int MAXSTONESIZE = 3;
	private float[] xPos, yPos, stoneSize;
	private int width;
	private int height;
	private int x, y;
	double[] richtung;

	private float speedvar = 1.0f;

	public Stars(PApplet p, int x, int y, int width, int height) {
		parent = p;
		xPos = new float[ANZAHL];
		yPos = new float[ANZAHL];
		stoneSize = new float[ANZAHL];
		richtung = new double[ANZAHL];
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;

		for (int i = 0; i < ANZAHL; i++) {
			stoneSize[i] = parent.random(MINSTONESIZE, MAXSTONESIZE);
			xPos[i] = this.x + parent.random(0, this.width);
			yPos[i] = this.y + parent.random(0, this.height);
			richtung[i] = PApplet.round(parent.random(0.0f, 0.8f));
		}
	}

	public void render() {
		parent.fill(180);
		for (int i = 0; i < this.ANZAHL; i++) {

			parent.ellipse(this.xPos[i], this.yPos[i], this.stoneSize[i], this.stoneSize[i]);

			if (this.richtung[i] >= 0 && this.richtung[i] < 0.5) {
				this.xPos[i] += parent.random(0.1f, 0.2f);
			} else {
				this.xPos[i] -= parent.random(0.1f, 0.2f);
			}

			this.yPos[i] += (MAXSTONESIZE + this.richtung[i] - this.MAXSTONESIZE + this.stoneSize[i]) * speedvar;

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