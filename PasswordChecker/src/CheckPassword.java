import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Checks to see if the password meets the requirements stated.
 *
 * @author Vaishnavi Kasabwala
 *
 */
public final class CheckPassword {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CheckPassword() {
    }

    /**
     * Checks whether the given String satisfies the OSU criteria for a valid
     * password. Prints an appropriate message to the given output stream.
     *
     * @param s
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String s, SimpleWriter out) {
        int k = 0;

        if (s.length() < 8) {
            out.println("Password must contain at least 8 character.");
            out.println("Password is rejected.");
        } else {
            if (containsUpperCaseLetter(s)) {
                k++;
            } else {
                out.println("Password must contain an upper case letter.");
            }
            if (containsLowerCaseLetter(s)) {
                k++;
            } else {
                out.println("Password must contain a lower case letter.");
            }
            if (containsDigit(s)) {
                k++;
            } else {
                out.println("Password must contain a digit.");
            }

            if (k < 2) {
                out.println("Password is rejected.");
            }
        }
    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an upper case letter, false otherwise
     */
    private static boolean containsUpperCaseLetter(String s) {
        int i = 0;
        while (i < s.length() && !Character.isUpperCase(s.charAt(i))) {
            i++;
        }
        return i < s.length();
    }

    /**
     * Checks if the given String contains a lower case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains a lower case letter, false otherwise
     */
    private static boolean containsLowerCaseLetter(String s) {
        int i = 0;
        while (i < s.length() && !Character.isLowerCase(s.charAt(i))) {
            i++;
        }
        return i < s.length();
    }

    /**
     * Checks if the given String contains a digit.
     *
     * @param s
     *            the String to check
     * @return true if s contains a digit, false otherwise
     */
    private static boolean containsDigit(String s) {
        int i = 0;
        while (i < s.length() && !Character.isDigit(s.charAt(i))) {
            i++;
        }
        return i < s.length();
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        /*
         * Put your main program code here; it may call checkPassword as shown
         */
        out.println("Please enter a password:");
        String s = in.nextLine();

        checkPassword(s, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
