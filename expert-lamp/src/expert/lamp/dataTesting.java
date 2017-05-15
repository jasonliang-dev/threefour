package expert.lamp;

import java.util.ArrayList;

public class dataTesting {
    Player curPlayer;
    
    public static void main(String[] args) {
        UsersData allData = new UsersData();
        String[] names = new String[] {"Bob", "Sam", "Jim", "Sammy"};
        
        for (int i = 0; i < 4; i++) {
            ArrayList temp = new  ArrayList();
            
            temp.add(Math.random());
            temp.add(Math.random());
            temp.add(Math.random());
            temp.add(Math.random());
            
            allData.addUser(names[i], temp);
        }
        
        Player curPlayer = allData.setCurrentUser("Bob");
        Player otherPlayer = allData.players.get(1);
        
        System.out.println(otherPlayer.getName());
        System.out.println(curPlayer.getAvg());
        System.out.println("Cur: "+curPlayer.avg + " Other: "+otherPlayer.avg);
        System.out.println(curPlayer.compareTo(otherPlayer));
    }
	
}
