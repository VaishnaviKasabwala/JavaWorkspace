import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;

/**
 * Program with implementation of {@code NaturalNumber} secondary operation
 * {@code root} implemented as static method.
 *
 * @author Vaishnavi Kasabwala
 *
 */
public final class HW14 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HW14() {
    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @clears n
     * @ensures productOfDigits1 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits1(NaturalNumber n) {
        int d1 = n.divideBy10();
        NaturalNumber product = new NaturalNumber2(d1);

        if (!n.isZero()) {
            NaturalNumber productP1 = productOfDigits1(n);
            product.multiply(productP1);
        }

        return product;
    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @ensures productOfDigits2 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits2(NaturalNumber n) {

        int d1 = n.divideBy10();
        NaturalNumber product = new NaturalNumber2(d1);

        if (!n.isZero()) {
            NaturalNumber productP1 = productOfDigits1(n);
            product.multiply(productP1);
        }

        n.multiplyBy10(d1);

        return product;
    }

    /**
     * Reports the value of {@code n} as an {@code int}, when {@code n} is small
     * enough.
     *
     * @param n
     *            the given {@code NaturalNumber}
     * @return the value
     * @requires n <= Integer.MAX_VALUE
     * @ensures toInt = n
     */
    private static int toInt(NaturalNumber n) {

        int d1 = n.divideBy10();

        int r = d1;
        if (!n.isZero()) {
            r = toInt(n) * 10 + r;
        }
        return r;
    }

    /**
     * Reports whether the given tag appears in the given {@code XMLTree}.
     *
     * @param xml
     *            the {@code XMLTree}
     * @param tag
     *            the tag name
     * @return true if the given tag appears in the given {@code XMLTree}, false
     *         otherwise
     * @ensures <pre>
     * findTag =
     *    [true if the given tag appears in the given {@code XMLTree}, false otherwise]
     * </pre>
     */
    private static boolean findTag(XMLTree xml, String tag) {
        boolean tagFound = false;

        if (xml.isTag()) {
            if (xml.label().equals(tag)) {
                tagFound = true;
            } else {
                int i = 0;
                while (i < xml.numberOfChildren() && !tagFound) {
                    tagFound = findTag(xml.child(i), tag);
                    i++;
                }
            }
        }
        return tagFound;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        NaturalNumber n = new NaturalNumber2(213);

        out.close();
    }

}