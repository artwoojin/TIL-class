package org.example.week02.collection;

import java.util.LinkedList;
import java.util.Queue;

public class Col4 {
    public static void main(String[] args) {
        // Queue : FIFO
        // add(추가), peek(조회), poll(꺼냄)
        // Queue : 생성자가 없는 인터페이스(new 키워드로 만들 수 없음)

        Queue<Integer> intQueue = new LinkedList<Integer>(); // queue를 선언, 생성

        // 추가
        intQueue.add(1);
        intQueue.add(5);
        intQueue.add(9);

        while (!intQueue.isEmpty()) {
            System.out.println(intQueue.poll());
        }

        // 추가
        intQueue.add(1);
        intQueue.add(5);
        intQueue.add(9);
        intQueue.add(10);

        // peek(조회)
        System.out.println(intQueue.peek()); // First In 된 게 맨 먼저 조회가 된다.
        System.out.println(intQueue.size());
    }
}
