
package herobirds;
import java.awt.geom.Rectangle2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Fire extends JPanel {
    public ImageIcon[] mfire = new ImageIcon[4];
    public int y;
    public int x;
    public int count=0;
    Fire(int x,int y){
        for(int i=0;i<mfire.length;i++){
            String imageLocation = "f"+(i+1)+".png";
            mfire[i] = new ImageIcon(this.getClass().getResource(imageLocation));
	}
            this.x=x;
            this.y=y+50;
    }
	
    public void move(){
	this.x+=3;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,50,50));
    }
}
