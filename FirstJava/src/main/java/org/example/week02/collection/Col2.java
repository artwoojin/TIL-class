package org.example.week02.collection;

import java.util.LinkedList;

public class Col2 {
    public static void main(String[] args) {
        // linked list
        // 메모리에 남는 공간을 요청해서 여기 저기 나누어서 실제 값을 담아놔요.
        // 실제 값이 있는 주소값으로 목록을 구성하고 저장하는 자료구조

        // 기본적 기능은 -> ArrayList와 동일!
        // LinkedList는 값을 여기저기 나누어서 놓으니까 조회 속도가 느리다.
        // 반면, 값을 추가하거나 삭제할 때는 빠르다.

        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(3);

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));

        System.out.println(linkedList.toString());

        linkedList.add(200);
        System.out.println(linkedList.toString());

        linkedList.add(2, 4);
        System.out.println(linkedList.toString());

        linkedList.add(1, 30);
        System.out.println(linkedList.toString());

        linkedList.remove(1);
        System.out.println(linkedList.toString());

        linkedList.clear();
        System.out.println(linkedList.toString());

    }
}
