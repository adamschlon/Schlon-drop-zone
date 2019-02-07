/*      CLASS MyArray
 *   Creates ArrayList
 *   Implements MyInterface
 */
@SuppressWarnings({"ManualArrayCopy", "StringConcatenationInLoop"})
public class ArrayList implements MyInterface {

    private Object[] myArray;                   //declare initial variables
    private Object[] tempArray;                 //saved everything, allow for mutating arrays
    private int size;                            //amount of data in array, not same as length(storage)


    /*      CONSTRUCTOR ArrayList
     *   myArray is object array with size 50
     */
    @SuppressWarnings("WeakerAccess")
    public ArrayList() {
        myArray = new Object[20];
        tempArray = new Object[20];
    }

    /*      METHOD checkSize
     *   INPUT: Object[] of myArray
     *   OUTPUT: False if full, True if space is available
     *   Throws error if there is more data than space
     */
    public boolean enoughSize() {
        if (size < myArray.length) {
            return true;
        } else if (size == myArray.length) {
            return false;
        } else {
            throw new OutOfMemoryError();
        }
    }


    /*      METHOD increaseSize
     *   INPUTS: NONE
     *   OUTPUTS: NONE
     *   Adds 50 to current array size
     */
    public void increaseArrayLength() {
        Object[] bigArray = new Object[size + 20];
        for (int i = 0; i < myArray.length; i++) {
            bigArray[i] = myArray[i];
        }
        myArray = bigArray;

        bigArray = new Object[size + 20];
        for (int i = 0; i < tempArray.length; i++) {
            bigArray[i] = tempArray[i];
        }
        tempArray = bigArray;
    }


    /*      METHOD getArrayObject
     *   INPUTS: Index
     *   OUTPUTS: Object in array at given index
     */
    public Object getArrayObject(int index) {
        return myArray[index];
    }

    /*      METHOD getLength
    *   INPUTS:NONE
    *   OUTPUTS: Length of array
     */
    @SuppressWarnings("WeakerAccess")
    public int getLength() { return myArray.length; }

    /*      METHOD getSize
     *   INPUTS:NONE
     *   OUTPUTS: Amount of data in array
     */
    private int getSize() {return size;}

    /*      METHOD incrementSize
     *   INPUTS:NONE
     *   OUTPUTS: NONE
     *   increments the size of the array by 1
     */
    public void incrementSize(){size++;}

    /*      METHOD shiftArray
     *   INPUTS: Object array myArray
     *           Index
     *   OUTPUTS: NONE
     *   Makes a null space at given index and shifts everything
     *   else to the right
     */
    public void shiftArray(int index) {
        if (!enoughSize()) {
            increaseArrayLength();
        }
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i <= getSize(); i++) {
            if (i < index) {
                tempArray[i] = myArray[i];
            } else if (i == index) {
                tempArray[i] = null;
                incrementSize();
            } else {
                tempArray[i] = myArray[i - 1];
            }
        }
        myArray = tempArray;
    }


    /*      METHOD insert
     *   INPUTS: data to add
     *   OUTPUTS: NONE
     *   Replaces nearest null value with data
     *   adding space as needed
     */
    @Override
    public void insert(Object data) {
        if (!enoughSize()) {
            increaseArrayLength();
            myArray[size] = data;
            incrementSize();
        } else {
            myArray[size] = data;
            incrementSize();
        }
    }

    /*      METHOD insert
     *   INPUTS: data to add, index to insert
     *   OUTPUTS: NONE
     *   Adds data at given index shifting
     *   the rest to the right
     */
    @Override
    public void insert(Object data, int index) {

        if (!enoughSize()) {
            increaseArrayLength();
        }
        if (index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            if (myArray[index] == null) {
                myArray[index] = data;
                incrementSize();

            } else {
                shiftArray(index);
                myArray[index] = data;
                incrementSize();
            }
        }
    }

    /*      METHOD toString
     *   INPUTS: NONE
     *   OUTPUTS: NONE
     *   Converts array to printable string
     *   ignoring null
     */
    @Override
    public String toString() {
        String stringOfArray = "";
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] != null) {
                stringOfArray += myArray[i];
                if (i + 1 < size) {
                    stringOfArray += "-";
                }
            } else {
                stringOfArray += "*";
            }
        }
        return stringOfArray;
    }

}
