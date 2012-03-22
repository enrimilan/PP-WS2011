/**
 * Die Anwendung (ausführbare Klasse), die ein Telefonbuch benutzt. 
 */

public class PhonebookApp {
    public static void main (String [] args) {
        Phonebook ph = new Phonebook();
        ph.add("Max","012456263",1);
        ph.add("Susanne","013434234",1);
        ph.add("Claudia","012345434",3);
        ph.add("Alexander","013446563",2);
    
        System.out.println(ph);
      
    }
}