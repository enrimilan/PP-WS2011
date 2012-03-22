public class FactoryException extends Exception{
	
	/*   erzeugt eine leere FactoryException. Ruft den entsprechenden 
	Super-Konstruktor in der Klasse Exception auf.*/
	public FactoryException(){
		super();
	}
	
	/*erzeugt eine FactoryException mit der entsprechenden Fehlerbeschreibung. 
	Ruft den entsprechenden Super-Konstruktor in der Klasse Exception auf.*/
        public FactoryException(String message){
        	super(message);
        }	
}
