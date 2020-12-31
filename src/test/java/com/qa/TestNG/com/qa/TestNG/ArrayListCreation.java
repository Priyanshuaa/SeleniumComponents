package com.qa.TestNG.com.qa.TestNG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListCreation {
	
	public static void main(String[] args)
	
	{
		ArrayList<String> Tvseries=new ArrayList<String>();
		Tvseries.add("Breaking Bad");
		Tvseries.add("The Big Bang Theory");
		Tvseries.add("Game of Thrones");
		Tvseries.add("The Walking Dead");
		Tvseries.add("The Prison Break");
        //1.java 8 with for each loop and lambda expression
		Tvseries.forEach(show ->{
			System.out.println("Each Item is "+show);	
		});
		
		//2.using Iterator
		
		Iterator<String> itr=Tvseries.iterator();
		while(itr.hasNext())
		{
			String shows=itr.next();
			System.out.println("Each Item is "+shows);	
		}
		
        //3.Java 8 with for each remaining method()
		itr=Tvseries.iterator();
		itr.forEachRemaining(show ->{
			System.out.println("Each Item is "+show);	
		});
	
		
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXFOR EACH LOOP DEMONSTRATIONXXXXXXXXXXXXXXXXXXXXXXXXXX");

		//4.Using For Each Loop
		for(String k:Tvseries)
		{
	    	System.out.println(k);

		}
			
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXUSING FOR LOOP WITH ORDER/INDEXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	    //5.Using For Loop with Order/Index
		int size=Tvseries.size();
		for(int u=0;u<size;u++)
		{
		   	System.out.println(Tvseries.get(u));
		}
		
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXUSING LIST ITERATOR to traverse in both directionsXXXXXXXXXXXXXXXXXXXXXXXXXX");
	    //5.Using List Iterator
		ListIterator<String> lst1=Tvseries.listIterator(Tvseries.size());
		while(lst1.hasPrevious())
		{
			String show=lst1.previous();
			System.out.println(show);
		}
		
	}
}
