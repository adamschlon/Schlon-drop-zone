
public class ArrayTester {

    public boolean testHarness() {
        boolean testsPassed = true;
        String testResult;
        if (testEnoughSize()) {
            testResult = "passed";
        } else {
            testResult = "failed";
            testsPassed = false;
        }
        System.out.println("testEnoughSize: " + testResult);

        if(testShiftArray()){
            testResult = "passed";
        }
        else{
            testResult = "failed";
            testsPassed = false;
        }
        System.out.println("testShiftArray: " + testResult);

        return testsPassed;
    }

    public void fillArray(ArrayList a) {
        for (int i = 0; i < a.getLength(); i++) {
            a.insert(0);
        }
    }


    public boolean testEnoughSize() {
        boolean result = true;

        ArrayList testArray = new ArrayList();

        System.out.println("Should be true is " + testArray.enoughSize());
        if (!testArray.enoughSize()) {
            result = false;
        }

        System.out.println(testArray.toString());

        testArray = new ArrayList();
        testArray.insert(0);
        System.out.println("Should be true is " + testArray.enoughSize());
        if (!testArray.enoughSize()) {
            result = false;
        }
        System.out.println(testArray.toString());

        testArray = new ArrayList();
        fillArray(testArray);
        System.out.println("Should be false is " + testArray.enoughSize());
        if (testArray.enoughSize()) {
            result = false;
        }

        System.out.println(testArray.toString());

        return result;
    }


    public boolean testShiftArray() {
        boolean result = true;
        String statement;

        ArrayList testArray = new ArrayList();
//
        System.out.println("length is " + testArray.getLength());
        System.out.println("" + testArray.enoughSize()); //TODO error on calling enough size on test array, running else case
        System.out.println("Array: " + testArray.toString());
//
        fillArray(testArray);

        testArray.shiftArray(0);
        if(testArray.getArrayObject(0) == null){
            statement = null;
        }
        else{
            statement = "" + testArray.getArrayObject(0);
            result = false;
        }
        System.out.println("index 0 should be null is " + statement);


        testArray = new ArrayList();
        fillArray(testArray);
        testArray.shiftArray(7);
        if(testArray.getArrayObject(7) == null){
            statement = null;
        }
        else{
            statement = "" + testArray.getArrayObject(7);
            result = false;
        }
        System.out.println("index 7 should be null is " + statement);


        testArray = new ArrayList();
        try{
            System.out.print("Should throw exception: ");
            testArray.shiftArray(15);
        }
        catch(IndexOutOfBoundsException i){
            System.out.println("threw correct exception");
        }

        testArray = new ArrayList();
        fillArray(testArray);
        try{
            System.out.print("Should throw exception: ");
            testArray.shiftArray(50);
        }
        catch(IndexOutOfBoundsException i){
            System.out.println("threw correct exception");
        }


        return result;
    }


}
