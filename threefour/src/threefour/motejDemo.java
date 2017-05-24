package threefour;

import java.util.ArrayList;
import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;
import motej.event.AccelerometerEvent;
import motej.event.AccelerometerListener;
import motej.event.CoreButtonEvent;
import motej.event.CoreButtonListener;
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
	
	public static void buttonDemo(Mote mote) {
		mote.addCoreButtonListener(new CoreButtonListener() {
			
			@Override
			public void buttonPressed(CoreButtonEvent evt) {
				if (evt.isButtonAPressed()) System.out.println("Button A pressed!");
				if (evt.isButtonBPressed()) System.out.println("Button B pressed!");
				if (evt.isNoButtonPressed()) System.out.println("No button pressed.");
			}
			
		});
	}
	
	public static void accelerometerDemo(Mote mote) throws InterruptedException {
		AccelerometerListener listener = new AccelerometerListener() {
			
			public void accelerometerChanged(AccelerometerEvent evt) {
				String x = Integer.toHexString(evt.getX());
				String y = Integer.toHexString(evt.getY());
				String z = Integer.toHexString(evt.getZ());
				System.out.println(x + " : " + y + " : " + z);
			}
			
		};
		
		mote.addAccelerometerListener(listener);
		mote.setReportMode(ReportModeRequest.DATA_REPORT_0x31);
		
		Thread.sleep(30000l);
		
		mote.setReportMode(ReportModeRequest.DATA_REPORT_0x30);
		mote.disconnect();
	}
	
}
