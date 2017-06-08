package threefour;

import motej.Mote;

public class mainGame {
	static WiimoteFinder[] wmFinder = new WiimoteFinder[2];
	static Wiimote[] wiimotes = new Wiimote[2];
	static int[] playerTime = {0, 0};
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
	 * resets the game
	 */
	public static void endGame() {

	}

	/**
	 * Announcer countdown
	 * @throws java.lang.InterruptedException
	 */
	public static void countDown() throws InterruptedException {
		// TODO: audio
		System.out.println("ready");
		Thread.sleep((int)(Math.random() * 2000) + 3000);
		System.out.println("DRAW");
		// TODO: start clock for both players
	}

	public static boolean playersReady() {
		for (Wiimote wm : wiimotes) {
			if (!wm.getButton().equals("AB")) {
				return false;
			}
		}
		return true;
	}

	/**
	 * See if the player successfully fired 
	 * @param slot player slot
	 * @return time in ms if wiimote is facing away
	 */
	public static int fire(int slot) {
		// TODO: stop the clock
		Wiimote wm = wiimotes[slot];
		if (wm.pointAway()) {
			// TODO: return the time in ms
		}
		return 0; // "AHHH I SHOT THE DIRT"
	}

}
