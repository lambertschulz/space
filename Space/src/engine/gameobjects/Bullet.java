package engine.gameobjects;

import gamespace.GV;
import processing.core.PApplet;
import processing.core.PImage;

public class Bullet extends RectObjTex {
	int bulletSpeed = 5;
	public boolean alive = true;

	public Bullet(PApplet p, int x, int y, PImage tex, boolean alive) {
		super(p, x, y, 6, 10, tex);
		this.alive = alive;
	}
	public boolean isAlive(){
		return alive;
	}

	public void render() {
		super.render();
		yPos = yPos - bulletSpeed;
		if (this.yPos - this.height < GV.FELD_Y_POS) {
			alive = false;
		}
	}
	public int getxPos(){
		return this.xPos;
	}
	public int getyPos(){
		return this.yPos;
	}
	public int getWidth(){
		return this.width;
	}
	public int getHeight(){
		return this.height;
	}
	public Bullet getInstance() {
		return this;
	}

}
