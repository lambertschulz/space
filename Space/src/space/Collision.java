package space;

public class Collision {

	public static boolean mouseCollisionRect(int mx, int my, int x, int y, int w, int h) {
		// check X
		if (mx >= x && mx <= x + w) {
			// check Y
			if (my >= y && my <= y + h) {
				return true;
			}
		}
		return false;
	}

	public static boolean mouseCollisionCircle(int mx, int my, int x, int y, int r) {
		if (Math.sqrt(Math.pow(mx - x, 2) + Math.pow(my - y, 2)) <= r) {
			return true;
		}
		return false;
	}
}