import java.awt.Color;
import java.awt.Graphics;

public class Log extends GameObject {

	public Log(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 1;
	}

	void update() {
		x-= speed;
	}

	public void draw(Graphics g) {

	    g.setColor(new Color (165, 42, 42) );
        g.fillRect(x, y, width, height);
	}

}