public class BinaryOperation implements Operation{
	private char threshold;
	
	//erzeugt eine neue BinaryOperation mit dem entsprechenden Schwellwert.
	public BinaryOperation(char threshold){
		this.threshold=threshold;
	}
	
	/*gibt ein neues AsciiImage zurück, das das Binärbild des übergebenen AsciiImage ist. 
	Zur Umwandlung in ein Binärbild werden alle Zeichen, die im Zeichensatz des Bildes 
	vor dem Schwellwert kommen, auf das dunkelste Zeichen gesetzt, alle Zeichen ab dem 
	Schwellwert werden auf das hellste Zeichen gesetzt. Sollte das Schwellwertzeichen 
	nicht im Zeichensatz des AsciiImage vorkommen, so wird eine OperationException geworfen.*/
	public AsciiImage execute(AsciiImage img) throws OperationException{
		String charset = img.getCharset();
		if(!charset.contains(""+threshold)){
			throw new OperationException("Schwellwertzeichen nicht im Zeichensatz");
		}
		AsciiImage neu = new AsciiImage(img);
		for(int y=0;y<img.getHeight();y++){
			for(int x = 0;x<img.getWidth();x++){
				if(charset.indexOf(threshold)<=charset.indexOf(img.getPixel(x,y))){
					neu.setPixel(x,y,charset.charAt(charset.length()-1));
				}
				else{
					neu.setPixel(x,y,charset.charAt(0));
				}
			}
		}
		return neu;
		
	}
}
