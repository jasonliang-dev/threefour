package threefour;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileHandler {
    
    /**
     * 
     * @param users - Class that stores the player data for the game
     */
    public void readFile(UsersData users) {
        String currentDirectory = System.getProperty("user.dir");
        String fullFileName = currentDirectory + "/times.txt";
        
        try {
            FileReader fr = new FileReader(fullFileName);
            BufferedReader br = new BufferedReader(fr);
            
            int start = 0; //Starting position for String grabbing
            int delimiter = 0; //Position of delimiter
            
            String line = br.readLine();
            String name = "";
            
            while(line != null) {
                ArrayList<Integer> reactionTimes = new ArrayList();
                delimiter = line.indexOf("*", start);
                name = line.substring(start, delimiter);
                
                if(delimiter != line.length() - 1 && delimiter != -1) {
                    
                    
                    //Grabs the individual's time and stores into an ArrayList
                    while(delimiter != line.length()-1 && delimiter != -1) {
                        start = delimiter+1;
                        delimiter = line.indexOf("*", start);
                        reactionTimes.add(Integer.parseInt(line.substring(start, delimiter)));
                    }
                    start = 0;
                    delimiter = 0;
                    users.addUser(name, reactionTimes);
                    line = br.readLine();
                } else { //Condition for players with no times stored
                    start = 0;
                    delimiter = 0;
                    users.addUser(name);
                    line = br.readLine();
                }
            }
            
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("ERROR READING TO FILE");
           
        }
    }
    
    /**
     * 
     * @param players - List of player data to export to the file
     */
    public void writeFile(ArrayList<Player> players) {
        String currentDirectory = System.getProperty("user.dir");
        String fullFileName = currentDirectory + "/times.txt";
        
        if(players.size() > 0) {
            try {
                FileWriter fw = new FileWriter(fullFileName);
                BufferedWriter bw = new BufferedWriter(fw);

                for(Player p : players) {
                    bw.write(p.getName());

                    String tempTimes = "";
                    for(int i : p.reactionTimes) {
                        tempTimes += "*" + i;
                    }
                    tempTimes += "*";

                    bw.write(tempTimes);
                    bw.newLine();
                }

                bw.close();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("ERROR WRITING TO FILE");
            }
        }
        
    }
    
}
