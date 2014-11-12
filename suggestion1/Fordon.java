/**
 * Fordon is the super class of all vehicles, it contains the basic methods and variables that a subclass wants.
 * 
 */

public abstract class Fordon{
    /**
     * BornTime is the time a vehicle enters a simulation.
     */

    int bornTime;
    /**
     * dest is the destination of a vehicle.
     */
    int dest;
    /**
     * returns the bornTime of vehicle.
     * @return bornTime
     */
    
    public int return_bornTime(){
	return bornTime;
    }
    /**
     *returns destination of a vehicle.
     * @return dest.
     */
    
    public int returnDest(){
	return dest;
    }
    /**
     * returns a string representation of a Fordon. 
     */
    public abstract String toString();

    
}
