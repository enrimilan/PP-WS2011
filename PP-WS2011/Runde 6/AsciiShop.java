import java.util.Scanner;
public class AsciiShop {
	public static void main (String [] args){
		
		Scanner sc = new Scanner(System.in);
		int count = 0;//Variable die verwendet wird um die Zeilen zu zählen.
                int width=0;
		int height=0;                   //Variable für das Einlesen der Höhe im read Befehl.
		AsciiImage image=null;
		AsciiStack stack=null ;
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
						stack=new AsciiStack(3);
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
					stack.push(new AsciiImage(image));
					int x0 = sc.nextInt();
					int y0 = sc.nextInt();
					int x1 = sc.nextInt();
					int y1 = sc.nextInt();
					char c = sc.next().charAt(0);
					image.drawLine(x0,y0,x1,y1,c);
				}
				
				//Falls das ein Bild eingelesen soll.
				if(read.equals("load")&&einlesen==false){
					stack.push(new AsciiImage(image));
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
					stack.push(image);
					image.transpose();
				}
				
				//Falls der Befehl centroid auftritt.
				if(read.equals("centroid")&&einlesen==false){
					char c = sc.next().charAt(0);
					System.out.println(image.getCentroid(c));
				}
				
				//Falls der Befehl grow auftritt.
				if(read.equals("grow")&&einlesen==false){
					stack.push(new AsciiImage(image));
					char c = sc.next().charAt(0);
					image.growRegion(c);
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
					stack.push(new AsciiImage(image));
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
					stack.push(new AsciiImage(image));
					image.clear();
				}
				
				//Falls der Befehl print auftritt.
				if(read.equals("print")&&einlesen==false){
					System.out.println(image.toString());
				}
				
				//Falls der Befehl undo auftritt.
				if(read.equals("undo")&&einlesen==false){
					if(stack.empty()){
					System.out.println("STACK EMPTY");
					}
					else{
					image=new AsciiImage(stack.pop());
					System.out.println("STACK USAGE "+stack.size()+"/"+stack.capacity());
					}
				}
				
				//Fall ein unbekannter Befehl auftritt.
				if(!read.equals("load")&&!read.equals("undo")&&!read.equals("line")&&!read.equals("clear")&&!read.equals("transpose")&&!read.equals("replace")&&!read.equals("print")&&!read.equals("grow")&&!read.equals("centroid")&&!read.equals("fill")&&!read.equals(eof)&&einlesen==false){
					System.out.println("UNKNOWN COMMAND");
					ok=false;
					break;
				}
				
			}
			
			
		}
		
		
	}
	
	
}
