/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threefour;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class MainMenuFrame extends javax.swing.JFrame {

    UsersData gameData = new UsersData();
    FileHandler filer = gameData.filer;

    public MainMenuFrame() throws IOException {
        initComponents();

        /*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        */
        this.setSize(1024, 768);

        String currentDirectory = System.getProperty("user.dir");
        String fullFileName = currentDirectory + "/background_main.png";

        BufferedImage myImage = ImageIO.read(new File(fullFileName));
        this.setContentPane(new ContentPanel(myImage));
        
        JButton play = new JButton("Play");
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    playActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton ranking = new JButton();
        ranking.setText("Ranking");
        ranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    rankingActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        play.setBounds(25, 50, 75, 25);
        ranking.setBounds(285, 50, 85, 25);

        this.add(play);
        this.add(ranking);

        gameData.importData();

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

        rankingButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 600));
        setSize(new java.awt.Dimension(600, 450));

        rankingButton.setText("Ranking");
        rankingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(469, Short.MAX_VALUE)
                .addComponent(rankingButton)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addComponent(rankingButton)
                .addGap(128, 128, 128))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rankingActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        ScoreMenuFrame rankingFrame = new ScoreMenuFrame();
        rankingFrame.gameData = gameData;
        rankingFrame.updateLists();
        rankingFrame.setVisible(true);
    }

    private void rankingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingButtonActionPerformed
        /*ScoreMenuFrame menu = new ScoreMenuFrame();
        menu.gameData = gameData;
        menu.updateLists();
        menu.setVisible(true);
         */
    }//GEN-LAST:event_rankingButtonActionPerformed

    private void playActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        PlayerSelectionFrame menu = new PlayerSelectionFrame();
        menu.gameData = gameData;
        menu.updateLists();
        menu.setVisible(true);
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
            java.util.logging.Logger.getLogger(MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainMenuFrame();
                } catch (IOException ex) {
                    Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton rankingButton;
    // End of variables declaration//GEN-END:variables
}
