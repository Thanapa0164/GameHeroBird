
package herobirds;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Victory extends JPanel {
    private final ImageIcon bgV = new ImageIcon(this.getClass().getResource("victory.jpg"));
    private final ImageIcon restart = new ImageIcon(this.getClass().getResource("resV.jpg"));
    public JButton BreV = new JButton(restart);
    private final ImageIcon exit = new ImageIcon(this.getClass().getResource("ExV.jpg"));
    public JButton BexV = new JButton(exit);
    
    Victory(){
        setLayout(null);
        BreV.setBounds(70,200,190,65);
        BreV.setBackground ( Color.BLACK );
        BreV.setBorder ( BorderFactory.createLineBorder ( Color.gray, 1 ) );
        add(BreV);
        BexV.setBounds(630,200,190,68);
        BexV.setBackground ( Color.BLACK );
        BexV.setBorder ( BorderFactory.createLineBorder ( Color.gray, 1 ) );
        add(BexV);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bgV.getImage(),0,0,getWidth(),getHeight(),this);
    }
}
