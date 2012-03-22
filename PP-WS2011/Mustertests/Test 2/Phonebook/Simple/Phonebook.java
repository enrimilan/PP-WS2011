/**
* Ein einfaches Telefonbuch mit maximal 3 Einträgen
*/

public class Phonebook {
	
	// Datenelemente (3 Speicherplaetze)
	private Person p1;
	private Person p2;
	private Person p3;
	
	/**
	* Speichert an einem bestimmten Speicherplatz einen Eintrag
	* @param name Name der Person
	* @param phone Telefonnummer der Person
	* @param index Speicherplatz (1,2 oder 3)
	*/
	public void add (String name, String phone, int index) {
		if (index == 1) {
			p1 = new Person(name,phone);
		} else if (index == 2) {
			p2 = new Person(name,phone);
		} else if (index == 3) {
			p3 = new Person(name,phone);
		}
		
	}
	
	/**
	* Liefert den Eintrag an einem bestimmten Speicherplatz
	* @param index Speicherplatz (1,2 oder 3)
	*/
	public Person get (String name) {
		if (p1.getName().equals(name)) 
			return p1;
		else if (p2.getName().equals(name)) 
			return p2;
		else if (p3.getName().equals(name)) 
			return p3;
		else return null;
	}
	
	/**
	* Löscht alle Einträge mit entsprechendem Namen
	* @param name Name der Person
	*/
	public void remove (String name) {
		//FILL IN
	}
	
	/**
	* Liefert eine lesbare Repräsentation des 
	* Telefonbuchs
	* die alle Einträge mit Namen und Telefonnummer, durch ':' getrennt, 
	* beinhaltet
	* @return lesbare Repräsentation des Telefonbuchs
	*/
	public String toString () {
		return ""+ p1+ "\n" + p2 + "\n" + p3;
	}
}
