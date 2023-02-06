package CollectionsPractice;

import java.lang.reflect.Array;
import java.util.*;

public class demo1 {

	public static void main(String[] args) {
		
		Object[] arrr = new Object[] {1,5,8,9,2};
		Vector v3 =new Vector(Arrays.asList(arrr));
		System.out.println(v3);
		System.out.println("size: " +v3.size() );
		System.out.println("capacity: "+v3.capacity());
		
		Vector v1= new Vector(20);
		v1.add("Ashok");
		v1.add("Kumar");
		v1.add("Raj");
		
		Vector v2= new Vector();
		v2.add("Ramesh");
		v2.add("Suresh");
		
		System.err.println(v1);
		System.err.println(v2);
		
		v1.addAll(0,v2);
		/*
		 * for(int i=0; i<v2.size(); i++) { v1.add(v2.get(i)); }
		 */
		System.err.println(v1);
		
		//v1.remove(0);
		//v1.removeAll(v2);
		//v1.clear();
		System.out.println(v1.containsAll(v2));
		v1.set(1,"Satish");
		
		
		System.err.println(v1);
		System.out.println(v1.indexOf("Kumar"));
		System.out.println(v1.firstElement());
		System.out.println(v1.lastElement());
		
		Object[] arr =v1.toArray();
		System.err.println(Arrays.toString(arr));
		
		System.out.println("size: " +v1.size() );
		System.out.println("capacity: "+v1.capacity());
	} 

}          
