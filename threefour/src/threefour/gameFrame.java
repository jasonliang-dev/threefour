/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threefour;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author calvin
 */
public class gameFrame extends javax.swing.JFrame {

    UsersData gameData = new UsersData();
    int scoreSection = -1;
    FileHandler filer = new FileHandler();

    public gameFrame() {
        initComponents();
        
        filer.readFile(gameData);
        updateLists();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataButton = new javax.swing.JButton();
        namesList = new java.awt.List();
        avgTimeList = new java.awt.List();
        pNameText = new javax.swing.JTextField();
        addPlayerButton = new javax.swing.JButton();
        allNamesList = new java.awt.List();
        selectText = new javax.swing.JTextField();
        curPlayerButton = new javax.swing.JButton();
        curNameText = new javax.swing.JTextField();
        curPlayerTimeList = new java.awt.List();
        removeButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        timeText = new javax.swing.JTextField();
        addTimeButton = new javax.swing.JButton();
        curPlayersList = new java.awt.List();
        nextPlayerButton = new javax.swing.JButton();
        selectedPlayerText = new javax.swing.JTextField();
        prevButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        scoreScreenButton = new javax.swing.JButton();
        writeFileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(680, 385));

        dataButton.setText("Generate Data");
        dataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataButtonActionPerformed(evt);
            }
        });

        addPlayerButton.setText("Add Player");
        addPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerButtonActionPerformed(evt);
            }
        });

        allNamesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allNamesListMouseClicked(evt);
            }
        });

        selectText.setEditable(false);
        selectText.setText("Select from 1st List");

        curPlayerButton.setText("Set Player");
        curPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curPlayerButtonActionPerformed(evt);
            }
        });

        curNameText.setEditable(false);

        removeButton.setText("Remove Player");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset Times");
        resetButton.setEnabled(false);
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        addTimeButton.setText("Add Time");
        addTimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTimeButtonActionPerformed(evt);
            }
        });

        nextPlayerButton.setText("Next Player");
        nextPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPlayerButtonActionPerformed(evt);
            }
        });

        prevButton.setText("Previous");
        prevButton.setEnabled(false);
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        scoreScreenButton.setText("Score Screen");
        scoreScreenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreScreenButtonActionPerformed(evt);
            }
        });

        writeFileButton.setText("Save To File");
        writeFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addPlayerButton)
                                .addGap(31, 31, 31)
                                .addComponent(pNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(timeText, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(curNameText, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectText, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(curPlayerButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(removeButton)
                                            .addComponent(resetButton)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(addTimeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(allNamesList, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(curPlayersList, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nextPlayerButton)
                            .addComponent(selectedPlayerText, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namesList, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prevButton))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(avgTimeList, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(curPlayerTimeList, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nextButton))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scoreScreenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(writeFileButton)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(curPlayerTimeList, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(avgTimeList, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                        .addComponent(namesList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(allNamesList, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(removeButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dataButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addPlayerButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(selectText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(curPlayerButton))
                                .addGap(18, 18, 18)
                                .addComponent(curNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(resetButton)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addTimeButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(curPlayersList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextPlayerButton)
                            .addComponent(prevButton)
                            .addComponent(nextButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectedPlayerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scoreScreenButton)
                            .addComponent(writeFileButton))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void updateLists() {
        namesList.removeAll();
        avgTimeList.removeAll();
        allNamesList.removeAll();
        curPlayerTimeList.removeAll();
        curPlayersList.removeAll();

        if (gameData != null && gameData.players.size() > 0) {
            ArrayList<Player> temp = gameData.sortUsers();
            
            for (String n : gameData.usedNames) {
                allNamesList.add(n);
            }
            
            if (scoreSection + 5 < temp.size() - 5)
                nextButton.setEnabled(true);
            else 
                nextButton.setEnabled(false);
            
            for (int i = scoreSection+1; i < scoreSection+6; i++) {
                namesList.add(temp.get(i).getName());
                avgTimeList.add(String.valueOf(temp.get(i).getAvg()));
            }
            
            if (gameData.curPlayer != null) {
                for (Integer t : gameData.curPlayer.sortTimes()) {
                    curPlayerTimeList.add(String.valueOf(t) + "ms");
                }
            }
            
            for (Player p : gameData.selectedPlayers) {
                curPlayersList.add(p.getName());
            }
        }
    }
    
    private void dataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataButtonActionPerformed
        String[] names = new String[]{"Bob", "Sam", "Jim", "Sammy", "A", "B", "C", "D", "E", "F"};

        for (int i = 0; i < 10; i++) {
            ArrayList temp = new ArrayList();

            temp.add((int) (Math.random() * 901) + 100);
            temp.add((int) (Math.random() * 901) + 100);
            temp.add((int) (Math.random() * 901) + 100);
            temp.add((int) (Math.random() * 901) + 100);

            gameData.addUser(names[i], temp);
        }

        updateLists();
    }//GEN-LAST:event_dataButtonActionPerformed

    private void addPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerButtonActionPerformed
        String name = pNameText.getText();

        boolean addedPlayer = gameData.addUser(name);

        if (addedPlayer != true) {
            pNameText.setText("Name already used");
        }
        updateLists();
    }//GEN-LAST:event_addPlayerButtonActionPerformed

    private void allNamesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allNamesListMouseClicked
        String selected = allNamesList.getSelectedItem();

        selectText.setText(selected);
    }//GEN-LAST:event_allNamesListMouseClicked

    private void curPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curPlayerButtonActionPerformed
        String name = selectText.getText();
        gameData.setCurUser(name);
        selectedPlayerText.setText(gameData.curPlayer.getName());
        
        removeButton.setEnabled(true);
        resetButton.setEnabled(true);
        updateLists();

    }//GEN-LAST:event_curPlayerButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

        updateLists();
        removeButton.setEnabled(false);
    }//GEN-LAST:event_removeButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        gameData.curPlayer.clearTimes(); //NOT MOST EFFECTIVE
        updateLists();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void addTimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTimeButtonActionPerformed
        gameData.curPlayer.addTime(Integer.parseInt(timeText.getText()));
        updateLists();
    }//GEN-LAST:event_addTimeButtonActionPerformed

    private void nextPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPlayerButtonActionPerformed
        if (gameData.nextPlayer()) {
            selectedPlayerText.setText(gameData.curPlayer.getName());
            updateLists();
        } else {
            selectedPlayerText.setText(gameData.curPlayer.getName());
            updateLists();
        }
    }//GEN-LAST:event_nextPlayerButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        scoreSection -= 5;
        if (scoreSection == -1)
            prevButton.setEnabled(false);
        updateLists();
    }//GEN-LAST:event_prevButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        scoreSection += 5;
        prevButton.setEnabled(true);
        updateLists();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void scoreScreenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreScreenButtonActionPerformed
        ScoreMenuFrame menu = new ScoreMenuFrame();
        menu.gameData = gameData;
        menu.updateLists();
        menu.setVisible(true);
        
    }//GEN-LAST:event_scoreScreenButtonActionPerformed

    private void writeFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeFileButtonActionPerformed
        filer.writeFile(gameData.players);
    }//GEN-LAST:event_writeFileButtonActionPerformed

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
            java.util.logging.Logger.getLogger(gameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gameFrame mainFrame = new gameFrame();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int height = screenSize.height;
                int width = screenSize.width;
                mainFrame.setSize(700, 400);

                // here's the part where i center the jframe on screen
                mainFrame.setLocationRelativeTo(null);

                mainFrame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlayerButton;
    private javax.swing.JButton addTimeButton;
    private java.awt.List allNamesList;
    private java.awt.List avgTimeList;
    private javax.swing.JTextField curNameText;
    private javax.swing.JButton curPlayerButton;
    private java.awt.List curPlayerTimeList;
    private java.awt.List curPlayersList;
    private javax.swing.JButton dataButton;
    private java.awt.List namesList;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton nextPlayerButton;
    private javax.swing.JTextField pNameText;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton scoreScreenButton;
    private javax.swing.JTextField selectText;
    private javax.swing.JTextField selectedPlayerText;
    private javax.swing.JTextField timeText;
    private javax.swing.JButton writeFileButton;
    // End of variables declaration//GEN-END:variables
}
