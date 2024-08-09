package lang.immutable.change;

public class ImmutableMain2 {

    public static void main(String[] args) {
        ImmutableObj obj1 = new ImmutableObj(10);
        obj1.add(20);

        System.out.println("obj1 = " + obj1.getValue());

        //불변 객체에서 변경과 관련된 메서드들은 보통 객체를 새로 만들어서
        //반환하기 때문에 꼭! 반환 값을 받아야 반영된다.(지금 코드에는 없음)
    }
}
