import java.util.ArrayList;
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
	
	//Kopierkonstruktor.
	public AsciiImage(AsciiImage img){
		this.height=img.height;
		this.width=img.width;
		image = new char[height][width];
		
		for(int y = 0 ; y < height ; y++){
			for(int x= 0 ; x< width ; x++){
				setPixel(x, y, img.getPixel(x,y));
			}
		}
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
	
	//Bestimmt den Schwerpunkt aller Pixel mit dem Zeichen c und gibt diesen als AsciiPoint zur�ck.
	public AsciiPoint getCentroid(char c){
		ArrayList<AsciiPoint> points = getPointList(c);
		if(points.size()==0){
			return null;
		}
		int cX=0;
		int cY=0;
		for(int i = 0 ; i < points.size() ; i++){
			cX=cX + points.get(i).getX();
			cY=cY + points.get(i).getY();
		}
		cX=(int) Math.round((double)cX/(double)points.size());
		cY=(int) Math.round((double)cY/(double)points.size());
		return new AsciiPoint(cX , cY);
		
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
	
	/*vergr��ert die die Fl�chen aller Pixel des Zeichens c, in dem es an diese Pixel 
	angrenzende Hintergrundpixel (also Pixel mit dem Zeichen �.�) auf das Zeichen c setzt.*/
	public void growRegion(char c){
		ArrayList<AsciiPoint> points = getPointList(c);
		AsciiPoint p ;
		for(int i = 0 ; i<points.size(); i++){
			p= points.get(i);
			
			if((p.getY()-1>=0)&&(getPixel(p.getX(),p.getY()-1)=='.')){
				setPixel(p.getX(),p.getY()-1,c);
			}
			
			if((p.getY()+1<height)&&(getPixel(p.getX(),p.getY()+1)=='.')){
				setPixel(p.getX(),p.getY()+1,c);
			}
			
			if((p.getX()-1>=0)&&(getPixel(p.getX()-1,p.getY())=='.')){
				setPixel(p.getX()-1,p.getY(),c);
			}
			
			if((p.getX()+1<width)&&(getPixel(p.getX()+1,p.getY())=='.')){
				setPixel(p.getX()+1,p.getY(),c);
			}
			
		}
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
	
	//ersetzt alle Vorkommen eines bestimmten Zeichens oldChar im Bild durch ein anderes Zeichen newChar.
	public void replace(char oldChar, char newChar){
		ArrayList<AsciiPoint> points = getPointList(oldChar);
		
		for(int i = 0 ; i<points.size(); i++){
			setPixel(points.get(i),newChar);
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
	
	/*speichert, analog zur Methode public char setPixel(int x, int y, char c), 
	das �bergebene Zeichen an der durch den p spezifizierten Stelle.*/
	public void setPixel(AsciiPoint p, char c){
		setPixel(p.getX(),p.getY(),c);
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
		char z = getPixel(x,y);//Das zu ersetzende Zeichen.
		setPixel(x,y,c);//Ersetzen des Zeichens.
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
