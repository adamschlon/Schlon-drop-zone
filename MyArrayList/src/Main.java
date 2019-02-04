import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {

        ArrayList arr = new ArrayList();

        /*TEMPORARY TESTING OF METHODS
        arr.insert(new Integer(7));
        arr.insert("Hello", 0);
        System.out.println(arr.getArrayObject(0));
        System.out.println(arr.toString());
        */

        System.out.println(ArrayTester.testHarness() ? "Tests passed" : "1 or more tests failed");
    }
}
