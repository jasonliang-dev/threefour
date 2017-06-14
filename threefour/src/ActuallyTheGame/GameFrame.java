package ActuallyTheGame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends MainFrame {
	//add variable to keep track of state of game
	//to add the necessary components at each stage
	//ie. Before playing, during play, and after play
	mainGame G = new mainGame(this);
	
	JLabel infoLabel = new JLabel("Please connect the Wiimotes");
	JLabel player1Label = new JLabel("P1");
	JLabel player2Label = new JLabel("P2");
	JButton connectButton = new JButton("Connect");
	
	public GameFrame() {
		setup("background_blank.png");
		updateFrame();
	}
	
	public void addComponents() {
		//Represents general the x and y coordinates for all components
		int genYPos = (frameHeight / 2);
		int genXPos = (frameWidth / 2);
		
		infoLabel.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
		infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		infoLabel.setText("Please connect the Wiimotes");
		infoLabel.setBounds(genXPos-298, 25, 596, 50);
		
		player1Label.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
		player1Label.setText("P1");
		player1Label.setBounds(20, (genYPos*2)-80, 50, 50);
		
		player2Label.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
		player2Label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
		player2Label.setText("P2");
		player2Label.setBounds((genXPos*2)- 70, (genYPos*2)-80, 50, 50);
		
		connectButton.setBounds(20, 75, 85, 25);
		connectButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				connectButtonActionPerformed(evt);
			}
		});
		
		
		
		curPanel.add(infoLabel);
		curPanel.add(player1Label);
		curPanel.add(player2Label);
		curPanel.add(connectButton);
	}
	
	private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {
		connectButton.setVisible(false);
		for (int k = 0; k < 2; k++) {
			G.addWiimote(k);
		}
		G.startTimer();
	}

	public void setInfoLabel(String s) {
		infoLabel.setText(s);
	}
	
	public void setPlayerLabel(int slot, String s) {
		javax.swing.JLabel label;
		switch (slot) {
			case 0:
				label = player1Label;
				break;
			case 1:
				label = player2Label;
				break;
			default:
				return;
		}
		label.setText(s);
	}
	
	public void updateFrame() {
		
	}
	
	//REMOVE WHEN GAME IS FINISHED
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		* For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		*/
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(threefour.MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(threefour.MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(threefour.MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(threefour.MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GameFrame();
			}
		});
	}
}
