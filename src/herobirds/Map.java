
package herobirds;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Map extends JPanel {
    private final ImageIcon bg = new ImageIcon(this.getClass().getResource("bam2.jpg"));
    private final ImageIcon  map1 = new ImageIcon(this.getClass().getResource("m1.jpg"));
    private final ImageIcon  map2 = new ImageIcon(this.getClass().getResource("m2.jpg"));
    private final ImageIcon  textm = new ImageIcon(this.getClass().getResource("textm.jpg"));
    private final ImageIcon  texts = new ImageIcon(this.getClass().getResource("textsp.jpg"));
    private final ImageIcon  bback = new ImageIcon(this.getClass().getResource("bback.jpg"));
    public JButton Bm1 = new JButton(map1);
    public JButton Bm2 = new JButton(map2);
    public JButton Bback = new JButton(bback);

    Map(){

        setLayout(null);
        Bm1.setBounds(100,150,250,250);
        Bm1.setBackground ( Color.BLACK );
        Bm1.setBorder ( BorderFactory.createLineBorder ( Color.WHITE, 1 ) );
        add(Bm1);
        
        Bback.setBounds(320,500,260,105);
        Bback.setBackground ( Color.white);
        Bback.setBorder ( BorderFactory.createLineBorder ( Color.blue, 1 ) );
        add(Bback);
        

        Bm2.setBounds(550,150,250,250);
        Bm1.setBackground ( Color.BLACK );
        Bm2.setBorder ( BorderFactory.createLineBorder ( Color.white, 1 ) );
        add(Bm2);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bg.getImage(),0,0,getWidth(),getHeight(),this);
        g.drawImage(textm.getImage(),130,70,180,70,this);
        g.drawImage(texts.getImage(),580,70,180,70,this);
    }
}
