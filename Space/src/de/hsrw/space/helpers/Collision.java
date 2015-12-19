package de.hsrw.space.helpers;

import de.hsrw.space.gameobjects.CircleObj;
import de.hsrw.space.gameobjects.GObject;
import de.hsrw.space.gameobjects.RectObj;

public class Collision {

	// HitCollision
	public static boolean colPointPoint(int mx, int my, int x, int y) {
		if (Math.abs(Math.sqrt(Math.pow(mx - x, 2) + Math.pow(my - y, 2))) > 0) {
			return false;
		}
		return true;
	}

	public static boolean colPointRect(int mx, int my, int x, int y, int w, int h) {
		// check X
		if (mx >= x && mx <= x + w) {
			// check Y
			if (my >= y && my <= y + h) {
				return true;
			}
		}
		return false;
	}

	public static boolean colPointCircle(int mx, int my, int x, int y, int r) {
		if (Math.sqrt(Math.pow(mx - x, 2) + Math.pow(my - y, 2)) <= r) {
			return true;
		}
		return false;
	}

	public static boolean colRectRect(int ax, int ay, int aw, int ah, int x, int y, int w, int h) {
		// check X
		if (x <= ax + aw && x + w >= ax) {
			// check Y
			if (y <= ay + ah && y + h >= ay) {
				return true;
			}
		}
		return false;
	}

	public static boolean colCircleCircle(int ax, int ay, int ar, int x, int y, int r) {
		if (Math.sqrt(Math.pow(ax - x, 2) + Math.pow(ay - y, 2)) <= (ax + x)) {
			return true;
		}
		return false;
	}

	public static boolean colPointPoint(GObject a, GObject b) {
		if (Math.sqrt(Math.pow(a.getxPos() - b.getxPos(), 2) + Math.pow(a.getyPos() - b.getyPos(), 2)) > 0) {
			return true;
		}
		return false;
	}

	public static boolean colPointRect(GObject a, RectObj b) {
		// check X
		if (a.getxPos() >= b.getxPos() && a.getxPos() <= b.getxPos() + b.getWidth()) {
			// check Y
			if (a.getyPos() >= b.getyPos() && a.getyPos() <= b.getyPos() + b.getHeight()) {
				return true;
			}
		}
		return false;
	}

	public static boolean colPointCircle(GObject a, CircleObj b) {
		if (Math.sqrt(Math.pow(a.getxPos() - b.getxPos(), 2) + Math.pow(a.getyPos() - b.getyPos(), 2)) <= b
				.getRadius()) {
			return true;
		}
		return false;
	}

	public static boolean colRectRect(RectObj a, RectObj b) {
		// check X
		if (b.getxPos() <= a.getxPos() + a.getWidth() && b.getxPos() + b.getWidth() >= a.getxPos()) {
			// check Y
			if (b.getyPos() <= a.getyPos() + a.getHeight() && b.getyPos() + b.getHeight() >= a.getyPos()) {
				return true;
			}
		}
		return false;
	}

	public static boolean colCircleCircle(CircleObj a, CircleObj b) {
		if (Math.sqrt(Math.pow(a.getxPos() - b.getxPos(), 2) + Math.pow(a.getyPos() - b.getyPos(), 2)) <= (a.getRadius()
				+ b.getRadius())) {
			return true;
		}
		return false;
	}

	// inside Collision

	public static boolean isInside(int ax, int ay, int aw, int ah, int bx, int by, int bw, int bh) {
		// check X
				if (ax >= bx && ax + aw <= bx + bw) {
					// check Y
					if (ay >= by || ay + ah <= by + bh) {
						return true;
					}
				}
				return false;
	}
}
