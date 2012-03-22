public class CreateOperation implements Operation {
	private int width;
	private int height;
	private String charset;
	
	/*erzeugt eine neue CreateOperation, die ein neues Bild mit angegebener 
	Bildg��e und Zeichensatz erzeugt. Alle Pixel werden mit dem "hellsten" Zeichen */
	public CreateOperation(int width, int height, String charset){
		this.width=width;
		this.height=height;
		this.charset=charset;
	}
	
	//gibt ein neues AsciiImage zur�ck.
	public AsciiImage execute(AsciiImage img) throws OperationException{
		return new AsciiImage(width , height , charset);
	}
}
