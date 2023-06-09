package org.prominentpixel;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        Stream.iterate(0,n->n+1).limit(51).forEach(x-> System.out.print(x+" "));

        System.out.println();

        List<String> words = Arrays.asList("cat", "dog", "bird", "elephant");

        String word=words.stream().filter(w->w.length()>10).findFirst().orElse("No word found");

        System.out.println(word);

        String result= words.stream().map(w->w.toUpperCase()).reduce(" ",(w1,w2)->w1+w2);

        System.out.println(result);


        String text = "ehihyholle";

        int index = text.lastIndexOf("e", 4);

        System.out.println(index);

        Stream<String> words1 = Stream.of("apple", "banana", "cherry");
        List<String> result5 = words1.collect(Collectors.toUnmodifiableList());
        System.out.println(result5);

        Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> doubleIt = x -> x * x;
        int result6 = addOne.compose(doubleIt).apply(3);
        System.out.println(result6);


        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> endsWithB = s -> s.endsWith("B");
        Predicate<String> combined = startsWithA.and(endsWithB);
        List<String> words2 = Arrays.asList("Apple", "Banana", "Cherry");
        List<String> result8 = words.stream().filter(combined).collect(Collectors.toList());
        System.out.println(result8);


        Stream<Integer> ints = Stream.iterate(1, i -> i + 2).limit(3);
        Function<Integer, Integer> addOne2 = i -> i + 1;
        List<Integer> result10 = ints.map(addOne2).collect(Collectors.toList());
        System.out.println(result10);



        Map<Integer, Integer> map = new HashMap<>();
        map.put (1, 2);
        map.put (2, 4);
        map.put (3, 6);
        int result11 = map.entrySet ().stream()
                .filter (entry -> entry.getKey() % 2 == 1)
                .mapToInt (Map. Entry::getValue)
                .reduce (0, Integer::sum);
        System.out.println(result11);


        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "a");
        map1.put (2, "b");
        map1.put(3, "c");
        map1.computeIfAbsent (4, key -> "d");
        System.out.println(map1.size());
        System.out.println(map1.get(4));


        Map<String, Integer> map5 = new HashMap<>() ;
        map5.put ("a",1);
        map5.put ("b",2);
        map5.put ("c",3);
        int sum10 = map5.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum10);



        Map<String, Integer> map6 = new HashMap<> ();
        map6.put ("a",1);
        map6.put ("b",2);
        map6.put("c",3);
        int result12 = map6.entrySet().stream()
                .mapToInt (entry -> entry.getKey().length() * entry.getValue ())
                .reduce (0, Integer::sum);
        System.out.println(result12);

        Map<Integer, Integer> map7 = new HashMap<>();
        map7.put (1, 10);
        map7.put (2, 20);
        map7.put (3, 30);
        int result13 = map7.values().stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println(result13);


        Map<String, String> map8 = new HashMap<> ();
        map8.put("a","A");
        map8.put ("b","B");
        Map<String, String> map9 = new HashMap<> ();
        map9.put ("e", "C");
        map9.put ("d","D");
        map8.putAll (map9);
        System.out.println (map8.size()) ;

        TreeMap<String, Integer> map10 = new TreeMap<> ();
        map10.put("apple", 3);
        map10.put ("banana", 2);
        map10.put ("cherry", 1);
        map10.put ("date",4);
        map10.put ("bakana", 5);
        map10.put ("cari", 6);
        System.out.println(map10.lastKey()) ;

        TreeMap<String, String> map11 = new TreeMap<> () ;
        map11.put ("apple","A");
        map11.put ("banana", "B");
        map11.put("cherry", "C");
        map11.put ("date", "D");
        Map. Entry<String, String> entry = map11.ceilingEntry("a");
        System.out.println(entry.getValue()) ;


        TreeMap<Integer, String> map12 = new TreeMap<> ();
        map12.put(1, "A");
        map12.put(2, "B");
        map12.put(3, "C");
        map12.put(4, "D");
        SortedMap<Integer, String> subMap = map12.subMap (2, 4);
        subMap.put(5, "E");
        System.out.println (map.size());


    }

}
