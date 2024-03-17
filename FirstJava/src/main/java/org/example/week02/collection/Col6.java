package org.example.week02.collection;

import java.util.HashMap;
import java.util.Map;

public class Col6 {
    public static void main(String[] args) {
        // Map : Key - value pair -> 중요!!
        // key라는 값으로 unique하게 보장이 돼야 함!!
        // Map -> HashMap, TreeMap으로 응용!!

        Map<String, Integer> intMap = new HashMap<>();

        // 키 값 세팅
        intMap.put("일", 11);
        intMap.put("이", 12);
        intMap.put("삼", 13);
        intMap.put("삼", 14); // 중복 key
        intMap.put("삼", 15); // 중복 key
        intMap.put("삼", 16); // 중복 key

        // key 값 전체 출력(향상된 for문)
        for (String key : intMap.keySet()) {
            System.out.println(key); // 중복된 key는 생략해버린다.
        }

        // key 값 전체 출력(향상된 for문)
        for (Integer value : intMap.values()) {
            System.out.println(value);
        }

        System.out.println(intMap.get("삼")); // 앞에 중복된 key의 값들은 덮어씌어져서 없기 때문에 최근 값인 16이 나옴
    }
}
