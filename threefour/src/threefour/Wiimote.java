package threefour;

import motej.Mote;
import motej.event.AccelerometerEvent;
import motej.event.AccelerometerListener;
import motej.event.CoreButtonEvent;
import motej.event.CoreButtonListener;
import motej.request.ReportModeRequest;

public class Wiimote {

	public Mote mote = null;

	private int axisX  = 130;
	private int axisY  = 131;
	private int axisZ  = 152;
	private String button = "none";

	public Wiimote(Mote m) {
		mote = m;
	}
	
	public void accelerationInput() throws InterruptedException {
		AccelerometerListener listener = new AccelerometerListener() {
			
			public void accelerometerChanged(AccelerometerEvent evt) {
				axisX = evt.getX();
				axisY = evt.getY();
				axisZ = evt.getZ();
			}
			
		};
		
		mote.addAccelerometerListener(listener);
		mote.setReportMode(ReportModeRequest.DATA_REPORT_0x31);
	}

	public void buttonInput() {
		CoreButtonListener listener = new CoreButtonListener() {
			
			@Override
			public void buttonPressed(CoreButtonEvent evt) {
				if (evt.isButtonAPressed() && evt.isButtonBPressed()) button = "AB";
				else if (evt.isButtonAPressed()) button = "A";
				else if (evt.isButtonBPressed()) button = "B";
				else if (evt.isNoButtonPressed()) button = "none";
			}
			
		};

		mote.addCoreButtonListener(listener);
	}
	
	public int getAxisX() {
		return axisX;
	}

	public int getAxisY() {
		return axisY;
	}

	public int getAxisZ() {
		return axisZ;
	}

	public String getButton() {
		return button;
	}

}
