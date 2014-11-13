import static org.junit.Assert.*;

import org.junit.Test;


public class TrafficsystemTest {
	Trafficsystem s = new Trafficsystem(1, 30, 10, 10, 6, 6, 3);

	@Test
	public void test_methods(){
		s.createCar();
		s.createBike();
		s.step();
		s.step();
		s.step();
	}
	

}
