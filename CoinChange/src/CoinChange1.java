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
public final class CoinChange1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange1() {
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
        double cents;

        out.print("Please enter the number of cents: ");
        cents = in.nextDouble();

        double dollar = (cents - (cents % 100)) / 100;
        cents = cents % 100;

        double halfDollar = (cents - (cents % 50)) / 50;
        cents = cents % 50;

        double quarter = (cents - (cents % 25)) / 25;
        cents = cents % 25;

        double dime = (cents - (cents % 10)) / 10;
        cents = cents % 10;

        double nickle = (cents - (cents % 5)) / 5;
        cents = cents % 5;

        double penny = (cents - (cents % 1)) / 1;
        cents = cents % 1;

        out.println("Change in:");
        out.println("Dollars: " + dollar);
        out.println("Half Dollars: " + halfDollar);
        out.println("Quarters: " + quarter);
        out.println("Dimes: " + dime);
        out.println("Nickles: " + nickle);
        out.println("Pennies: " + penny);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
