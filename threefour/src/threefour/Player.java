package threefour;

import java.util.ArrayList;
import java.util.Collections;


public class Player implements Comparable<Player> {
    String name;
    double avg = 0;
    ArrayList<Double> reactionTimes = new ArrayList();
 
    Player(String name) {
        this.name = name;
        reactionTimes = new ArrayList();
    }
    
    Player(String name, ArrayList<Double> reactionTimes) {
        if (reactionTimes.size() > 0) {
            this.name = name;
            this.reactionTimes = reactionTimes;
            this.findAvg();
        }
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void addTime(Double time) {
        if(time > -1) {
            reactionTimes.add(time);
            findAvg();
        }
    }
    
    public double getAvg() {
        return avg;
    }
    
    public void findAvg() {
        int numOfItems = reactionTimes.size();
        
        if (numOfItems > 0) {
            double sum = 0;
            
            for (Double i : reactionTimes) {
                sum += i;
            }
            
            avg = sum / numOfItems;
        } else {
            avg = 0;
        }
    }
    
    public void clearTimes() {
        reactionTimes.clear();
        findAvg();
    }
    
    public ArrayList<Double> sortTimes() {
        ArrayList<Double> temp = new ArrayList();
        
        for(Double t : reactionTimes) {
            temp.add(t);
        }
        
        Collections.sort(temp);
        return temp;
    }
    
    /**
     * 
     * @return 
     * If reactionTimes ArrayList is filled, will return a sorted List in descending order
     */
    public ArrayList sortUserTime() {
        ArrayList temp = new ArrayList();
        
        if (reactionTimes.size() > 0) {
            for (Double d : reactionTimes)
                temp.add(d);
            
            Collections.sort(temp);
            return temp;
        } else
            return null;
    }
    
    /**
     * 
     * @param otherPlayer This is another user to compare average times to. 
     * @return Returns "1" if the other player has a slower time. 
     * Returns "0" if the times are equal. 
     * Returns "-1" when the other player has a greater time. 
     */
    public int compareTo(Player otherPlayer) {
        if (avg > otherPlayer.avg)
            return 1;
        else if (avg < otherPlayer.avg)
            return -1;
        else 
            return 0;
    }


}
