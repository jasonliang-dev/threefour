package ActuallyTheGame;

import ActuallyTheGame.ImagePanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import threefour.UsersData;
import threefour.FileHandler;

public abstract class MainFrame extends JFrame {
    static UsersData gameData = new UsersData();
    static JFrame mainMenuFrame;
    static boolean gameStarted = false; //indicates whether to import  data from file or not, ensures no overwriting of existing data
    
    protected int frameHeight = 768;
    protected int frameWidth = 1024;
    protected JPanel curPanel;
    
    public void setup(String imageFileName) {
        setBackgroundImage(imageFileName);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); //ensures program stops running when frame closes
        
        // here's the part where i center the jframe on screen
        this.setSize(frameWidth, frameHeight);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }
    
    public abstract void addComponents();
    
    public void setBackgroundImage(String imageFileName) {
        String currentDirectory = System.getProperty("user.dir");
        String fullFileName = currentDirectory + "/"+imageFileName;
        
        curPanel = new ImagePanel(new ImageIcon(fullFileName).getImage());
        
        addComponents();
        
        this.getContentPane().add(curPanel);
    }
    
    public void updateFrame() {
        
    }
}
