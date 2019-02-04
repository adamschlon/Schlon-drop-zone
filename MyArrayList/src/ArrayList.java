
    /*      CLASS MyArray
     *   Creates ArrayList
     *   Implements MyInterface
     */
public class ArrayList implements MyInterface {

    private static Object[] myArray;                   //declare initial variables
    public static int size;


    //TODO comment getters
    public static Object[] getMyArray(){
        return myArray;
    }
    public static int getSize(){
        return size;
    }

    /*      METHOD checkSize
    *   INPUT: Object[] of myArray
    *   OUTPUT: False if full, True if space is available
    *   Throws error if there is more data than space
     */
    public boolean enoughSize() {
        if(size < myArray.length){
            return true;
        }
        else if(size == myArray.length){
            return false;
        }
        else{
            throw new OutOfMemoryError();
        }
    }


    /*      METHOD increaseSize
    *   INPUTS: NONE
    *   OUTPUTS: NONE
    *   Adds 50 to current array size
     */
    private void increaseSize(){
        Object[] tempArray = new Object[size + 50];
        for(int i = 0; i < myArray.length; i++){
            tempArray[i] = myArray[i];
        }
        myArray = tempArray;
    }

    /*      CONSTRUCTOR ArrayList
    *   myArray is object array with size 50
     */
    public ArrayList() {
        this.myArray = new Object[50];
    }


    /*      METHOD getArrayObject
    *   INPUTS: Index
    *   OUTPUTS: Object in array at given index
     */
    public Object getArrayObject(int index) {
        return myArray[index];
    }


    /*      METHOD shiftArray
    *   INPUTS: Object array myArray
    *           Index
    *   OUTPUTS: NONE
    *   Makes a null space at given index and shifts everything
    *   else to the right
     */
    private void shiftArray(Object[] a, int index){
        Object[] tempArray = new Object[size];
        for (int i = 0; i <= size; i++) {
            if(i < index){
                tempArray[i] = a[i];
            }
            else if(i == index){
                tempArray[i] = null;
                size++;
            }
            else{
                tempArray[i] = a[i - 1];
            }
        }
        a = tempArray;
    }



    /*      METHOD insert
    *   INPUTS: data to add
    *   OUTPUTS: NONE
    *   Replaces nearest null value with data
    *   adding space as needed
     */
    @Override
    public void insert(Object data) {
        //TODO check size then add to end. is fucked up rn bad
        if(this.size == myArray.length){
            this.myArray = new Object[size + 10];
            myArray[size] = data;
        }
        else{
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

        if(enoughSize()){                                //TODO can I call checksize stand alone?
            increaseSize();
        }

        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(this.size == myArray.length){
            this.myArray = new Object[size + 10];
            if(myArray[index] ==  null){
                myArray[index] = data;
            }
            else{
                shiftArray(myArray, index);
                myArray[index] = data;
            }
        }
        else{
            myArray[index] = data;
            size++;
        }
    }

    /*      METHOD toString COMPLETE
    *   INPUTS: NONE
    *   OUTPUTS: NONE
    *   Converts array to printable string
    *   ignoring null
     */
    @Override
    public String toString(){
        String stringOfArray = "";
        for (int i = 0; i < myArray.length; i++) {
            if(myArray[i] != null){
                stringOfArray += myArray[i];
                if(i + 1 < myArray.length){
                    stringOfArray += "-";
                }
            }
        }
        return stringOfArray;
    }

}
