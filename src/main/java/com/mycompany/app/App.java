package com.mycompany.app;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static boolean valuesBetween(ArrayList<Integer> array, int a, int b) {
        System.out.println("inside values_between");

        if (array == null || a==b) return false;

        if (a>b){
	   System.out.println("The first element should be smaller than the second one");
	   return false;
	}  

	ArrayList<Integer> outarray = new ArrayList<Integer>();

        for (Integer elt : array) {
   	     if (elt > a && elt<b) outarray.add(elt);
        }
       
	boolean retval = outarray.isEmpty();
   	return retval;
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
