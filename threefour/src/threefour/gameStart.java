package threefour;

/**
 *
 * @author jason
 */
public class gameStart extends javax.swing.JFrame {

	int moteNum = mainGame.C;

	/**
	 * Creates new form gameStart
	 */
	public gameStart() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                infoLabel = new javax.swing.JLabel();
                player1Label = new javax.swing.JLabel();
                player2Label = new javax.swing.JLabel();
                connectButton = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                infoLabel.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
                infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoLabel.setText("Please connect the Wiimotes");

                player1Label.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
                player1Label.setText("P1");

                player2Label.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
                player2Label.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                player2Label.setText("P2");

                connectButton.setText("Connect");
                connectButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                connectButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(player1Label)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(player2Label))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(connectButton)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(infoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(connectButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(player1Label)
                                        .addComponent(player2Label))
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
		connectButton.setVisible(false);
		for (int k = 0; k < moteNum; k++) {
			mainGame.addWiimote(k);
		}
		mainGame.startTimer();
        }//GEN-LAST:event_connectButtonActionPerformed

	public static void setInfoLabel(String s) {
		infoLabel.setText(s);
	}
	
	public static void setPlayerLabel(int slot, String s) {
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

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set GTK theme */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("GTK+".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(gameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(gameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(gameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(gameStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new gameStart().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton connectButton;
        private static javax.swing.JLabel infoLabel;
        private static javax.swing.JLabel player1Label;
        private static javax.swing.JLabel player2Label;
        // End of variables declaration//GEN-END:variables
}
