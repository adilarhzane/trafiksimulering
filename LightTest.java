import static org.junit.Assert.*;

import org.junit.Test;


public class LightTest {
	Light light = new Light(2,1);
	@Test
	public void test_isGreen() {
		assertTrue(light.isGreen());
		light.step();
		assertFalse(light.isGreen());
	}

}
