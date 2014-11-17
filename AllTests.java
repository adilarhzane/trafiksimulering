import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ BikeTest.class, CarTest.class, LaneTest.class, LightTest.class,
		SimulationTest.class, TrafficsystemTest.class })
public class AllTests {
	

}
