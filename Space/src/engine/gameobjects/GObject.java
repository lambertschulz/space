package engine.gameobjects;

import processing.core.PApplet;

public class GObject {
	protected PApplet parent;
	protected int xPos, yPos;

	public GObject(PApplet p, int x, int y) {
		this.parent = p;
		this.xPos = x;
		this.yPos = y;
	}

	public GObject(PApplet p) {
		this(p, 0, 0);
	}

	public GObject() {
		this(new PApplet());
	}

	public void render() {

	}
	public void move(int x, int y){
		this.xPos+=x;
		this.yPos+=y;
	}

	public String toString() {
		return "xPos: " + this.xPos + " | yPos: " + this.yPos;
	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}
	
}
