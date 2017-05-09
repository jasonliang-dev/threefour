package expert.lamp;

import java.util.ArrayList;

public class Player {
    String name;
    double avg;
    ArrayList<Integer> reactionTime;
    
    Player() {
        
    }
    
    Player(String name, double avg, ArrayList<Integer> reactionTime) {
        this.name = name;
        this.avg = avg;
        this.reactionTime = reactionTime;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getAvg() {
        return avg;
    }
    
    public void  setAvg(double avg) {
        this.avg = avg;
    }
}
