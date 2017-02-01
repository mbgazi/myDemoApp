package com.mycompany.app;

import junit.framework.*;
//import junit.framework.TestCase;
//import junit.framework.TestSuit;
import java.util.*;
//import App;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
 
   public void  testNotEmptyArray(){
     ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5,9,1,20,3,7));   
     assertTrue(new App().valuesBetween(array, 2,10));
   }
  
   public void testAllValuesGreater(){
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5,9,1,20,3,7));
      assertFalse(new App().valuesBetween(array, 25,30));
   }

   public void testAllValuesSmaller(){
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5,9,1,20,3,7));
      assertFalse(new App().valuesBetween(array, -1,0));
   }

   public void testNothingBetween(){
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5,9,1,20,3,7));
      assertFalse(new App().valuesBetween(array, 3,3));
   }

   public void testArrayNull(){
      assertFalse(new App().valuesBetween(null, 1, 5));
   }
  
   public void testReturnedListNotEmpty(){
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5,9,1,20,3,7));
      assertTrue(new App().valuesBetween(array, 2,10));
   }
 }
