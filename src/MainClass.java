import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MainClass implements KeyListener {

	public static void main(String[] args) {
		MainClass mainclass = new MainClass();
		mainclass.setup();

	}

	JFrame frame;
	GamePanel gamepanel;

	public static final int width = 500;
	public static final int height = 650;

	public MainClass() {
		frame = new JFrame();
		gamepanel = new GamePanel();
	}

	void setup() {
		frame.add(gamepanel);
		frame.addKeyListener(gamepanel);
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
