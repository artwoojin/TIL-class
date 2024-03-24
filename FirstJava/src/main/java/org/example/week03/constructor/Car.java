package org.example.week03.constructor;

public class Car {

    String company; // 자동차 회사
    String model; // 자동차 모델
    String color; // 자동차 색상
    double price; // 자동차 가격

    double speed;  // 자동차 속도 , km/h
    char gear; // 기어의 상태, P,R,N,D
    boolean lights; // 자동차 조명의 상태

    Tire tire;
    Door door = new Door();
    Handle handle = new Handle();

    // (1) : 오버로딩
    public Car(String modelName) {
        model = modelName;
        System.out.println("첫 번째 생성자가 호출되었습니다.");
    }

    // (2)
    public Car(String modelName, String colorName) {
        model = modelName;
        color = colorName;
        System.out.println("두 번째 생성자가 호출되었습니다.");
    }

    // (3)
    public Car(String modelName, String colorName, double priceValue) {
        model = modelName;
        color = colorName;
        price = priceValue;
        System.out.println("세 번째 생성자가 호출되었습니다.");
    }

    double gasPedal(double kmh, char type) {
        changeGear(type);
        speed = kmh;
        return speed;
    }

    double brakePedal(char type) {
        speed = 0;
        type = 'P'; // 정지 후 매개변수 type을 어떤 타입으로 전달 받았는지 상관없이 'P'로 고정시키기
        changeGear(type);
        return speed;
    }

    char changeGear(char type) {
        gear = type;
        return gear;
    }

    boolean onOffLights() {
        lights = !lights;
        return lights;
    }

    void horn() {
        System.out.println("빵빵");
    }

    Tire setTire(Tire tireCompany) {
        tireCompany.company = "KIA"; // 금호 타이어를 전달 받았지만 강제로 KIA 타이어로 교체
        tire = tireCompany;
        return tire;
    }
}