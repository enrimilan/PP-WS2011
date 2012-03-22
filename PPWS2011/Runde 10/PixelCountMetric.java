public class PixelCountMetric implements Metric<AsciiImage>{
	
	//liefert den Absolutbetrag der Differenz der Bildgrößen von i1 und i2.
	public int distance(AsciiImage i1, AsciiImage i2){
		int dist = (i1.getHeight() * i1.getWidth()) - (i2.getHeight() * i2.getWidth());
		return Math.abs(dist);
	}
}
