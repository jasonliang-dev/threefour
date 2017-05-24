package threefour;

import java.util.ArrayList;
import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;

public class ExpertLamp {
	
	public static void main(String[] args) {
		
	}

	public static void demo(ArrayList<Mote> motes) throws InterruptedException {
		motejDemo.discoverRemote(motes);
		Mote P1 = motes.get(0);
		motejDemo.buttonDemo(P1);
		motejDemo.accelerometerDemo(P1);
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
