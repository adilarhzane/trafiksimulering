/**
 * Class Lane creates a lane with length n
 */
public class Lane {

	public static class OverflowException extends RuntimeException {
		// Undantag som kastas när det inte gick att lägga
		// in en ny bil på vägen

	}

	private Fordon[] theLane;

	/**
	 * Creates a new Lane object with the size for n veichles
	 * 
	 * @param n
	 *            Specifies the number of vehicles possible on the lane
	 */

	public Lane(int n) {
		// Konstruerar ett Lane-objekt med plats för n fordon
		theLane = new Fordon[n];
	}

	/**
	 * Creates a copy of a given Lane object
	 * 
	 * @param another
	 *            is a lane that you want to copy
	 */
	public Lane(Lane another) {
		this.theLane = another.theLane;
	}

	/**
	 * Moves all the veichles on the lane, except the first veichle on the lane,
	 * one step forward if possible
	 */
	public void step() {
		// Stega fram alla fordon (utom det på plats 0) ett steg
		// (om det går). (Fordonet på plats 0 tas bort utifrån
		// mm h a metoden nedan.)
		for (int i = 1; i < theLane.length; i++) {
			if (theLane[i - 1] == null) {
				theLane[i - 1] = theLane[i];
				theLane[i] = null;
			}
		}
	}

	/**
	 * Checks how many cars are left in the specific lane chosen
	 * 
	 * @return An array of type Car
	 */
	public int carsLeft() {
		int cars = 0;
		for (int o = 0; o < theLane.length; o++) {
			if (theLane[o] != null) {
				cars++;

			}

		}

		return cars;
	}

	/**
	 * Returns the vehicle in the first position in the lane and removes it from
	 * the lane
	 * 
	 * @return An object of type Fordon
	 */
	public Fordon getFirst() {
		// Returnera och tag bort bilen som står först
		Fordon firstCar = theLane[0];
		theLane[0] = null;
		return firstCar;
	}

	/**
	 * Returns the first vehicle in the lane, without removing in from the lane
	 * 
	 * @return An object of type Fordon
	 */
	public Fordon firstCar() {
		// Returnera bilen som står först utan att ta bort den
		return theLane[0];
	}

	/**
	 * Checks if the last position in the lane is free
	 * 
	 * @return true or false
	 */
	public boolean lastFree() {
		// Returnera true om sista platsen ledig, annars false
		return theLane[theLane.length - 1] == null;
	}

	/**
	 * Puts a Car in the last position in a lane
	 * 
	 * @param c
	 *            is of type Fordon
	 * 
	 */
	public void putLast(Fordon c) {
		// Ställ en bil på sista platsen på vägen
		// (om det går).
		if (lastFree()) {
			theLane[theLane.length - 1] = c;
		}
	}

	/**
	 * returns the string representation of Lane, creates the road which cars or
	 * bikes travels on
	 * 
	 * @return string representing Lane
	 */

	public String toString() {
		String s = "<";
		for (int i = 0; i < theLane.length; i++) {
			if (theLane[i] == null) {
				s += "-";
			} else {
				s += theLane[i].toString();
			}
		}
		s += "<";
		return s;
	}

}
