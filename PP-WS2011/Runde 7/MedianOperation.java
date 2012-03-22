import java.util.Arrays;
public class MedianOperation{
	
	//erzeugt eine neue MedianOperation.
	public MedianOperation(){}
	
	/*führt auf einer Kopie des Bildes den Medianfilter aus. Dabei werden immer 3 mal 3 Größe Blöcke des Bildes betrachtet, 
	die Pixel nach ihrem `Helligkeitswert' sortiert und dann der Median (also das in der sortierten Liste in der Mitte stehende Zeichen) 
	als neues Pixel im Mittelpunkt des Blocks gesetzt.*/
	public AsciiImage execute(AsciiImage img){
		AsciiImage neu = new AsciiImage(img);
		int[] rand=new int[9];//Index-Array der Zeichen
		int k=0;//Zählvariable
		for(int y=0;y<img.getHeight();y++){
			for(int x=0;x<img.getWidth();x++){
				char c = img.getPixel(x,y);
				for(int i =y-1 ;i<=y+1;i++){
					for(int j=x-1;j<=x+1;j++){
						if(i<0 || i>=img.getHeight() || j<0 || j>=img.getWidth()){
							rand[k++]=img.getCharset().length()-1;
						}
						else{
							rand[k++]=img.getCharset().indexOf(img.getPixel(j,i));	
						}
					}
				}
				k=0;
				Arrays.sort(rand);
				neu.setPixel(x,y,img.getCharset().charAt(rand[4]));
			}
		}	
		return neu;
	}
	
}
