import static org.junit.Assert.*;

import org.junit.Test;


public class CarTest {
	Car testCar = new Car(40,2);
	@Test
	public void TestReturnDest(){	
			assertTrue(testCar.returnDest() == 2);
		
		}
	@Test    
	public void TestReturn_BornTime(){
	    	assertTrue(testCar.return_bornTime() == 40);
	    }
	@Test
	public void TestToString(){
			assertTrue(testCar.toString() == "O");
	    }	

}
