import java.lang.*;

public class Lane {

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas när det inte gick att lägga 
        // in en ny bil på vägen
    }

    private Fordon[] theLane;

    public Lane(int n) {
	// Konstruerar ett Lane-objekt med plats för n fordon
	theLane = new Fordon[n];
    }
    
    
    
    public void step() {
	// Stega fram alla fordon (utom det på plats 0) ett steg 
        // (om det går). (Fordonet på plats 0 tas bort utifrån 
	// mm h a metoden nedan.)
	for(int i = 1; i<theLane.length; i++){
	    if(theLane[i-1] == null){
		theLane[i-1]=theLane[i];
		theLane[i] = null;
	    }
	}
    }
    public int carsLeft(){
	int cars = 0;
	for(int o = 0;o<theLane.length;o++){
	    if (theLane[o] != null){
		cars++;
		
	    }
	    
	}
	
	return cars;
    }

    public Fordon getFirst() {
	// Returnera och tag bort bilen som står först
	Fordon firstCar = theLane[0];
	theLane[0] = null;
	return firstCar;
    }

    public Fordon firstCar() {
	// Returnera bilen som står först utan att ta bort den
	return theLane[0];
    }


    public boolean lastFree() {
	// Returnera true om sista platsen ledig, annars false
	return theLane[theLane.length-1] == null;
    }

    public void putLast(Fordon c) throws OverflowException {
	// Ställ en bil på sista platsen på vägen
	// (om det går).
	if(lastFree()){
	    theLane[theLane.length -1] = c;
	}else{throw new OverflowException();}
    }

    public String toString() {
	String s = "<";
	for(int i=0;i<theLane.length; i++){
	    if(theLane[i] == null){
		s+="-";
	    }else{s+= theLane[i].toString();}
	}
	s+="<";
	return s;
    }

}
