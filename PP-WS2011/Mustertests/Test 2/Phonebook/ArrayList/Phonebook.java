import java.util.ArrayList;

/**
* Ein Telefonbuch. Implementierung mit ArrayList.
*/

public class Phonebook {
	private ArrayList<Person> entries = new ArrayList<Person>();
	
	/**
	* Fügt dem Telefonbuch eine neue Person hinzu.
	* @param p Personeneintrag
	*/
	public void add(Person p) {
		entries.add(p);
	}
	
	/**
	* Fügt dem Telefonbuch eine neue Person hinzu.
	* @param name Der Name der Person
	* @param phone Die Telefonnummer
	*/
	public void add(String name, String phone) {
		entries.add(new Person(name , phone));
	}
	
	/**
	* Liefert eine lesbare Repräsentation der Telefonbuchs, mit allen
	* Einträgen
	* @return Die Zeichenkettenrepräsentation
	*/
	public String toString() {
		String out = "";
		for (int i = 0; i<entries.size(); i++) {
			out += entries.get(i)+ "\n";
		}
		
		return out+entries.size()+" Eintraege"+"\n";
	}
	
	/**
	* Sucht nach dem Personeneintrag mit Namen und liefert die 
	* Telefonnummer der Person zurück zurück.
	* @return Die Telefonnummer
	*/
	public String getPhone(String name) {
		for(int i = 0 ; i<entries.size();i++){
			if(entries.get(i).getName().equals(name)){
				return entries.get(i).getPhone();
			}
		}
		return null;
	}
	
	/**
	* Sortiert die Einträge alphabetisch mit Selection Sort
	*/
	public void sort () {
		for (int i=0; i<entries.size(); i++) { 
			//Index des Elements mit kleinstem Wert suchen 
			int minIndex = i; 
			for (int j=i+1; j<entries.size(); j++) { 
				if (entries.get(minIndex).getName().compareTo(entries.get(j).getName())>0) { 
					minIndex = j; 
				} 
			}
			
			//kleinste Zahl mit vorderster Stelle tauschen 
			Person minValue = entries.get(minIndex); 
			entries.set(minIndex,entries.get(i)); 
			entries.set(i,minValue); 
		} 
	}
	
	/**
	* Löscht alle Einträge mit bestimmten Namen
	* @param Der Name der Personen, die gelöscht werden sollen
	*/
	public void remove (String name) {
		for(int i = 0 ; i < entries.size();i++){
			if(name.equals(entries.get(i).getName())){
				entries.remove(i);
			}
		}
	}
	
	/**
	* Liefert die Anzahl der Einträge
	* @return Anzahl der Einträge
	*/
	public int size() {
		return entries.size();
	}
}