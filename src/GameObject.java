import java.awt.Color;
import java.awt.Graphics;

public class GameObject {

	 int x;
	 int y;
	 int width;
	 int height;
	 int speed = 0;
	 
	 
	 
	 public GameObject (int x, int y, int width, int height){
		 this.x = x;
		 this.y = y;
		 this. width = width;
		 this.height = height;
	
	 }
	 
	 public void draw(Graphics g) {
		 g.setColor(Color.BLUE);
	        g.fillRect(x, y, width, height);

	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
