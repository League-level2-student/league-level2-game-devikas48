import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Car extends GameObject{
	
	Random ran = new Random();

	public Car(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = ran.nextInt(5)+1;
	}
	
	
	public void update() {
		super.update();
		x-= speed;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
	
	
}
