package threefour;

import java.util.Timer;
import java.util.TimerTask;
import motej.Mote;

public class mainGame {
	TimerTask clock = new TimerTask() {
		@Override
		public void run() {
			mainGame.step();
		}
	};
	static String status = "IDLE";

	static WiimoteFinder[] wmFinder = new WiimoteFinder[2];
	static Wiimote[] wiimotes = new Wiimote[2];
	static boolean[] ledOff = {false, false, false, false};
	static int[] playerTime = {0, 0};

	static int counter = 0;
	static int randNum = randNum();

	/**
	 * Start a timer
	 */
	public mainGame() {
		Timer time = new Timer();
		time.schedule(new clock(), 0, 10);
	}

	/**
	 * Run this every millisecond
	 */
	public void step() {
		countDown();
		gameStart.setStatus(status);
	}

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
	 */
	public static void countDown() {
		// TODO: audio
		if (playersReady()) {
			if (counter == 0) {
				System.out.println("ready");
			}
			counter++;
		}
		else {
			counter = 0;
			randNum = randNum();
		}
		if (counter == randNum) {
			System.out.println("FIRE!");
			// TODO: start clock for both players
		}
	}

	public static boolean playersReady() {
		for (Wiimote wm : wiimotes) {
			if (!wm.getButton().equals("AB") || !wm.pointDown()) {
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

	/**
	 * Get a random number
	 * @return a number between 2000 to 5000 (I think)
	 */
	public static int randNum() {
		return (int)(Math.random() * 3000) + 2000;
	}

}
