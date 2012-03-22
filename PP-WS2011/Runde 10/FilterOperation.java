abstract public class FilterOperation implements Operation{
	
	//Konstruktor der FilterOperation.
	public FilterOperation(){}
	
	/*f�hrt den Blockfilter aus. Diese Methode muss von abgeleiteten Klassen nicht �berschrieben 
	werden. Die Methode durchl�uft das Bild, bestimmt f�r jeden Pixel den Block an Nachbarpixeln 
	und ruft damit dann die Methode filter auf. Das Ergebnis dieser Methode wird dann als neuer 
	Pixel an der aktuellen Stelle gesetzt.*/
	public AsciiImage execute(AsciiImage img){
		AsciiImage neu = new AsciiImage(img);
		int[] rand=new int[9];//Index-Array der Zeichen
		int k=0;//Z�hlvariable
		for(int y=0;y<img.getHeight();y++){
			for(int x=0;x<img.getWidth();x++){
				char c = img.getPixel(x,y);
				for(int i =y-1 ;i<=y+1;i++){
					for(int j=x-1;j<=x+1;j++){
						if(i<0 || i>=img.getHeight() || j<0 || j>=img.getWidth()){
							rand[k++]=img.getCharset().length()-1;
						}
						else{
							rand[k++]=img.getCharset().indexOf(img.getPixel(j,i));	
						}
					}
				}
				k=0;
				neu.setPixel(x,y,img.getCharset().charAt(filter(rand)));
			}
		}	
		return neu;
	}
	
	/*muss von den abgeleiteten Klassen implementiert werden. Sie f�hrt die eigentliche Logik 
	des Filters durch. Das �bergebene Array umfasst die Helligkeitswerte der Pixel im Block Zeile 
	f�r Zeile. Diese Methode gibt den berechneten Helligkeitswert f�r den neuen Pixel zur�ck.*/
	public abstract int filter(int[] values);
	
}
