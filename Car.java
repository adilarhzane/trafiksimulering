/**
 * Class Car extends from class Fordon and is a vehicle that is created with 2
 * parameters called bornTime and dest bornTime is the time a Car is created,
 * dest is its destitanion
 * 
 */

public class Car extends Fordon {

	/**
	 * creates a Car-object
	 * 
	 * @param bornTime
	 *            The time a car enters a simulation
	 * @param the
	 *            destination of car
	 * @return An object of type Car.
	 */

	public Car(int bornTime, int dest) {
		super(bornTime, dest);
	}

	/**
	 * returns the string representation of a car.
	 * 
	 * @return string representing car.
	 */

	public String toString() {
		return "O";
	}

	// hello me is jocke
	/**
	 * equals check if 2 cars are equivalent, which means they either are
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
		if (!(obj instanceof Car))
			return false;
		Car objCar = (Car) obj;
		if (objCar.dest == this.dest)
			return true;
		return super.equals(obj);

	}
}
