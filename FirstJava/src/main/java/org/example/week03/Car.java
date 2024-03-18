package org.example.week03;

/*
* [ 클래스를 만들기 위해 필요한 4가지 STEP]
* 1. 만들려고 하는 설계도 선언 - 클래스 선언
* 2. 객체가 가지고 있어야 할 속성(필드) 정의
* 3. 객체를 생성하는 방식을 정의 - 생성자(constructor)
* 4. 객체가 가지고 있어야 할 행위(메서드) 정의
* */

public class Car {
    // <필드 영역>

    // 1) 고유 데이터 영역
    String company; // 자동차 회사
    String model = "Gv80"; // 자동차 모델
    String color; // 자동차 색
    double price; // 자동차 가격

    // 2) 상태 데이터 영역
    double speed; // 자동차 속도, km/h
    char gear; // 기어 상태(P, R, N, D)
    boolean lights = true; // 자동차 조명의 상태

    // 3) 객체 데이터 영역
    Tire tire = new Tire();
    Door door;
    Handle handle;

    // <생성자 영역>
    // 생성자 : 처음 객체가 생성될 때(instance화) 어떤 로직을 수행해야 하며, 어떤 값이 필수로 들어와야 하는지 정의함
    public Car() {
        // logic
        // 기본생성자 : 생략 가능
        System.out.println("생성자가 호출되었습니다! 객체가 생성됩니다!");
    }

    // <메서드 영역>

    // gasPedal
    // input : km/h
    // output: speed
    double gasPedal(double kmh) {
        speed = kmh;
        return speed;
    }

    // brakePedal
    // input : x
    // output : speed
    double brakePedal() {
        speed = 0;
        return speed;
    }

    // changePedal
    // input : gear(char type)
    // output : gear
    char changeGear(char type) {
        gear = type;
        return gear;
    }

    // onOffLight
    // input : x
    // output : lights(boolean)
    boolean onOffLights() {
        lights = !lights;
        return lights;
    }

    // horn
    // input : x
    // output : x
    void horn () {
        System.out.println("빵빵!");
    }
}
