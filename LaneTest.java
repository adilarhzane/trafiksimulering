import static org.junit.Assert.*;

import org.junit.Test;

public class LaneTest {
	Lane lane = new Lane(2);
	Lane lane2 = new Lane(3);
	Car car = new Car(1, 1);

	@Test
	public void test_putLast() {
		lane.putLast(car);
		assertFalse(lane.lastFree());
		assertTrue(lane2.lastFree());
		lane.step();
		assertTrue(lane.lastFree());
	}

	@Test
	public void test_firstCar() {
		lane.putLast(car);
		assertTrue(lane.firstCar() == null);
		lane.step();
		assertFalse(lane.firstCar() == null);
	}

	@Test
	public void test_getFirst() {
		lane.putLast(car);
		lane.step();
		Fordon equalCar = lane.firstCar();
		assertTrue(equalCar == car);
		assertEquals(lane.getFirst(), car);
	}

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
