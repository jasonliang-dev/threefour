package ActuallyTheGame;

import static ActuallyTheGame.MainFrame.gameData;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayersSelectFrame extends MainFrame {

    private String p1Name = null;
    private String p2Name = null;

    private JButton setNameButton = new JButton("Set Name");
    private JTextField player1Text = new JTextField();
    private JTextField player2Text = new JTextField();
    private Choice names1Choice = new Choice();
    private Choice names2Choice = new Choice();
    private JLabel p1Label = new JLabel("Player 1");
    private JLabel p2Label = new JLabel("Player 2");

    public PlayersSelectFrame() {
        setup("background_blank.png");
        updateFrame();
    }

    public void addComponents() {
        //Represents general the x and y coordinates for all components
        int genYPos = (frameHeight / 2)-40;
        int genXPos = (frameWidth / 2);

        setNameButton.setBounds(genXPos - 45, genYPos + 50, 90, 25);
        setNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setNameButtonActionPerformed(evt);
            }
        });

        names1Choice.setBounds(genXPos-110, genYPos - 95, 20, 15);
        names1Choice.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                names1ChoiceItemStateChanged(evt);
            }
        });

        names2Choice.setBounds(genXPos+270,genYPos-95, 20, 15);
        names2Choice.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                names2ChoiceItemStateChanged(evt);
            }
        });
        names2Choice.setEnabled(false);
        
        player1Text.setBounds(genXPos-265, genYPos - 100, 150, 25);
        player2Text.setBounds(genXPos+115, genYPos-100, 150, 25);
        
        p1Label.setBounds(genXPos-265, genYPos - 125, 150, 25);
        p1Label.setForeground(Color.WHITE);
        p1Label.setFont(new Font("SansSerif", Font.BOLD, 12));
        p2Label.setBounds(genXPos+115, genYPos-125, 150, 25);
        p2Label.setForeground(Color.WHITE);
        p1Label.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        player2Text.setEnabled(false);

        curPanel.add(setNameButton);
        curPanel.add(player1Text);
        curPanel.add(player2Text);
        curPanel.add(names1Choice);
        curPanel.add(names2Choice);
        curPanel.add(p1Label);
        curPanel.add(p2Label);
    }

    private void setNameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (p1Name == null) {
            if ((gameData.addUser(player1Text.getText())) || (gameData.nameSelected(player2Text.getText()) < 1)) {
                p1Name = player1Text.getText();
                gameData.setCurUser(p1Name);

                names1Choice.setEnabled(false);
                player1Text.setEnabled(false);
                names2Choice.setEnabled(true);
                player2Text.setEnabled(true);

                try {
                    names2Choice.remove(p1Name);
                } catch (Exception e) {

                }

            } else {
                player1Text.setText("Invalid name");
            }
        } else if (p2Name == null) {
            if ((gameData.addUser(player2Text.getText())) || (gameData.nameSelected(player2Text.getText()) < 1)) {
                p2Name = player2Text.getText();
                gameData.setCurUser(p2Name);

                names2Choice.setEnabled(false);
                player2Text.setEnabled(false);

                setNameButton.setText("Continue");
                GameFrame game = new GameFrame();
                this.dispose();
            } else {
                player2Text.setText("Invalid name");
            }
        } else {

        }
    }

    private void names1ChoiceItemStateChanged(java.awt.event.ItemEvent evt) {
        player1Text.setText(names1Choice.getSelectedItem());
    }

    private void names2ChoiceItemStateChanged(java.awt.event.ItemEvent evt) {
        player2Text.setText(names2Choice.getSelectedItem());
    }

    @Override
    public void updateFrame() {
        for (String name : gameData.storedNames) {
            names1Choice.add(name);
            names2Choice.add(name);
        }
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
                new PlayersSelectFrame();
            }
        });
    }
}
