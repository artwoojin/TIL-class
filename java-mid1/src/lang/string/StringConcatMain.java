package lang.string;

public class StringConcatMain {

    public static void main(String[] args) {
        String a = "hello"; //x001
        String b = " java"; //x002

        String result1 = a.concat(b);
        String result2 = a + b; //문자열은 예외적으로 + 연산이 된다.
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);

    }
}
