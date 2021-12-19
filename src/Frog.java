import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Frog extends GameObject {

	public Frog(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		
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
	

	public void right() {
		x += speed;
	}

	public void left() {
		x -= speed;
	}

	public void up() {
		y -= speed;
	}

	public void down() {
		y += speed;
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
	
	
	
	
}
