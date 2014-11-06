public class Car {
    private int bornTime;
    private int dest; // 1 för rakt fram, 2 för vänstersväng

    // konstruktor och get-metoder
    public Car(int bornTime, int dest){
	this.bornTime = bornTime;
	this.dest = dest;
    }
    public int returnDest(){
	return dest;
    }
    public int return_bornTime(){
	return bornTime;
    }
    public String toString() {
	return "(: entered: "+bornTime+". Destination: "+dest+". :]";
    }
    
}
