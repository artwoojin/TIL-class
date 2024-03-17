package org.example.week02.w2;

public class W12 {
    public static void main(String[] args) {
        // 중첩 if문
        boolean flag = true;
        int number = 2;

        if (flag) {
            if (number == 1) {
                System.out.println("flag값은 true고, number 값은 1입니다.");
            } else if (number == 2) {
                System.out.println("flag값은 true고, number 값은 2입니다.");
            } else {
                System.out.println("flag값은 true고, number 값은 모르겠습니다.");
            }
        } else {
            System.out.println("flag가 false입니다.");
        }
    }
}
