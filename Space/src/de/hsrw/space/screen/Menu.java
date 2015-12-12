package de.hsrw.space.screen;

import de.hsrw.space.helpers.Collision;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Menu {
	PImage bgImage;
	PImage panelTexture, playButtonTexture, exitButtonTexture, exitTexture;
	PApplet parent;

	int selectionBGWidth, selectionBGHeight, selectionBGXpos, selectionBGYpos, headBGWidth, headBGHeight, headBGXpos,
			headBGYpos, playButtonRadius, playButtonBorderWidth, playButtonX, playButtonY, exitButtonRadius,
			exitButtonBorderWidth, exitButtonX, exitButtonY, infoBoxBGWidth, infoBoxBGHeight, infoBoxBGXpos,
			infoBoxBGYpos, shadow, focusButton;

	public Menu(PApplet p) {
		parent = p;

		bgImage = parent.loadImage("levelBG.png");
		bgImage.resize(parent.width, parent.height);

		playButtonRadius = parent.height / 8;
		playButtonX = parent.width / 2;
		playButtonY = 0;
		playButtonBorderWidth = 2;

		selectionBGWidth = (parent.width / 10) * 2;
		selectionBGHeight = (parent.height / 5 * 4);
		selectionBGXpos = 0;
		selectionBGYpos = ((parent.height / 32) * 17) - (selectionBGHeight / 2);

		infoBoxBGWidth = (parent.width / 10) * 6;
		infoBoxBGHeight = selectionBGHeight;
		infoBoxBGXpos = parent.width - infoBoxBGWidth - (parent.width / 10);
		infoBoxBGYpos = selectionBGYpos;

		headBGWidth = parent.width;
		headBGHeight = parent.height / 20;
		headBGXpos = 0;
		headBGYpos = 0;

		exitButtonBorderWidth = 2;
		exitButtonRadius = headBGHeight / 2 + exitButtonBorderWidth * 4;
		exitButtonX = parent.width - (headBGHeight / 2) - exitButtonBorderWidth * 4;
		exitButtonY = (headBGHeight / 2) + exitButtonBorderWidth * 4;

		shadow = 2;

		playButtonTexture = parent.loadImage("textures//ui//buttons//menuPlayButton.png");
		playButtonTexture.resize(playButtonRadius * 2, playButtonRadius * 2);

		exitButtonTexture = parent.loadImage("textures//ui//buttons//menuPlayButton.png");
		exitButtonTexture.resize(exitButtonRadius * 2, exitButtonRadius * 2);

		exitTexture = parent.loadImage("textures//ui//buttons//exit.png");
		exitTexture.resize(exitButtonRadius, exitButtonRadius);

		focusButton = 0;// 0 = nix 1 = PlayButton

	}

	public void render() {
		// Background
		parent.noStroke();
		parent.background(42, 142, 53);
		parent.image(bgImage, 0, 0);

		// HeadMenu
		parent.fill(2);
		parent.rect(headBGXpos, headBGYpos, headBGWidth, headBGHeight + shadow, 0, 0, 5, 5);

		parent.fill(2);
		parent.ellipse(playButtonX, playButtonY, (playButtonRadius + shadow) * 2, (playButtonRadius + shadow) * 2);

		parent.fill(2);
		parent.ellipse(exitButtonX, exitButtonY, (exitButtonRadius + shadow) * 2, (exitButtonRadius + shadow) * 2);

		parent.fill(8);
		parent.rect(headBGXpos, headBGYpos, headBGWidth, headBGHeight, 0, 0, 5, 5);

		parent.fill(8);
		parent.ellipse(playButtonX, playButtonY, playButtonRadius * 2, playButtonRadius * 2);

		parent.fill(8);
		parent.ellipse(exitButtonX, exitButtonY, (exitButtonRadius + shadow) * 2, (exitButtonRadius + shadow) * 2);

		// Button
		parent.noFill();
		parent.ellipse(playButtonX, playButtonY, playButtonRadius * 2, playButtonRadius * 2);
		parent.image(playButtonTexture, playButtonX - playButtonRadius, playButtonY - playButtonRadius);
		// Text
		parent.fill(0, 0, 255);
		parent.textAlign(PConstants.CENTER);
		parent.textSize(playButtonRadius / 2);
		parent.text("PLAY", (parent.width / 2) - (playButtonRadius), playButtonRadius / 8, playButtonRadius * 2,
				playButtonRadius);

		// ExitButton
		parent.noFill();
		parent.ellipse(exitButtonX, exitButtonY, exitButtonRadius * 2, exitButtonRadius * 2);
		parent.image(exitButtonTexture, exitButtonX - exitButtonRadius, exitButtonY - exitButtonRadius);
		parent.image(exitTexture, exitButtonX - exitButtonRadius + exitButtonRadius / 2,
				exitButtonY - exitButtonRadius + exitButtonRadius / 2);

		/*
		 * // SelectionMenu parent.fill(250); parent.rect(selectionBGXpos,
		 * selectionBGYpos, selectionBGWidth, selectionBGHeight, 0, 5, 5, 0);
		 * 
		 * // Info Box parent.fill(250); parent.rect(infoBoxBGXpos,
		 * infoBoxBGYpos, infoBoxBGWidth, infoBoxBGHeight, 5, 5, 5, 5);
		 */
	}

	public void mouseInputCheck() {
		if (Collision.mouseCollisionCircle(parent.mouseX, parent.mouseY, playButtonX, playButtonY, playButtonRadius)) {
			focusButton = 1;
		} else if (Collision.mouseCollisionCircle(parent.mouseX, parent.mouseY, exitButtonX, exitButtonY,
				exitButtonRadius)) {
			focusButton = 2;
		}

	}
	public int getFb(){
		return focusButton;
	}
}
