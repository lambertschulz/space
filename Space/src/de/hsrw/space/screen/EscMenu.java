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
	private int textSize;

	private int buttonColor;
	private int buttonColorFocus;

	private int buttonTextColor;

	int lButtonHeight, lButtonWidth, lButtonx, lButtony, lButtonOffset;

	String[] buttonTextes = { "CONTINUE", "EXIT TO MAIN MENU", "EXIT TO WINDOWS" };

	public EscMenu(PApplet p) {
		this.parent = p;
		this.bgAlpha = 120;
		this.bgColor = parent.color(200, 200, 220, this.bgAlpha);
		buttonCount = buttonTextes.length;
		menuPadding = 10;
		textSize = 10;
		
		focusButton = -1;

		lButtonHeight = 50;
		lButtonWidth = 150;
		lButtonx = (parent.width / 2) - (lButtonWidth / 2);
		lButtony = (parent.height / 2) - ((lButtonHeight * buttonCount + (menuPadding * (buttonCount - 1))) / 2);

		lButtonOffset = 0;
	}

	public void renderbg() {
		parent.fill(bgColor);
		parent.rect(0, 0, parent.width, parent.height);
	}
	public void render() {
		
		for (int i = 0; i < buttonCount; i++) {
			// Check MouseCollision
			lButtonOffset = lButtonHeight + menuPadding * i;
			if (Collision.mouseCollisionRect(parent.mouseX, parent.mouseY, lButtonx, lButtony + lButtonOffset,
					lButtonWidth, lButtonHeight)) {
				parent.fill(buttonColorFocus);
				focusButton = buttonCount;
			} else {
				parent.fill(buttonColor);
				if (focusButton == buttonCount) {
					focusButton = -1;
				}
			}
			// --------------------------------------
			// Button

			parent.rect(lButtonx, lButtony + lButtonOffset,
					lButtonWidth, lButtonHeight, 5);
			parent.fill(buttonTextColor);
			parent.textSize(textSize);
			parent.textAlign(PConstants.CENTER);
			parent.text(buttonTextes[i], lButtonx, lButtony + lButtonOffset,
					lButtonWidth, lButtonHeight);
		}

	}

	public boolean pressedContinue() {
		return false;
	}

}
