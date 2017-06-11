package threefour;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;


public class ScoreMenuFrame extends javax.swing.JFrame {
    
    UsersData gameData;
    int scoreSection = -1;
    int maxUsersShown = 10;
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); //used to center align the text in  jTable
    
    public ScoreMenuFrame() {
        initComponents();
        
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height = screenSize.height;
            int width = screenSize.width;
            this.setSize(700, 500);

            // here's the part where i center the jframe on screen
            this.setLocationRelativeTo(null);

            this.setVisible(true);
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            playerTimesTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            playerTimesTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            playerTimesTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prevButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerTimesTable = new javax.swing.JTable();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 500));
        setSize(new java.awt.Dimension(700, 500));

        prevButton.setText("Previous");
        prevButton.setEnabled(false);
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.setEnabled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        playerTimesTable.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        playerTimesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "", "Average Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(playerTimesTable);
        if (playerTimesTable.getColumnModel().getColumnCount() > 0) {
            playerTimesTable.getColumnModel().getColumn(0).setMinWidth(40);
            playerTimesTable.getColumnModel().getColumn(0).setMaxWidth(40);
            playerTimesTable.getColumnModel().getColumn(2).setMinWidth(100);
            playerTimesTable.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        returnButton.setText("Return to Main Menu");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(returnButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(returnButton)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prevButton)
                    .addComponent(nextButton))
                .addGap(0, 120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        scoreSection += maxUsersShown;
        prevButton.setEnabled(true);
        updateLists();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        scoreSection -= maxUsersShown;
        
        if (scoreSection == -1)
            prevButton.setEnabled(false);
        updateLists();
    }//GEN-LAST:event_prevButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_returnButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(ScoreMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ScoreMenuFrame scoreFrame = new ScoreMenuFrame();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int height = screenSize.height;
                int width = screenSize.width;
                scoreFrame.setSize(700, 400);

                // here's the part where i center the jframe on screen
                scoreFrame.setLocationRelativeTo(null);

                scoreFrame.setVisible(true);
            }
        });
    }
    
    public void updateLists() {
        
        if (gameData.players.size() > 0) {
            ArrayList<Player> temp = gameData.sortUsers();
            
            if (scoreSection + maxUsersShown < temp.size() - 1)
                nextButton.setEnabled(true);
            else 
                nextButton.setEnabled(false);
            
            for(int row = 0; row < playerTimesTable.getRowCount(); row++) {
                playerTimesTable.getModel().setValueAt("", row, 0);
                playerTimesTable.getModel().setValueAt("", row, 1);
                playerTimesTable.getModel().setValueAt("", row, 2);
            }
            

            for(int row = 0;(scoreSection+1)+row < temp.size() && row < playerTimesTable.getRowCount(); row++) {
                playerTimesTable.getModel().setValueAt((scoreSection + 2)+row, row, 0);
                playerTimesTable.getModel().setValueAt(temp.get((scoreSection+1)+row).getName(), row, 1);
                playerTimesTable.getModel().setValueAt(temp.get((scoreSection+1)+row).getAvg(), row, 2);
            }
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JTable playerTimesTable;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}
