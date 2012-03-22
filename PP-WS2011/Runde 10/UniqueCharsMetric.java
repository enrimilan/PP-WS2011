public class UniqueCharsMetric implements Metric<AsciiImage>{
	
	//liefert den Absolutbetrag der Differenz der Anzahl unterschiedlicher Zeichen in einem Bild.
	public int distance(AsciiImage i1, AsciiImage i2){
		int dist = i1.getUniqueChars() - i2.getUniqueChars();
		return Math.abs(dist);
	}
	
}
