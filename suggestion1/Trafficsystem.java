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

    // Diverse attribut för simuleringsparametrar (ankomstintensiteter,
    // destinationer...)

    // Diverse attribut för statistiksamling
    public ArrayList<Car> D1 = new ArrayList();
    public ArrayList<Car> D2 = new ArrayList();
    
    private int time = 0;

    public TrafficSystem() {}

    public ReadInput readParameters() {
	// Läser in parametrar för simuleringen
	// Metoden kan läsa från terminalfönster, dialogrutor
	// eller från en parameterfil. Det sista alternativet
	// är att föredra vid uttestning av programmet eftersom
	// man inte då behöver mata in värdena vid varje körning.
        // Standardklassen Properties är användbar för detta. 

	//Terminal-input metoden
	ReadInput ri = new ReadInput();
	return ri;
	


    }

    public void step() {
	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna
	s1.step();
	s2.step();

	if(s2.isGreen() && r2.firstCar() != null){
	    D2.add(r2.getFirst());
	}
	r2.step();

	if(s1.isGreen() && r1.firstCar() !=null){
	    D1.add(r1.getFirst());
	}
	r1.step();

	if(r0.firstCar().returnDest() == 2){
	    r2.putLast(r0.getFirst());
	}
	else if(r0.firstCar().returnDest() == 1){
	    r1.putLast(r0.getFirst());
	}
	r0.step();
    }

    public void printStatistics() {
	// Skriv statistiken samlad så här långt
    }

    public void print() {
	// Skriv ut en grafisk representation av kösituationen
	// med hjälp av klassernas toString-metoder
	System.out.println(r1.toString()+r0.toString()+"\n"+r2.toString());
    }

}
