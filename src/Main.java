import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String args[]) {
        String string = "ababav";
        System.out.println(isPat(string));
    }

    public static boolean isPat(String value) {
        int length = value.length();
        for (int i = 1; i < length; i++) {
            if (length % i == 0) {
                String regex = value.substring(0, i);
                boolean matches = value.matches("(" + regex + ")+");
                if (matches) {
                    return true;
                }
            }
        }
        return false;
    }
}