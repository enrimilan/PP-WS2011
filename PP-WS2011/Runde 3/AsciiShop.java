import java.util.Scanner;
public class AsciiShop {
	public static void main (String [] args){
		
		Scanner sc = new Scanner(System.in);
		String bild="";//Variable für das Speichern des ASCII Bildes(für die Ausgabe).
		int count = 0;//Variable die verwendet wird um die Zeilen zu zählen.
		int width=0 ;
		int height=0;
		boolean ok = true ;//Variable die prüft ob ein Fehler passiert ist.
		
		//Einlesen und Prüfen des read Befehls.
		String befehl = sc.next();
		if(befehl.equals("read")){
			if(sc.hasNextInt()){
				height = sc.nextInt();
			}
			else {
				ok=false ;
				System.out.println("INPUT MISMATCH");
				
			}
		}
		else {
			ok = false ;
			System.out.println("INPUT MISMATCH");
		}
		
		//Erstellen des String arrays wo das Bild Zeile für Zeile gesepeichert wird.
			String [] image = new String [height] ;
		
		if(ok==true){
			
			
			//Einlesen der erten Zeile.
			String first=sc.next();
			image[count]=first;
			
			//Einlesen der nächsten Zeilen.
			String read ="";
			while(sc.hasNext()){
				
				read = sc.next();
				if(!read.equals("fill")){
					width=read.length();
					count++;
					
					if(width!=first.length()||count>=height){
						System.out.println("INPUT MISMATCH");
						ok=false ;
						break;
					}
					image[count]=read;
					
				}
				//Falls der Befehl fill auftritt.
				else {
					//Prüfen der Höhe des Bildes.
					if(count!=height-1){
						ok = false ;
						System.out.println("INPUT MISMATCH");
						break ;
					}
					
					//Prüfen ob alle Parameter vorhanden sind , und der angegebenen Position von fill.
					if(sc.hasNextInt()){
						
						int x = sc.nextInt();
						if(sc.hasNextInt()){
							int y = sc.nextInt();
							if(sc.hasNext()){
								char c = sc.next().charAt(0);
								if(x>=width||y>=height){
									System.out.println("OPERATION FAILED");
									ok=false ;
									break ;
								}
								else {
									fill(image,x,y,c);
								}
							}
							else {
								ok = false ;
								System.out.println("INPUT MISMATCH");
								break ;
							}
						}
						else {
							ok = false ;
							System.out.println("INPUT MISMATCH");
							break ;
						}
						
					}
					else{
						ok = false ;
						System.out.println("INPUT MISMATCH");
						break ;
					}
					
				}
				
			}
			
			
		}
		//Speichern des Bildes in die Variable "bild" Zeile für Zeile und dann wird es ausgegeben.
		if(ok==true){
			for(int i = 0 ; i < height ; i++){
				bild = bild + image[i]+"\n";
			}
			System.out.println(bild.trim());
			System.out.print(width +" "+height);
		}
		
		
	}
	
	/*Ersetzt das Zeichen an der Position (x,y) mit dem Zeichen c und ruft sich ggfs. 
	selbst rekursiv auf (mit neuen Werten von (x,y) die den Nachbarpositionen entsprechen).*/
	public static void fill(String[] image, int x, int y, char c){
		int height = image.length;
		int width = image[0].length();
		char z = image[y].charAt(x);//Das zu ersetzende Zeichen.
		image[y]=image[y].substring(0,x)+c+image[y].substring(x+1,width);//Ersetzen des Zeichens.
		
		if(y+1<=height-1){
			if(image[y+1].charAt(x)==z){
				fill(image , x , y+1 , c);
			}
		}
		
		if(y-1>=0){
			if(image[y-1].charAt(x)==z){
				fill(image , x , y-1 , c);	
			}
		}
		
		if(x+1<=width-1){
			if(image[y].charAt(x+1)==z){
				fill(image , x+1 , y , c);	
			}
		}
		
		if(x-1>=0){
			if(image[y].charAt(x-1)==z){
				fill(image , x-1 , y , c);	
			}
		}
	}
	
}
