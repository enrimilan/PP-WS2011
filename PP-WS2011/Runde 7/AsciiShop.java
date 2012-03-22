import java.util.Scanner;
public class AsciiShop {
	public static void main (String [] args){
		
		Scanner sc = new Scanner(System.in);
                int width=0;
		int height=0;
		AsciiImage image=null;
		AsciiStack stack=null ;
		boolean ok = true ;//Variable die prüft ob ein Fehler passiert ist.
		boolean einlesen = false ; //Variable ist nur true wenn das Bild eingelesen wird.
		String data=""; //Variable für das Speichern des Bildes.
		
		//Einlesen und Prüfen des create Befehls.
		String create = sc.next();
		if(create.equals("create")){
			if(sc.hasNextInt()){
				width = sc.nextInt();
				if(sc.hasNextInt()){
					height=sc.nextInt();
					if(sc.hasNext()){
						String charset = sc.next();
						
						try {
							
							//Erstellen des AsciiImage Objekts.
							image = new AsciiImage (width , height , charset);
							stack=new AsciiStack();
							
						}
						catch(IllegalArgumentException e){
							ok=false;
							System.out.println("INPUT MISMATCH");
						}
						ClearOperation clear = new ClearOperation();
						image=clear.execute(image);
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
				
				//Falls der Befehl load auftritt.
				if(read.equals("load")&&einlesen==false){
					stack.push(new AsciiImage(image));
					eof=sc.next();
					einlesen = true ;
					read= sc.next();
				}
				if(einlesen==true){
					
					//Falls das ende des Bildes erreicht wird.
					if(read.equals(eof)){
						einlesen = false ;	
						try{
							LoadOperation load = new LoadOperation(data); 
							image=load.execute(image);
						}
						catch(OperationException e){
							ok=false;
							System.out.println("OPERATION FAILED");
							break;
						}
					}
					else{
						//Zeilenweise speichern des Bildes.
						data=data+read+"\n";
						
					}	
				}
				
				//Falls der Befehl replace auftritt.
				if(read.equals("replace")&&einlesen==false){
					stack.push(new AsciiImage(image));
					if(sc.hasNext()){
						char oldChar = sc.next().charAt(0);
						if(sc.hasNext()){
							char newChar = sc.next().charAt(0);
							try{
								ReplaceOperation replace = new ReplaceOperation(oldChar,newChar); 
								image=replace.execute(image);
							}
							catch(OperationException e){
								ok=false;
								System.out.println("OPERATION FAILED");
								break;
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
				
				//Falls der Befehl clear auftritt.
				if(read.equals("clear")&&einlesen==false){
					stack.push(new AsciiImage(image));
					ClearOperation clear = new ClearOperation();
					image=clear.execute(image);
				}
				
				//Falls der Befehl filter auftritt.
				if(read.equals("filter")&&einlesen==false){
					if(sc.hasNext()){
						String filter = sc.next();
						if(filter.equals("median")){
							stack.push(new AsciiImage(image));
							MedianOperation median = new MedianOperation();
							image=median.execute(image);
						}
						else{
							ok=false;
							System.out.println("INPUT MISMATCH");
							break;
						}
						
					}
					else{
						ok=false;
						System.out.println("INPUT MISMATCH");
						break;
					}
					
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
					}
				}
				
				//Fall ein unbekannter Befehl auftritt.
				if(!read.equals("load")&&!read.equals("undo")&&!read.equals("clear")&&!read.equals("replace")&&!read.equals("filter")&&!read.equals("print")&&!read.equals(eof)&&einlesen==false){
					System.out.println("UNKNOWN COMMAND");
					ok=false;
					break;
				}
			}	
		}	
	}
}
