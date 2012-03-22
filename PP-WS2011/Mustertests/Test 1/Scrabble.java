import java.util.Scanner;
import java.util.Arrays;

public class Scrabble {
	
	/**
	* main-Methode: liest von der Standardeingabe ein und arbeitet die
	* einegegebenen Befehle ab. Erzeugt entsprechende Ausgaben.
	*/
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		String eingabe = sc.next();
		
		//macht aus einem String ein char-Array
		char[] charSet = eingabe.toCharArray(); 
		
		while(sc.hasNext()){
			
			String command = sc.next();
			
			if(command.equals("print")) {
				System.out.println(Arrays.toString(charSet));
			} 
			
			if(command.equals("occurrence")){
				char c=sc.next().charAt(0);
				System.out.println(occurrence(charSet , c));
			}
			
			if(command.equals("distinct")){
				String par = sc.next();
				System.out.println(distinct(par));
				
			}
			
			if(command.equals("moveleft")){
				char c = sc.next().charAt(0);
				moveleft(charSet , c);
			}
			
			if(command.equals("buildword")){
				String par = sc.next();
				System.out.println(buildword(eingabe , par.toCharArray()));
			}
		}
	}
	
	/**
	* bewegt alle Vorkommnisse des Zeichens c im Array charSet ganz nach 
	* links. Die Reihenfolge aller anderen Zeichen im Array ist danach 
	* beliebig.
	* @param charSet Das Array mit der Zeichenmenge
	* @param c Alle Vorkommnisse dieses Zeichens sollen im Array ganz nach 
	* links bewegt werden.
	*/
	public static void moveleft (char[] charSet, char c) {
		String ja ="";
		String nein="";
		for(int i =0 ; i<charSet.length ; i++){
			if(charSet[i]==c){
				ja=ja+charSet[i];
			}
			else{
				nein=nein+charSet[i];
			}
			
			
			
		}
		for(int i = 0 ; i < ja.length() ; i++){
		charSet[i]=ja.charAt(i);
		}
		for(int e = ja.length() ; e < (ja+nein).length(); e++){
		charSet[e]=(ja+nein).charAt(e);
		}
		
	}
	
	/**
	* liefert die Häufigkeit des angegebenen Zeichens c in der 
	* Zeichenfolge charSet zurück
	* @param charSet Das Array mit der Zeichenmenge
	* @param c Alle Vorkommnisse dieses Zeichens werden gezählt
	* @return Die Anzahl der Vorkommnisse
	*/
	public static int occurrence(char[] charSet, char c) {
		int a = 0 ;
		for(int i = 0 ; i < charSet.length; i++){
			if(charSet[i]==c){
				a++;
			}
			
			
		}
		return a ;
	}
	
	/**
	* liefert die Häufigkeit des angegebenen Zeichens c im 
	* String word
	* @param word Eine Zeichenkette in der die Anzahl des angegebenen 
	* Zeichens bestimmt wird
	* @param c Alle Vorkommnisse dieses Zeichens werden gezählt
	* @return Die Anzahl der Vorkommnisse
	*/
	public static int occurrence(String word, char c) {
		int a = 0 ;
		for(int i = 0 ; i < word.length(); i++){
			if(word.charAt(i)==c){
				a++;
			}
			
		}
		return a ;
	}
	
	/**
	* liefert einen String, der alle Zeichen enthält, die auch in word 
	* vorkommen, jedoch keine Zeichen mehrfach enthält. Die Reihenfolge der 
	* Zeichen ist beliebig.
	* @param word Der Eingabestring
	* @return Ein String in dem die Zeichen des Eingabestrings einmalig
	* vorkommen.
	*/
	public static String distinct(String word) {
		String out ="";
		for(int i = 0 ; i<word.length(); i++){
			if(!out.contains(String.valueOf(word.charAt(i)))){
				out = out+word.charAt(i);
			}
			
		}
		return out ;
	}
	
	/**
	* liefert einen boolean Wert der angibt, ob das als Parameter 
	* angegebene Wort word aus den im Array from gespeicherten Zeichen
	* gebildet werden kann (true) oder nicht (false).
	* @param word Das zu bildende Wort
	* @param from Aus den Zeichen dieses Arrays soll das Wort gebildet 
	* werden
	* @return true wenn das Wort gebildet werden kann, sonst false
	*/
	public static boolean buildword(String word, char[] from) {
		boolean stop = true ;
		for(int i = 0 ; i<from.length;i++){
			if(occurrence(word ,from[i])==0){
				stop =false ;
				break ;
				
			}
		}
		return stop ;
		
	}
	
	
}
