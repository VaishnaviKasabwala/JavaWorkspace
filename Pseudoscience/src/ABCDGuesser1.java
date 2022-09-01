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
public final class ABCDGuesser1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser1() {
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

        out.println(
                "Please enter a positive, decimal point number that you would like to estimate.");
        String x = in.nextLine();

        while (!FormatChecker.canParseDouble(x) || Double.parseDouble(x) <= 0) {
            out.println(
                    "Error. Please enter a positive, decimal point number.");
            x = in.nextLine();
        }

        return Double.parseDouble(x);
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
        String x = in.nextLine();
        // double x = getPositiveDouble(in, out);

        while (!FormatChecker.canParseDouble(x) || Double.parseDouble(x) <= 1) {
            out.println(
                    "Error. Please enter a positive, decimal point number that is not 1.");
            x = in.nextLine();
        }

        return Double.parseDouble(x);
    }

    /**
     * .
     */
    private static void error() {

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
         * Gets values for the variables mu, w, x, y, and z.
         */

        double mu = getPositiveDouble(in, out);
        out.println(
                "Please enter your first personal number. Must be a positive, decimal point number not equal to zero.");
        double w = getPositiveDoubleNotOne(in, out);
        out.println(
                "Please enter your second personal number. Must be a positive, decimal point number not equal to zero.");
        double x = getPositiveDoubleNotOne(in, out);
        out.println(
                "Please enter your third personal number. Must be a positive, decimal point number not equal to zero.");
        double y = getPositiveDoubleNotOne(in, out);
        out.println(
                "Please enter your fourth personal number. Must be a positive, decimal point number not equal to zero.");
        double z = getPositiveDoubleNotOne(in, out);

        double epsilon = 0.01;
        double[] arr = { -5.0, -4.0, -3.0, -2.0, -1.0, -1.0 / 2.0, -1.0 / 3.0,
                -1.0 / 4.0, 0, 1.0 / 4.0, 1.0 / 3.0, 1.0 / 2.0, 1.0, 2.0, 3.0,
                4.0, 5.0 };
        double a, b, c, d;
        double aVal, bVal, cVal, dVal;
        double temp = 0, approx = 0;
        double[] save = new double[4];

        int i = 0, j = 0, k = 0, l = 0;
        while (i < arr.length) {
            a = arr[i];
            aVal = Math.pow(w, a);
            while (j < arr.length) {
                b = arr[j];
                bVal = Math.pow(w, b);
                while (k < arr.length) {
                    c = arr[k];
                    cVal = Math.pow(w, c);
                    while (l < arr.length) {
                        d = arr[l];
                        dVal = Math.pow(w, d);
                        temp = (aVal * bVal * cVal * dVal);
                        if (Math.abs(mu - temp) < Math.abs(mu - approx)) {
                            approx = mu - temp;
                            save[0] = a;
                            save[1] = b;
                            save[2] = c;
                            save[3] = d;
                        }
                        l++;
                    }
                    k++;
                }
                j++;
            }
            i++;
        }

        out.println("The estimated value is " + approx + " .");
        out.println("The exponent for w is " + save[0] + " .");
        out.println("The exponent for x is " + save[1] + " .");
        out.println("The exponent for y is " + save[2] + " .");
        out.println("The exponent for z is " + save[3] + " .");

        double error = Math.abs((mu - approx) / mu) * 100;
        out.println("The estimated percent error is " + error + " .");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }
}
