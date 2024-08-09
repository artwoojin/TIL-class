
package lang.immutable.test;

public class ImmutableMyDateMain {

    public static void main(String[] args) {
        //date1=x001, date2=x001
        ImmutableMyDate date1 = new ImmutableMyDate(2024, 1, 1);
        ImmutableMyDate date2 = date1;

        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);

        System.out.println("2025 -> date1");
        //date1.setYear(2025);
        date1 = date1.withYear(2025); //x002
        //date2 = new ImmutableMyDate(2025, 1, 1);
        System.out.println("date1 = " + date1); //x002
        System.out.println("date2 = " + date2); //x001

        //불변 객체의 메서드가 with로 이름지어진 경우에는
        //그 메서드가 지정된 수정사항을 포함하는 객체의 새 인스턴스를 반환한다는 사실을 뜻한다.
        // ----> 원본 객체의 상태가 그대로 유지됨을 강조하면서 변경사항을 새 복사본에 포함하는 과정을 간결히 표현
    }
}
