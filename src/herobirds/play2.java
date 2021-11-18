
package herobirds;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
public class play2 extends JPanel implements ActionListener {
    Herobirds h = new Herobirds();
    private final ImageIcon imgmap2 = new ImageIcon(this.getClass().getResource("m2.jpg"));
    private final ImageIcon imgHerob = new ImageIcon(this.getClass().getResource("B1.png"));
    
    Homegame hg = new Homegame();
	ImageIcon Deadover = new ImageIcon(this.getClass().getResource("dead.jpg"));
        ImageIcon Vicover = new ImageIcon(this.getClass().getResource("victory.jpg"));
        ImageIcon exitD = new ImageIcon(this.getClass().getResource("ExD.jpg"));
//	ImageIcon restartD = new ImageIcon(this.getClass().getResource("resD.jpg"));
        ImageIcon exitV = new ImageIcon(this.getClass().getResource("ExV.jpg"));
//	ImageIcon restartV = new ImageIcon(this.getClass().getResource("resV.jpg"));
//        JButton BStartD = new JButton(restartD);
	JButton BExitD  = new JButton(exitD);
//	JButton BStartV = new JButton(restartV);
	JButton BExitV  = new JButton(exitV);
        
        private JLabel score = new JLabel();
        public ArrayList<Fire> fire = new ArrayList<Fire>();
	public ArrayList<EBird1> Eb1 = new ArrayList<EBird1>();
	public ArrayList<EBird2> Eb2 = new ArrayList<EBird2>();
        public ArrayList<EBird3> Eb3 = new ArrayList<EBird3>();
	public ArrayList<coin> coin1 = new ArrayList<coin>();
        
        public int times ;
	public int HP = 10;
        boolean timestart = true;
	boolean startEBirdl = false;
        
        private Dead Dover = new Dead();
        private Victory Vover = new Victory();
	public int scor = 0;
	boolean paralyze1 = false;
	int time_paralyze=5;
        
        Thread time = new Thread(new Runnable(){
            public void run(){
		while(true){
                    try{
			Thread.sleep(10);
                    }catch(Exception e){ }
                    
                    if(timestart == false){
			repaint();
                    }
		}
            }
	});
        
        Thread actor = new Thread(new Runnable(){
            public void run(){
		while(true){
                	try{
                            Thread.sleep(1);
			}catch(Exception e){}
                            repaint();
		}
            }
	});
        
        Thread tEBird1 = new Thread(new Runnable(){
            public void run() {
                while(true){
                	try{
                            if(startEBirdl == false){
				Thread.sleep(2000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startEBirdl == false){
                            Eb1.add(new EBird1());
			}
		}
            }
	});
        
        Thread tEBird2 = new Thread(new Runnable(){
            public void run() {
		while(true){
			try{
                            if(startEBirdl==false){
				Thread.sleep(3000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startEBirdl == false){
                            Eb2.add(new EBird2());
			}
		}
            }
	});
	
        Thread tEBird3 = new Thread(new Runnable(){
            public void run() {
		while(true){
			try{
                            if(startEBirdl==false){
				Thread.sleep(3000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startEBirdl == false){
                            Eb3.add(new EBird3());
			}
		}
            }
	});
        
	Thread tcoin = new Thread(new Runnable(){
            public void run() {
            	while(true){
			try{
                            if(startEBirdl==false){
                                Thread.sleep(4000);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startEBirdl == false){
                            coin1.add(new coin());
			}
		}
            }
	});
        
        Thread t = new Thread(new Runnable(){
            public void run() {
		while(true){
                	if(timestart == false){
                            times = (times-1) ;
                            if(paralyze1){
				time_paralyze--;
                            }
			}
			try{
                            Thread.sleep(1000);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
	});
        
        play2(){
            this.setFocusable(true);
            this.setLayout(null);
            this.add(score);
//            BStartD.setBounds(70,200,200,60);
            BExitD.setBounds(630,200,203,63);
//            BStartV.setBounds(70,200,190,65);
            BExitV.setBounds(630,200,190,68);
        
            this.addKeyListener(new KeyAdapter(){
                    public void keyPressed(KeyEvent e){
                        int a = e.getKeyCode();
			    if(a==KeyEvent.VK_LEFT){
			     	h.x-=10;
                                h.count++;
                            }
                            else if(a == KeyEvent.VK_RIGHT){
                               h.x+=10;
                               h.count++;
			   }
                            if(a==KeyEvent.VK_UP){
			     	h.y-=10;
                                h.count++;
                            }
                            else if(a == KeyEvent.VK_DOWN){
                               h.y+=10;
                               h.count++;
			   }
                            else if(a == KeyEvent.VK_SPACE){
			       fire.add(new Fire(h.x,h.y));
			    }
			}
                    public void keyReleased(KeyEvent e){
			h.count=0;
		    }
		});
                h.x = 100;
                h.y = 350;
		time.start();
		actor.start();
		t.start();
		tEBird1.start();
		tEBird2.start();
                tEBird3.start();
		tcoin.start();
		
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            if(HP<=0){
                this.setLayout(null);
                g.drawImage(Deadover.getImage(),0,0,900,700,this);
                this.add(BExitD);
//                this.add(BStartD);
		g.setColor(Color.BLACK);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,40));		
                g.drawString("SCORE   "+scor,340,550);	
            }else if(times <= 0){
                this.setLayout(null);
                g.drawImage(Vicover.getImage(),0,0,900,700,this);
                this.add(BExitV);
//                this.add(BStartV);
		g.setColor(Color.BLACK);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,40));		
                g.drawString("SCORE   "+scor,330,550);
            }else{
                g.drawImage(imgmap2.getImage(),0,0,900,700,this);
                g.drawImage(h.imh[h.count%7].getImage(), h.x, h.y,100,100, this);
                if(h.x<20){
                    h.x=20;
                }
		if(h.x>850){
                    h.x=850;
		}
                if(h.y<100){
                    h.y=100;
		}
		if(h.y>550){
                    h.y=550;
		}
                for(int i=0;i<fire.size();i++){
		    Fire ba = fire.get(i);
                    g.drawImage(ba.mfire[ba.count%4].getImage(), ba.x, ba.y,50,50, null);
		    ba.move();
                    ba.count++;
		    if(ba.x>850){
		    	fire.remove(i);
		    }
		}
                //========================================EBird1================= 
                for(int i=0 ; i<Eb1.size();i++){
                    g.drawImage(Eb1.get(i).getImage(),Eb1.get(i).getX(),Eb1.get(i).getY(),100,100,this);
 		}
		for(int i=0 ; i<fire.size();i++){
		    for(int j=0 ; j<Eb1.size();j++){
		    	if(Intersect(fire.get(i).getbound(),Eb1.get(j).getbound())){
			    Eb1.remove(j);
			    fire.remove(i);
			    scor += 5;
			}
		    }
		}
                for(int i=0;i<Eb1.size();i++){
                    if(Intersect(h.getbound(),Eb1.get(i).getbound())){
                     Eb1.remove(i);
                     HP -= 1;
                    }
                }
                //========================EBird2=========================
		for(int i=0 ; i<Eb2.size();i++){
		    g.drawImage(Eb2.get(i).getImage(),Eb2.get(i).getX(),Eb2.get(i).getY(),100,100,this);
		 }
		for(int i=0 ; i<fire.size();i++){
		    for(int j=0 ; j<Eb2.size();j++){
		    	if(Intersect(fire.get(i).getbound(),Eb2.get(j).getbound())){
			    Eb2.remove(j);
			    fire.remove(i);
			    scor += 10;
			 } 
		    }
		}
                for(int i=0;i<Eb2.size();i++){
                    if(Intersect(h.getbound(),Eb2.get(i).getbound())){
                     Eb2.remove(i);
                     HP -= 1;
                    }
                }
                //========================EBird3=========================
		for(int i=0 ; i<Eb3.size();i++){
		    g.drawImage(Eb3.get(i).getImage(),Eb3.get(i).getX(),Eb3.get(i).getY(),100,100,this);
		 }
		for(int i=0 ; i<fire.size();i++){
		    for(int j=0 ; j<Eb3.size();j++){
		    	if(Intersect(fire.get(i).getbound(),Eb3.get(j).getbound())){
			    Eb3.remove(j);
			    fire.remove(i);
			    scor += 10;
			 } 
		    }
		}
                for(int i=0;i<Eb3.size();i++){
                    if(Intersect(h.getbound(),Eb3.get(i).getbound())){
                     Eb3.remove(i);
                     HP -= 1;
                    }
                }
                //=================================coin=============
		for(int i=0 ; i<coin1.size();i++){
		    g.drawImage(coin1.get(i).getImage(),coin1.get(i).getX(),coin1.get(i).getY(),100,100,this);
		}
		for(int i=0 ; i<fire.size();i++){
		    for(int j=0 ; j<coin1.size();j++){
		    	if(Intersect(fire.get(i).getbound(),coin1.get(j).getbound())){
			    coin1.remove(j);
			    fire.remove(i);
			    HP-=1;
			}
		    }
		}
                for(int i=0;i<coin1.size();i++){
                    if(Intersect(h.getbound(),coin1.get(i).getbound())){
                     coin1.remove(i);
                     scor += 15;
                    }
                }
                g.setFont(new Font("Hobo Std",Font.CENTER_BASELINE,30));
		g.setColor(Color.YELLOW);
		g.drawString("SCORE =  "+scor,100, 100);	     
                g.setFont(new Font("Hobo Std",Font.CENTER_BASELINE,40));
                g.setColor(Color.WHITE);
		g.drawString("Time "+times,370,100);
		g.setFont(new Font("Hobo Std",Font.CENTER_BASELINE,30));
                g.setColor(Color.RED);
		g.drawString("HP  "+HP,650,100);
            
            }
            
        }
        public boolean Intersect(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}
        public void actionPerformed(ActionEvent e) {
             
	}
}
