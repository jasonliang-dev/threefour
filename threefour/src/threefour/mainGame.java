package threefour;

import motej.Mote;

public class mainGame {
	static Wiimote[] wiimotes = new Wiimote[2];
	static boolean[] resting = {false, false};
	static WiimoteFinder[] wmFinder = new WiimoteFinder[2];
		
	static boolean[] ledOff = {false, false, false, false};

	public static void addWiimote(int slot) {
		wmFinder[slot] = new WiimoteFinder();
		Mote m = wmFinder[slot].findMote();

		boolean[] playerLeds = ledOff;
		playerLeds[slot] = true;
		m.setPlayerLeds(playerLeds);
		m.rumble(2000l);

		Wiimote wm = new Wiimote(m);
		wiimotes[slot] = wm;
	}

	public static boolean pointIn(int slot) {
		//TODO: check for mote input
		return false;
	}
	public static boolean pointDown(int slot) {
		//TODO: check for mote input
		return false;
	}
}
