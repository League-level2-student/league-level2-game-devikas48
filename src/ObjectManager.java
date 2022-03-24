import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class ObjectManager implements ActionListener{

	Frog frog;
	ArrayList<Log> logs = new ArrayList<Log>();
	ArrayList<Car> cars = new ArrayList<Car>();
	Random random = new Random();
	
	Timer carSpawn = new Timer(2000, this);
	Timer logSpawn = new Timer(5000, this);
	
	public ObjectManager(Frog frog) {
		this.frog = frog;
	logSpawn.start();
	carSpawn.start();
	
	}
	
	
	
	public void addLog() {
		logs.add(new Log(Frogger.width,random.nextInt(Frogger.height),50,50));
		
	}
	
	public void addCar() {
		cars.add(new Car(Frogger.width ,random.nextInt(Frogger.height),50,50));
		
	}
	
	public void update() {
		for (int i = 0; i < logs.size(); i++) {
			logs.get(i).update();
		
			
			if(logs.get(i).x < 0) {
				logs.get(i).isActive = false;
			}
		}
		
		for (int i = 0; i < cars.size(); i++) {
			cars.get(i).update();
		
			if(cars.get(i).x < 0) {
				cars.get(i).isActive = false;
			}
			
			}
		
		
			frog.update();
	

		
		
		if(frog.isActive == false) {
			GamePanel.currentState = GamePanel.END;
		}
		
		checkCollision();
		purgeObjects();
		
		
		}
	
	
	
	
	public void purgeObjects() {
		for (int i = 0; i < logs.size(); i++) {
			if(logs.get(i).isActive == false) {
				logs.remove(i);
			}
		}
		
		for (int i = 0; i < cars.size(); i++) {
			if(cars.get(i).isActive == false) {
				cars.remove(i);
			}
		}	
	
	}
	
	
	
	
	public void draw(Graphics g) {
		for (int i = 0; i < logs.size(); i++) {
			logs.get(i).draw(g);
		
		}
		
		for (int i = 0; i < cars.size(); i++) {
			cars.get(i).draw(g);

			
			}
		
		frog.draw(g);
		}
	
	
	public void checkCollision() {
		for (int i = 0; i < cars.size(); i++) {
			if(frog.collisionBox.intersects(cars.get(i).collisionBox)) {
				cars.get(i).isActive = false;
				frog.isActive = false;
				
				
		}
		
	}
		
		
		for (int i = 0; i < logs.size(); i++) {
			if(frog.collisionBox.intersects(logs.get(i).collisionBox)) {
				cars.get(i).isActive = false;
				frog.isActive = false;
		}
	}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource() == logSpawn) {
			addLog();
			logSpawn.setDelay((random.nextInt(4) + 1) * 1000);
		} else if (e.getSource() == carSpawn) {
			addCar();
		}
	}
	
}
