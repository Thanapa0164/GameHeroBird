
package herobirds;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Playgame extends JFrame implements ActionListener {
    Homegame homeS = new Homegame();
    play1 play1 = new play1();
    play2 play2 = new play2();
    Map m = new Map();
    public Playgame()
    {
        this.setSize(900,700);
        this.add(homeS);
        homeS.BStart.addActionListener(this);
        m.Bback.addActionListener(this);
        m.Bm1.addActionListener(this);
        m.Bm2.addActionListener(this); 
        play2.BExitD.addActionListener(this);
//        play2.BStartD.addActionListener(this);
        play2.BExitV.addActionListener(this);
//        play2.BStartV.addActionListener(this);
        play1.BExitD.addActionListener(this);
//        play1.BStartD.addActionListener(this);
        play1.BExitV.addActionListener(this);
//        play1.BStartV.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==homeS.BStart)
        {
            this.setLocationRelativeTo(null);
            this.remove(homeS);
            this.setSize(900,700);
            this.add(m);
        }
        else if(e.getSource()==m.Bm1)
        {
            this.setLocationRelativeTo(null);
            this.remove(homeS);
            this.setSize(900,700);
            remove(m);
            this.add(play1);
            play1.times=100;
            play1.timestart=false;
            play1.requestFocusInWindow();

        }
        else if(e.getSource()==m.Bm2)
        {
            this.setLocationRelativeTo(null);
            this.remove(homeS);
            this.setSize(900,700);
            this.add(play2);
            remove(m);
            play2.times=100;
            play2.timestart=false;
            play2.requestFocusInWindow();
            play2.startEBirdl=false;

        }
        else if(e.getSource() == m.Bback)
        {
            this.setLocationRelativeTo(null);
            this.remove(m);
            this.setSize(900,700);
            this.add(homeS);
            homeS.requestFocusInWindow();
        }
        else if(e.getSource() == play2.BExitD)
        {
             System.exit(0);
        }
//        else if(e.getSource() == play2.BStartD)
//        {
//            this.setLocationRelativeTo(null);
//            this.remove(play2);
//            this.setSize(900,700);
//            this.add(homeS);
//            homeS.requestFocusInWindow();
//        }
        else if(e.getSource() == play2.BExitV)
        {
             System.exit(0);
        }
//        else if(e.getSource() == play2.BStartV)
//        {
//            this.setLocationRelativeTo(null);
//            this.remove(play2);
//            this.setSize(900,700);
//            this.add(homeS);
//            homeS.requestFocusInWindow();
//        }
        else if(e.getSource() == play1.BExitD)
        {
             System.exit(0);
        }
//        else if(e.getSource() == play1.BStartD)
//        {
//            this.setLocationRelativeTo(null);
//            this.remove(play1);
//            this.setSize(900,700);
//            this.add(homeS);
//            homeS.requestFocusInWindow();
//        }
        else if(e.getSource() == play1.BExitV)
        {
             System.exit(0);
        }
//        else if(e.getSource() == play1.BStartV)
//        {
//            this.setLocationRelativeTo(null);
//            this.remove(play1);
//            this.setSize(900,700);
//            this.add(homeS);
//            homeS.requestFocusInWindow();
//        }
        this.validate();
        repaint();
    }
    public static void main(String[] args)
    {
        JFrame home = new Playgame();
        home.setTitle(" -- Hero Birds --");
        home.setSize(900,700);
        home.setLocationRelativeTo(null);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setLocationRelativeTo(null);
        home.setVisible(true);
    }
}
