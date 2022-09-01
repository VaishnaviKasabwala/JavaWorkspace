import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program accepts a file and generates a glossary in HTML terms.
 *
 * @ Vaishnavi Kasabwala
 *
 */

public final class Glossary {

    /**
     * Compare {@code String}s in lexicographic order.
     */
    private static class StringLT implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Glossary() {
    }

    /**
     * Reads the file and generates two Queues, one with words and then one with
     * both words and definition.
     *
     * @param file
     *            the input file from user
     * @param glossary
     *            the generated list of terms
     * @param terms
     *            the individual words given by the file
     * @updates glossary, keys
     * @requires <pre>
     * file != empty
     * </pre>
     * @ensures <pre>
     * glossary contains list of words and their definitions.
     * terms contains list of words.
     * </pre>
     */
    public static void reader(SimpleReader out,
            Queue<Map<String, String>> glossary, Queue<String> terms) {
        assert glossary != null : "Violation of: glossary is not null";
        assert terms != null : "Violation of: terms is not null";
        assert out != null : "Violation of: file is not null";

        while (!out.atEOS()) {
            Map<String, String> line = new Map1L<>();

            // intake for the word
            String word = "";
            if (!out.atEOS()) {
                word = out.nextLine();
            }

            //intake for the definition of the word
            String definition = "";
            if (!out.atEOS()) {
                definition = out.nextLine();
            }

            // if empty, moves onto text word
            if (!word.isEmpty() && !definition.isEmpty()) {
                terms.enqueue(word);
            }

            //forms definition
            String temp = "";
            if (!out.atEOS()) {
                temp = out.nextLine();
            }
            while (!temp.isEmpty()) {
                definition = definition + " " + temp;
                if (!out.atEOS()) {
                    temp = out.nextLine();
                } else {
                    temp = "";
                }
            }

            if (!word.isEmpty() && !definition.isEmpty()) {
                // adds every word and definition to the map
                line.add(word, definition);

                // adds map to the glossary
                glossary.enqueue(line);
            }
        }
    }

    /**
     * Sorts the words in the glossary into lexicographical order.
     *
     * @param glossary
     *            the generated list of terms
     * @param terms
     *            the individual words given by the file
     * @updates glossary
     * @requires <pre>
     * terms = first String in each Map in glossary
     * </pre>
     * @ensures <pre>
     * glossary contains list of words and their definitions in lexicographical
     *       order
     * terms contains list of words in lexicographical order
     * </pre>
     */
    public static void sort(Queue<Map<String, String>> glossary,
            Queue<String> terms) {
        assert glossary != null : "Violation of: glossary is not null";
        assert terms != null : "Violation of: keys is not null";

        Queue<Map<String, String>> temp = new Queue1L<>();
        temp.transferFrom(glossary);

        while (temp.length() != 0) {
            String word = terms.dequeue();

            for (int i = 0; i < temp.length(); i++) {
                Map<String, String> term = temp.dequeue();

                if (term.hasKey(word)) {
                    glossary.enqueue(term);
                } else {
                    temp.enqueue(term);
                }
            }
            terms.enqueue(word);
        }
    }

    /**
     * Generates the main index page, listing words in lexicographical order
     * with a link to each word's page.
     *
     * @param terms
     *            the individual words given by the file
     * @param path
     *            the file the HTML files will be saved to
     * @requires <pre>
     * terms = first String in each Map in glossary
     * </pre>
     * @ensures <pre>
     * generates index with a lexicographical list of words with
     * links to their own pages with a word and definition
     * </pre>
     */
    public static void generateIndex(Queue<String> terms, String path) {
        assert terms != null : "Violation of: terms is not null";

        SimpleWriter out = new SimpleWriter1L(path + "/index.html");

        // header
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Glossary</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Glossary</h2>");
        out.println("<hr>");
        out.println("<h3>Index</h3>");
        out.println("<ul>");

        for (int i = 0; i < terms.length(); i++) {
            out.println("<li>");
            String name = terms.front();

            out.println("<a href=\"" + name + ".html\">" + name + "</a>");
            out.println("</li>");

            terms.rotate(1);
        }

        //footer
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    /**
     * Outputs the "opening" tags in the generated HTML file. These are the
     * expected elements generated by this method:
     *
     * @param terms
     *            the individual words given by the file
     * @param out
     *            the output stream
     * @updates out.content
     * @requires out.is_open terms != empty
     * @ensures out.content = #out.content * [the HTML "opening" tags]
     */
    private static void outputHeader(Queue<String> terms, SimpleWriter out) {
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";
        assert terms != null : "Violation of: terms is not null";

        String name = terms.front();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + name + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>");
        out.println("<b>");
        out.println("<i>");
        out.println("<font color=\"red\">" + name + "</font>");
        out.println("</i>");
        out.println("</b>");
        out.println("</h2>");
        out.println("<blockquote>");
    }

    /**
     * Outputs the "closing" tags in the generated HTML file. These are the
     * expected elements generated by this method:
     *
     * @param out
     *            the output stream
     * @updates out.contents
     * @requires out.is_open
     * @ensures out.content = #out.content * [the HTML "closing" tags]
     */
    private static void outputFooter(SimpleWriter out) {
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";

        out.println("</blockquote>");
        out.println("<hr>");
        out.println("<p>");
        out.println("Return to ");
        out.println("<a href=\"index.html\">index</a>");
        out.println(".");
        out.println("</p>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Generates individual HTML pages containing a word, its definition, and a
     * link back to the index.
     *
     * @param glossary
     *            the generated list of terms
     * @param terms
     *            the individual words given by the file
     * @param path
     *            the file the HTML files will be saved to
     * @requires <pre>
     * terms != empty
     * </pre>
     * @ensures <pre>
     * pages for different words will be formed containing the word, definition,
     * and a link to the index page.
     * </pre>
     */
    public static void generatePages(Queue<Map<String, String>> glossary,
            Queue<String> terms, String path) {
        assert glossary != null : "Violation of: glossary is not null";
        assert terms != null : "Violation of: terms is not null";

        for (int i = 0; i < terms.length(); i++) {
            String name = terms.front();
            SimpleWriter file = new SimpleWriter1L(path + "/" + name + ".html");

            outputHeader(terms, file);
            printDefinition(name, file, glossary, terms);
            outputFooter(file);

            terms.rotate(1);
            glossary.rotate(1);

            file.close();
        }
    }

    /**
     * Generates definitions for each word.
     *
     * @param name
     *            name of the word
     * @param out
     *            the output stream
     * @param glossary
     *            the generated list of terms
     * @param terms
     *            the individual words given by the file
     * @requires <pre>
     * terms != empty, glossary != empty, name != empty, file is valid
     * </pre>
     * @ensures <pre>
     * new definition is formed with links to other words in it
     * </pre>
     */
    public static void printDefinition(String name, SimpleWriter out,
            Queue<Map<String, String>> glossary, Queue<String> terms) {
        assert glossary != null : "Violation of: glossary is not null";
        assert terms != null : "Violation of: terms is not null";
        assert name != null : "Violation of: name is not null";
        assert out != null : "Violation of: file is not null";

        String definition = glossary.front().value(name);
        String concat = "";

        for (int i = 0; i < terms.length(); i++) {
            String word = terms.front();
            concat = isTerm(word, definition);

            if (!concat.isEmpty()) {
                definition = concat;
            }
            terms.rotate(1);
        }

        out.println(definition);
    }

    /**
     * Alters definition to link to words found in definition.
     *
     * @param term
     *            name of the word tested against each definition
     * @param definition
     *            definition of a particular unique word
     * @requires <pre>
     * term != empty, definition != valid
     * </pre>
     * @ensures <pre>
     * new definition is formed with links to other words in it
     * </pre>
     */
    public static String isTerm(String term, String definition) {
        assert term != null : "Violation of: term is not null";
        assert definition != null : "Violation of: definition is not null";

        String concat = "";

        for (int i = 0; i <= definition.length() - term.length(); i++) {
            String temp = definition.substring(i, term.length() + i);

            if (temp.equals(term)) {
                String first = definition.substring(0, i - 1) + " <a href=\""
                        + term + ".html\">" + term + "</a>";
                String last = definition.substring(i + term.length(),
                        definition.length());

                concat = first + last;
            }
        }
        return concat;
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

        // output to folder in project folder
        out.print(
                "Please a folder for the files to be stored (ex. data, doc, lib, etc.): ");
        String path = in.nextLine();

        out.print("Enter a file to add to the glossary: ");
        SimpleReader file = new SimpleReader1L(in.nextLine());

        Queue<Map<String, String>> glossary = new Queue1L<>();
        Queue<String> terms = new Queue1L<>();

        reader(file, glossary, terms);
        Comparator<String> comp = new StringLT();
        terms.sort(comp);
        sort(glossary, terms);
        generateIndex(terms, path);
        generatePages(glossary, terms, path);

        file.close();
        in.close();
        out.close();
    }

}