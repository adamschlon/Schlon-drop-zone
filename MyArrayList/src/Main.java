import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {

        ArrayList arr = new ArrayList();

        ArrayTester t = new ArrayTester();


        System.out.println("\n" + (t.testHarness() ? "Tests passed" : "1 or more tests failed"));
    }
}
