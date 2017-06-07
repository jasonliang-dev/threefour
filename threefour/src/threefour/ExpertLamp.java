package threefour;

public class ExpertLamp {
	
	public static void main(String[] args) {
		int motesNum = 1;
		for (int k = 0; k < motesNum; k++) {
			mainGame.addWiimote(k);
		}
		while (true) {
			for (int k = 0; k < motesNum; k++) {
				int[] motion = mainGame.wiimotes[k].getMotion();
				for (int i = 0; i < motion.length; i++) {
					double m = (motion[i] - 128) / 2.448979592;
					System.out.print(m + ", ");
				}
				double pitch = mainGame.wiimotes[k].getPitch();
				System.out.println(pitch);
			}
		}
	}
}
