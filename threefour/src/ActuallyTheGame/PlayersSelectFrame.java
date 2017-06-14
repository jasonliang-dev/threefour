package ActuallyTheGame;

import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayersSelectFrame extends MainFrame {
    
    String p1Name = null;
    String p2Name = null;
    
    JButton setNameButton = new JButton("Set Name");
    JTextField player1Text = new JTextField();;
    JTextField player2Text = new JTextField();;
    Choice names1Choice = new Choice();
    Choice names2Choice = new Choice();
    
    public PlayersSelectFrame(int width, int height) {
        super(width, height);
        setup("background_blank.png");
        updateFrame();
    }
    
    public void addComponents() {
        setNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setNameButtonActionPerformed(evt);
            }
        });
        setNameButton.setBounds(150, 140, 90, 25);
        
        player1Text.setBounds(15, 50, 100, 25);
        player2Text.setBounds(250, 50, 100, 25);
        player2Text.setEnabled(false);
        
        names1Choice.setBounds(120, 58, 20, 15);
        names1Choice.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                names1ChoiceItemStateChanged(evt);
            }
        });
        
        names2Choice.setBounds(355, 58, 20, 15);
        names2Choice.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                names2ChoiceItemStateChanged(evt);
            }
        });
        names2Choice.setEnabled(false);
        
        curPanel.add(setNameButton);
        curPanel.add(player1Text);
        curPanel.add(player2Text);
        curPanel.add(names1Choice);
        curPanel.add(names2Choice);
    }
    
    private void setNameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(p1Name == null) {
            if( ( gameData.addUser(player1Text.getText()) ) || ( gameData.nameSelected(player1Text.getText()) == 1 ) ) {
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
            if( ( gameData.addUser(player2Text.getText()) ) || ( gameData.nameSelected(player2Text.getText()) == 1) ) {
                p2Name = player2Text.getText();
                gameData.setCurUser(p2Name);

                names2Choice.setEnabled(false);
                player2Text.setEnabled(false);
                
                setNameButton.setText("Continue");
            } else {
                player2Text.setText("Invalid name");
            }
        } else {
            GameFrame game = new GameFrame(frameWidth, frameHeight);
            this.setVisible(false);
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
        for(String name : gameData.storedNames) {
            names1Choice.add(name);
            names2Choice.add(name);
        }
    }
}
