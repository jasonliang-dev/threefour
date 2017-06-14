package threefour;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.JPanel;


public class ContentPanel extends JPanel {
    Image bgImage = null;
    
    ContentPanel(Image image) {
        this.bgImage = image;
        
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int imageWidth = bgImage.getWidth(null);
        int imageHeight = bgImage.getHeight(null);
        g.drawImage(bgImage, 1, 1, this);
    }
}
