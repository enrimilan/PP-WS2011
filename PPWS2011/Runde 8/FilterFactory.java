import java.util.Scanner;
public class FilterFactory implements Factory {
	
	//erzeugt eine neue FilterFactory.
	public FilterFactory(){}
	
	/*liest den nächsten String ein und gibt, falls dieser ‘median’ ist, eine neue 
	MedianOperation zurück. Tritt beim Einlesen des Strings ein Fehler auf, oder 
	ist der String nicht ‘median’, so wird eine FactoryException geworfen.*/
	public Operation create(Scanner scanner) throws FactoryException{
		if(!scanner.hasNext()){
			throw new FactoryException("Kein Parameter vorhanden");
		}
		
		String s = scanner.next();
		if(s.equals("median")){
			return new MedianOperation();
		}
		else{
			throw new FactoryException("Parameter ist nicht median");
		}
		
		
	}
}
