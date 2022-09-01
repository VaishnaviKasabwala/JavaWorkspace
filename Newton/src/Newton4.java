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
public final class Newton4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number or zero to compute square root of
     * @param epsilon
     *            used to compute the root with the boolean statement of the
     *            while loop
     * @return estimate of square root
     */
    private static double sqrt(double x, double epsilon) {
        double r = x;

        if (x != 0) {
            while (!(Math.abs(r * r - x) / x < epsilon * epsilon)) {
                r = (r + x / r) / 2;
            }
        } else {
            r = 0;
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
         * Put your main program code here; it may call myMethod as shown
         */
        double input = 1;

        out.println("If you would like to calculate a square root, enter y");
        String repeat = in.nextLine();

        if (repeat.equals("y")) {
            while (input >= 0) {
                out.print("Enter a positive decimal point number:");
                input = in.nextDouble();

                if (input >= 0) {
                    out.print("Enter the value of epsilon:");
                    double epsilon = in.nextDouble();

                    out.println("The squared root of " + input + " is: "
                            + sqrt(input, epsilon));
                }
            }
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
