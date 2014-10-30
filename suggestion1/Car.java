public class Car {
    private int bornTime;
    private int dest; // 1 för rakt fram, 2 för vänstersväng

    // konstruktor och get-metoder
    public Car(int bornTime, int dest){
	this.bornTime = bornTime;
	this.dest = dest;
    }
    public String toString() {
	return bornTime + " " + dest;
    }
    
}
