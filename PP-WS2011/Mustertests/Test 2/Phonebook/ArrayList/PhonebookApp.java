/**
* Die Anwendung (ausführbare Klasse), die ein Telefonbuch benutzt. 
*/

public class PhonebookApp {
	public static void main (String [] args) {
		Phonebook ph = new Phonebook();
		ph.add("Max","012456263");
		ph.add("Susanne","013434234");
		ph.add("Claudia","012345434");
		ph.add("Alexander","013446563");
		
		System.out.println(ph);
		ph.sort();
		
		System.out.println(ph);
		
		ph.remove("Max");
		System.out.println(ph);
	}
}