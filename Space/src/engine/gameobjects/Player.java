package engine.gameobjects;

import engine.io.Keys;
import gamespace.GV;
import processing.core.PApplet;
import processing.core.PImage;

public class Player extends RectObjTex {

	private String name = "";
	private int shootingCooldown = 15;
	private int shotCooldownCounter = 0;
	private float speed = 0.0f;
	private float speedCap = 4.0f;
	private float wallBounce = 2.0f;
	private float speedFalloffDividor = 1.1f;
	private int playerID;
	private int health = 10;

	public Player(PApplet p, int x, int y, PImage tex) {
		super(p, x, y, tex);
	}

	public Player(PApplet p, int x, int y, String player) {
		this(p, x, y, p.loadImage(GV.TEXTUREPATH + "entity//player//" + player + "//ship.png"));
		this.name = player;
		switch(this.name){
		case "adrian":{
			this.playerID = 0;
		}
		case "christian":{
			this.playerID = 1;
		}
		case "denis":{
			this.playerID = 2;
		}
		case "lucas":{
			this.playerID = 3;
		}
		case "robin":{
			this.playerID = 4;
		}
		default:{
			this.playerID = 5;
		}
		}
	}

	public Player(PApplet p, String player) {
		this(p, GV.PLAYER_SPAWN_X, GV.PLAYER_SPAWN_Y, player);
	}

	public void render() {
		checkMovement(GV.FELD_X_POS, GV.FELD_Y_POS, GV.FELD_WIDTH, GV.FELD_HEIGHT);
		super.render();
	}

	private void checkMovement(int fx, int fy, int fw, int fh) {
		if (Keys.keys[0]) { // w / UP
			if (shotCooldownCounter == 0) {
				shoot();
				shotCooldownCounter = shootingCooldown;
			}
		}
		if (Keys.keys[2]) { // s / DOWN
			absorb();
		}
		if (Keys.keys[1]) { // a / LEFT
			if (this.speed >= -speedCap) {
				this.speed -= 1;
			}
		}

		if (Keys.keys[3]) { // d / RIGHT
			if (this.speed <= speedCap) {
				this.speed += 1;
			}
		}

		// wenn speed zu klein dann speed = 0
		if (this.speed < 0.001f && this.speed > 0.0f) {
			this.speed = 0.0f;
		}
		if (this.speed > -0.001f && this.speed < 0.0f) {
			this.speed = 0.0f;
		}
		// check ob im feld
		if (this.xPos < fx) {
			this.xPos = fx;
			this.speed = wallBounce;
		}
		if (this.xPos + this.width > (fx + fw)) {
			this.xPos = (fx + fw) - this.width;
			this.speed = -wallBounce;
		}

		this.xPos += (int) this.speed;
		this.speed = this.speed / speedFalloffDividor;
		if (shotCooldownCounter != 0) {
			shotCooldownCounter--;
		}
	}

	private void absorb() {

	}

	private void shoot() {
		GV.bullets[GV.bulletIndex] = new Bullet(parent, this.xPos + this.width / 2, yPos,
				parent.loadImage("textures//entity//bullet//" + this.name + "//bulletFired.png"), true);
		nextBullet();
	}

	private void nextBullet() {
		if (GV.bulletIndex < GV.bullets.length - 1) {
			GV.bulletIndex++;
		} else {
			GV.bulletIndex = 0;
		}
	}

	public float getSpeed() {
		return speed;
	}

	public void hit(Hobby h) {
		if(h.getPlayerID() != this.playerID){
			if(this.health <= 1){
				GV.gameover = true;
			}
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
	public Player getInstance() {
		return this;
	}
}
