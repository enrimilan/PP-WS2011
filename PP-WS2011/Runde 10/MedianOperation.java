import java.util.Arrays;
public class MedianOperation extends FilterOperation{
	
	//erzeugt eine neue MedianOperation.
	public MedianOperation(){}
	
	/*f�hrt mit dem �bergebenen Block den Medianfilter aus. 
	Die Pixel des Blocks werden nach ihrem Helligkeitswert sortiert. 
	Der Median (also das in der sortierten Liste in der Mitte stehende Zeichen) 
	f�r diesen Block wird als Ergebnis zur�ckgegeben.*/
	public int filter(int[] values){
		Arrays.sort(values);
		return values[4];
	}
	
}
