
/**
 * Class Car extends from class Fordon and is a vehicle that is created with 2 parameters called bornTime and dest
 * bornTime is the time a Car is created, dest is its destitanion
 * 
 */

public class Car extends Fordon{

/**
 * creates a Car-object
 *@param bornTime The time a car enters a simulation
 *@param the destination of car
 *@return An object of type Car.
 */

    public Car(int bornTime, int dest){
	super.bornTime = bornTime;
	super.dest = dest;
    }
/**
 * returns the string representation of a car.
 *@return string representing car.
 */

    public  String toString() {
	return "O";
    }
    //hello me is jocke
}
