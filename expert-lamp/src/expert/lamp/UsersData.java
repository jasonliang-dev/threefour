package expert.lamp;

import java.util.ArrayList;

public class UsersData {
    ArrayList<Player> players = new ArrayList();
    ArrayList<String> usedNames = new ArrayList();
    Player curPlayer;
    
    public void addUser(String name) {
        if (nameUsed(name))
            System.out.println("Name is already used. Please enter a different name."); // Integrate error messages into jFrame
        else {
            usedNames.add(name);
            players.add(new Player(name));
        }
    }
    
    public void addUser(String name, ArrayList<Double> reactionTime) {
        if (nameUsed(name))
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
            
            return curPlayer = players.get(playerIndex);
        } else {
            System.out.println("USER NOT FOUND");
            return null;
        }
    }
    
    public void removeUser(String name) {
        
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
