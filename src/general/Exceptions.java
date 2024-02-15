package general;

public class Exceptions {

    public static void main(String[] args) {
        System.out.println(exception());
    }

    private static int exception() {
        try {
            if (true) throw new RuntimeException("Exception...");
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
}

