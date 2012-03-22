import java.util.Scanner;
public class LoadOperation implements Operation{
	
	private String data;
	
	//erzeugt eine neue LoadOperation mit den entsprechenden Bilddaten.
	public LoadOperation(String data){
		this.data=data;
	}
	
	/*gibt ein neues AsciiImage zurück, das von Größe und Zeichensatz dem 
	übergebenen AsciiImage entspricht und in das die Daten geladen wurden*/
	public AsciiImage execute(AsciiImage img) throws OperationException{
	        AsciiImage neu = new AsciiImage(img);
	        Scanner sc = new Scanner(data);
	        String line="";//Zeile , in dem wir uns befinden.
	        int y=0;//Zählvariable
	        while(sc.hasNextLine()){
	        	line=sc.nextLine();
	        	
	        	if(y>img.getHeight()){
	        		throw new OperationException("Zeile zu viel!");
	        	}
	        	
	        	if((line.length()!=img.getWidth())){
	        		throw new OperationException("Bild zu breit(eng)");
	        	}
	        	//Pixelweise speichern des Bildes.
	        	for(int x = 0 ; x < line.length();x++){
	        		if(!img.getCharset().contains(""+line.charAt(x))){
	        			throw new OperationException("Zeichen ist nicht Teil des Zeichensatzes");
	        		}
	        		neu.setPixel(x,y,line.charAt(x));
	        	}
	        	y++;
	        }
	        
	        if(y!=img.getHeight()){
	        	throw new OperationException("Zeile(n) zu viel(wenig)!");
	        }
	        
	        return neu;
		
	}
}
