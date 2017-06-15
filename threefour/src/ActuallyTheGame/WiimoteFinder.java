package ActuallyTheGame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;

public class WiimoteFinder implements MoteFinderListener {

	public Mote mote;

	private Logger log = LoggerFactory.getLogger(WiimoteFinder.class);
	private MoteFinder finder;
	private Object lock = new Object();

	@Override
	public void moteFound(Mote mote) {
		log.info("received notification of a found mote.");
		this.mote = mote;
		finder.removeMoteFinderListener(this);
		synchronized(lock) {
			lock.notifyAll();
		}
	}
	
	public Mote findMote() {
		if (finder == null) {
			finder = MoteFinder.getMoteFinder();
			finder.addMoteFinderListener(this);
		}
		finder.startDiscovery();
		try {
			synchronized(lock) {
				lock.wait();
			}
		} catch (InterruptedException ex) {
			log.error(ex.getMessage(), ex);
		}
		return mote;
	}

}