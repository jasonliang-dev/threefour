package expertlamp;

import java.util.ArrayList;
import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;
import motej.event.AccelerometerEvent;
import motej.event.AccelerometerListener;
import motej.request.ReportModeRequest;

public class motejDemo {

	public static void discoverRemote(ArrayList motes) throws InterruptedException {
		MoteFinderListener listener = new MoteFinderListener() {
			
			@Override
			public void moteFound(Mote mote) {
				System.out.println("Found mote: " + mote.getBluetoothAddress());
				mote.rumble(2000l);
				motes.add(mote);
			}
			
		};
		
		MoteFinder finder = MoteFinder.getMoteFinder();
		finder.addMoteFinderListener(listener);
		
		finder.startDiscovery();
		Thread.sleep(30000l);
		finder.stopDiscovery();
	}
	
	public static void accelerometerDemo(Mote mote) throws InterruptedException {
		AccelerometerListener listener = new AccelerometerListener() {
			
			public void accelerometerChanged(AccelerometerEvent evt) {
				System.out.println(evt.getX() + " : " + evt.getY() + " : " + evt.getZ());
			}
			
		};
		
		mote.addAccelerometerListener(listener);
		mote.setReportMode(ReportModeRequest.DATA_REPORT_0x31);
		
		Thread.sleep(60000l);
		
		mote.setReportMode(ReportModeRequest.DATA_REPORT_0x30);
		mote.disconnect();
	}	
}
