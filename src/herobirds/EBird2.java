
package herobirds;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class EBird2 extends EBird1 {
    Image img;
    EBird2(){
        img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("s2.png"));
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
	public void run() {
            while(true){
		x -= 4;
		if(x <= 0){
                    img = null;
                    runner = null;
                    x = +900;
                    y = +700;
                }
                try{
                    runner.sleep(20);
                }catch(InterruptedException e){}
            }
	}
    });

    public Image getImage(){
	return img;
    }
}
