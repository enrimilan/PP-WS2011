import java.util.Scanner;
public class AsciiShop {
	
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		String read = "";
		int width=0 ;
		int height=0;
		boolean ok = true ; //Variable die angibt , ob ein Fehler passiert ist.
		String first=sc.nextLine();//Einlesen der ersten Zeile.
		height++;
		
		while(sc.hasNextLine()){
			read=sc.nextLine();
			width=read.length();
			height++;
			
			if(width!=first.length()){
				System.out.println("INPUT MISMATCH");
				ok=false ;
				break;
			}
			
		}
		if(ok==true){
			width=first.length() ;
			System.out.println(width+" "+height);
		}
	}
}
