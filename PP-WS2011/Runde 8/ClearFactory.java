import java.util.Scanner;
public class ClearFactory implements Factory{
	
	//erzeugt eine neue ClearFactory.
	public ClearFactory(){}
	
	//erzeugt eine neue ClearOperation und gibt diese zur�ck.
	public Operation create(Scanner scanner){
		return new ClearOperation();
	}
	
}
