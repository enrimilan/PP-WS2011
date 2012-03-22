import java.util.Scanner;
public class SearchFactory implements Factory{
	private MetricSet<AsciiImage> saved;
	
	//erzeugt eine neue SearchFactory.
	public SearchFactory(MetricSet<AsciiImage> saved){
		this.saved=saved;
	}
	
	public Operation create(Scanner scanner) throws FactoryException{
		if(!scanner.hasNext()){
			throw new FactoryException("Kein Parameter vorhanden");
		}
		Metric<AsciiImage> result;
		String s = scanner.next();
		if(s.equals("pixelcount")){
			result = new PixelCountMetric();
		}
		else if(s.equals("uniquechars")){
			result = new UniqueCharsMetric();
		}
		else{
			throw new FactoryException("Parameter ist nicht pixelcount oder uniquechars");
		}
		return new SearchOperation(saved , result);
	}
}
