package ActuallyTheGame;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import motej.Mote;

public class mainGame {
	// there are two players
	final int C = 2;

	GameFrame frame;
        UsersData gameData;

	TimerTask clock; // for step method
	String status = "IDLE"; // state of the game
	String info = ""; // info text

	WiimoteFinder[] wmFinder = new WiimoteFinder[C];
	Wiimote[] wiimotes = new Wiimote[C];

        ArrayList<Player> players = gameData.selectedPlayers;
        String p1Name = players.get(0).getName();
        String p2Name = players.get(1).getName();

	boolean[] playerFlag = {false, false};
	int[] playerTime = {0, 0};
	String[] playerAngle = {"", ""};

	DecimalFormat timeFormat = new DecimalFormat("0.000"); // stop the labels from jumping around
	DecimalFormat angleFormat = new DecimalFormat("0.0"); // too many decimals. remove them.


	int counter = 0;
	int randNum = randNum();

	public mainGame(GameFrame f, UsersData gameData) {
		frame = f;
                this.gameData = gameData;
	}

	/**
	 * create and start a new timer
	 * the step method will be called every millisecond-ish.
	 */
	public void startTimer() {
		clock = new TimerTask() {
			@Override
			public void run() {
				step();
			}
		};
		Timer time = new Timer();
		time.schedule(clock, 1, 1);
	}

	/**
	 * Oh man this is huge and big and huge and big and- okay I think you get it.
	 * this method runs every millisecond(-ish).
	 */
	public void step() {
		// TODO: audio

		switch (status) {
			case "IDLE": // new game
				boolean ready = true;

				for (int k = 0; k < C; k++) {
					if (playerFlag[k]) {
						frame.setPlayerLabel(k, "OK");
					}
					else {
						ready = false;
						frame.setPlayerLabel(k, "Waiting...");

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
					randNum = randNum();
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
						frame.setPlayerLabel(k, "OK");
					}
					else {
						frame.setPlayerLabel(k, "Point the remote down!");
						point = false;
					}
				}
				if (point) {
					if (counter == 0) {
						info = "Ready?";
					}
					counter++;
					if (counter == 800) {
						new soundPlayer("ready.wav");
					}
					if (counter == randNum) {
						counter = 0;
						info = "FIRE!";
						status = "RUN";
						new soundPlayer("go.wav");

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
					frame.setPlayerLabel(k, timeFormat.format(t));

					if (!playerFlag[k]) {
						playersFired = false;
						playerTime[k]++;

						Wiimote wm = wiimotes[k];
						String button = wm.getButton();
						if (button.equals("B")) {
							new soundPlayer("gunshot.wav");
							Mote m = wm.getMote();
							m.rumble(120l);
							playerFlag[k] = true;
							double a = -Math.toDegrees(wm.getPitch()); // convert pitch to degress
							playerAngle[k] = angleFormat.format(a); // then format

							if (!wm.pointAway()) {
								playersFired = true;
								playerTime[k] = 0;
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
                                recordTimes();

				if (pt[0] == pt[1]) {
					info = "It's a tie!";
				}
				else if (pt[0] == 0) {
					info = p1Name + " shot the ground!";
				}
				else if (pt[1] == 0) {
					info = p2Name + " shot the ground!";
				}
				else if (pt[0] < pt[1]) {
					info = p1Name + " wins!";
				}
				else if (pt[1] < pt[0]) {
					info = p2Name + " wins!";
				}
				else {
					info = "Something went wrong.";
				}

				for (int k = 0; k < C; k++) {
					if (pt[k] == 0) {
						frame.setPlayerLabel(k, "DQ");
					}
				}
				cont(4, "PITCH");
				break;
			case "PITCH": // display pitch
				info = "Angle of shot";

				for (int k = 0; k < C; k++) {
					frame.setPlayerLabel(k, playerAngle[k]);
				}
				cont(3, "END");
				break;
			case "END": // endgame
				info = "Press  +  to start a new game or - to go to main menu!";

				for (int k = 0; k < C; k++) {
					frame.setPlayerLabel(k, "");
                                        gameData.exportData();
                                        
					Wiimote wm = wiimotes[k];
					if (wm.getButton().equals("PLUS")) {
						status = "IDLE";
					}
					else if (wm.getButton().equals("MINUS")) {
						frame.restartGame();
					}
				}
				break;
			default:
				break;
		}
		frame.setInfoLabel(info);
	}

	/**
	 * Adds a new Wii Remote.
	 * @param slot player slot
	 */
	public void addWiimote(int slot) {
		wmFinder[slot] = new WiimoteFinder();
		Mote m = wmFinder[slot].findMote();

		boolean[] playerLeds = {false, false, false, false};
		playerLeds[slot] = true;
		m.setPlayerLeds(playerLeds);

		Wiimote wm = new Wiimote(m);
		wiimotes[slot] = wm;
	}

	/**
	 * Continue to next state.
	 * @param seconds the number of seconds to wait before continuing.
	 * @param s name of status.
	 */
	public void cont(int seconds, String s) {
		counter++;
		if (counter == seconds * 1000) {
			counter = 0;
			status = s;
		}
	}

	/**
	 * Sets all indexes of playerFlag to false.
	 */
	public void resetFlag() {
		for (int k = 0; k < C; k++) {
			playerFlag[k] = false;
		}
	}

	/**
	 * Get a random number.
	 * @return a number between 2000 to 5000 (I think)
	 */
	public int randNum() {
		return (int)(Math.random() * 3000) + 2000;
	}

	/**
	 * Get the time for each player
	 * @return time it took to shoot if round is over
	 */
	public int[] getTime() {
		if (status.equals("END")) {
			return playerTime;
		}
		return null;
	}
    
        /**
        * Records the reaction times of each player 
        */
        public void recordTimes() {
            players.get(0).addTime(playerTime[0]);
            players.get(1).addTime(playerTime[1]);
        }
}
