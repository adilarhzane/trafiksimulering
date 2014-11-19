import static org.junit.Assert.*;

import org.junit.Test;

public class LaneTest {
	Lane lane = new Lane(2);
	Lane lane2 = new Lane(3);
	Car car = new Car(1, 1);

	// but a car last in lane, asserts false on lane.lastFree(), asserts true on
	// lane2.lastFree().
	@Test
	public void test_putLast() {
		lane.putLast(car);
		assertFalse(lane.lastFree());
		assertTrue(lane2.lastFree());
		lane.step();
		assertTrue(lane.lastFree());
	}

	// a lane with length 2, puts car last, firstCar = null. steps lane and
	// firstCar is the car we just put in.
	@Test
	public void test_firstCar() {
		lane.putLast(car);
		assertTrue(lane.firstCar() == null);
		lane.step();
		assertFalse(lane.firstCar() == null);
	}

	// again, length 2 lane. putlast -> step -> check if the first car is equal
	// to the one we put in.
	@Test
	public void test_getFirst() {
		lane.putLast(car);
		lane.step();
		Fordon equalCar = lane.firstCar();
		assertTrue(equalCar == car);
		assertEquals(lane.getFirst(), car);
	}

	// adds 3 cars checks if there are 3 cars left. takes one away, checks if
	// there are 2 left
	@Test
	public void test_carsLeft() {
		lane2.putLast(car);
		lane2.step();
		lane2.putLast(car);
		lane2.step();
		lane2.putLast(car);
		assertEquals(lane2.carsLeft(), 3);
		lane2.getFirst();
		assertEquals(lane2.carsLeft(), 2);
	}

}
