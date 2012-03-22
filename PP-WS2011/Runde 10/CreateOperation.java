public class CreateOperation implements Operation {
	private int width;
	private int height;
	private String charset;
	
	/*erzeugt eine neue CreateOperation, die ein neues Bild mit angegebener 
	Bildgöße und Zeichensatz erzeugt. Alle Pixel werden mit dem "hellsten" Zeichen */
	public CreateOperation(int width, int height, String charset){
		this.width=width;
		this.height=height;
		this.charset=charset;
	}
	
	//gibt ein neues AsciiImage zurück.
	public AsciiImage execute(AsciiImage img) throws OperationException{
		return new AsciiImage(width , height , charset);
	}
}
