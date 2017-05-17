package expertlamp;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import motej.Mote;

public class ExpertLamp {
	
	public static void main(String[] args) {

		ArrayList<Mote> wiimotes = new ArrayList<>();

		try {
			motejDemo.discoverRemote(wiimotes);
			Mote P1 = wiimotes.get(0);
			motejDemo.buttonDemo(P1);
			motejDemo.accelerometerDemo(P1);
		} catch (InterruptedException ex) {
			Logger.getLogger(ExpertLamp.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	
	public static void what() throws InterruptedException {
		long p = System.nanoTime();
		Thread.sleep(1000);
		long q = System.nanoTime();
		long T1 = (q-p);
		System.out.println(T1);
		
		long a = System.nanoTime();
		Thread.sleep(999);
		long b = System.nanoTime();
		long T2 = (b-a);
		System.out.println(T2);
		
		System.out.println((T2-T1)/1000000);
	}
	
}
