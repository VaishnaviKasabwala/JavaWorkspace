import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Creates square roots from input.
 *
 * @author Vaishnavi Kasabwala
 *
 */
public final class Newton1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton1() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {

        double r = x;
        double epsilon = 0.0001;

        while (!(Math.abs(r * r - x) / x < epsilon * epsilon)) {
            r = (r + x / r) / 2;
        }
        return r;
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
         * Put your main program code here; it may call sqrt as shown
         */
        double input;

        out.println("If you would like to calculate a square root, enter y");
        String repeat = in.nextLine();

        while (repeat.equals("y")) {
            out.print("Enter a positive decimal point number:");
            input = in.nextDouble();

            out.println("The squared root of " + input + " is: " + sqrt(input));

            out.println(
                    "If you would like to calculate another square root, enter y");
            repeat = in.nextLine();
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
