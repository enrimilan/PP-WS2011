public class AsciiPoint {
	//Koordinaten.
	private int x ;
	private int y ;
	
	//Konstruktor.
	public AsciiPoint(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	//Gibt die Koordinate x zurück.
	public int getX(){
		return x ;
	}
	
	//Gibt die Koordinate y zurück.
	public int getY(){
		return y;
	}
	
	//Gibt eine lesbare Darstellung des Punktes in der Form (x,y) zurück.
	public String toString(){
		return "("+x+","+y+")";
	}
}
