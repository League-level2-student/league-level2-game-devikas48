import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{

	Frog frog;
	ArrayList<Log> logs = new ArrayList<Log>();
	ArrayList<Car> cars = new ArrayList<Car>();
	Random random = new Random();
	
	public ObjectManager(Frog frog) {
		this.frog = frog;

	
	}
	

	public void addLog() {
		logs.add(new Log(random.nextInt(Frogger.width),0,50,50));
	
	}
	
	public void update() {
		for (int i = 0; i < logs.size(); i++) {
			logs.get(i).update();
		
			
			if(logs.get(i).y > Frogger.height) {
				logs.get(i).isActive = false;
			}
		}
		
		for (int i = 0; i < cars.size(); i++) {
			cars.get(i).update();
		
			if(logs.get(i).y > Frogger.height) {
				logs.get(i).isActive = false;
			}
			
			}
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


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
