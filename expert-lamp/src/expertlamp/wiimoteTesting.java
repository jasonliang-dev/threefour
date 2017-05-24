package expertlamp;

import java.util.ArrayList;
import motej.Mote;
import motej.MoteFinder;
import motej.MoteFinderListener;

public class wiimoteTesting extends javax.swing.JFrame {

	static ArrayList<Mote> motes = new ArrayList<>();
	static MoteFinder finder = MoteFinder.getMoteFinder();

	/**
	 * Creates new form wiimoteTesting
	 */
	public wiimoteTesting() {
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

                disconnectButton = new javax.swing.JButton();
                discoverButton = new javax.swing.JToggleButton();
                runButton = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                disconnectButton.setText("Disconnect");
                disconnectButton.setEnabled(false);
                disconnectButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                disconnectButtonActionPerformed(evt);
                        }
                });

                discoverButton.setText("Discover");
                discoverButton.setEnabled(false);
                discoverButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                discoverButtonActionPerformed(evt);
                        }
                });

                runButton.setText("Run");
                runButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                runButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(runButton)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(discoverButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(disconnectButton)))
                                .addContainerGap(214, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(runButton)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(discoverButton)
                                        .addComponent(disconnectButton))
                                .addContainerGap(225, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void discoverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discoverButtonActionPerformed
		if (discoverButton.isSelected()) {
			finder.startDiscovery();
		}
		else {
			finder.stopDiscovery();
		}
        }//GEN-LAST:event_discoverButtonActionPerformed

        private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
		MoteFinderListener listener = FinderListener();
		finder.addMoteFinderListener(listener);
		discoverButton.setEnabled(true);
		disconnectButton.setEnabled(true);
        }//GEN-LAST:event_runButtonActionPerformed

        private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
		for (Mote m : motes) {
			m.rumble(1000l);
			m.disconnect();
		}
        }//GEN-LAST:event_disconnectButtonActionPerformed

	public static MoteFinderListener FinderListener() {
		MoteFinderListener listener = new MoteFinderListener() {
			
			@Override
			public void moteFound(Mote mote) {
				mote.rumble(2000l);
				motes.add(mote);
			}
			
		};
		
		return listener;
	}
	
	/**
	 * @param args the command line arguments
	 */
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
			java.util.logging.Logger.getLogger(wiimoteTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(wiimoteTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(wiimoteTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(wiimoteTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new wiimoteTesting().setVisible(true);
			}
		});

	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton disconnectButton;
        private javax.swing.JToggleButton discoverButton;
        private javax.swing.JButton runButton;
        // End of variables declaration//GEN-END:variables
}