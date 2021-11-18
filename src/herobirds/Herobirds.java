
package herobirds;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Herobirds {
    public ImageIcon[] imh = new ImageIcon[7];
    public int x;
    public int y;
    public int count = 0;
    Herobirds(){
        for(int i=0;i<imh.length;i++){
            imh[i] = new ImageIcon(this.getClass().getResource("B"+(i+1)+".png"));
	}
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,50,50));
    }
}
