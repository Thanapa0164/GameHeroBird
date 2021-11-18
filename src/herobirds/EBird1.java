
package herobirds;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class EBird1 {
    Image img;
	public int x = 900;
	public int y= (int)((Math.random()*700)+50);
	public int count = 0;
	EBird1(){
            img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("s1.png"));
            runner.start();
        }
	Thread runner = new Thread(new Runnable() {
            public void run() {
		while(true){
                    x -= 5;
                    if(x <= 0){
			img = null;
			runner = null;
			x = +900;
			y = +700;
                    }
                    try{
			runner.sleep(10);
                    }catch(InterruptedException e){}
                }
            }
	});
        
	public Image getImage(){
            return img;
	}
	
	public int getX(){
            return x;
	}
	public int getY(){
            return y;
	}
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,100,100));
	}
}
