package expertlamp;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import motej.Mote;

public class ExpertLamp {
	
	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<Mote> wiimotes = new ArrayList<>();

		Wiimote P1 = new Wiimote();
		P1.discoverRemote();
		
		//mote.setReportMode(ReportModeRequest.DATA_REPORT_0x30);
		//mote.disconnect();
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
