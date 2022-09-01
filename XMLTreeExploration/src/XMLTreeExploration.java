import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Output of XML Tree.
 *
 * @author Vaishnavi Kasabwala
 *
 */
public final class XMLTreeExploration {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeExploration() {
    }

    /**
     * Output information about the middle child of the given {@code XMLTree}.
     *
     * @param xt
     *            the {@code XMLTree} whose middle child is to be printed
     * @param out
     *            the output stream
     * @updates out.content
     * @requires <pre>
     * [the label of the root of xt is a tag]  and
     * [xt has at least one child]  and  out.is_open
     * </pre>
     * @ensures <pre>
     * out.content = #out.content * [the label of the middle child
     *  of xt, whether the root of the middle child is a tag or text,
     *  and if it is a tag, the number of children of the middle child]
     * </pre>
     */
    private static void printMiddleNode(XMLTree xt, SimpleWriter out) {
        int num = xt.numberOfChildren();
        int middle = num / 2;
        XMLTree middleChild = xt.child(middle);

        out.println("The label of the middle child is " + middleChild.label()
                + ".");

        if (middleChild.isTag()) {
            out.println("The middle child's label is a tag.");
            out.print("Middle child number of children: "
                    + middleChild.numberOfChildren());
        } else {
            out.println("The middle child's label is text.");
        }
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

        XMLTree xml = new XMLTree1(
                "http://web.cse.ohio-state.edu/software/2221/web-sw1/"
                        + "extras/instructions/xmltree-model/columbus-weather.xml");
        // out.println(xml.toString());
        xml.display();

        // The Root
        if (xml.isTag()) {
            out.println("Root of XMLTree xml is a Tag.");
        } else {
            out.println("Root of XMLTree xml is not a Tag.");
        }
        out.println("The label of the root is " + xml.label() + " .");

        //The Children
        XMLTree results = xml.child(0);
        XMLTree channel = results.child(0);
        out.println("XMLTree channel has " + channel.numberOfChildren()
                + " children.");

        XMLTree title = channel.child(1);
        XMLTree titleText = title.child(0);

        out.println(titleText.label());

        //The Attributes
        XMLTree astronomy = channel.child(10);
        if (astronomy.hasAttribute("sunset")) {
            out.println(
                    "The root of the astronomy XMLTree has an attribute named \"sunset\".");
        } else {
            out.println(
                    "The root of the astronomy XMLTree does not have an attribute named \"sunset\".");
        }

        if (astronomy.hasAttribute("midday")) {
            out.println(
                    "The root of the astronomy XMLTree has an attribute named \"midday\".");
        } else {
            out.println(
                    "The root of the astronomy XMLTree does not have an attribute named \"midday\".");
        }

        out.println("The value of attribute sunrise is "
                + astronomy.attributeValue("sunrise") + " .");
        out.println("The value of attribute sunset is "
                + astronomy.attributeValue("sunset") + " .");

        //One More Challenge
        printMiddleNode(channel, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
