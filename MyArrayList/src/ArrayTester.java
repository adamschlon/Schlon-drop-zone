
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
        System.out.println("testEnoughSize: " + testResult + "\n");

        if(testShiftArray()){
            testResult = "passed";
        }
        else{
            testResult = "failed";
            testsPassed = false;
        }
        System.out.println("testShiftArray: " + testResult + "\n");

        if(testInsert()){
            testResult = "passed";
        }
        else{
            testResult = "failed";
            testsPassed = false;
        }
        System.out.println("testInsert: " + testResult + "\n");

        return testsPassed;
    }


    private void fillArray(ArrayList a) {
        for (int i = 0; i < a.getLength(); i++) {
            a.insert(0);
        }
    }


    private boolean testEnoughSize() {
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




    private boolean testShiftArray() {
        boolean result = true;
        boolean caught = false;
        String statement;

        ArrayList testArray = new ArrayList();
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
        System.out.println(testArray.toString());


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
        System.out.println(testArray.toString());

        testArray = new ArrayList();
        fillArray(testArray);
        testArray.shiftArray(20);
        if(testArray.getArrayObject(20) == null){
            statement = null;
        }
        else{
            statement = "" + testArray.getArrayObject(20);
            result = false;
        }
        System.out.println("index 20 should be null is " + statement);
        System.out.println(testArray.toString());

        testArray = new ArrayList();
        try{
            System.out.print("Should throw exception: ");
            testArray.shiftArray(15);
        }
        catch(IndexOutOfBoundsException i){
            System.out.println("threw correct exception");
            caught = true;
        }
        finally{
            if(!caught){
                result = false;
            }
        }

        caught = false;
        testArray = new ArrayList();
        fillArray(testArray);
        try{
            System.out.print("Should throw exception: ");
            testArray.shiftArray(50);
        }
        catch(IndexOutOfBoundsException i){
            System.out.println("threw correct exception");
            caught = true;
        }
        finally{
            if(!caught){
                result = false;
            }
        }

        return result;
    }

    private boolean testInsert(){
        boolean result = true;
        boolean caught = false;

        ArrayList testArray = new ArrayList();
        fillArray(testArray);
        testArray.insert("String", 0);
        System.out.println(testArray.toString());
        System.out.println("index 0 should be \"String\" is " + testArray.getArrayObject(0));
        if(!testArray.getArrayObject(0).equals("String")){
            result = false;
        }

        testArray = new ArrayList();
        testArray.insert('C');
        System.out.println(testArray.toString());
        System.out.println("index 0 should be \'C\' is " + testArray.getArrayObject(0));
        if(!testArray.getArrayObject(0).equals('C')){
            result = false;
        }

        testArray = new ArrayList();
        fillArray(testArray);
        testArray.insert(5.0, 20);
        System.out.println(testArray.toString());
        System.out.println("index 20 should be 5.0 is " + testArray.getArrayObject(20));
        if(!testArray.getArrayObject(20).equals(5.0)){
            result = false;
        }

        testArray.insert(5.1, 21);
        System.out.println(testArray.toString());
        System.out.println("index 21 should be 5.1 is " + testArray.getArrayObject(21));
        if(!testArray.getArrayObject(21).equals(5.1)){
            result = false;
        }

        testArray = new ArrayList();
        fillArray(testArray);
        testArray.insert(9,9);
        System.out.println(testArray.toString());
        System.out.println("index 9 should be 9 is " + testArray.getArrayObject(9));
        if(!testArray.getArrayObject(9).equals(9)){
            result = false;
        }

        testArray = new ArrayList();
        try{
            System.out.print("Should throw exception: ");
            testArray.insert(111, 1);
        }
        catch(IndexOutOfBoundsException i){
            System.out.println("threw correct exception");
            caught = true;
        }
        finally{
            if(!caught){
                result = false;
            }
        }

        caught = false;
        testArray = new ArrayList();
        fillArray(testArray);
        try{
            System.out.print("Should throw exception: ");
            testArray.insert(111, 50);
        }
        catch(IndexOutOfBoundsException i){
            System.out.println("threw correct exception");
            caught = true;
        }
        finally{
            if(!caught){
                result = false;
            }
        }

        return result;
    }


}
