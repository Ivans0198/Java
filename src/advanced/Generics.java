package advanced;

import java.util.List;

public class Generics {

    public static void main(String[] args) {

    }

    // Generic method. Before return type of the method
    // Local scope
    public static <T> List<T> arrayToList(T[] array, List<T> list) {
        for (T obj : array) {
            list.add(obj);
        }
        return list;
    }
}
