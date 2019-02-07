public class Main {

    public static void main(String[] args) {

        //ArrayList arr = new ArrayList();

        ArrayTester t = new ArrayTester();

        /*
        System.out.println(arr.toString());
        arr.insert('e');
        System.out.println(arr.toString());
        arr.insert("llo", 1);
        System.out.println(arr.toString());
        arr.insert('h', 0);
        System.out.println(arr.toString());
        arr.increaseArrayLength();
        System.out.println(arr.toString());
        arr.increaseArrayLength();
        System.out.println(arr.toString());
        */

        System.out.println("\n" + (t.testHarness() ? "ALL TESTS PASSED!!!" : "1 or more tests failed"));
    }
}
