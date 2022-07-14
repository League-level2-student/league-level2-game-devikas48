import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Log extends GameObject {

	Random ran = new Random();

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public Log(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = ran.nextInt(5) + GamePanel.difficultyLevel*10;

		if (needImage) {
			loadImage("log.png");
		}
	}

	public void update() {
		super.update();
		x -= speed;
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

	public void draw(Graphics g) {

		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, width, height);
		}

	}

}