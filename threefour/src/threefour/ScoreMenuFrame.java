package threefour;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class ScoreMenuFrame extends javax.swing.JFrame {
    
    UsersData gameData;
    int scoreSection = -1;
    int maxUsersShown = 10;
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); //used to center align the text in  jTable
    UsersData gamesData;
    
    JButton returnButton = new JButton("Main Menu");
    JButton prevButton = new JButton("Prev");
    JButton nextButton = new JButton("Next");
    
    JScrollPane defaultScrollPane = new JScrollPane();
    JTable playerTimesTable = new JTable();
    
    
    public ScoreMenuFrame() throws IOException {
        initComponents();
        
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height = screenSize.height;
            int width = screenSize.width;
            this.setSize(400, 400);
            
            String currentDirectory = System.getProperty("user.dir");
            String fullFileName = currentDirectory + "/background.png";

            BufferedImage myImage = ImageIO.read(new File(fullFileName));
            this.setContentPane(new ContentPanel(myImage));

            returnButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    returnButtonActionPerformed(evt);
                }
            });
            returnButton.setBounds(10, 10, 100, 25);
            
            prevButton.setBounds(10, 320, 100, 25);
            prevButton.setEnabled(false);
            prevButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    prevButtonActionPerformed(evt);
                }
            });
            
            nextButton.setBounds(290, 320, 100, 25);
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
            
            defaultScrollPane.setViewportView(playerTimesTable);
                if (playerTimesTable.getColumnModel().getColumnCount() > 0) {
                    playerTimesTable.getColumnModel().getColumn(0).setMinWidth(40);
                    playerTimesTable.getColumnModel().getColumn(0).setMaxWidth(40);
                    playerTimesTable.getColumnModel().getColumn(2).setMinWidth(100);
                    playerTimesTable.getColumnModel().getColumn(2).setMaxWidth(100);
            }
            defaultScrollPane.setBounds(10, 75, 380, 200);
            
            /*centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            playerTimesTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            playerTimesTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            playerTimesTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            */
            
            this.add(returnButton);
            this.add(nextButton);
            this.add(prevButton);
            this.add(defaultScrollPane);
            
            // here's the part where i center the jframe on screen
            this.setLocationRelativeTo(null);
            this.setLayout(null);
            this.setVisible(true);

                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prev = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerTimes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(700, 500));

        prev.setText("Previous");
        prev.setEnabled(false);
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        next.setText("Next");
        next.setEnabled(false);
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        playerTimes.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        playerTimes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(playerTimes);
        if (playerTimes.getColumnModel().getColumnCount() > 0) {
            playerTimes.getColumnModel().getColumn(0).setMinWidth(40);
            playerTimes.getColumnModel().getColumn(0).setMaxWidth(40);
            playerTimes.getColumnModel().getColumn(2).setMinWidth(100);
            playerTimes.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prev)
                    .addComponent(next))
                .addGap(0, 120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
    }
    
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {                                     
        scoreSection += maxUsersShown;
        prevButton.setEnabled(true);
        updateLists();
    }
    
    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {                                     
        scoreSection -= maxUsersShown;
        
        if (scoreSection == -1)
            prevButton.setEnabled(false);
        updateLists();
    }
    
    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        scoreSection += maxUsersShown;
        prev.setEnabled(true);
        updateLists();
    }//GEN-LAST:event_nextActionPerformed

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
        scoreSection -= maxUsersShown;
        
        if (scoreSection == -1)
            prev.setEnabled(false);
        updateLists();
    }//GEN-LAST:event_prevActionPerformed

    public void updateLists() {
        
        if (gameData.players.size() > 0) {
            /*
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
            }*/
            
        }
    }
    
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
                try {
                    new ScoreMenuFrame();
                } catch (IOException ex) {
                    Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton next;
    private javax.swing.JTable playerTimes;
    private javax.swing.JButton prev;
    // End of variables declaration//GEN-END:variables
}
