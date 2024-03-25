package org.example.week03.packageExample.main;


import org.example.week03.packageExample.pk1.Car;

public class Main {
    public static void main(String[] args) {
        // 클래스의 일부분이며, 하위 패키지를 도트(.)로 구분한다.

        Car car = new Car();
        org.example.week03.packageExample.pk2.Car pkCar = new org.example.week03.packageExample.pk2.Car();
        car.horn();
    }
}
