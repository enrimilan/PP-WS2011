import java.util.Scanner;
public class FilterFactory implements Factory {
        
        //erzeugt eine neue FilterFactory.	
	public FilterFactory(){}
	
	/*liest den n�chsten String ein und gibt, je nach Parameter, 
	eine neue MedianOperation (bei �median�) oder eine neue AverageOperation (bei �average�) 
	zur�ck. Ist der Typ unbekannt, so wird eine FactoryException geworfen.*/
	public Operation create(Scanner scanner) throws FactoryException{
		if(!scanner.hasNext()){
			throw new FactoryException("Kein Parameter vorhanden");
		}
		
		String s = scanner.next();
		if(s.equals("median")){
			return new MedianOperation();
		}
		else if(s.equals("average")){
			return new AverageOperation();
		}
		else{
			throw new FactoryException("Parameter ist nicht median");
		}
		
		
	}
}
