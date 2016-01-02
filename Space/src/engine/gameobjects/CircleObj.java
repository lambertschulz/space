package engine.gameobjects;

import processing.core.PApplet;

public class CircleObj extends GObject {
	protected int radius;
	private int color;

	/*
	 * KONSTRUKTOREN
	 */

	public CircleObj(PApplet p, int x, int y, int radius, int color) {
		super(p, x, y);
		this.radius = radius;
		this.color = color;
	}

	public CircleObj(PApplet p, int x, int y, int radius) {
		this(p, x, y, radius, p.color(128));
	}

	public CircleObj(PApplet p, int radius) {
		this(p, p.width / 2, p.height / 2, radius);
	}

	public void render() {
		parent.noStroke();
		parent.fill(color);
		parent.ellipse(xPos, yPos, radius * 2, radius * 2);
	}

	public int getRadius() {
		return radius;
	}
}
