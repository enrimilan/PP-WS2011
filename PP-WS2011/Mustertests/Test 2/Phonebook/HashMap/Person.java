/**
* Diese Klasse repräsentiert einen Personeneintrag im Telefonbuch
*/
public class Person {
	
	//Datenelemente
	private String name;
	private String phone;
	
	/**
	* Erzeugt ein Person-Objekt mit Namen und Telefonnummer
	* @param name Der Name der Person
	* @param phone Die Telefonnummer der Person 
	*/
	public Person (String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	/**
	* Liefert den Namen der Person
	* @return Name der Person
	*/
	public String getName() {
		return name;
	}
	
	/**
	* Liefert die Telefonnummer der Person
	* @return Telefonnummer der Person
	*/
	public String getPhone() {
		return phone;
	}
	
	/**
	* Liefert eine lesbare Repräsentation des 
	* Personenobjekts
	* die Namen und Telefonnummer, durch ':' getrennt, 
	* beinhaltet
	* @return lesbare Repräsentation des Personenobjekts
	*/
	public String toString() {
		return name + ": " + phone;
	}
}
