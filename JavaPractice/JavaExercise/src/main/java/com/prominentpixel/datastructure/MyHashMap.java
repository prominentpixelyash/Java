package com.prominentpixel.datastructure;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {

    public static void main(String[] args) {

        HashMap<String,Integer> hashMap=new HashMap<>();
        hashMap.put("Hello",1);
        hashMap.put("Java",2);
        hashMap.put("Hello",3);
        hashMap.put("React",4);
        hashMap.put("Hello",5);
        hashMap.put("Spring Boot",6);

        for (Map.Entry<String,Integer> entry:hashMap.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }

    }

}
