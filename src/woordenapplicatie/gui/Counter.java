package woordenapplicatie.gui;

import java.util.*;

/**
 * Created by Ken on 29-8-2017.
 */
public class Counter {

    String woorden[];
    HashSet<String> set;

    public Counter(String woorden) {
        this.woorden = woorden.toLowerCase().split("\\W+");
        set = new HashSet<String>(Arrays.asList(woorden.toLowerCase().split("\\W+")));
    }

    public int countAll(){
        return woorden.length;
    }

    public int countUnique(){
        return set.size();
     }

     public String countSort (){
         TreeSet<String> desendingSet = new TreeSet<>(set);
         return desendingSet.descendingSet().toString();
     }
   /*  public String countFrequent(){
         TreeMap<String, Integer> = new TreeMap<String,Integer>();
     }
*/
}
