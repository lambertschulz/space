package engine.gameobjects;

import processing.core.PApplet;

public class RectObj extends GObject {
	protected int width;
	protected int height;
	private int color;

	/*
	 * KONSTRUKTOREN
	 */

	public RectObj(PApplet p, int x, int y, int width, int height, int color) {
		super(p, x, y);
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public RectObj(PApplet p, int x, int y, int width, int height) {
		this(p, x, y, width, height, p.color(128));
	}

	public RectObj(PApplet p, int width, int height, int color) {
		this(p, 0, 0, width, height, color);
	}

	public RectObj(PApplet p, int width, int height) {
		this(p, 0, 0, width, height);
	}

	public RectObj(PApplet p) {
		this(p, 0, 0, p.width, p.height);
	}

	public RectObj() {
		this(new PApplet());
	}

	public void render() {
		parent.noStroke();
		parent.fill(color);
		parent.rect(xPos, yPos, width, height);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
