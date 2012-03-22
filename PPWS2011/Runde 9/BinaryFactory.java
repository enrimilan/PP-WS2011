import java.util.Scanner;
public class BinaryFactory implements Factory{
	
	//erzeugt eine neue BinaryFactory.
	public BinaryFactory(){}
	
	/*liest mit dem Scanner das Schwellwert Zeichen ein, erzeugt damit eine neue 
	BinaryOperation und gibt diese zurück. Tritt beim Einlesen des Zeichens ein 
	Fehler auf, so wird eine FactoryException geworfen.*/
	public Operation create(Scanner scanner) throws FactoryException{
		if(!scanner.hasNext()){
			throw new FactoryException("Parameter nicht vorhanden");
		}
		String s = scanner.next();
		if(s.length()>1){
			throw new FactoryException("Parameter zu lang");
		}
		return new BinaryOperation(s.charAt(0));
	}
}
