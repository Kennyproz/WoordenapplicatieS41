package woordenapplicatie.gui;

import java.util.*;

/**
 * Created by Ken on 29-8-2017.
 */
public class Counter {

    String woorden[];
    String defaultWords;
    HashSet<String> set;

    public Counter(String words) {
        this.woorden = words.toLowerCase().replace("é","e").split("\\W+");
        this.defaultWords = words.toLowerCase().replace("é","e");
        set = new HashSet<String>(Arrays.asList(words.toLowerCase().split("\\W+")));
    }


    public int countAll(){
        return woorden.length;
    }

    public int countUnique(){
        return set.size();
     }

     public String countSortDesc(){
         TreeSet<String> desendingSet = new TreeSet<>(set);
         return desendingSet.descendingSet().toString();
     }

    public String countFrequent(){
         Map<String, Integer> map = new TreeMap<>();
         Map<Integer,Set<String>> sortedMap = new TreeMap<>();
         for (String word : woorden){
             Integer w = map.get(word);
             map.put(word, (w == null) ? 1 : w+1 );
         }
         for (Map.Entry<String,Integer> ksv : map.entrySet()){
             Integer intKey = ksv.getValue();
             Set<String> stringSet = sortedMap.get(intKey);
             if (stringSet == null){
                 stringSet = new HashSet<>();
                 stringSet.add(ksv.getKey());
                 sortedMap.put(ksv.getValue(), stringSet);
             }
             else {
                 sortedMap.get(intKey).add(ksv.getKey());
             }
         }
         return  sortedMap.toString().replace("=",": ");

      }


     public String locationWords() {

         TreeMap<String, Set<Integer>> map = new TreeMap<>();
         String[] lines = defaultWords.split("\\n");

         int currentLine = 1;

         for (String line : lines) {
             String[] words = line.split("\\W+");
             for (String word : words) {
                 if (!word.equals("")) {
                     if (!map.containsKey(word)) {
                         int count = currentLine;
                         map.put(word, new TreeSet() {{
                             add(count);
                         }});
                     } else {
                         map.get(word).add(currentLine);
                     }
                 }
             }
             currentLine++;
         }
         return map.toString();
     }
}
