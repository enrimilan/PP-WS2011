/*
* 1. Aufgabe: Typbeziehungen
* 
* Der Inhalt dieser Datei wird nicht bewertet.
*/
public class Zoo {
	
	public static void main(String[] args) {
		
		Animal ele = new Elefant();
		Animal low = new Lion();
		Animal sch = new Schaf();
		Animal tig = new Tiger();
		System.out.println(ele.eatsMeat());
		System.out.println(ele.dailyFoodQuantity());
		System.out.println(low.eatsMeat());
		System.out.println(low.dailyFoodQuantity());
		System.out.println(sch.eatsMeat());
		System.out.println(sch.dailyFoodQuantity());
		System.out.println(tig.eatsMeat());
		System.out.println(tig.dailyFoodQuantity());
		
		
	}
}
