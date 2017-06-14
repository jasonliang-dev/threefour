package threefour;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import motej.Mote;

public final class mainGame {
	// there are two players
	static final int C = 2;

	static TimerTask clock; // for step method
	static String status = "IDLE"; // state of the game
	static String info = ""; // info text

	static WiimoteFinder[] wmFinder = new WiimoteFinder[C];
	static Wiimote[] wiimotes = new Wiimote[C];

	static Player[] players = new Player[C];

	static boolean[] playerFlag = {false, false};
	static int[] playerTime = {0, 0};
	static String[] playerAngle = {"", ""};

	static DecimalFormat timeFormat = new DecimalFormat("0.000"); // stop the labels from jumping around
	static DecimalFormat angleFormat = new DecimalFormat("0.0"); // too many decimals. remove them.


	static int counter = 0;
	static int randNum = randNum();

	private mainGame() {
		/*
		  everything is static
		  class is final
		  constructor is private
		  because there should only be one mainGame
		*/
	}

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
	 * Oh man this is huge and big and huge and big and- okay I think you get it.
	 * this method runs every millisecond(-ish).
	 */
	public static void step() {
		// TODO: audio

		switch (status) {
			case "IDLE": // new game
				boolean ready = true;

				for (int k = 0; k < C; k++) {
					if (playerFlag[k]) {
						gameStart.setPlayerLabel(k, "OK");
					}
					else {
						ready = false;
						gameStart.setPlayerLabel(k, "Waiting...");

						Wiimote wm = wiimotes[k];
						if (wm.getButton().equals("AB")) {
							Mote m = wm.getMote();
							m.rumble(500l);
							playerFlag[k] = true;
						}
					}
				}
				if (ready) {
					status = "COUNT";
					resetFlag();
				}
				else {
					info = "Press A and B to start";
				}
				break;
			case "COUNT": // countdown
				boolean point = true;

				for (int k = 0; k < C; k++) {
					Wiimote wm = wiimotes[k];
					if (wm.pointDown()) {
						gameStart.setPlayerLabel(k, "OK");
					}
					else {
						gameStart.setPlayerLabel(k, "Point the remote down!");
						point = false;
					}
				}
				if (point) {
					if (counter == 0) {
						info = "Ready?";
					}
					counter++;
					if (counter == randNum) {
						counter = 0;
						info = "FIRE!";
						status = "RUN";

						for (int k = 0; k < C; k++) {
							playerTime[k] = 0;
							playerAngle[k] = "";
						}
					}
				}
				else {
					counter = 0;
					info = "Point the remotes downwards!";
				}
				break;
			case "RUN": // clock is ticking! quick! fire!
				boolean playersFired = true;

				for (int k = 0; k < C; k++) {
					double t = playerTime[k] / 1000.0;
					gameStart.setPlayerLabel(k, timeFormat.format(t));

					if (!playerFlag[k]) {
						playersFired = false;
						playerTime[k]++;

						Wiimote wm = wiimotes[k];
						String button = wm.getButton();
						if (button.equals("B")) {
							Mote m = wm.getMote();
							m.rumble(120l);
							playerFlag[k] = true;
							double a = -Math.toDegrees(wm.getPitch()); // convert pitch to degress
							playerAngle[k] = angleFormat.format(a); // then format

							if (!wm.pointAway()) {
								playersFired = true;
								playerTime[k] = 0;
								break;
							}
						}
					}
				}
				if (playersFired) {
					status = "RESULT";
					resetFlag();
				}
				break;
			case "RESULT": // end result
				int[] pt = playerTime;

				if (pt[0] == pt[1]) {
					info = "It's a tie!";
				}
				else if (pt[0] == 0) {
					info = "Player 1 shot the ground!";
				}
				else if (pt[1] == 0) {
					info = "Player 2 shot the ground!";
				}
				else if (pt[0] < pt[1]) {
					info = "Player 1 wins!";
				}
				else if (pt[1] < pt[0]) {
					info = "Player 2 wins!";
				}
				else {
					info = "Something went wrong.";
				}

				for (int k = 0; k < C; k++) {
					if (pt[k] == 0) {
						gameStart.setPlayerLabel(k, "DQ");
					}
				}
				cont(5, "PITCH");
				break;
			case "PITCH": // display pitch
				info = "Angle of shot";

				for (int k = 0; k < C; k++) {
					gameStart.setPlayerLabel(k, playerAngle[k]);
				}
				cont(5, "END");
				break;
			case "END": // endgame
				String s = "Press  +  to start a new game!";

				info = s;
				for (int k = 0; k < C; k++) {
					gameStart.setPlayerLabel(k, s);

					Wiimote wm = wiimotes[k];
					if (wm.getButton().equals("PLUS")) {
						status = "IDLE";
					}
				}
				break;
			default:
				break;
		}
		gameStart.setInfoLabel(info);
	}

	/**
	 * Adds a new Wii Remote.
	 * @param slot player slot
	 */
	public static void addWiimote(int slot) {
		wmFinder[slot] = new WiimoteFinder();
		Mote m = wmFinder[slot].findMote();

		boolean[] playerLeds = {false, false, false, false};
		playerLeds[slot] = true;
		m.setPlayerLeds(playerLeds);
		m.rumble(3000l);

		Wiimote wm = new Wiimote(m);
		wiimotes[slot] = wm;
	}

	/**
	 * Contine to next state.
	 * @param seconds the number of seconds to wait before continuing.
	 * @param s name of status.
	 */
	public static void cont(int seconds, String s) {
		counter++;
		if (counter == seconds * 1000) {
			counter = 0;
			status = s;
		}
	}

	/**
	 * Sets all indexes of playerFlag to false.
	 */
	public static void resetFlag() {
		for (int k = 0; k < C; k++) {
			playerFlag[k] = false;
		}
	}

	/**
	 * Get a random number.
	 * @return a number between 2000 to 5000 (I think)
	 */
	public static int randNum() {
		return (int)(Math.random() * 3000) + 2000;
	}

	/**
	 * Get the time for each player
	 * @return time it took to shoot if round is over
	 */
	public static int[] getTime() {
		if (status.equals("END")) {
			return playerTime;
		}
		return null;
	}

}
