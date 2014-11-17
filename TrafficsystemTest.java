import static org.junit.Assert.*;

import org.junit.Test;


public class TrafficsystemTest {
	Trafficsystem s = new Trafficsystem(1, 2, 2, 3, 1, 1, 1);

	@Test
	public void test_methods(){
		s.step();
		s.step();
		s.step();
		
		
	}
	

}
