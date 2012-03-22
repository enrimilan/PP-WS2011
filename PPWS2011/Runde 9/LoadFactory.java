import java.util.Scanner;
public class LoadFactory implements Factory{
	
	//erzeugt eine neue LoadFactory.
	public LoadFactory(){}
	
	/*liest den eof-String ein und übergibt in einem String alle Zeilen bis zum abschließenden 
	eof-String durch Zeilenumbrüche getrennt an den Konstruktor der LoadOperation. 
	Tritt beim Einlesen ein Fehler auf (eof fehlt), so wird eine FactoryException geworfen.*/
	public Operation create(Scanner scanner) throws FactoryException{
		if(!scanner.hasNext()){
			throw new FactoryException("Parameter nicht vorhanden");
		}
		String eof = scanner.next();
		String data="";
		boolean end = false;
		while(scanner.hasNext()){
			String line=scanner.next();
			if(line.equals(eof)){
				end=true;
				break;
			}
			data=data+line+"\n";
			
		}
		if(!end){
			throw new FactoryException();
		}
		return new LoadOperation(data);
	}
}
