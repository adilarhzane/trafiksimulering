/**
 * Class Bike extends class Fordon and is a vehicle that is created with 2 parameters called bornTime and dest
 * bornTime is the time a Bike is created, dest is its destitanion
 */
public class Bike extends Fordon{
     
    /**
     *Creates an object of instance Bike
     *@param bornTime >= 0
     *@param dest is either 1 or 2
     *@return object of instance Bike
     */

    public Bike(int bornTime, int dest){
	super.bornTime = bornTime;
	super.dest = dest;
    }
    
    
    
    
    /**
     *returns a string representation of a Bike.
     *@return string representation of bike.
     */

    
    public String toString(){
	return "B";
    }
}
