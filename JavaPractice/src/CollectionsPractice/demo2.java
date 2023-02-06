package CollectionsPractice;

import java.util.*;

public class demo2 {

	public static void main(String[] args) {
		//List <String> list = new Vector<>(); //list object

		Map <Integer,String> m = new Hashtable<>(); //creation of map

		//addition of elements
		m.put(500030, "Hyderabad");
		m.put(500223, "Chennai");
		m.put(123456, "Delhi");

		//System.out.println(m);

		//retrieval of elements
		Set<Integer> Keys = m.keySet();
		for (Integer key : Keys) {
			System.out.println(Keys);
		}
		System.out.println();

		//retrieval of values
		Collection<String> values = m.values();
		for (String value : values) {
			System.out.println(value);
		} System.out.println();

		//retrieval of value from the map based on a key
		//System.out.println(m.get(500030));
		for (Integer key : Keys) {
			System.out.println(key + ">>>>" + m.get(key));
		}
	} 

}