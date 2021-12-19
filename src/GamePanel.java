import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Font title2Font;
	Font title3Font;
	Font title4Font;
	Font title5Font;
	Font title6Font;
	Timer frameDraw;
	
	
	int x = 250;
	int y = 550;
	int width = 50;
	int height = 50;
	
	Frog frog = new Frog(250, 550, width, height);
	Car car = new Car (100,100, width, height);
	Log log  = new Log (200, 200, width , height);
	ObjectManager objectmanager = new ObjectManager(frog);

	Timer carSpawn = new Timer(1000, objectmanager);
	Timer logSpawn = new Timer(1000, objectmanager);

	
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		title2Font = new Font("Arial", Font.PLAIN, 30);
		title3Font = new Font("Arial", Font.PLAIN, 30);
		title4Font = new Font("Arial", Font.PLAIN, 30);
		title4Font = new Font("Arial", Font.PLAIN, 30);
		title6Font = new Font("Arial", Font.PLAIN, 30);
		frameDraw = new Timer(1000/60,this);
		frameDraw.start();
	}
	
	
	
	
	public void  updateMenuState() {  
		  
		  
	}
	public void updateGameState() { 
		objectmanager.update();
	
	}
	public void updateEndState()  {  
			  
	}
	
	
	
	public void drawMenuState(Graphics g) { 
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Frogger.width, Frogger.height);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("FROGGER", 100, 100);
		g.setFont(title2Font);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start", 80, 300);
		g.setFont(title3Font);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE for instructions", 45, 500);
		

		
	}
	public void drawGameState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Frogger.width, Frogger.height);
		objectmanager.draw(g);
	}
	public void drawEndState(Graphics g)  { 
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Frogger.width, Frogger.height);
		g.setFont(title4Font);
		g.setColor(Color.YELLOW);
		g.drawString("GAMEOVER", 15, 100);
		g.setFont(title5Font);
		g.setColor(Color.YELLOW);
		g.setFont(title6Font);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to restart", 45, 500);
	}
		
		
	

	
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		    
		    startGame();
		}
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    if (objectmanager.frog.y < 0) {
		    	objectmanager.frog.y = 0;
		    } else {
		    	objectmanager.frog.up();
		    }
		} else if (e.getKeyCode()==KeyEvent.VK_DOWN){
			objectmanager.frog.down();
		} else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			objectmanager.frog.right();
		} else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			objectmanager.frog.left();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@Override
	public void paintComponent(Graphics g){
		
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}

		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		
		repaint();
		
		
	}
	
	
	public void startGame( ) {
		carSpawn = new Timer(1000 , objectmanager);
		carSpawn.start();
		
		logSpawn = new Timer(1000 , objectmanager);
		logSpawn.start();

	}

}
