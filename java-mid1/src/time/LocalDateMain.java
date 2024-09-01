package time;

import java.time.LocalDate;

public class LocalDateMain {

    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        LocalDate ofDate = LocalDate.of(2018, 1, 1);
        System.out.println("오늘날짜 = " + nowDate);
        System.out.println("지정날짜 = " + ofDate);

        //계산(불변) -  새로운 객체 생성 안 할 시에는 변경 반영 X
//        ofDate = ofDate.plusDays(10);
//        System.out.println("지정날짜+10d = " + ofDate);

        // 새로운 객체 생성시에 변경 반영 O
        LocalDate plusDays = ofDate.plusDays(10);
        System.out.println("지정날짜+10d = " + plusDays);
    }
}
