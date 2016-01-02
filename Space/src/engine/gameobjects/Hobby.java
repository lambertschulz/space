package engine.gameobjects;

import gamespace.GV;
import processing.core.PApplet;

public class Hobby extends RectObjTex {

	private int playerID;
	private int hobbyID;
	private String path;
	private int speed = 2;
	private boolean alive = true;
	private int health;

	public Hobby(PApplet p, int x, int y, int playerID, int hobbyID) {
		super(p, x, y, p.loadImage(GV.TEXTUREPATH + "entity//asteroid//adrian//hobby0.png"));
		this.path = GV.TEXTUREPATH + "entity//asteroid//";
		switch (playerID) {
		case 0: {
			this.path += "adrian//";
			break;
		}

		case 1: {
			this.path += "christian//";
			break;
		}
		case 2: {
			this.path += "denis//";
			break;
		}
		case 3: {
			this.path += "lucas//";
			break;
		}
		case 4: {
			this.path += "robin//";
			break;
		}
		default:
			break;
		}

		switch (hobbyID) {
		case 0: {
			this.path += "hobby0.png";
			break;
		}
		case 1: {
			this.path += "hobby1.png";
			break;
		}
		case 2: {
			this.path += "hobby2.png";
			break;
		}
		case 3: {
			this.path += "hobby3.png";
			break;
		}
		default:
			break;
		}

		super.changeTexture(parent.loadImage(path));
		this.hobbyID = hobbyID;
		this.playerID = playerID;
		this.health = (int) parent.random(1, 5);
	}

	public void render() {
		yPos += speed;
		super.render();
	}

	public int getPlayerID() {
		return playerID;
	}

	public int getHobbyID() {
		return hobbyID;
	}

	public boolean isAlive() {
		return alive;
	}

	public void hit() {
		if (this.health <= 1) {
			this.alive = false;
		} else {
			this.health--;
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

	public Hobby getInstance() {
		return this;
	}

	public void die() {
		this.alive = false;
		
	}
}
