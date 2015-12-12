package space;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class MainMenu {

	String[] buttons;
	PApplet parent;
	PImage bgImage;
	AudioManager am;

	int menuColor;

	int m_w = 0;// MainMenu breite
	int m_h = 0;// MainMenu höhe
	int m_x = 0;
	int m_y = 0;

	int buttonWidth;
	int buttonHeight;
	int menuPadding;

	int menuButtonColor;
	int menuButtonFocusColor;
	int menuButtonTextColor;
	int textSizeMenu;

	int focusButton = -1;

	public MainMenu(PApplet p, AudioManager am, String[] buttons) {
		this.am = am;
		this.buttons = buttons;
		parent = p;
		menuColor = parent.color(100);
		menuButtonColor = parent.color(220);
		menuButtonFocusColor = parent.color(255);
		menuButtonTextColor = parent.color(0);

		m_w = parent.width / 2; // setze MainMenubreite
		m_h = (parent.height / 8) * 7; // setze MainMenuhöhe
		m_x = (parent.width / 2) - (m_w / 2); // setze MainMenuXposition
		m_y = parent.height / 16; // setze MainMenuYposition

		buttonWidth = m_w - (m_w / 8);
		buttonHeight = (parent.height / 16);
		menuPadding = 20;
		textSizeMenu = buttonHeight / 3;

		bgImage = parent.loadImage("levelBG.png");
		bgImage.resize(parent.width, parent.height);
	}

	public void render() {
		parent.noStroke();
		parent.background(42, 142, 53);
		parent.image(bgImage, 0, 0);
		parent.fill(menuColor);
		parent.rect(m_x, m_y, m_w, m_h, 2);
		// display Menubuttons
		for (int i = 0; i < buttons.length; i++) {
			renderMenuButton(i + 1, buttons[i]);
		}

	}

	private void renderMenuButton(int buttonCount, String bT) {
		// ButtonVars
		int lBh = buttonHeight;
		int lBTh = lBh;
		int lBw = buttonWidth;
		int lBTw = lBw;
		int lBx = (parent.width / 2) - (buttonWidth / 2);
		int lBTx = lBx;
		int lBy = (buttonHeight * buttonCount) + (menuPadding * buttonCount);
		int lBTy = lBy + (buttonHeight / 2) - (textSizeMenu / 2);
		// Button
		if (checkFocus(lBx, lBx + lBw, lBy, lBy + lBh)) {
			parent.fill(menuButtonFocusColor);
			focusButton = buttonCount;
		} else {
			parent.fill(menuButtonColor);
			if (focusButton == buttonCount) {
				focusButton = -1;
			}
		}
		parent.rect(lBx, lBy, lBw, lBh, 5);
		parent.fill(menuButtonTextColor);
		parent.textSize(textSizeMenu);
		parent.textAlign(PConstants.CENTER);
		parent.text(bT, lBTx, lBTy, lBTw, lBTh);
	}

	private boolean checkFocus(int minX, int maxX, int minY, int maxY) {
		// X achse check
		if (parent.mouseX >= minX && parent.mouseX <= maxX) {
			// Y achse check
			if (parent.mouseY >= minY && parent.mouseY <= maxY) {
				return true;
			}
		}
		return false;
	}

}
