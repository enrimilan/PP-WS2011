public class AsciiImage {
	private int height  ;
	private int width  ;
	private String image ;
	
	/*initialisiert das neue ASCII-Bild (H�he und Breite sind anfangs 0 
	und ver�ndern sich erst durch das Hinzuf�gen von Zeilen zum Bild).*/
	public AsciiImage(){
		height=0;
		width=0;
		image="";
	}
	
	//F�gt dem Bild eine neue Zeile hinzu.
	public boolean addLine(String line){
		//Einlesen der ersten Zeile.
		if((getWidth()==0)&&(getHeight()==0)){
			if(line.length()<1){
				return false ;
			}
			width=line.length();
			
		}
		//Speichern des Bildes im String image.
		if(line.length()==width){
			image = image+line;
			height++;
			return true ;
			
		}
		if(line.length()!=width){
			return false ;
		}
		else {
			return true ;
		}
	}
        
	//gibt die Breite des Bildes (die L�nge der Zeilen) zur�ck.
	public int getWidth(){
		return width;
	}
	
	//gibt die H�he des Bildes (die Anzahl der Zeilen) zur�ck.
	public int getHeight(){
		return height;
	}
	
	/*    gibt eine lesbare Darstellung des ASCII-Bildes zur�ck. 
	Die einzelnen Zeilen sollen dabei durch Zeilenumbr�che �\n� getrennt werden.*/
	public String toString(){
		String out="";
		for(int i = 0 ; i <getHeight();i++){
			out = out + image.substring(i*getWidth(),i*getWidth()+getWidth())+"\n";
		}
		return out.trim() ;
	}
	
	//gibt zur�ck wieviele unterschiedliche Zeichen im Bild vorkommen.
	public int getUniqueChars(){
		int unique=0;
		String temp ="";
		for(int i =0 ; i<image.length(); i++){
			if(!temp.contains(""+image.charAt(i))){
				temp=temp+image.charAt(i);
				unique++;
			}
		}
		return unique ;
	}
	
	/*dreht das Bild vertikal um, sprich es vertauscht die Zeilen des Bildes 
	(die erste mit der letzten, die zweite mit der vorletzten, usw.)*/
	public void flipV(){
		String temp="";
		for(int i = getHeight()-1 ; i>=0 ;i--){
			temp = temp + image.substring(i*getWidth(),i*getWidth()+getWidth());
		}	
		image=temp ;
        }
        
        //Hilfsmethode , die das Pixel an der Postition (x,y) zur�ckgibt.
        private char getPixel(int x, int y){
        	String row = image.substring(y*getWidth(),y*getWidth()+getWidth());
        	return row.charAt(x);
        }
        
        //vertauscht Zeilen und Spalten des Bildes, sprich aus der ersten Zeile im Bild wird die erste Spalte usw. 
        public void transpose(){
        	
        	//Speichern des neuen Bildes ein einer momentane Variable temp.
        	String temp="";
        	for(int x = 0 ; x < getWidth() ; x++){
        		for(int y = 0 ; y < getHeight(); y++){
        			temp=temp+getPixel(x,y);
        		}	
        	}
        	//Vertauschung der H�he und der Breite des Bildes,und Zuweisung des neuen Bild in der Varialbe image.
        	int tempHeight = height;
        	height = width;
        	width = tempHeight;
        	
        	image=temp;
        }
        
        
        
	/*Ersetzt das Zeichen an der Position (x,y) mit dem Zeichen c und ruft sich ggfs. 
	selbst rekursiv auf (mit neuen Werten von (x,y) die den Nachbarpositionen entsprechen).*/
	public void fill( int x, int y, char c){
		String row = image.substring(y*getWidth(),y*getWidth()+getWidth());
		char z = row.charAt(x);//Das zu ersetzende Zeichen.
		row=row.substring(0,x)+c+row.substring(x+1,width);//Ersetzen des Zeichens.
		image=image.substring(0,y*getWidth())+row+image.substring(y*getWidth()+getWidth(),image.length());//Das neue Bild(als String) nach der Ersetzung des Zeichens.
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
        
	//Pr�fen der Symmetrie.(es wird f�r jede Zeile �berpr�ft ob sie ein Palindrom ist.
        public boolean isSymmetricH(){
        	boolean symmetrisch = true ;
        	for(int i = 0 ; i < getHeight() ; i++){
        		if(symmetrisch==true){
        			String row = image.substring(i*getWidth(),i*getWidth()+getWidth());
        			int a = 0;
        			int b = row.length()-1;
        			while(a<b){
        				if(row.charAt(a)==row.charAt(b)){
        					a++;
        					b--;
        				}
        				else {
        					symmetrisch=false ;
        					break ;
        				}
        			}
        		}
        		else {
        			break ;
        		}
        	}
        	return symmetrisch;
        }	
	
}
