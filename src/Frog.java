import java.awt.Color;
import java.awt.Graphics;

public class Frog extends GameObject {

	public Frog(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	
	
	public void draw(Graphics g) {
	    g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
	}

}
