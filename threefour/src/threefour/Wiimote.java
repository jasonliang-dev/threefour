package threefour;

import motej.Mote;
import motej.event.AccelerometerEvent;
import motej.event.AccelerometerListener;
import motej.event.CoreButtonEvent;
import motej.event.CoreButtonListener;
import motej.request.ReportModeRequest;

public class Wiimote {

	private final Mote mote;

	private final AccelerometerListener accelListener;
	private final CoreButtonListener buttonListener;

	private int[] axis = {130, 131, 152};
	private String button = "none";

	public Wiimote(Mote mote) {
		this.mote = mote;
		this.accelListener = new AccelerometerListener() {

			@Override
			public void accelerometerChanged(AccelerometerEvent evt) {
				axis[0] = evt.getX();
				axis[1] = evt.getY();
				axis[2] = evt.getZ();
			}
		};
		this.buttonListener = new CoreButtonListener() {

			@Override
			public void buttonPressed(CoreButtonEvent evt) {
				if (evt.isButtonAPressed() && evt.isButtonBPressed()) button = "AB";
				else if (evt.isButtonAPressed()) button = "A";
				else if (evt.isButtonBPressed()) button = "B";
				else if (evt.isNoButtonPressed()) button = "none";
			}
		};
	}
	
	public void addButtonListener() {
		mote.addCoreButtonListener(buttonListener);
	}

	public void addAccelListener() {
		mote.addAccelerometerListener(accelListener);
		mote.setReportMode(ReportModeRequest.DATA_REPORT_0x31);
	}

	public void removeButtonListener() {
		mote.removeCoreButtonListener(buttonListener);
	}

	public void removeAccelListener() {
		mote.setReportMode(ReportModeRequest.DATA_REPORT_0x30);
		mote.removeAccelerometerListener(accelListener);
	}
	
	public int getAxisX() {
		return axis[0];
	}

	public int getAxisY() {
		return axis[1];
	}

	public int getAxisZ() {
		return axis[2];
	}

	public String getButton() {
		return button;
	}

	public Mote getMote() {
		return mote;
	}

	@Override
	public String toString() {
		return mote.toString();
	}
}
