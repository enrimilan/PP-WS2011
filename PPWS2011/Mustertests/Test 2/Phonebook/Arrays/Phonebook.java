/**
* Ein Telefonbuch. Implementierung mit Arrays.
*/

public class Phonebook {
	public static final int MAX_ENTRIES = 20;
	private Person[] entries = new Person[MAX_ENTRIES];
	private int size = 0;
	
	/**
	* Fügt dem Telefonbuch eine neue Person hinzu.
	* @param p Personeneintrag
	*/
	public void add(Person p) {
		entries[size++]=p;
		
		
		
	}
	
	/**
	* Fügt dem Telefonbuch eine neue Person hinzu.
	* @param name Der Name der Person
	* @param phone Die Telefonnummer
	*/
	public void add(String name, String phone) {
		Person p = new Person(name , phone);
		entries[size++]=p;
		
	}
	
	/**
	* Sucht nach dem Personeneintrag mit Namen und liefert das 
	* entsprechende Personenobjekt zurück.
	* @return Das Personenobjekt
	*/
	public Person get(String name) {
		for(int i = 0 ; i < size;i++){
			if(name.equals(entries[i].getName())){
				return entries[i] ;
			}
		}
		return null;
	}
	
	/**
	* Sucht nach dem Personeneintrag mit Namen und liefert die 
	* Telefonnummer der Person zurück zurück.
	* @return Die Telefonnummer
	*/
	public String getPhone(String name) {
		return get(name).getPhone();
	}
	
	/**
	* Liefert true wenn alle Plätze verbraucht sind
	* @return true, wenn alle Plätze verbraucht sind, sonst false
	*/
	public boolean isFull() {
		return size==20 ;	
	}
	
	
	/**
	* Liefert eine lesbare Repräsentation der Telefonbuchs, mit allen
	* Einträgen
	* @return Die Zeichenkettenrepräsentation
	*/
	public String toString() {
		String out = "";
		for (int i = 0; i<size; i++) {
			out += entries[i]+ "\n";
		}
		
		return out+size()+" Eintraege"+"\n";
	}
	
	/**
	* Sortiert die Einträge alphabetisch mit Selection Sort
	*/
	public void sort () {
		for (int i=0; i<size; i++) { 
			//Index des Elements mit kleinstem Wert suchen 
			int minIndex = i; 
			for (int j=i+1; j<size; j++) { 
				if (entries[minIndex].getName().
					compareTo(entries[j].getName())>0) { 
				minIndex = j; 
					} 
			}
			
			//kleinste Zahl mit vorderster Stelle tauschen 
			Person minValue = entries[minIndex]; 
			entries[minIndex] = entries[i]; 
			entries[i] = minValue; 
		} 
	}
	
	/**
	* Löscht alle Einträge mit bestimmten Namen
	* @param Der Name der Person, die gelöscht werden soll
	*/
	public void remove (String name) {
		Person[] temp = new Person[MAX_ENTRIES];
		int j=0;
		int tempi=size;
		for(int i = 0 ; i <tempi ; i++){
			if(!name.equals(entries[i].getName())){
				temp[j]=entries[i];
				j++;
			}
			else{
			size--;
			}
		}
		
		entries=temp;
		
	}
	
	/**
	* Liefert die Anzahl der Einträge
	* @return Anzahl der Einträge
	*/
	public int size() {
		return size;
	}
}