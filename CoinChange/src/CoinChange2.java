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
public final class CoinChange2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange2() {
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
         * Put your main program code here
         */
        int cents;
        int[] coinCounts = new int[6];
        int[] a = { 100, 50, 25, 10, 5, 1 };

        out.print("Please enter the number of cents: ");
        cents = Integer.parseInt(in.nextLine());

        coinCounts[0] = (cents - (cents % a[0])) / a[0];
        cents = cents % a[0];

        coinCounts[1] = (cents - (cents % a[1])) / a[1];
        cents = cents % a[1];

        coinCounts[2] = (cents - (cents % a[2])) / a[2];
        cents = cents % a[2];

        coinCounts[3] = (cents - (cents % a[3])) / a[3];
        cents = cents % a[3];

        coinCounts[4] = (cents - (cents % a[4])) / a[4];
        cents = cents % a[4];

        coinCounts[5] = (cents - (cents % a[5])) / a[5];
        cents = cents % a[5];

        out.println("Change in:");
        out.println("Dollars: " + coinCounts[0]);
        out.println("Half Dollars: " + coinCounts[1]);
        out.println("Quarters: " + coinCounts[2]);
        out.println("Dimes: " + coinCounts[3]);
        out.println("Nickles: " + coinCounts[4]);
        out.println("Pennies: " + coinCounts[5]);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
