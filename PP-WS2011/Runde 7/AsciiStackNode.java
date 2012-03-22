public class AsciiStackNode{
	private AsciiImage image;
	private AsciiStackNode next;
	
	//inizialisiert den Listenknoten.
	public AsciiStackNode(AsciiImage image, AsciiStackNode next){
		this.image=image;
		this.next=next;
	}
	
	//liefert das vom Knoten referenzierte AsciiImage zurück.
	public AsciiImage getImage(){
		return image;
	}
	
	//liefert eine Referenz auf den nächsten Knoten zurück.
	public AsciiStackNode getNext(){
		return next;
	}
	
	//liefert die Anzahl der Knoten in der von diesem Knoten referenzierten Restliste plus eins (für diesen Knoten).S
	public int size(){
		AsciiStackNode tmp = next;
		int i = 0;
		while(tmp!=null){
			tmp=tmp.getNext();
			i++;
		}
		return i+1;
	}
}
