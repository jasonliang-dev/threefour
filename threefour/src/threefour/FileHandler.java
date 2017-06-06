package threefour;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileHandler {
    
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
                
                if(delimiter != -1) {
                    name = line.substring(start, delimiter);
                    
                    while(delimiter != line.length()-1 && delimiter != -1) {
                        start = delimiter+1;
                        delimiter = line.indexOf("*", start);
                        reactionTimes.add(Integer.parseInt(line.substring(start, delimiter)));
                    }
                    start = 0;
                    delimiter = 0;
                    line = br.readLine();
                    users.addUser(name, reactionTimes);
                } else {
                    start = 0;
                    delimiter = 0;
                    users.addUser(name);
                    line = br.readLine();
                }
            }
            
        } catch (Exception e) {
            /*try {
                FileWriter fw = new FileWriter(fullFileName);
                BufferedWriter bw = new BufferedWriter(fw);
                
                bw.newLine();
                bw.close();
            } catch (Exception ee) {*/
                System.out.println(e);
           
        }
    }
    
    public void writeFile(ArrayList<Player> players) {
        String currentDirectory = System.getProperty("user.dir");
        String fullFileName = currentDirectory + "/times.txt";
        
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
            System.out.println("ERROR WRITING TO FILE");
        }
        
    }
    
}
