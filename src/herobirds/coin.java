
package herobirds;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
public class coin extends EBird1 {
    Image img;
    public int count = 0;
    coin(){
        img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("c.png"));
	runner.start();
    }
    Thread runner = new Thread(new Runnable() {
	public void run() {
            while(true){
		x -= 3;
		if(x <= 0){
                    img = null;
                    runner = null;
                    x = +900;
                    y = +700;
		}
		try{
                    runner.sleep(1000);
		}catch(InterruptedException e){}
            }
	}
    });
    public Image getImage(){
	return img;
    }
}
