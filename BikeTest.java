import static org.junit.Assert.*;

import org.junit.Test;


public class BikeTest {
    Bike testBike = new Bike(12,1);
    @Test
    public void TestgetDest(){	
    	assertTrue(testBike.returnDest() == 1);
	
    }
    @Test
    public void TestgetBornTime(){
    	assertTrue(testBike.return_bornTime() == 12);
    }
    @Test
    public void TestToString(){
    	assertTrue(testBike.toString() == "B");
    }
    

}
