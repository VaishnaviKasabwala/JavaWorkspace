import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Execution of the de Jager formula.
 *
 * @author Vaishnavi Kasabwala
 *
 */
public final class ABCDGuesser2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser2() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        boolean good = false;

        out.println("Please enter a positive number that has a demical.");
        String mu = in.nextLine();

        while (!good) {
            // returns only is mu is a double and positive
            if (FormatChecker.canParseDouble(mu)
                    && Double.parseDouble(mu) > 0) {
                good = true;
            } else {
                out.println(
                        "Please enter a positive number that has a demical.");
                mu = in.nextLine();
            }
        }

        return Double.parseDouble(mu);
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        double mu = getPositiveDouble(in, out);

        while (mu == 1) {
            out.println("Number can not be 1. Please try again.");
            mu = getPositiveDouble(in, out);
        }

        return mu;
    }

    /**
     * Evaluates the jager formula
     */
    private static void jager() {

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
         * Gets values for the variables
         */

        double mu = getPositiveDouble(in, out);
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);

        out.println(mu + " " + w + " " + x + " " + y + " " + z + " ");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
