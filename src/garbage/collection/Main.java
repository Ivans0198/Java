package garbage.collection;

public class Main {

    public static void main(String[] args) {
        doCatStuff();
        System.out.println("I'm done doing a cat stuff");
    }

    private static void doCatStuff(){

    }
}

/**
 * Garbage collection: Java do a good Memory management
 * Delete objects from memory that the program doesn't need anymore
 * when a method end, all objects are deleted in this scope
 * other way is set null
 */