package org.JavaJungseokEssence.Chapter11;

import java.util.TreeSet;

class Ex11_14 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();

        String from = "b";
        String to = "d";

        set.add("abd");
        set.add("bat");
        set.add("car");
        set.add("Car");
        set.add("disc");
        set.add("elephant");
        set.add("fan");
        set.add("flower");

        System.out.println(set);
        System.out.println("range search : from " + from + " to " + to);
        System.out.println("result1 : " + set.subSet(from, to));
        System.out.println("result2 : " + set.subSet(from, to + "zzz"));
    }
}
