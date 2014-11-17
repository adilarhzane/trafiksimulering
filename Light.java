
/**
 * Class Light is created with two parameters called period and green
 *period is the time interval for the trafic light, and green is the length of the green time.
 */

public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen grön när time<green 

    /**
     * creates a Light-object
     *@param period Time interval for the Light
     *@param green checks if green light, cars or bikes and only pass if the light is green
     *@return An object of type Light.
     */

    public Light(int period, int green) {
	this.period = period;
	this.green = green;
	time = 0;
    }

    /**
     * Moves the time forward one step at a time.
     */

    public void step() { 
       // Stegar fram klocka ett steg
	
	time++;
	time = time % period;
    }


    /**
     * Checks if it is green light or red light
     *@return true or false
     */
    public boolean isGreen()   {
	// Returnerar true om time<green, annars false
	if(time<green){
	    return true;
	}else {return false;}
    }
    
    /**
     * returns the string representation of the light, [G] for green [R] for red
     *@return string representing Light
     */
    public String  toString()  {if(this.isGreen()){return "[G]";}else{return "[R]";}
	
    }
}
