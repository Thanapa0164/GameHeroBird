
package herobirds;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class EBird5 extends EBird4 {
    Image img;
    EBird5(){
        img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("s5.png"));
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
