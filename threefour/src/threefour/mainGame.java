package threefour;

import java.util.Timer;
import java.util.TimerTask;
import motej.Mote;

public final class mainGame {
	static TimerTask clock;
	static String status = "IDLE";
	static String info = "";

	static WiimoteFinder[] wmFinder = new WiimoteFinder[2];
	static Wiimote[] wiimotes = new Wiimote[2];
	static String[] wiimoteButtons = {"none", "none"};
	static boolean[] ledOff = {false, false, false, false};
	static boolean[] timeSet = {false, false};
	static int[] playerTime = {0, 0};

	static int counter = 0;
	static int randNum = randNum();

	private mainGame() {} // private because there should be only one mainGame
				// note: everything is static

	/**
	 * create and start a new timer
	 * the step method will be called every millisecond-ish.
	 */
	public static void startTimer() {
		mainGame.clock = new TimerTask() {
			@Override
			public void run() {
				mainGame.step();
			}
		};
		Timer time = new Timer();
		time.schedule(clock, 1, 1);
	}

	/**
	 * Run this every millisecond(-ish).
	 */
	public static void step() {
		// TODO: audio
		switch (status) {
			case "IDLE":
				if (playersButton("AB")) {
					status = "COUNT";
				}
				else {
					info = "Press A and B to start";
				}
				break;
			case "COUNT":
				if (playersPointDown()) {
					if (counter == 0) {
						info = "Ready?";
					}
					counter++;
					if (counter == randNum) {
						status = "RUN";
						info = "FIRE!";
						for (int k = 0; k < wiimotes.length; k++) {
							playerTime[k] = 0;
							timeSet[k] = false;
						}
					}
				}
				else {
					counter = 0;
					info = "Point the remote downwards!";
				}
				break;
			case "RUN":
				//TODO: listen for a button press
				boolean playersFired = true;
				for (int k = 0; k < wiimotes.length; k++) {
					if (!timeSet[k]) {
						playersFired = false;
						playerTime[k]++;
						Wiimote wm = wiimotes[k];
						String button = wm.getButton();
						if (button.equals("B")) {
							timeSet[k] = true;
							if (!wm.pointAway()) {
								playerTime[k] = 0;
							}
						}
					}
				}
				if (playersFired) {
					status = "END";
				}
				break;
			case "END":
				if (playerTime[0] < playerTime[1] && playerTime[0] != 0) {
					info = "Player 1 wins!";
				}
				else if (playerTime[1] < playerTime[0] && playerTime[1] != 0) {
					info = "Player 2 wins!";
				}
				else {
					info = "IT'S A TIE!";
				}
				cont("TIME");
				break;
			case "TIME":
				info = "TIME: " + playerTime[0] + ", " + playerTime[1];
				cont("PITCH");
				break;
			case "PITCH":
				info = "PITCH: " + wiimotes[0].getPitch() + ", " + wiimotes[1].getPitch();
				cont("IDLE");
				break;
			default:
				//status = "IDLE";
				break;
		}
		gameStart.setInfoLabel(info);
	}

	/**
	 * Contine to next status.
	 * @param s name of state.
	 */
	public static void cont(String s) {
		for (Wiimote wm : wiimotes) {
			if (wm.getButton().equals("PLUS")) {
				status = s;
			}
		}
	}

	/**
	 * Adds a new Wii Remote.
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
	 * Resets the game.
	 */
	public static void endGame() {

	}

	/**
	 * Announcer countdown.
	 */
	public static void countDown() {

	}

	/**
	 * see if all players are pressing a button.
	 * @param s button
	 * @return true if players are pressing the button specified
	 */
	public static boolean playersButton(String s) {
		for (Wiimote wm : wiimotes) {
			if (!wm.getButton().equals(s)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * see if all players are pointing the remote down.
	 * @return true if remotes are pointing down
	 */
	public static boolean playersPointDown() {
		for (Wiimote wm : wiimotes) {
			if (!wm.pointDown()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * See if the player successfully fired.
	 * @param slot player slot
	 * @return time in ms if remote is facing away
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
	 * Get a random number.
	 * @return a number between 2000 to 5000 (I think)
	 */
	public static int randNum() {
		return (int)(Math.random() * 3000) + 2000;
	}

}
