package de.hsrw.space.unused;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Menu2 {
	PImage bgImage;
	PApplet parent;
	
	int selectionBGWidth, selectionBGHeight, selectionBGXpos, selectionBGYpos, 
		headBGWidth, headBGHeight, headBGXpos, headBGYpos,
		headBG2Width, headBG2Height, headBG2LXpos, headBG2RXpos, headBG2Ypos,
		playButtonWidth, playButtonHeight, playButtonBorderWidth, 
		infoBoxBGWidth, infoBoxBGHeight, infoBoxBGXpos, infoBoxBGYpos;
	
	public Menu2(PApplet p) {
		parent = p;
		
		bgImage = parent.loadImage("levelBG.png");
		bgImage.resize(parent.width, parent.height);
		
		playButtonWidth = parent.width/10;
		playButtonHeight = parent.height/19;
		playButtonBorderWidth = 2;
		
		selectionBGWidth = (parent.width/10) * 2;
		selectionBGHeight = (parent.height/5*4);
		selectionBGXpos = 0;
		selectionBGYpos = ((parent.height/32)*17)-(selectionBGHeight/2);
		
		infoBoxBGWidth = (parent.width/10)*6;
		infoBoxBGHeight = selectionBGHeight;
		infoBoxBGXpos = parent.width - infoBoxBGWidth - (parent.width/10);
		infoBoxBGYpos = selectionBGYpos;
		
		headBGWidth = parent.width;
		headBGHeight = parent.height/20 + playButtonBorderWidth;
		headBGXpos = 0;
		headBGYpos = 0;
		
		headBG2Width = parent.width/2 - playButtonWidth/2 - playButtonBorderWidth;
		headBG2Height = parent.height/20;
		headBG2RXpos = parent.width - headBG2Width;
		headBG2LXpos = playButtonBorderWidth;
		headBG2Ypos = 0;
		
		
		
		
	}

	public void render() {
		parent.noStroke();
		parent.background(42, 142, 53);
		parent.image(bgImage, 0, 0);
		
		//HeadMenu
		parent.fill(250);
		parent.rect(headBGXpos, headBGYpos, headBGWidth, headBGHeight, 0, 0, 5, 5);
		
		parent.fill(123);
		parent.rect(headBG2LXpos, headBG2Ypos, headBG2Width, headBG2Height, 0, 0, 5, 5);
		
		parent.fill(123);
		parent.rect(headBG2RXpos, headBG2Ypos, headBG2Width, headBG2Height, 0, 0, 5, 5);
		//Play Button
		//BG
		parent.fill(250);
		parent.rect((parent.width/2) - (playButtonWidth/2) - playButtonBorderWidth, 0, playButtonWidth + 2*playButtonBorderWidth, playButtonHeight + playButtonBorderWidth, 0, 0, 5, 5);
		parent.fill(123);
		parent.rect((parent.width/2) - (playButtonWidth/2), 0, playButtonWidth, playButtonHeight, 0, 0, 5, 5);
		//Button
		parent.fill(0, 0, 50);
		parent.rect((parent.width/2) - (playButtonWidth/2) + playButtonBorderWidth + playButtonWidth/16, playButtonHeight/8, ((playButtonWidth - (2 * playButtonBorderWidth))/8)*7, (playButtonHeight/8)*6, 5);
		//Text
		parent.fill(123);
		parent.textAlign(PConstants.CENTER);
		parent.textSize(playButtonHeight/2);
		parent.text("PLAY", (parent.width/2) - (playButtonWidth/2) + playButtonBorderWidth + playButtonWidth/16, playButtonHeight/8 + playButtonHeight/16, ((playButtonWidth - (2 * playButtonBorderWidth))/8)*7, (playButtonHeight/8)*6);
		
		
		//SelectionMenu
		parent.fill(250);
		parent.rect(selectionBGXpos, selectionBGYpos, selectionBGWidth, selectionBGHeight, 0, 5, 5, 0);
		
		//Info Box
		parent.fill(250);
		parent.rect(infoBoxBGXpos, infoBoxBGYpos, infoBoxBGWidth, infoBoxBGHeight, 5, 5, 5, 5);
	}
	
	private boolean checkFocus(int minX, int maxX, int minY, int maxY) {
	    //X achse check
	    if (parent.mouseX >= minX && parent.mouseX <= maxX) {
	      //Y achse check
	      if (parent.mouseY >= minY && parent.mouseY <= maxY) {
	        return true;
	      }
	    }
	    return false;
	  }

}
