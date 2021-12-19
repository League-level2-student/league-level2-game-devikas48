import java.awt.Color;
import java.awt.Graphics;

public class Car extends GameObject{

	public Car(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 1;
	}
	
	
	void update() {
		x-= speed;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}
	
	
}
