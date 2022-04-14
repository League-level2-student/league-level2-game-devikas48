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

	
	public static final int MENU = 1;
	public static final int GAME = 2;
	public static final int END = 3;
	public static final int INSTRUCTIONS = 0;
    public static int currentState = MENU;
    Font titleFont;
    Font title2Font;
	Font title3Font;
	Font title4Font;
	Font title5Font;
	Font title6Font;
	Font instructionsFont;
	Timer frameDraw;
	
	
	
	int x = 250;
	int y = 550;
	int width = 50;
	int height = 50;
	
	Frog frog = new Frog(250, 500, width, height);
	Car car = new Car (100,100, width, height);
	Log log  = new Log (200, 200, width , height);
	ObjectManager objectmanager = new ObjectManager(frog);

	

	
	public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		title2Font = new Font("Arial", Font.PLAIN, 30);
		title3Font = new Font("Arial", Font.PLAIN, 30);
		title4Font = new Font("Arial", Font.PLAIN, 30);
		title4Font = new Font("Arial", Font.PLAIN, 30);
		title6Font = new Font("Arial", Font.PLAIN, 30);
		instructionsFont = new Font("Arial", Font.PLAIN, 30);
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
	
	public void drawInstructionsState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Frogger.width, Frogger.height);
		g.setFont(instructionsFont);
		g.setColor(Color.BLACK);
		g.drawString("INSTRUCTIONS", 110, 200);
		g.setColor(Color.BLACK);
		g.drawString("- move the frog with the up/down and left/right keys", 110, 300);
		g.setColor(Color.BLACK);
		g.drawString("- move the frog with the up/down and left/right keys", 80, 300);

		
	}
	
	public void drawMenuState(Graphics g) { 
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Frogger.width, Frogger.height);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("FROGGER", 130, 200);
		g.setFont(title2Font);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start", 110, 300);
		g.setFont(title3Font);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE for instructions", 70, 400);
		

		
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
		g.drawString("GAMEOVER", 150, 200);
		g.setFont(title5Font);
		g.setColor(Color.YELLOW);
		g.setFont(title6Font);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to restart", 85, 300);
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
		        if(currentState == GAME) {
		        	frog.isActive = true;
		        	frog.x = 250;
		        	frog.y = 500;
		        }
		    }
		    
		}
		
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			currentState = INSTRUCTIONS;
		}
		
		
		
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		   
		    	objectmanager.frog.up(true);
		
		} else if (e.getKeyCode()==KeyEvent.VK_DOWN){
			objectmanager.frog.down(true);
		} else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			objectmanager.frog.right(true);
		} else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			objectmanager.frog.left(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			objectmanager.frog.up(false);
		} else if (e.getKeyCode()==KeyEvent.VK_DOWN){
			objectmanager.frog.down(false);
		} else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			objectmanager.frog.right(false);
		} else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			objectmanager.frog.left(false);
		}
	}
	
	
	
	@Override
	public void paintComponent(Graphics g){
		
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}else if (currentState == INSTRUCTIONS) {
			drawInstructionsState(g);
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
	
	
	
}
