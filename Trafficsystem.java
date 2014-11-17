import java.util.*;

/**
 * Trafficsystem is a system that combines the classes Fordon, Light, Lane.
 * Trafficsystem runs the whole simulation but needs to be told what to do and
 * when.
 */
public class Trafficsystem {
	// Definierar de vägar och signaler som ingår i det
	// system som skall studeras.
	// Samlar statistik

	// Attribut som beskriver beståndsdelarna i systemet
	private Lane r0;
	private Lane r1;
	private Lane r2;
	private Light s1;
	private Light s2;
	// Car = 1, Bike = 2;
	private int vehicle;

	// intensity is used to randomly put cars into the system
	// intensity = 3 means a new car is made randomly about every 4 seconds
	private int intensity;
	private int time = 0;
	// variables for statistics
	private int longestTime;
	private int averageTime;

	private int notEntered = 0;

	// Diverse attribut för simuleringsparametrar (ankomstintensiteter,
	// destinationer...)

	// Diverse attribut för statistiksamling
	/**
	 * D1 is the end state of vehicles that finished to trafficsystem and had
	 * dest = 1.
	 */
	public ArrayList<Fordon> D1 = new ArrayList<Fordon>();
	/**
	 * D2 is the end state of vehicles that finished the trafficsystem and had
	 * dest = 2.
	 */
	public ArrayList<Fordon> D2 = new ArrayList<Fordon>();

	//
	/**
	 * creates a trafficSystem, the user is allowed to enter the length of lanes
	 * greentimes and light intervals to study a traffic situation.
	 * 
	 * @param vehicle
	 *            is 1 if we want create a system using cars and is 2 if we use
	 *            Bikes.
	 * @param r0
	 *            the length of lane r0.
	 * @param r1
	 *            the length of lane r1 and lane r2, since they have the same
	 *            length.
	 * @param period
	 *            the time interval of the lights.
	 * @param greenTime
	 *            as long as the time counter is less than greenTime the light
	 *            will be green (the straight lane).
	 * @param greenTime2
	 *            same as greenTime except this is the greentime for the second
	 *            light (the left turn lane).
	 * @param intensity
	 *            the createCar and createBike method uses intensity to know how
	 *            often a vehicle should be added to the system, 1 vehicle every
	 *            X step. For example intensity = 3 and 90 ticks would spawn
	 *            about 30 cars. since it uses Random it's mostly not axactly
	 *            30.
	 */
	public Trafficsystem(int vehicle, int r0, int r1, int period,
			int greenTime, int greenTime2, int intensity) {
		// lanes
		this.vehicle = vehicle;
		this.r0 = new Lane(r0);
		this.r1 = new Lane(r1);
		this.r2 = new Lane(this.r1);
		// lights
		this.s1 = new Light(period, greenTime);
		this.s2 = new Light(period, greenTime2);
		this.intensity = intensity;
		this.longestTime = 0;
		this.averageTime = 0;
	}

	public Trafficsystem(int vehicle) {
		this.vehicle = vehicle;
		this.r0 = new Lane(30);
		this.r1 = new Lane(10);
		this.r2 = new Lane(10);
		// lights
		this.s1 = new Light(10, 6);
		this.s2 = new Light(10, 6);
		this.intensity = 3;
		this.longestTime = 0;
		this.averageTime = 0;
	}

	/**
	 * Creates a car and puts it in the last position of the lane. Using Random
	 * to make the simulation more real. The intensity of car spawn is entered
	 * by the user but since it's random it will almost never be exact.
	 * Intensity works as follows, intensity x = 3, a car will be spawned
	 * approximately every 3 seconds.
	 */

	public void createCar() {

		Random rand = new Random();
		int randInt = rand.nextInt(intensity);

		if (randInt == 0) {
			Car newCar = new Car(time, rand.nextInt(2) + 1);
			r0.putLast(newCar);

		}

	}

	/**
	 * Creates a Bike and puts it in the last position of the lane. Using Random
	 * to make the simulation more real. The intensity of bike spawn is entered
	 * by the user but since it's random it will almost never be exact.
	 * Intensity works as follows, intensity x = 3, a bike will be spawned
	 * approximately every 3 seconds.
	 */

	public void createBike() {
		Random rand = new Random();
		int randInt = rand.nextInt(intensity);

		if (randInt == 0) {
			Bike newBike = new Bike(time, rand.nextInt(2) + 1);

			r0.putLast(newBike);
		}

	}

	/**
	 * Steps every object in the right order: Lights, Lanes and then it uses
	 * createBike or createCar. If a vehicle exits lanes: r1 or r2, it will be
	 * put in its end state(D1 or D2) depending on which destination it has.
	 */
	public void step() {
		// Stega systemet ett tidssteg m h a komponenternas step-metoder
		// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna
		s1.step();
		s2.step();

		if (s2.isGreen() && r2.firstCar() != null) {
			if ((time - r2.firstCar().return_bornTime()) > longestTime) {
				longestTime = (time - r2.firstCar().return_bornTime());
			}
			averageTime = averageTime
					+ (time - (r2.firstCar().return_bornTime()));
			D2.add(r2.getFirst());

		}
		r2.step();

		if (s1.isGreen() && r1.firstCar() != null) {
			if ((time - r1.firstCar().return_bornTime()) > longestTime) {
				longestTime = (time - r1.firstCar().return_bornTime());
			}
			averageTime = averageTime
					+ (time - (r1.firstCar().return_bornTime()));
			D1.add(r1.getFirst());
		}
		r1.step();

		if (r0.firstCar() != null && r0.firstCar().returnDest() == 2) {
			r2.putLast(r0.getFirst());
		} else if (r0.firstCar() != null && r0.firstCar().returnDest() == 1) {
			r1.putLast(r0.getFirst());
		}
		r0.step();
		if (r0.lastFree() == false)
			this.notEntered++;
		if (vehicle == 1) {
			this.createCar();
		} else {
			this.createBike();
		}

		this.time++;
	}

	/**
	 * Prints the statistics that has been calculated this far. Average time,
	 * Longest time, vehicles left, and how many vehicles went straight/left.
	 */

	public void printStatistics() {
		// Skriv statistiken samlad så här långt

		if (D1.size() == 0 && D2.size() == 0) {
			System.out
					.println("no vehicle made it throught the system. Try increasing the time of the simulation");
		} else {
			System.out.println("Average time in the simulation: " + averageTime
					/ (D1.size() + D2.size()) + "\n");
			System.out.println("Longest time in the simulation: " + longestTime
					+ "\n");
			System.out.println("Vehicles that went straight: ");
			System.out.println(D1.size() + "\n");

			System.out.println("Vehicles that went left: ");
			System.out.println(D2.size() + "\n");
			System.out
					.println("Total amount of vehicles that finished the simulation: ");
			System.out.println(D2.size() + D1.size() + "\n");
			int carsLeft = r0.carsLeft() + r1.carsLeft() + r2.carsLeft();
			System.out.println("Vehicles still in the system: " + carsLeft
					+ "\n");

			System.out.println("vehicles that could not enter the simulation: "
					+ Integer.toString(notEntered) + "\n");
		}

	}

	/**
	 * Prints the representation of the traffic situation using the
	 * Lane.toString method.
	 */

	public void print() {
		// Skriv ut en grafisk representation av kösituationen
		// med hjälp av klassernas toString-metoder
		System.out.println(s1.toString() + r1.toString() + r0.toString() + "\n"
				+ s2.toString() + r2.toString() + "\n");
	}
}
