package engine.gameobjects;

import processing.core.PApplet;
import processing.core.PImage;

public class RectObjTex extends RectObj {

	protected PImage tex;

	public RectObjTex(PApplet p, int x, int y, int width, int height, PImage tex) {
		super(p, x, y, width, height);
		this.tex = tex;
	}

	public RectObjTex(PApplet p, int x, int y, PImage tex) {
		super(p, x, y, tex.width, tex.height);
		this.tex = tex;
	}
	public RectObjTex(PApplet p, PImage tex) {
		super(p);
		this.tex = tex;
	}

	public void render() {
		parent.image(tex, xPos, yPos, width, height);
	}
	
	public void changeTexture(PImage tex){
		this.tex = tex;
	}
	public PImage getTexture(){
		return tex;
	}
}
