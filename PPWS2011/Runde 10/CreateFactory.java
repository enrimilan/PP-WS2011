import java.util.Scanner;
public class CreateFactory implements Factory {
	
	//erzeugt eine neue CreateFactory.
	public CreateFactory(){}
	
	/*liest mit Hilfe des Scanners Breite und H�he und einen String ein und gibt eine damit initialisierte neue 
	CreateOperation zur�ck. Tritt beim Einlesen ein Fehler (zu wenig Parameter, falsche Parameter), so wird eine 
	FactoryException geworfen.*/
	public Operation create(Scanner scanner) throws FactoryException{
		if(!scanner.hasNextInt()){
			throw new FactoryException("Breite Fehlt!");
		}
		int width = scanner.nextInt();
		
		if(!scanner.hasNextInt()){
			throw new FactoryException("Hoehe Fehlt!");
		}
		int height = scanner.nextInt();
		
		if(!scanner.hasNext()){
			throw new FactoryException("Charset Fehlt!");
		}
		String charset = scanner.next();	
		
		return new CreateOperation(width , height , charset);
	}
}
