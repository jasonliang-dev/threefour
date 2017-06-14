package ActuallyTheGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import threefour.ContentPanel;
import threefour.PlayerSelectionFrame;

public class MainMenuFrame extends MainFrame {
    
    MainMenuFrame(int width, int height) {
        super(width, height);
        mainMenuFrame = this;
        gameData.importData();
        setup("background_main.png");
    }
    
    public void addComponents() {
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
        
        curPanel.add(play);
        curPanel.add(ranking);
    }
    
    private void playActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        PlayersSelectFrame playersSelect = new PlayersSelectFrame(frameWidth, frameHeight);
        this.setVisible(false);
    }
    
    private void rankingActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        RankingFrame rankingFrame = new RankingFrame(frameWidth, frameHeight);
        this.setVisible(false);
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
                new MainMenuFrame(1024, 768);
            }
        });
    }
    
}
