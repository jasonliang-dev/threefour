package threefour;

public class ExpertLamp {
	
	public static void main(String[] args) {
		int motesNum = 2;
		for (int k = 0; k < motesNum; k++) {
			mainGame.addWiimote(k);
		}
		while (true) {
			for (int k = 0; k < motesNum; k++) {
				System.out.println(mainGame.playersReady(motesNum, "AB"));
			}
		}
	}
}
