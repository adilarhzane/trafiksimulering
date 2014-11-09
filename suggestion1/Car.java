public class Car extends Fordon{
    //private int bornTime;
    //private int dest; // 1 för rakt fram, 2 för vänstersväng

    // konstruktor och get-metoder
    public Car(int bornTime, int dest){
	super.bornTime = bornTime;
	super.dest = dest;
    }
    /*    public int returnDest(){
	return dest;
    }
    public int return_bornTime(){
	return bornTime;
	}
    */
    public String toString() {
	return "O";
    }
    
}
