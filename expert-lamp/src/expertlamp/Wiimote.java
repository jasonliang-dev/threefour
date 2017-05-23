package expertlamp;
import java.util.ArrayList;
import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;
import motej.event.AccelerometerEvent;
import motej.event.AccelerometerListener;
import motej.event.CoreButtonEvent;
import motej.event.CoreButtonListener;
import motej.request.ReportModeRequest;

public class Wiimote {

	private int axisX  = 130;
	private int axisY  = 131;
	private int axisZ  = 152;
	Mote address = null;
	String button = "none";

	public int getAxisX() {
		return axisX;
	}

	public int getAxisY() {
		return axisY;
	}

	public int getAxisZ() {
		return axisZ;
	}
	
	public void discoverRemote() throws InterruptedException {
		MoteFinderListener listener = new MoteFinderListener() {
			
			@Override
			public void moteFound(Mote mote) {
				address = new Mote(mote.getBluetoothAddress());
				mote.rumble(2000l);
			}
			
		};
		
		MoteFinder finder = MoteFinder.getMoteFinder();
		finder.addMoteFinderListener(listener);
		
		finder.startDiscovery();
		Thread.sleep(15000l);
		finder.stopDiscovery();
	}
	
	public void buttonInput() {
		address.addCoreButtonListener(new CoreButtonListener() {
			
			@Override
			public void buttonPressed(CoreButtonEvent evt) {
				if (evt.isButtonAPressed() && evt.isButtonBPressed()) button = "AB";
				else if (evt.isButtonAPressed()) button = "A";
				else if (evt.isButtonBPressed()) button = "B";
				else if (evt.isNoButtonPressed()) button = "none";
			}
			
		});
	}
	
	public void accelerationInput() throws InterruptedException {
		AccelerometerListener listener = new AccelerometerListener() {
			
			public void accelerometerChanged(AccelerometerEvent evt) {
				axisX = evt.getX();
				axisY = evt.getY();
				axisZ = evt.getZ();
			}
			
		};
		
		address.addAccelerometerListener(listener);
		address.setReportMode(ReportModeRequest.DATA_REPORT_0x31);
		
		Thread.sleep(30000l);
		
	}
	
}
