import java.util.Scanner;
public class AsciiShop {
	public static void main (String [] args){
		
		Scanner sc = new Scanner(System.in);
		int tempHeight = 0;//Variable die verwendet wird um die Zeilen zu z�hlen.
		int height=0; //Variable f�r das Einlesen der H�he im read Befehl.
		boolean ok = true ;//Variable die pr�ft ob ein Fehler passiert ist.
		
		//Einlesen und Pr�fen des read Befehls.
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
		
		
		
		
		
		
		//Erstellen des AsciiImage Objekts.
		AsciiImage image = new AsciiImage ();
		
		if(ok==true){
			
			String read ="";//Hier wird jede Zeile gespeichert.
			while(sc.hasNext()){
				
				read = sc.next();
				if(!read.equals("fill")&&!read.equals("uniqueChars")&&!read.equals("flip-v")&&!read.equals("transpose")&&!read.equals("symmetric-h")){
					if(image.addLine(read)==true)
					{
						tempHeight=image.getHeight();
						
					}
					else{
						System.out.println("INPUT MISMATCH");
						ok=false ;
						break ;
					}
					
					if(tempHeight>height){
						System.out.println("INPUT MISMATCH");
						ok=false ;
						break;
					}
					
					
				}
				
				//Falls der Befehl uniqueChars auftritt.
				else if(read.equals("uniqueChars")){
					//Pr�fen der H�he des Bildes.
					if(tempHeight!=height){
						ok = false ;
						System.out.println("INPUT MISMATCH");
						break ;
					}
					System.out.println(image.getUniqueChars());
				}
				
				//Falls der Befehl flip-v auftritt.
				else if(read.equals("flip-v")){
					//Pr�fen der H�he des Bildes.
					if(tempHeight!=height){
						ok = false ;
						System.out.println("INPUT MISMATCH");
						break ;
					}
					image.flipV();
				}
				
				//Falls der Befehl transpose auftritt.
				else if(read.equals("transpose")){
					//Pr�fen der H�he des Bildes.
					if(tempHeight!=height){
						ok = false ;
						System.out.println("INPUT MISMATCH");
						break ;
					}
					image.transpose();
				}
				//Falls der Befehl symmetric-h auftritt.
				else if(read.equals("symmetric-h")){
					//Pr�fen der H�he des Bildes.
					if(tempHeight!=height){
						ok = false ;
						System.out.println("INPUT MISMATCH");
						break ;
					}
					System.out.println(image.isSymmetricH());
				}
				
				//Falls der Befehl fill auftritt.
				else if(read.equals("fill")) {
					//Pr�fen der H�he des Bildes.
					if(tempHeight!=height){
						ok = false ;
						System.out.println("INPUT MISMATCH");
						break ;
					}
					
					
					
					//Pr�fen ob alle Parameter vorhanden sind , und der angegebenen Position von fill.
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
				
			}
			
			
		}
		//Ausgeben des Bildes und der Parameter.
		if(ok==true){
			
			System.out.println(image.toString());
			System.out.println(image.getWidth()+" "+image.getHeight());
		}
		
		
	}
	
	
}
