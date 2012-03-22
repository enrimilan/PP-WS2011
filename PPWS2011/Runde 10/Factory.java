import java.util.Scanner;
public interface Factory{
	
	/*erzeugt ein neues Objekt vom Typ Operation. Welche konkrete Operation erzeugt wird, 
	hängt von der implementierenden Factory ab. Bei Bedarf liest diese Methode vom übergebenen 
	Scanner Parameter ein. Sollten Parameter fehlen oder von einem falschen Typ sein, so soll 
	eine FactoryException geworfen werden.*/
	Operation create(Scanner scanner) throws FactoryException;
}
