import java.util.HashMap;
import java.util.Iterator;

/**
* Ein Telefonbuch. Implementierung mit einer HashMap.
*/

public class Phonebook {
	
	// HashMap zur Verwaltung der Personeneintraege
	private HashMap<String,Person> entryMap = new HashMap<String,Person>();
	
	/**
	* Fügt dem Telefonbuch eine neue Person hinzu.
	* @param p Personeneintrag
	*/
	public void add(Person p) {
		entryMap.put(p.getName(),p);
	}
	
	/**
	* Fügt dem Telefonbuch eine neue Person hinzu.
	* @param name Der Name der Person
	* @param phone Die Telefonnummer
	*/
	public void add(String name, String phone) {
		entryMap.put(name,new Person(name,phone));
	}
	
	/**
	* Sucht nach dem Personeneintrag mit Namen und liefert das 
	* entsprechende Personenobjekt zurück.
	* @return Das Personenobjekt
	*/
	public Person get(String name) {
		return entryMap.get(name);
	}
	
	/**
	* Liefert eine lesbare Repräsentation der Telefonbuchs, mit allen
	* Einträgen
	* @return Die Zeichenkettenrepräsentation
	*/
	public String toString() {
		String out = "";
		Iterator iter = entryMap.values().iterator();
		while (iter.hasNext()) {
			out += iter.next()+ "\n";
		}
		
		return out+entryMap.size()+" Eintraege"+"\n";
	}
	
	/**
	* Entfernt den ersten Personeneintrag mit entsprechendem
	* Namen
	* @param name Name der zu entfernenden Person
	*/
	public void remove (String name) {
		entryMap.remove(name);
	}
	
	/**
	* Liefert die Anzahl der Einträge
	* @return Anzahl der Einträge
	*/ 
	public int size() {
		return entryMap.size();
	}
}