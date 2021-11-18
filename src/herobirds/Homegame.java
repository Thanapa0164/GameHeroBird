
package herobirds;
import javax.swing.*;
import java.awt.*;
public class Homegame extends JPanel {
    private  ImageIcon bghome = new ImageIcon(this.getClass().getResource("home.jpg"));
    private  ImageIcon start = new ImageIcon(this.getClass().getResource("p.png"));
    public JButton BStart = new JButton(start);
    Homegame()
    {
        setLayout(null);
        BStart.setBounds(330,430,230,85);
        add(BStart);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bghome.getImage(),0,0,getWidth(),getHeight(),this);

    }
}
