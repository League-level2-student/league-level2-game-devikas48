import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Frog extends GameObject {

	boolean up;
	boolean down;
	boolean right;
	boolean left;
	
	
	public Frog(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		
		if (needImage) {
		    loadImage ("frog.png");
		}
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	

	public void right(boolean active) {
		right = active;
	}

	public void left(boolean active) {
		left = active;
		
	}

	public void up(boolean active) {
		up = active;
	}

	public void down(boolean active) {
		down = active;
	}

	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
	public void update() {
		super.update();
		if(up ==  true) {
			y-=speed;
		}
		if(down ==  true) {
			y+=speed;
		}

		if(left ==  true) {
			x-=speed;
		}

		if(right ==  true) {
			x+=speed;
		}

	}
	
	
	
}
