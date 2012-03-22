public class ClearOperation implements Operation{
	
	//erzeugt eine neue ClearOperation.
	public ClearOperation(){};
	
	/*gibt ein neues AsciiImage zurück, das dem übergebenen AsciiImage entspricht, 
	wobei alle Zeichen auf das hellste Zeichen, sprich dem letzten Zeichen im Zeichensatz des Bildes, gesetzt sind.*/
	public AsciiImage execute(AsciiImage img){
		AsciiImage neu = new AsciiImage(img);
		for(int y=0;y<img.getHeight();y++){
			for(int x=0;x<img.getWidth();x++){
				neu.setPixel(x,y,img.getCharset().charAt(img.getCharset().length()-1));	
			}
		}
		return neu;
	}
}
