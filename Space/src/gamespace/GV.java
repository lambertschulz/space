package gamespace;

import engine.gameobjects.Bullet;
import engine.gameobjects.Hobby;
import processing.core.PApplet;

public class GV {
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 675;
	// public final static int WIDTH = 1920;
	// public final static int HEIGHT = 1080;

	// FELD

	public final static int FELD_WIDTH = WIDTH / 2;
	//public final static int FELD_HEIGHT = (HEIGHT / 8) * 7;
	public final static int FELD_HEIGHT = HEIGHT;
	public final static int FELD_X_POS = (WIDTH / 2) - (FELD_WIDTH / 2);
	//public final static int FELD_Y_POS = HEIGHT / 16;
	public final static int FELD_Y_POS = 0;
	public final static int FELD_BACKGROUND_COLOR = new PApplet().color(0, 0, 10);

	// PLAYER

	public final static int PLAYER_SPAWN_X = FELD_X_POS + FELD_WIDTH / 2;
	public final static int PLAYER_SPAWN_Y = (HEIGHT / 8) * 7;
	
	public final static int PLAYER_WIDTH = 64;
	public final static int PLAYER_HEIGHT = 128;
	 
	
	// BULLET
	
	public final static int BULLET_WIDTH = 16;
	public final static int BULLET_HEIGHT = 48;
	
	// HOBBY
	
	public final static int HOBBY_WIDTH = 32;
	public final static int HOBBY_HEIGHT = 32;
	
	// TEXTURE PATHS
	public final static String TEXTUREPATH = "textures//";
	
	
	// ARRAYS
	public static Bullet[] bullets = new Bullet[10];
	public static int bulletIndex = 0;
	public static Hobby[] hobbies = new Hobby[30];
	public static int hobbyIndex = 0;
	
	
	//GAMEVARS
	public static boolean gameover = false;

}
