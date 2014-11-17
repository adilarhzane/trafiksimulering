import java.util.*;

/**
 * Simulation Runs the traffic simulation by taking inputs, creating a
 * trafficsystem using the trafficsystem constructor. Then it just runs the
 * given amount of steps and prints the system after each step.
 */
public class Simulation {
	/**
	 * shows a given message and returns user input
	 * 
	 * @param scanner
	 *            By requiering a scanner parameter we do not need to create a
	 *            new scanner every time we run the function.
	 * @param message
	 *            a string message that is meant to ask for a specific number
	 *            input.
	 * @return the int number given by the user.
	 */
	public static int readNumber(Scanner scanner, String message) {
		int a;
		while (true) {
			try {
				System.out.println(message);
				a = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Try entering a number");

			}
		}
		if (a < 0) {
			System.out.println("No numbers less than 0");
			readNumber(scanner, "lets try again, " + message);
		}
		return a;

	}

	/**
	 * Lets the user enter 1 or 2, which represents what vehicle we want to run
	 * the simulation with.
	 * 
	 * @param scanner
	 *            By requiering scanner as an input we do not need to create a
	 *            new scanner every time.
	 * 
	 * @return int 1 or 2, where 1 = Car and 2 = Bike.
	 */
	public static int choose_1or2(Scanner scanner) {
		int i = 2;
		try {
			i = Integer.parseInt(scanner.nextLine());
			try {
				if (i == 1 || i == 2) {
					return i;
				} else {
					System.out.println("must be 1 or 2");
					return choose_1or2(scanner);

				}

			} catch (NumberFormatException e) {
				// print fel medfelalnde
				return choose_1or2(scanner);
			}

		} catch (NumberFormatException e) {
			System.out.println("Try entering a number");
			choose_1or2(scanner);

		}
		return i;
	}

	/**
	 * The main function takes user input and uses the inputs to create a
	 * trafficsystem which is stepped as many times as the user wants.
	 */
	public static void main(String[] args) {
		// Skapar ett TrafficSystem
		// Utför stegningen, anropar utskriftsmetoder
		int vehicle = 1;
		int intensity = 3;
		int period = 10;
		int greenTime = 6;
		int greenTime2 = 6;
		int r0 = 30;
		int r1 = 10;
		int r2 = 10;
		int cycles = 100;
		Scanner scanner = new Scanner(System.in);

		int system = 1;
		Trafficsystem s;

		System.out.println("Cars(1) or Bikes(2)?");
		vehicle = choose_1or2(scanner);
		System.out
				.println("Whould you like to use default settings(1) or advanced(2)?");
		system = choose_1or2(scanner);
		if (system == 2) {

			cycles = readNumber(scanner, "how many cycles?");
			intensity = readNumber(scanner,
					"intensity? (1 vehicle in every X second).");
			period = readNumber(scanner, "What period would you want to use?");
			greenTime = readNumber(scanner,
					"what green time would you want to use for the straight row?");
			greenTime2 = readNumber(scanner,
					"What green time would you like to use for the turn lane?");
			r0 = readNumber(scanner,
					"what length would you like for the runup road?");
			r2 = readNumber(scanner,
					"what length would you like for the turn lane?");
			r1 = r2;
			s = new Trafficsystem(vehicle, r0, r1, period, greenTime,
					greenTime2, intensity);
		} else {
			s = new Trafficsystem(vehicle);
		}
		System.out.println("The simulation is starting");

		for (int o = 0; o < cycles; o++) {
			s.step();
			s.print();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		s.printStatistics();

	}
}
