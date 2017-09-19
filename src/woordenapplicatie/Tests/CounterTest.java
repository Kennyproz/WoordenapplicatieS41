package woordenapplicatie.Tests;

import org.junit.jupiter.api.Assertions;
import woordenapplicatie.gui.Counter;

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
        Assertions.assertEquals("[equal, dozen, csharp, bee, alpha]",counter.countSortDesc());

        testString = "Alpha Equal Dozen Csharp Bee";
        counter = new Counter(testString);
        Assertions.assertEquals("[equal, dozen, csharp, bee, alpha]",counter.countSortDesc());
    }

    @org.junit.jupiter.api.Test
    void countFrequent(){
        testString = "One Two Two Three Three Three";
        counter = new Counter(testString);
        Assertions.assertEquals("{one: 1, two: 2, three: 3}",counter.countFrequent());

        testString = "One Two Three Three";
        counter = new Counter(testString);
        Assertions.assertEquals("{one: 1, two: 1, three: 2}",counter.countFrequent());
    }




}