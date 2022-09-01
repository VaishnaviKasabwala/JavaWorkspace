import components.set.Set;

/**
 *
 * @author Vaishnavi Kasabwala
 *
 */
public final class HW21 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HW21() {
    }

    /**
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     *
     * @param str
     *            the given {@code String}
     * @param charSet
     *            the {@code Set} to be replaced
     * @replaces charSet
     * @ensures charSet = entries(str)
     */
    private static void generateElements(String str, Set<Character> charSet) {
        int count = 0;
        char var = 'a';
        charSet.clear();

        while (count < str.length()) {
            if (!charSet.contains(str.charAt(count))) {
                var = str.charAt(count);
                charSet.add(var);
            }
            count++;
        }
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     * </pre>
     */
    private static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {

        String word = "";
        char A = text.charAt(position);
        int count = position;

        if (separators.contains(A)) {
            while (separators.contains(A)) {
                word += A;
                count++;
                A = text.charAt(count);
            }

        } else {
            while (!separators.contains(A)) {
                word += A;
                count++;
                A = text.charAt(count);
            }

        }

        return word;
    }
}