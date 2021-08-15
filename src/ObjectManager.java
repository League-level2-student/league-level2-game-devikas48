import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

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
	}
	
}
