public class AsciiStack {
	
	private AsciiStackNode head=null;
	
	//erzeugt einen leeren Stack.
	public AsciiStack(){
	}
	
	//�berpr�ft ob der Stack leer ist.
	public boolean empty(){
		if(head==null){
			return true ;
		}
		return false ;
	}
	
	//Gibt das oberste Element am Stack zur�ck und entfernt dieses.
	public AsciiImage pop(){
		if(empty()){
			return null;
		}
		AsciiImage img = new AsciiImage(head.getImage());
		head=head.getNext();
		return img;
	}
	
	//Gibt das oberste Element am Stack zur�ck ohne es zu entfernen.
	public AsciiImage peek(){
		return head.getImage();
	}
	
	//Legt ein AsciiImage oben auf den Stack.
	public void push(AsciiImage img){
		head=new AsciiStackNode(img,head);
		
	}
	
	//Gibt die Anzahl der im Stack belegten Pl�tze zur�ck.
	public int size(){
		return head.size();
	}
}
