
package herobirds;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Dead extends JPanel {
    private final ImageIcon bgD = new ImageIcon(this.getClass().getResource("dead.jpg"));
    private final ImageIcon restart = new ImageIcon(this.getClass().getResource("resD.jpg"));
    public JButton BreD = new JButton(restart);
    private final ImageIcon exit = new ImageIcon(this.getClass().getResource("ExD.jpg"));
    public JButton BexD = new JButton(exit);
    
    Dead(){
        setLayout(null);
        BreD.setBounds(70,200,200,60);
        BreD.setBackground ( Color.BLACK );
        BreD.setBorder ( BorderFactory.createLineBorder ( Color.gray, 1 ) );
        add(BreD);
        BexD.setBounds(630,200,203,63);
        BexD.setBackground ( Color.BLACK );
        BexD.setBorder ( BorderFactory.createLineBorder ( Color.gray, 1 ) );
        add(BexD);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bgD.getImage(),0,0,getWidth(),getHeight(),this);
    }
}
