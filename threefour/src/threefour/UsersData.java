package threefour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsersData {
    ArrayList<Player> players = new ArrayList();
    ArrayList<String> usedNames = new ArrayList();
    ArrayList<Player> selectedPlayers = new ArrayList();
    FileHandler filer = new FileHandler();
    private int maxName = 30;
    
    /**
     * Used to add new user to the game with a given name
     * @param name
     * Provided by the user. Must be unique, otherwise name will not be used. 
     * @return True if the provided name is not already used and is valid. 
     */
    public boolean addUser(String name) {
        boolean success = false;
        
        if (name.length() > maxName)
            System.out.println("Name is too long");
        else if (nameUsed(name) > -1)
            System.out.println("Name is already used. Please enter a different name.");
        else {
            usedNames.add(name);
            players.add(new Player(name));
            success = true;
        }
        
        return success;
    }
    
    /**
     * Used to import data from a file with a specific player's time data
     * Should not be used during the regular run-time of the game
     * Only used during initial run of the game to import player data 
     * @param name
     * @param reactionTime
     * @return True if the player can be successfully imported. 
     */
    public boolean addUser(String name, ArrayList<Integer> reactionTime) {
        boolean success = false;
        
        if (name.length() > maxName) 
            System.out.println("Name is too long");
        else if (nameUsed(name) > -1)
            System.out.println("Name is already used. Please enter a different name."); // Integrate error messages into jFrame
        else {
            usedNames.add(name);
            players.add(new Player(name, reactionTime));
            success = true;
        }
        
        return success;
    }
    
    /**
     * Stores a list of users that are actively playing the game
     * @param name - Name of a valid user that will be playing the game
     */
    public void setCurUser(String name) {
        if (nameUsed(name) > -1) {
            int playerIndex = findPlayer(name);
            boolean alreadyChosen = false;
            
            Player temp = players.get(playerIndex);
            
            if (selectedPlayers.size() > 0) {
                for(Player p : selectedPlayers) {
                    if (temp==p)
                        alreadyChosen = true;
                }
                
                if (alreadyChosen != true) {
                    selectedPlayers.add(temp);
                }
            } else {
                selectedPlayers.add(temp);
            }
        }
    }
    
    /**
     * 
     * @return 
     * Returns a sorted list of players if the players ArrayList is valid
     * Will return null if the players ArrayList is empty or invalid
     */
    public ArrayList<Player> sortUsers() {
        ArrayList<Player> temp = new ArrayList();
        if (players.size() > 0) {
            for (Player p : players) {
                if (p.getAvg() > 0)
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
        int playerIndex = findPlayer(name);
        
        if (playerIndex != -1) {
            players.remove(playerIndex);
            usedNames.remove(name);
        } else 
            System.out.println("USER NOT FOUND");
    }
    
    /**
     * 
     * @param name Takes in a String for the user's name
     * @return true - if name is used; false if name is not used
     */
    private int nameUsed(String name) {
        return usedNames.indexOf(name);
    }
    
    /**
     * Checks whether the user is valid (If they are stored in the game already)
     * @param name Takes in a String for the user's name
     * @return -1 if no user with given "name"
     * Otherwise, returns the index of the player with the given "name"
     */
    private int findPlayer(String name) {
        int playerIndex = -1;
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);

            if ( (p.getName()).equals(name)) {
                playerIndex = i;
                break;
            }
        }
        
        return playerIndex;
    }
    
    /**
     * Used to grab user data from a file
     * Recommended to run the method when the game first begins
     */
    public void importData() {
        filer.readFile(this);
    }
    
    /**
     * Writes all user data to a file
     */
    public void exportData() {
        filer.writeFile(players);
    }
}
