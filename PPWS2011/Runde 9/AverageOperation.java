public class AverageOperation extends FilterOperation{
	
	//erzeugt eine neue AverageOperation.
	public AverageOperation(){}
	
	/*führt mit dem übergebenen Block den Mittelwertfilter aus. 
	Dafür wird das arithmetische Mittel der Helligkeitswerte bestimmt. 
	Das Ergebnis wird mathematisch gerundet und als Ergebnis für diesen 
	Block zurückgegeben.*/
	public int filter(int[] values){
		int out=0;
		for(int i = 0 ; i<values.length;i++){
			out=out+values[i];	
		}
		
		return (int) Math.round(((double)out)/9.0);
	}
}
