import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Hailstone4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone4() {
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
        out.print(n + ", ");
        while (x != 1) {
            if (x != 1) {
                if (x % 2 == 0) { // when even
                    x /= 2;
                } else { // when odd
                    x = 3 * x + 1;
                }
                if (x == 1) {
                    out.println(x);
                } else {
                    out.print(x + ", ");
                }
            }
            count++; // length of series
            if (x > max) {
                max = x;
            }
        }
        out.println("Length of series: " + count);
        out.println("The maximum value is: " + max);
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
        char repeat = 'y';
        int input;

        while (repeat == 'y') {
            out.println("Enter a positive number: ");

            input = in.nextInteger();
            generateSeries(input, out);

            out.println(
                    "Would you like to calculate a new series? If so, please enter y.");
            repeat = in.read();
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}
