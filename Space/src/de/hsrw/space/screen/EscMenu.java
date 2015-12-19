package de.hsrw.space.screen;

import de.hsrw.space.helpers.Collision;
import processing.core.PApplet;
import processing.core.PConstants;

public class EscMenu {

	private PApplet parent;
	private int bgAlpha;
	private int bgColor;
	private int buttonCount;
	private int focusButton;
	private int menuPadding;

	private int buttonColor;
	private int buttonColorFocus;

	private int buttonTextColor;
	private boolean continueGame;
	private boolean endLevel;

	int buttonHeight, buttonWidth, buttonYOffset;

	int buttonFieldHeight, buttonFieldWidth, buttonFieldX, buttonFieldY;

	String[] buttonTextes = { "CONTINUE", "EXIT TO MAIN MENU", "EXIT TO WINDOWS" };

	public EscMenu(PApplet p) {
		this.parent = p;
		this.bgAlpha = 120;
		this.bgColor = parent.color(200, 200, 220, this.bgAlpha);
		buttonCount = buttonTextes.length;
		menuPadding = 20;

		buttonTextColor = parent.color(30, 20, 255);
		focusButton = -1;

		buttonHeight = parent.height / 8;
		buttonWidth = parent.width / 4;

		buttonFieldHeight = (buttonHeight * buttonCount) + (menuPadding * (buttonCount - 1));
		buttonFieldWidth = buttonWidth;
		buttonFieldX = (parent.width / 2) - (buttonFieldWidth / 2);
		buttonFieldY = (parent.height / 2) - (buttonFieldHeight / 2);
		
		continueGame = false;
		endLevel = false;
	}

	public void renderbg() {
		parent.fill(bgColor);
		parent.rect(0, 0, parent.width, parent.height);
	}

	public void render() {

		parent.fill(2);
		parent.rect(buttonFieldX - menuPadding, buttonFieldY - menuPadding + 2, buttonFieldWidth + 2 * menuPadding,
				buttonFieldHeight + 2 * menuPadding, 5);
		parent.fill(8);
		parent.rect(buttonFieldX - menuPadding, buttonFieldY - menuPadding, buttonFieldWidth + 2 * menuPadding,
				buttonFieldHeight + 2 * menuPadding, 5);

		
		System.out.print(parent.key);
		for (int i = 0; i < buttonCount; i++) {

			buttonYOffset = i * (buttonHeight + menuPadding);

			if (Collision.colPointRect(parent.mouseX, parent.mouseY, buttonFieldX, buttonFieldY + buttonYOffset, buttonWidth, buttonHeight)) {
				parent.fill(buttonColorFocus);
				focusButton = i;
			} else {
				parent.fill(buttonColor);
				if (focusButton == buttonCount) {
					focusButton = -1;
				}
			}
			parent.fill(132);
			parent.rect(buttonFieldX, buttonFieldY + buttonYOffset, buttonWidth, buttonHeight, 5);
			parent.fill(buttonTextColor);
			parent.textSize(buttonHeight / 3);
			parent.textAlign(PConstants.CENTER);
			parent.text(buttonTextes[i], buttonFieldX, buttonFieldY + buttonYOffset + (buttonHeight / 3), buttonWidth,
					buttonHeight);
		}

	}

	public boolean pressedContinue() {
		return continueGame;
	}
	public boolean pressedMenu(){
		return endLevel;
	}

	public void mouseClick() {
		System.out.println(focusButton);
		if(focusButton == 0){
			continueGame = true;
		}else if(focusButton == 1){
			endLevel = true;
		}else if(focusButton == 2){
			parent.stop();
			parent.exit();
		}
	}

}
