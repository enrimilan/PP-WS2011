import java.util.*;
public class SearchOperation implements Operation {
	private MetricSet<AsciiImage> saved;
	private Metric<AsciiImage> m;
	
	/*initialisiert diese SearchOperation mit einer angegebenen Metrik. 
	saved ist eine Referenz auf ein MetricSet, in dem sich die gespeicherten 
	Bilder befinden. m ist die Metrik.*/
	public SearchOperation(MetricSet<AsciiImage> saved, Metric<AsciiImage> m){
		this.saved=saved;
		this.m=m;
	}
	
	/*liefert ein Bild mit minimaler Distanz zum spezifizierten Bild und liefert 
	dieses als Kopie zur�ck. Gibt es mehrere gespeicherte Bilder mit minimaler
	Distanz, wird irgendeines dieser Bilder geliefert. Ist saved leer, wird 
	eine OperationException geworfen.*/
	public AsciiImage execute(AsciiImage img) throws OperationException{
		if(saved.isEmpty()){
			throw new OperationException("Saved ist leer!");
		}
		Iterator<AsciiImage> iter = saved.search(img, m).iterator();
		return new AsciiImage(iter.next());
	}
}
