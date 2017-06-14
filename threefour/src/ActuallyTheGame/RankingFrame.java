package ActuallyTheGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import static ActuallyTheGame.MainFrame.gameData;
import threefour.Player;

public class RankingFrame extends MainFrame {
    int scoreSection = -1;
    int maxUsersShown = 10;
    
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); //used to center align the text in  jTable
    JButton returnButton = new JButton("Main Menu");
    JButton prevButton = new JButton("Prev");
    JButton nextButton = new JButton("Next");
    
    JScrollPane defaultScrollPane = new JScrollPane();
    JTable playerTimesTable = new JTable();
    
    public RankingFrame(int width, int height) { 
        super(width, height);
        setup("background_blank.png");
        updateFrame();
    }
    
    public void addComponents() {
        returnButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    returnButtonActionPerformed(evt);
                }
            });
            returnButton.setBounds(10, 10, 100, 25);
            
            prevButton.setBounds(272+50, 500, 100, 25);
            prevButton.setEnabled(false);
            prevButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    prevButtonActionPerformed(evt);
                }
            });
            
            nextButton.setBounds(702-100, 500, 100, 25);
            nextButton.setEnabled(false);
            nextButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    nextButtonActionPerformed(evt);
                }
            });
            
            playerTimesTable.setFont(new java.awt.Font("Noto Sans", 0, 24)); // NOI18N
            playerTimesTable.setRowHeight(27);
            
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
                    playerTimesTable.getColumnModel().getColumn(0).setMinWidth(80);
                    playerTimesTable.getColumnModel().getColumn(0).setMaxWidth(80);
                    playerTimesTable.getColumnModel().getColumn(2).setMinWidth(200);
                    playerTimesTable.getColumnModel().getColumn(2).setMaxWidth(200);
            }
            defaultScrollPane.setBounds(272, 175, 480, 300);
            
            curPanel.add(returnButton);
            curPanel.add(nextButton);
            curPanel.add(prevButton);
            curPanel.add(defaultScrollPane);
    }
    
    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
        mainMenuFrame.setVisible(true);
    }
    
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {                                     
        scoreSection += maxUsersShown;
        prevButton.setEnabled(true);
        updateFrame();
    }
    
    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {                                     
        scoreSection -= maxUsersShown;
        
        if (scoreSection == -1)
            prevButton.setEnabled(false);
        updateFrame();
    }
    
    @Override 
    public void updateFrame() {
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
}
