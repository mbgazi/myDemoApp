package com.mycompany.app;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

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

        for (Integer i : array) {
   	     if (i > a && i<b) outarray.add(i);
        }
       
	boolean retval = !(outarray.isEmpty());
   	return retval;
    }//end  of valuesBetween

    public static void main( String[] args )
    {
      //  System.out.println( "Hello World!" );
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);


          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);
          
          String input3= req.queryParams("input3").replaceAll("\\s","");
          int input3AsInt = Integer.parseInt(input3);
          
          boolean result = App.valuesBetween(inputList, input2AsInt, input3AsInt);

          Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
 }


