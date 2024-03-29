import java.util.*;
public class MetricSet<E> extends LinkedHashSet<E> {
	
	//initialisiert ein leeres MetricSet.
	public MetricSet(){}
	
	//initialisiert das MetricSet mit den Elementen aus c.
	public MetricSet(Collection<? extends E> c){
		this.addAll(c);	
	}
	
	/*liefert ein neues MetricSet zur�ck, in dem nur die Elemente enthalten sind, 
	die die minimale Distanz zum spezifizierten Element e haben. Das kann auch nur 
	ein Element sein. m ist die Metrik, die als Distanzma� benutzt werden soll.*/
	public MetricSet<E> search(E e, Metric<? super E> m){
		int min = 100000000;//kleinste Distanz , muss am Anfang m�glichst die gr��te sein!
		MetricSet<E> met = new MetricSet<E>();
		Iterator<E> iter = this.iterator();
		
		//durchlaufen aller Elemente des Set.
		while(iter.hasNext()){
			E f = iter.next();
			if(m.distance(f,e)<=min){
				if(m.distance(f,e)==min){
					met.add(f);
				}
				else {
					met.clear();
					met.add(f);
					min=m.distance(f,e);
				}
				
				
			}
		}
		return met;
	}
}
