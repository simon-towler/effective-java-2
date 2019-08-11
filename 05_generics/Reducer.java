import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Reducer implements Function {

    public static void main(String[] args){
        Reducer reducer = new Reducer();
        Function function = reducer;
        List<String> list = new ArrayList<>();
        List syncList = Collections.synchronizedList(list);
        String initVal = "nothing";
        Object result = reducer.reduce(list, function, initVal);
        System.out.println(result.toString());
    }

    public Object apply(Object arg1, Object arg2) {
        return("" + arg1 + arg2);
    }

    // Reduction without generics, and with concurrency flaw!

    /**
     * Method to reduce a list by applying a function across it.
     *
     * If the list contains integers and the function adds two
     * integer values, the reduce method returns the sum of all
     * the values in the list;
     *
     * If the function multiplies two integer values, the method
     * returns the product of the values in the list.
     *
     * If the list contains strings and the function concatenates
     * two strings, the method returns a string consisting of all
     * the strings in the list in sequence.
     *
     * In addition to a list and a function, the reduce method takes
     * an initial value for the reduction, which is returned if the
     * list is empty.
     *
     * @param list
     * @param f
     * @param initVal
     * @return
     */
    public static Object reduce(List list, Function f, Object initVal) {
        synchronized(list){
            Object result = initVal;
            for (Object o : list)
                result = f.apply(result, o);
            return result;
        }
    }

}