public class AsciiStack {
	private int increment ;
	private AsciiImage[] image;
	private int index = -1 ; //Stackpointer.
	private int capacity ;
	
	//Konstruktor,erzeugt einen neuen Stack,der initial 'increment' Elemente speichern kann.
	public AsciiStack(int increment){
		this.increment=increment;
		image = new AsciiImage[increment];
		capacity=increment;
	}
	
	//Anzahl der Plätze des Stacks.
	public int capacity(){
		return capacity;
	}
	
	//Überprüft ob der Stack leer ist.
	public boolean empty(){
		if(size()<1){
			return true ;
		}
		return false ;
	}
	
	//Gibt das oberste Element am Stack zurück und entfernt dieses.
	public AsciiImage pop(){
		if(empty()){
			return null;
		}
		index--;
		if(capacity()-size()>increment){
			
			AsciiImage[] temp = new AsciiImage[capacity];
			for(int i = 0 ; i < image.length ; i++){
				temp[i]=image[i];
			}
			capacity=capacity-increment;
			image=new AsciiImage[capacity];
			for(int i = 0 ; i < image.length ; i++){
				image[i]=temp[i];
			}
			
			return image[index+1];	
		}
		return image[index+1];	
	}
	
	//Gibt das oberste Element am Stack zurück ohne es zu entfernen.
	public AsciiImage peek(){
		if(empty()){
			return null;
		}
		return image[index];
	}
	
	//Legt ein AsciiImage oben auf den Stack.
	public void push(AsciiImage img){
		
		if(index==capacity-1){
			capacity=capacity + increment;
			AsciiImage [] temp = new AsciiImage[capacity];
			for(int i = 0 ; i < image.length ; i++){
				temp[i]=image[i];
			}
			image=new AsciiImage[capacity];
			for(int i = 0 ; i < temp.length ; i++){
				image[i]=temp[i];
			}
			
		}
		
			index++;
			image[index]=img;
		        
	}
	
	//Gibt die Anzahl der im Stack belegten Plätze zurück.
	public int size(){
		return index+1;
	}
}
