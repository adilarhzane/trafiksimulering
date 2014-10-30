public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen grön när time<green 

    public Light(int period, int green) {
	this.period = period;
	this.green = green;
	time = 0;
    }

    public void    step() { 
       // Stegar fram klocka ett steg
	
	time++;
	time = time % period;
    }

    public boolean isGreen()   {
	// Returnerar true om time<green, annars false
	if(time<green){
	    return true;
	}else {return false;}
    }

    public String  toString()  {return period + " " + time + " " + green + ".";}
	
}
