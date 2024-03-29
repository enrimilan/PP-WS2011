public class AsciiImage {
	private int height  ;
	private int width  ;
	private char[][] image ;
	
	//erzeugt ein ASCII-Bild der spezifizierten Gr��e. Anfangs sind alle Pixel auf den Wert �.� gesetzt.
	public AsciiImage(int width , int height){
		this.height=height;
		this.width=width;
		image = new char[height][width];
		clear();
		
	}
	
	//setzt alle Pixel des Bildes auf das Zeichen �.�.
	public void clear(){
		for(int y = 0 ; y < height ; y++){
			for(int x= 0 ; x< width ; x++){
				setPixel(x, y, '.');
			}
		}
	}
	
	/*zeichnet eine Linie zwischen den Koordinaten (x0,y0) und (x1,y1). 
	Anfangs- und Endpunkt sind dabei inkludiert. c spezifiziert das zu verwendende Zeichen.*/
	public void drawLine(int x0, int y0, int x1, int y1, char c){
		int dx=x1-x0;
		int dy=y1-y0;
		double Steigung = (double)dy/(double)dx;
		double unrounded=0.0 ;
		setPixel(x0,y0,c);
		if((dx>=0)&&(Math.abs(dy)<=Math.abs(dx))){
			unrounded=(double)y0;
			while(x0!=x1||y0!=y1){
				
				if(x0!=x1){
					x0=x0+1;
				}
				if(y0!=y1){
					unrounded = unrounded + Steigung;
					y0=(int)Math.round(unrounded);
				}
				setPixel(x0,y0,c);
			}
			setPixel(x1,y1,c);
		}
		
		if((dx<0)&&(Math.abs(dy)<=Math.abs(dx))){
			unrounded=(double)y0;
			while(x0!=x1||y0!=y1){
				
				if(x0!=x1){
					x0=x0-1;
				}
				if(y0!=y1){
					unrounded = unrounded - Steigung;
					y0=(int)Math.round(unrounded);
				}
				setPixel(x0,y0,c);
			}
			setPixel(x1,y1,c);
		}
		
		if((dy>=0)&&(Math.abs(dy)>Math.abs(dx))){
			unrounded =(double) x0;
			while(x0!=x1||y0!=y1){
				
				if(x0!=x1){
					unrounded = unrounded + (1.0/Steigung);
					x0=(int)Math.round(unrounded);
				}
				if(y0!=y1){
					y0=y0+1;
				}
				setPixel(x0,y0,c);
			}
			setPixel(x1,y1,c);
		}
		
		if((dy<0)&&(Math.abs(dy)>Math.abs(dx))){
			unrounded =(double) x0;
			while(x0!=x1||y0!=y1){
				
				if(x0!=x1){
					unrounded = unrounded - (1.0/Steigung);
					x0=(int)Math.round(unrounded);
				}
				if(y0!=y1){
					y0=y0-1;
				}
				setPixel(x0,y0,c);
			}
			setPixel(x1,y1,c);
		}
		
		
		
		
	}
	
	//gibt die H�he des Bildes (die Anzahl der Zeilen) zur�ck.
	public int getHeight(){
		return height;
	}
	
	//gibt das an den �bergebenen Koordinaten/Indizes gespeicherte Zeichen zur�ck.
	public char getPixel(int x, int y){
		return image[y][x];
	}
	
	//gibt die Breite des Bildes (die L�nge der Zeilen) zur�ck.
	public int getWidth(){
		return width;
	}
	
	//ersetzt alle Vorkommen eines bestimmten Zeichens oldChar im Bild durch ein anderes Zeichen newChar.
	public void replace(char oldChar, char newChar){
		for(int y = 0 ; y < height ; y++){
			for(int x= 0 ; x< width ; x++){
				if(getPixel(x,y)==oldChar){
					
					setPixel(x, y, newChar);
				}
			}
		}
		
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
	
	
	
	
	//vertauscht Zeilen und Spalten des Bildes, sprich aus der ersten Zeile im Bild wird die erste Spalte usw. 
	public void transpose(){
		
		//Speichern des neuen Bildes ein einer momentane Variable temp.
		char temp [][]=new char[width][height];
		for(int x = 0 ; x < getWidth() ; x++){
			for(int y = 0 ; y < getHeight(); y++){
				temp[x][y]=getPixel(x,y);
			}	
		}
		//Vertauschung der H�he und der Breite des Bildes,und Zuweisung des neuen Bild in der Varialbe image.
		int tempHeight = height;
		height = width;
		width = tempHeight;
		image = new char [height][width];
		for(int y = 0 ; y < height ; y++){
			for(int x= 0 ; x< width ; x++){
				setPixel(x, y, temp[y][x]);
			}
		}
	}
	
	
	
	
	/*Ersetzt das Zeichen an der Position (x,y) mit dem Zeichen c und ruft sich ggfs. 
	selbst rekursiv auf (mit neuen Werten von (x,y) die den Nachbarpositionen entsprechen).*/
	
	public void fill( int x, int y, char c){
		//String row = image.substring(y*getWidth(),y*getWidth()+getWidth());
		char z = getPixel(x,y);//Das zu ersetzende Zeichen.
		setPixel(x,y,c);//Ersetzen des Zeichens.
		//image=image.substring(0,y*getWidth())+row+image.substring(y*getWidth()+getWidth(),image.length());//Das neue Bild(als String) nach der Ersetzung des Zeichens.
		//Rekursive Aufrufe.
		if(y+1<=getHeight()-1){
			if(getPixel(x,y+1)==z){
				fill(x , y+1 , c);
			}
		}
		
		if(y-1>=0){
			if(getPixel(x,y-1)==z){
				fill(x , y-1 , c);	
			}
		}
		
		if(x+1<=getWidth()-1){
			if(getPixel(x+1,y)==z){
				fill(x+1 , y , c);	
			}
		}
		
		if(x-1>=0){
			if(getPixel(x-1,y)==z){
				fill(x-1 , y , c);	
			}
		}
	}
	
	
}
