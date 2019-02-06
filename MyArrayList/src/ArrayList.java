/*      CLASS MyArray
 *   Creates ArrayList
 *   Implements MyInterface
 */
public class ArrayList implements MyInterface {

    private Object[] myArray;                   //declare initial variables
    public int size;


    //TODO comment getters
    public Object[] getMyArray() {
        return myArray;
    }

    public int getSize() {
        return size;
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
    public void increaseSize() {
        Object[] tempArray = new Object[size + 20];
        for (int i = 0; i < myArray.length; i++) {
            tempArray[i] = myArray[i];
        }
        myArray = tempArray;
    }

    /*      CONSTRUCTOR ArrayList
     *   myArray is object array with size 50
     */
    public ArrayList() {
        myArray = new Object[20];
    }


    /*      METHOD getArrayObject
     *   INPUTS: Index
     *   OUTPUTS: Object in array at given index
     */
    public Object getArrayObject(int index) {
        return myArray[index];
    }
    public int getLength(){
        return myArray.length;
    }


    /*      METHOD shiftArray
     *   INPUTS: Object array myArray
     *           Index
     *   OUTPUTS: NONE
     *   Makes a null space at given index and shifts everything
     *   else to the right
     */
    public void shiftArray(int index) {
        if (!enoughSize()) {
            increaseSize();
        }

        if (index > size){
            throw new IndexOutOfBoundsException();
        }
        Object[] tempArray = new Object[size];
        for (int i = 0; i <= size; i++) {
            if (i < index) {
                tempArray[i] = myArray[i];
            } else if (i == index) {
                tempArray[i] = null;
                size++;
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
            increaseSize();
        } else {
            myArray[size] = data;
            size++;
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

        if (!enoughSize()) {                                //TODO can I call checksize stand alone?
            increaseSize();
        }

        if (myArray[index] == null) {
            myArray[index] = data;

        } else {
            shiftArray(index);
            myArray[index] = data;
        }
    }

    /*      METHOD toString COMPLETE
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
            }
            else{stringOfArray += "*";}
        }
        return stringOfArray;
    }

}
