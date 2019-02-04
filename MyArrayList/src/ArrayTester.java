    /*      CLASS ArrayTester
    *   Checks each method of the ArrayList class for function
    *   Prints out what pass or fail and values for each method
     */

    import java.lang.reflect.Array;

    public class ArrayTester {

    public static boolean testHarness(){
        boolean testsPassed = true;
        testsPassed = testEnoughSize() ? true : false;

        return testsPassed;
    }

    public static void fillArray(ArrayList a){
        for (int i = 0; i < ArrayTester.length(); i++) {
            a.insert(0);
        }
    }

    public static int length(){
        int length = ArrayList.getMyArray().length;
        return length;
    }

    public static boolean testEnoughSize(){
        boolean result = true;

        ArrayList testArray = new ArrayList();
        System.out.println("Should be true is " + testArray.enoughSize());
        if(!testArray.enoughSize()){
            result = false;
        }

        testArray = new ArrayList();
        testArray.insert(0);
        System.out.println("Should be true is " + testArray.enoughSize());
        if(!testArray.enoughSize()){
            result = false;
        }

        testArray = new ArrayList();
        fillArray(testArray);
        System.out.println("Should be false is " + testArray.enoughSize());
        if(testArray.enoughSize()){
            result = false;
        }

        System.out.println(testArray.toString());

        return result;
    }


    public static boolean testShiftArray(){

        return false;
    }


}
