public class AverageOperation extends FilterOperation{
	
	//erzeugt eine neue AverageOperation.
	public AverageOperation(){}
	
	/*f�hrt mit dem �bergebenen Block den Mittelwertfilter aus. 
	Daf�r wird das arithmetische Mittel der Helligkeitswerte bestimmt. 
	Das Ergebnis wird mathematisch gerundet und als Ergebnis f�r diesen 
	Block zur�ckgegeben.*/
	public int filter(int[] values){
		int out=0;
		for(int i = 0 ; i<values.length;i++){
			out=out+values[i];	
		}
		
		return (int) Math.round(((double)out)/9.0);
	}
}
