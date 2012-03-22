import java.util.ArrayList;
public class AsciiImage {
	private int height  ;
	private int width  ;
	private String charset;
	private char[][] image ;
	
	//erzeugt ein ASCII-Bild der spezifizierten Größe. Anfangs sind alle Pixel auf des hellste Zeichen gesetzt.
	public AsciiImage(int width , int height,String charset) {
		if(width<=0||height<=0||charset.length()==0){
			throw new IllegalArgumentException();
		}
		
		//Prüfen des Zeichensatzes.
		String tmp="";
		for(int i = 0;i<charset.length();i++){
			if(tmp.contains(""+charset.charAt(i))){
				throw new IllegalArgumentException();
			}
			tmp=tmp+charset.charAt(i);
		}
		
		this.height=height;
		this.width=width;
		this.charset=charset;
		image = new char[height][width];
		
	}
	
	//Kopierkonstruktor.
	public AsciiImage(AsciiImage img){
		this.height=img.height;
		this.width=img.width;
		this.charset=img.charset;
		image = new char[height][width];
		
		for(int y = 0 ; y < height ; y++){
			for(int x= 0 ; x< width ; x++){
				setPixel(x, y, img.getPixel(x,y));
			}
		}
	}
	
	//gibt den Zeichensatz des Bildes als String zurück.
	public String getCharset(){
		return charset;
	}
	
	//gibt die Höhe des Bildes (die Anzahl der Zeilen) zurück.
	public int getHeight(){
		return height;
	}
	
	//gibt das an den übergebenen Koordinaten/Indizes gespeicherte Zeichen zurück.
	public char getPixel(int x, int y){
		return image[y][x];
	}
	
	//Gibt, analog zur Methode public char getPixel(int x, int y), das Zeichen, an der durch p spezifizierten Stelle, zurück.
	public char getPixel(AsciiPoint p){
		return getPixel(p.getX(),p.getY());
	}
	
	//gibt die Breite des Bildes (die Länge der Zeilen) zurück.
	public int getWidth(){
		return width;
	}
	
	//gibt eine ArrayList aller Pixel eines bestimmten Zeichens zurück.
	public ArrayList<AsciiPoint> getPointList(char c){
		ArrayList<AsciiPoint> points = new ArrayList<AsciiPoint>();
		for(int y = 0 ; y < height ; y++){
			for(int x= 0 ; x< width ; x++){
				if(getPixel(x,y)==c){
					
					points.add(new AsciiPoint(x,y));
				}
			}
		}
		return points ;
	}
	
	/*    gibt eine lesbare Darstellung des ASCII-Bildes zurück. 
	Die einzelnen Zeilen sollen dabei durch Zeilenumbrüche ‘\n’ getrennt werden.*/
	public String toString(){
		String out="";
		for(int y = 0 ; y <getHeight();y++){
			
			for(int x = 0 ; x <getWidth();x++){
				out = out + getPixel(x ,y );
			}
			out=out+"\n";
		}
		return out ;
	}
	
	
	//speichert an den übergebenen Koordinaten/Indizes das übergebene Zeichen.
	public void setPixel(int x, int y, char c){
		image[y][x]=c ;
	}
	
	/*speichert, analog zur Methode public char setPixel(int x, int y, char c), 
	das übergebene Zeichen an der durch den p spezifizierten Stelle.*/
	public void setPixel(AsciiPoint p, char c){
		setPixel(p.getX(),p.getY(),c);
	}
}
