package threefour;

import motej.Mote;

public class mainGame {
	static Wiimote[] wiimotes = new Wiimote[2];
	static WiimoteFinder[] wmFinder = new WiimoteFinder[2];
		
	static boolean[] ledOff = {false, false, false, false};

	/**
	 * Adds a new Wii Remote
	 * @param slot player slot
	 */
	public static void addWiimote(int slot) {
		wmFinder[slot] = new WiimoteFinder();
		Mote m = wmFinder[slot].findMote();

		boolean[] playerLeds = ledOff;
		playerLeds[slot] = true;
		m.setPlayerLeds(playerLeds);
		m.rumble(3000l);

		Wiimote wm = new Wiimote(m);
		wiimotes[slot] = wm;
	}

	/**
	 * Check if both players are "ready"
	 * @param players number of players (which should always be 2 so there should be any parameters but whatever)
	 * @param button the button(s) to press to be considered "ready" (can be "none")
	 * @return true if all players press the button(s) specified
	 */
	public static boolean playersReady(int players, String button) {
		for (int k = 0; k < players; k++) {
			Wiimote wm = wiimotes[k];
			if (!wm.getButton().equals(button)) {
				return false;
			}
		}
		return true;
	}
}
