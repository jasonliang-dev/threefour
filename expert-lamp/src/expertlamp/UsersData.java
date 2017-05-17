package expertlamp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsersData {
    ArrayList<Player> players = new ArrayList();
    ArrayList<String> usedNames = new ArrayList();
    int maxName = 30;
    
    public void addUser(String name) {
        if (name.length() > maxName)
            System.out.println("Name is too long");
        else if (nameUsed(name))
            System.out.println("Name is already used. Please enter a different name."); // Integrate error messages into jFrame
        else {
            usedNames.add(name);
            players.add(new Player(name));
        }
    }
    
    public void addUser(String name, ArrayList<Double> reactionTime) {
        if (name.length() > maxName) 
            System.out.println("Name is too long");
        else if (nameUsed(name))
            System.out.println("Name is already used. Please enter a different name."); // Integrate error messages into jFrame
        else {
            usedNames.add(name);
            players.add(new Player(name, reactionTime));
        }
    }
    
    public Player setCurrentUser(String name) {
        if (nameUsed(name)) {
            int playerIndex = -1;
            
            for (int i = 0; i < players.size(); i++) {
                Player p = players.get(i);
                
                if ( (p.getName()).equals(name)) {
                    playerIndex = i;
                    break;
                }
            }
            
            return players.get(playerIndex);
        } else {
            System.out.println("USER NOT FOUND");
            return null;
        }
    }
    
    /**
     * 
     * @return 
     * Returns a sorted list of players if the players ArrayList is valid
     * Will return null if the players ArrayList is empty or invalid
     */
    public ArrayList sortUsers() {
        ArrayList<Player> temp = new ArrayList();
        if (players.size() > 0) {
            for (Player p : players) {
                temp.add(p);
            }
            Collections.sort(temp);
            return temp;
        } else {
            System.out.println("No users available");
            return null;
        }
        
        
    } 
    
    /**
     * 
     * @param name A name that is associated with a player stored in the game
     */
    public void removeUser(String name) {
        usedNames.remove(name);
        int playerIndex = -1;
        
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);

            if ( (p.getName()).equals(name)) {
                playerIndex = i;
                break;
            }
        }
        
        players.remove(playerIndex);
    }
    
    /**
     * 
     * @param name Takes in a String for the user's name
     * @return true - if name is used; false if name is not used
     */
    public boolean nameUsed(String name) {
        if (usedNames.indexOf(name) > -1) 
            return true;
        
        return false;    
    }
}
