import java.util.ArrayList;
public class AsciiImage {
	private int height  ;
	private int width  ;
	private String charset;
	private char[][] image ;
	
	//erzeugt ein ASCII-Bild der spezifizierten Gr��e. Anfangs sind alle Pixel auf des hellste Zeichen gesetzt.
	public AsciiImage(int width , int height,String charset) {
		if(width<=0||height<=0||charset.length()==0){
			throw new IllegalArgumentException();
		}
		
		//Pr�fen des Zeichensatzes.
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
	
	//gibt den Zeichensatz des Bildes als String zur�ck.
	public String getCharset(){
		return charset;
	}
	
	//gibt die H�he des Bildes (die Anzahl der Zeilen) zur�ck.
	public int getHeight(){
		return height;
	}
	
	//gibt das an den �bergebenen Koordinaten/Indizes gespeicherte Zeichen zur�ck.
	public char getPixel(int x, int y){
		return image[y][x];
	}
	
	//Gibt, analog zur Methode public char getPixel(int x, int y), das Zeichen, an der durch p spezifizierten Stelle, zur�ck.
	public char getPixel(AsciiPoint p){
		return getPixel(p.getX(),p.getY());
	}
	
	//gibt die Breite des Bildes (die L�nge der Zeilen) zur�ck.
	public int getWidth(){
		return width;
	}
	
	//gibt eine ArrayList aller Pixel eines bestimmten Zeichens zur�ck.
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
	
	/*    gibt eine lesbare Darstellung des ASCII-Bildes zur�ck. 
	Die einzelnen Zeilen sollen dabei durch Zeilenumbr�che �\n� getrennt werden.*/
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
	
	
	//speichert an den �bergebenen Koordinaten/Indizes das �bergebene Zeichen.
	public void setPixel(int x, int y, char c){
		image[y][x]=c ;
	}
	
	/*speichert, analog zur Methode public char setPixel(int x, int y, char c), 
	das �bergebene Zeichen an der durch den p spezifizierten Stelle.*/
	public void setPixel(AsciiPoint p, char c){
		setPixel(p.getX(),p.getY(),c);
	}
	
	/*Vergleicht das angegebene Bild mit diesem Bild und liefert true wenn H�he und Breite �bereinstimmen 
	und der Pixelwert an jeder Position des angegebenen Bildes mit dem in diesem Bild �bereinstimmt. 
	Ansonsten wird false geliefert.*/
	public boolean equals(Object o){
		
		//referenz auf die Klasse des Objekts.
		if(this.getClass()!=o.getClass()){
			return false;
		}
		
		//umwandeln in AsciiImage.
		AsciiImage cast = (AsciiImage) o ;
		if(this.getHeight()!=cast.getHeight()||this.getWidth()!=cast.getWidth()){
			return false;
		}
		
		for(int y = 0 ; y<this.getHeight() ; y++){
			for(int x = 0 ; x<this.getWidth() ; x++){
				if(this.getPixel(x,y)!=cast.getPixel(x,y)){
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	//liefert den Hashcode diese Bildes, der der Summe der ASCII Codes aller Zeichen im Bild entspricht.
	public int hashCode(){
		int hashCode=0;
		for(int y = 0 ; y<this.getHeight() ; y++){
			for(int x = 0 ; x<this.getWidth() ; x++){
				hashCode=hashCode + (int)this.getPixel(x,y);
			}
		}
		
		return hashCode;
	}
	
	//liefert die Anzahl unterschiedlicher Zeichen im Bild zur�ck.
	public int getUniqueChars(){
		int unique = 0 ;	
		String temp ="";
		
		for(int y = 0 ; y<this.getHeight() ; y++){
			for(int x = 0 ; x<this.getWidth() ; x++){
				if(!temp.contains(""+this.getPixel(x,y))){
					temp = temp + this.getPixel(x,y);
					unique++;
				}
			}
		}
		
		return unique;
	}
}	
