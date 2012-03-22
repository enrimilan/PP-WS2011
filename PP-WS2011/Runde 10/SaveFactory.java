import java.util.Scanner;
public class SaveFactory implements Factory{
	private MetricSet<AsciiImage> saved;
	
	//erzeugt eine neue SaveFactory.
	public SaveFactory(MetricSet<AsciiImage> saved){
		this.saved = saved;
	}
	
	//Erzeugt eine neue SaveOperation.
	public Operation create(Scanner scanner) throws FactoryException{
		return new SaveOperation(saved);
	}
}
