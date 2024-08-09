package lang.immutable.change;

public class ImmutableMain1 {

    public static void main(String[] args) {
        ImmutableObj obj1 = new ImmutableObj(10);
        ImmutableObj abj2 = obj1.add(20);

        System.out.println("obj1 = " + obj1.getValue());
        System.out.println("abj2 = " + abj2.getValue());
    }
}
