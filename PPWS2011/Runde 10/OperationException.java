public class OperationException extends Exception{
	
	//erzeugt eine leere OperationException.
	public OperationException(){
		super();
	}
	
	//erzeugt eine OperationException mit der entsprechenden Fehlerbeschreibung.
	public OperationException(String message){
        	super(message);
        }
}
