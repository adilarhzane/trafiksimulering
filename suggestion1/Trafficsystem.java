import java.util.*;
import java.io.*;

public class Trafficsystem {
    // Definierar de vägar och signaler som ingår i det 
    // system som skall studeras.
    // Samlar statistik
    
    // Attribut som beskriver beståndsdelarna i systemet
    private Lane  r0;
    private Lane  r1;
    private Lane  r2;
    private Light s1;
    private Light s2;
    //Car = 1, Bike = 2;
    private int vehicle;
    
    //intensity is used to randomly put cars into the system
    //intensity = 3 means a new car is made randomly about every 4 seconds
    private int intensity;
    private int time = 0;
    //variables for statistics
    private int longestTime;
    private int averageTime;
   

    // Diverse attribut för simuleringsparametrar (ankomstintensiteter,
    // destinationer...)

    // Diverse attribut för statistiksamling
    public ArrayList<Fordon> D1 = new ArrayList<Fordon>();
    public ArrayList<Fordon> D2 = new ArrayList<Fordon>();
    
    //
   

    public Trafficsystem(int vehicle, int r0, int r1, int period, int greenTime, int greenTime2,  int intensity) {
	//lanes
	this.vehicle = vehicle;
	this.r0 = new Lane(r0);
	this.r1 = new Lane(r1);
	this.r2 = new Lane(r1);
	//lights
	this.s1 = new Light(period, greenTime);
	this.s2 = new Light(period, greenTime2);
	this.intensity = intensity;
	this.longestTime = 0;
	this.averageTime = 0;
    }

    public ReadString readParameters() {
	// Läser in parametrar för simuleringen
	// Metoden kan läsa från terminalfönster, dialogrutor
	// eller från en parameterfil. Det sista alternativet
	// är att föredra vid uttestning av programmet eftersom
	// man inte då behöver mata in värdena vid varje körning.
        // Standardklassen Properties är användbar för detta. 

	//Terminal-input metoden
	return null;
    }
    //not sure this function should be here or in Simulation.
  
    
    public void createCar(){
	Random rand = new Random();
	int randInt = rand.nextInt(intensity);
	if (randInt == 0){
	    Car newCar = new Car(time, rand.nextInt(2)+1);
	    r0.putLast(newCar);
	}
    }
    public void createBike(){
	Random rand = new Random();
	int randInt = rand.nextInt(intensity);
	if (randInt == 0){
	    Bike newBike = new Bike(time, rand.nextInt(2)+1);
	    r0.putLast(newBike);
	}
    }

    public void step() {
	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna
	s1.step();
	s2.step();

	if(s2.isGreen() && r2.firstCar() != null){
	     if((time - r2.firstCar().return_bornTime()) > longestTime){
		 longestTime = (time - r2.firstCar().return_bornTime());
	    } 
	     averageTime = averageTime + (time -(r2.firstCar().return_bornTime()));
	     D2.add(r2.getFirst());
	    
	}
	r2.step();

	if(s1.isGreen() && r1.firstCar() !=null){
	    if((time - r1.firstCar().return_bornTime()) > longestTime){
		longestTime = (time - r1.firstCar().return_bornTime());
	    }
	    averageTime = averageTime + (time -(r1.firstCar().return_bornTime()));
	    D1.add(r1.getFirst());
	}
	r1.step();

	if(r0.firstCar() != null && r0.firstCar().returnDest() == 2){
	    r2.putLast(r0.getFirst());
	}
	else if(r0.firstCar() != null && r0.firstCar().returnDest() == 1){
	    r1.putLast(r0.getFirst());
	}
	r0.step();
	if(vehicle == 1){
	    this.createCar();
	} else{this.createBike();}
	this.time++;
    }

    public void printStatistics() {
	// Skriv statistiken samlad så här långt


	if(D1.size() == 0 && D2.size() == 0){
	    System.out.println("no vehicle made it throught the system. Try increasing the time of the simulation");
	}else{
	    System.out.println("Average time in the simulation: "+averageTime/(D1.size()+D2.size())+"\n");
	    System.out.println("Longest time in the simulation: "+longestTime+"\n");
	    System.out.println("Vehicles that went straight: ");
	    System.out.println(D1.size()+"\n");
	    
	    System.out.println("Vehicles that went left: ");
	    System.out.println(D2.size()+"\n");
	    System.out.println("Total amount of vehicles that finished the simulation: ");
	    System.out.println(D2.size() + D1.size() +"\n");
	    int carsLeft = r0.carsLeft() + r1.carsLeft() + r2.carsLeft();
	    System.out.println("Vehicles still in the system: " + carsLeft + "\n");
	}
	

    }

    public void print() {
	// Skriv ut en grafisk representation av kösituationen
	// med hjälp av klassernas toString-metoder
	System.out.println(s1.toString() +r1.toString() + r0.toString() + "\n" + s2.toString()+r2.toString()+"\n");
    }
}
