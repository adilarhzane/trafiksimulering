/**
 * Class Bike extends class Fordon and is a vehicle that is created with 2
 * parameters called bornTime and dest bornTime is the time a Bike is created,
 * dest is its destitanion
 */
public class Bike extends Fordon {

	/**
	 * Creates an object of instance Bike
	 * 
	 * @param bornTime
	 *            >= 0
	 * @param dest
	 *            is either 1 or 2
	 * @return object of instance Bike
	 */

	public Bike(int bornTime, int dest) {
		super(bornTime, dest);
	}

	/**
	 * equals check if 2 bikes are equivalent, which means they either are
	 * identical or they have the same dest.
	 * 
	 * @param obj
	 *            the object we are comparing with
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Bike))
			return false;
		Bike objBike = (Bike) obj;
		if (objBike.dest == this.dest)
			return true;
		return super.equals(obj);
	}

	/**
	 * returns a string representation of a Bike.
	 * 
	 * @return string representation of bike.
	 */

	public String toString() {
		return "B";
	}
}
