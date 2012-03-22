import java.util.Scanner;
public class BarPlot {
	
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		//Einlesen mittels Scanner.
		while(sc.hasNext()){
			String Beschr = sc.next();
			if(sc.hasNextInt()){
				int value = sc.nextInt();
				if(value>30){
					System.out.println("INPUT ERROR");
					break ;
				}
				System.out.println(drawBar(Beschr, value));
			}
			else if(sc.hasNextDouble()){
				double value = sc.nextDouble();
				if(value>1.0){
					System.out.println("INPUT ERROR");
					break ;
				}
				System.out.println(drawBar(Beschr, value));
			}
			else{
				System.out.println("INPUT ERROR");
				break ;
			}
		}
		
	}
	
	//Liefert einen String der Länge n zurück der nur aus dem Zeichen c besteht.
	static String repeat(char c, int n){
		String out ="";
		for(int i=1 ; i<=n;i++){
			out = out + c;
			
		}
		return out ;
		
	}
	
	/*Liefert einen String zurück der label beinhaltet 
	aber genau n Zeichen lang ist. Wenn label zu lange ist 
	wird es abgeschnitten, wenn label zu kurz ist, 
	wird der Rückgabewert mit Leerzeichen aufgefüllt.
	Um den Rest der Beschriftung mit Leerzeichen auszufüllen ,wird 
	die Methode repeat verwendet(RestLength ist die Anzahl der Leerzeichen).*/       
	static String drawLabel(String label, int n){
		if(label.length()>n){
			return label.substring(0,n);
			
		}
	        if(label.length()<n){
	        	int RestLength = n-label.length();  
	        	String Rest =repeat(' ',RestLength);
	        	return label+Rest ;
		}
	        return label ;
	        
	}
	
	/*Generiert eine Zeile des Balkendiagramms. value bezeichnet dabei die absolute Länge des Balkens.
	Um das Balkendiagramm zu zeichnen wird zuerst die Beschriftung gezeichnnet(die maximal die Länge 8 haben darf).
	Dafür wird die Methode drawLabelverwendet.Um den Balken zu zeichnen wird wieder dieselbe Methode benutzt , 
	aber dieses mal wird die Methode repeat verwendet um den Balken zu generieren(value ist die absolute Länge des Balkens).
	Wenn diese Länge kleiner ist als 30 ,dann wird der Rest durch die Methode drawLabel mit Leerzeichen ausgefüllt.*/
	static String drawBar(String label, int value){
		
		String Beschriftung =drawLabel(label,8);
		String Balken = drawLabel(repeat('#',value),30);
		return Beschriftung+"|"+Balken+"|";
		
	}
	
	/*Generiert eine Zeile des Balkendiagramms. value bezeichnet die prozentuelle Länge des Balkens. 
	Die Länge des Balkens wird berechnet durch Multiplikation von der prozentuellen Längel und 30.
	Das Ergebnis muss dann eine ganzzahlige Balkenlänge sein.Dafür wird die Methode Math.round 
	verwendet um das Ergebniss zu runden , und dann wird es zu einem int umgewandelt.Schließlich wird
	dieser Parameter an der Methode drawBar(String label, int value) übergeben. */
	static String drawBar(String label, double value){
		int intValue = (int)Math.round(value*30.0);
		return drawBar(label, intValue);
		
	}
}
