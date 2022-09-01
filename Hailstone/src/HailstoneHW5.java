import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class HailstoneHW5 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HailstoneHW5() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        int count = 0;
        int max = n;
        int x = n;
        out.print(n);
        while (x != 1) {
            if (x % 2 == 0) { // when even
                x /= 2;
            } else { // when odd
                x = 3 * x + 1;
            }

            out.print(" ," + x);
            count++; // length of series

            if (x > max) {
                max = x;
            }
        }
        out.println();
        out.println("Length of series: " + count);
        out.println("The maximum value is: " + max);
    }

    /**
     * Repeatedly asks the user for a positive integer until the user enters
     * one. Returns the positive integer.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive integer entered by the user
     */
    private static int getPositiveInteger(SimpleReader in, SimpleWriter out) {
        String input;
        boolean good = false;

        do {
            out.println("Please enter a positive integer.");
            input = in.nextLine();

            if (FormatChecker.canParseInt(input)) {
                good = true;
            }

        } while (!good);

        return Integer.parseInt(input);
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
         * Put your main program code here; it may call myMethod as shown
         */

        int input;

        out.println("If you would like to calculate a series, enter y");
        String repeat = in.nextLine();

        while (repeat.equals("y")) {

            input = getPositiveInteger(in, out);

            generateSeries(input, out);

            out.println(
                    "Would you like to calculate a new series? If so, please enter y.");
            repeat = in.nextLine();
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}
