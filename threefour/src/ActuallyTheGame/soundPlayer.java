package ActuallyTheGame;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioStream;
import sun.audio.AudioPlayer;

public class soundPlayer {

	public soundPlayer(String s) {
		// get the working directory
		String pwd = System.getProperty("user.dir");

		try {
			InputStream in = new FileInputStream(pwd + "/sounds/" + s);
			AudioStream audioStream = new AudioStream(in);
			AudioPlayer.player.start(audioStream);
		} catch (IOException ex) {
			Logger.getLogger(soundPlayer.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
