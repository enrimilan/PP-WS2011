import java.util.*;
public class AsciiShop {
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
                int width=0;
		int height=0;
		AsciiImage image=null;
		AsciiStack stack=null ;
		HashMap<String,Factory> befehl=null;
		MetricSet<AsciiImage> saved = new MetricSet<AsciiImage>();
		
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
							image=(new ClearFactory().create(sc)).execute(image);	
						}
						catch(IllegalArgumentException e){
							
							System.out.println("INPUT MISMATCH");
						}
						catch(OperationException e){
							System.out.println("OPERATION FAILED");
						}
						befehl=new HashMap<String,Factory>();
						befehl.put("clear",new ClearFactory());
						befehl.put("load",new LoadFactory());
						befehl.put("replace",new ReplaceFactory());
						befehl.put("filter",new FilterFactory());
						befehl.put("binary",new BinaryFactory());
						befehl.put("create",new CreateFactory());
						befehl.put("save",new SaveFactory(saved));
						befehl.put("search",new SearchFactory(saved));
						
						String read ="";//Hier wird jede Zeile gespeichert.			
						while(sc.hasNext()){
							
							read = sc.next();
							//Falls ein bekannter Befehl auftritt.
							if(befehl.containsKey(read)){
								stack.push(new AsciiImage(image));
								try{
									image=(befehl.get(read).create(sc)).execute(image);
								}
								catch(FactoryException e){
									
									System.out.println("INPUT MISMATCH");
									break;
								}
								catch(OperationException e){
									System.out.println("OPERATION FAILED");
									break;
								}	
							}
							//Falls der Befehl undo auftritt.
							else if(read.equals("undo")){
								if(stack.empty()){
									System.out.println("STACK EMPTY");
								}
								else{
									image=new AsciiImage(stack.pop());
								}
							}
							//Falls der Befehl print auftritt.
							else if(read.equals("print")){
								System.out.println(image.toString());
							}
							////Falls der Befehl print auftritt.
							else if(read.equals("printsaved")){
								
								if(saved.isEmpty()){
									System.out.println("NO SAVED IMAGES");
								}
								else {
									Iterator<AsciiImage> iter = saved.iterator();
									while(iter.hasNext()){
										System.out.println(iter.next().toString());
									}
								}
							}
							
							//Falls ein unbekannter Befehl auftritt.
							else{
								System.out.println("UNKNOWN COMMAND");
								break;
							}
						}	
					}
					else {
						System.out.println("INPUT MISMATCH");
					}	
				}
				else {
					System.out.println("INPUT MISMATCH");
				}
			}
			else {
				System.out.println("INPUT MISMATCH");
			}
		}
		else {
			System.out.println("INPUT MISMATCH");
		}		
	}
}
