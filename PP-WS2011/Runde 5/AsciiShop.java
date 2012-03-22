import java.util.Scanner;
public class AsciiShop {
	public static void main (String [] args){
		
		Scanner sc = new Scanner(System.in);
		int count = 0;//Variable die verwendet wird um die Zeilen zu zählen.
                int width=0;
		int height=0;                   //Variable für das Einlesen der Höhe im read Befehl.
		AsciiImage image=null;
		boolean ok = true ;//Variable die prüft ob ein Fehler passiert ist.
		boolean einlesen = false ; //Variable ist nur true wenn das Bild eingelesen wird.
		
		//Einlesen und Prüfen des create Befehls.
		String create = sc.next();
		if(create.equals("create")){
			if(sc.hasNextInt()){
				width = sc.nextInt();
				if(sc.hasNextInt()){
					height=sc.nextInt();
					if(width>0&&height>0){
						//Erstellen des AsciiImage Objekts.
						image = new AsciiImage (width , height);
					}
					else {
						ok = false ;
						System.out.println("INPUT MISMATCH");
					}
					
				}
				else {
					ok=false ;
					System.out.println("INPUT MISMATCH");
				}
				
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
		
		
		
		
		
		
		if(ok==true){
			
			String read ="";//Hier wird jede Zeile gespeichert.
			String eof=""; //Ende des Einlesen des Bildes.
			while(sc.hasNext()){
				
				read = sc.next();
				
				//Falls der Befehl line auftritt.
				if(read.equals("line")&&einlesen==false){
					int x0 = sc.nextInt();
					int y0 = sc.nextInt();
					int x1 = sc.nextInt();
					int y1 = sc.nextInt();
					char c = sc.next().charAt(0);
					image.drawLine(x0,y0,x1,y1,c);
				}
				
				//Falls das ein Bild eingelesen soll.
				if(read.equals("load")&&einlesen==false){
					eof=sc.next();
					einlesen = true ;
					read= sc.next();
				}
				if(einlesen==true){
					
					if(count>=height&&!read.equals(eof)){
						ok=false;
						System.out.println("INPUT MISMATCH");
						break ;
					}
					
					if((read.length()!=width)&&!read.equals(eof)){
						ok=false;
						System.out.println("INPUT MISMATCH");
						break ;
					}
					//Falls das ende des Bildes erreicht wird.
					if(!read.equals(eof)){
						//Pixelweise speichern des Bildes.
						for(int x = 0 ; x < read.length();x++){
							image.setPixel(x,count,read.charAt(x));
						}
						count++;
					}
					if(read.equals(eof)){
						einlesen = false ;
						if(count!=height){
							ok=false;
							System.out.println("INPUT MISMATCH");
							break ;
						}
						count=0;
						
					}
					
					
				}
				
				
				
				
				
				
				//Falls der Befehl transpose auftritt.
				if(read.equals("transpose")&&einlesen==false){
					image.transpose();
				}
				
				//Falls der Befehl fill auftritt.
				if(read.equals("fill")&&einlesen==false) {
					
					//Prüfen ob alle Parameter vorhanden sind , und der angegebenen Position von fill.
					if(sc.hasNextInt()){
						
						int x = sc.nextInt();
						if(sc.hasNextInt()){
							int y = sc.nextInt();
							if(sc.hasNext()){
								char c = sc.next().charAt(0);
								if(x>=image.getWidth()||y>=image.getHeight()){
									System.out.println("OPERATION FAILED");
									ok=false ;
									break ;
								}
								else {
									image.fill(x,y,c);
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
				
				//Falls der Befehl replace auftritt.
				if(read.equals("replace")&&einlesen==false){
					if(sc.hasNext()){
						char oldChar = sc.next().charAt(0);
						if(sc.hasNext()){
							char newChar = sc.next().charAt(0);
							image.replace(oldChar , newChar);
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
				
				//Falls der Befehl clear auftritt.
				if(read.equals("clear")&&einlesen==false){
					image.clear();
				}
				
				//Falls der Befehl print auftritt.
				if(read.equals("print")&&einlesen==false){
					System.out.println(image.toString());
				}
				
				//Fall ein unbekannter Befehl auftritt.
				if(!read.equals("load")&&!read.equals("line")&&!read.equals("clear")&&!read.equals("transpose")&&!read.equals("replace")&&!read.equals("print")&&!read.equals("fill")&&!read.equals(eof)&&einlesen==false){
					System.out.println("UNKNOWN COMMAND");
					ok=false;
					break;
				}
				
			}
			
			
		}
		
		
	}
	
	
}
