import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class GameObject {

	 int x;
	 int y;
	 int width;
	 int height;
	 int speed = 0;
	 boolean isActive = true;
	 
	 
	 
	 public Rectangle collisionBox;
	 
	 public GameObject (int x, int y, int width, int height){
		 this.x = x;
		 this.y = y;
		 this. width = width;
		 this.height = height;
		 this.collisionBox = new Rectangle(x,y,width,height);
	 }
	 
	 public void draw(Graphics g) {
		 g.setColor(Color.BLUE);
	        g.fillRect(x, y, width, height);

	 }
	 
	 
	 public void update() {
		 collisionBox.setBounds(x, y, width, height);
	 }
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
}
