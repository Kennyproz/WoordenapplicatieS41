package woordenapplicatie.Tests;

import org.junit.jupiter.api.Assertions;
import woordenapplicatie.gui.Counter;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Ken on 2-9-2017.
 */
class CounterTest {

    Counter counter;
    String testString;

    @org.junit.jupiter.api.Test
    void countAll() {
        testString = "One Two Three Four Five";
        counter = new Counter(testString);
        Assertions.assertEquals(5,counter.countAll());

        testString = "One Two Three Four Five \n Six Seven";
        counter = new Counter(testString);
        Assertions.assertEquals(7,counter.countAll());
    }

    @org.junit.jupiter.api.Test
    void countUnique() {
        testString = "One Two One Two Three";
        counter = new Counter(testString);
        Assertions.assertEquals(3,counter.countUnique());

        testString = "One Two One Two Three \n Four Five Four";
        counter = new Counter(testString);
        Assertions.assertEquals(5,counter.countUnique());
    }

    @org.junit.jupiter.api.Test
    void countSortDesc() {
        testString = "Alpha Bee Csharp Dozen Equal";
        counter = new Counter(testString);
        TreeSet<String> desendingSet = new TreeSet<>();
        desendingSet.add("Equal, Dozen, Csharp, Bee, Alpha");
        Assertions.assertEquals(desendingSet.descendingSet().toString().toLowerCase(),counter.countSortDesc());

        testString = "Alpha Equal Dozen Csharp Bee";
        counter = new Counter(testString);
        Assertions.assertEquals(desendingSet.descendingSet().toString().toLowerCase(),counter.countSortDesc());
    }

    @org.junit.jupiter.api.Test
    void countFrequent(){
        testString = "One Two Two Three Three Three";
        counter = new Counter(testString);
        TreeMap<Integer, Set<String>> testmap = new TreeMap();
        Set strings = new HashSet();
        strings.add("One");
        testmap.put(1,strings);
        strings = new HashSet();
        strings.add("Two");
        testmap.put(2,strings);
        strings = new HashSet();
        strings.add("Three");
        testmap.put(3,strings);

        Assertions.assertEquals(testmap.toString().toLowerCase().replace("=",": "),counter.countFrequent());


        testString = "One Two Three Three";
        counter = new Counter(testString);
        testmap = new TreeMap();
        strings = new HashSet();
        strings.add("One");
        strings.add("Two");
        testmap.put(1,strings);
        strings = new HashSet();
        strings.add("Three");
        testmap.put(2,strings);
        Assertions.assertEquals(testmap.toString().toLowerCase().replace("=",": "),counter.countFrequent());

    }




}