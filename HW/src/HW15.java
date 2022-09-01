import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.queue.Queue;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 *
 * @author Vaishnavi Kasabwala
 *
 */
public final class HW15 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private HW15() {
    }

    /**
     * Reports the smallest integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return the smallest integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * min is in entries(q) and
     * for all x: integer
     *  where (x is in entries(q))
     *   (min <= x)
     * </pre>
     */
    private static int min(Queue<Integer> q) {

        int n = q.length();
        int min = q.dequeue();

        for (int i = 1; i < n; i++) {
            int x = q.dequeue();

            if (x < min) {
                min = x;
            }

            q.enqueue(x);
        }
        return min;
    }

    /**
     * Reports an array of two {@code int}s with the smallest and the largest
     * integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return an array of two {@code int}s with the smallest and the largest
     *         integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * { minAndMax[0], minAndMax[1] } is subset of entries(q) and
     * for all x: integer
     *     where (x in in entries(q))
     *   (minAndMax[0] <= x <= minAndMax[1])
     * </pre>
     */
    private static int[] minAndMax(Queue<Integer> q) {
        int[] arr = new int[2];

        int n = q.length();
        int min = q.dequeue();
        int max = q.dequeue();

        for (int i = 1; i < n; i++) {
            int x = q.dequeue();

            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
            }

            q.enqueue(x);
        }

        arr[0] = min;
        arr[1] = max;

        return arr;
    }

    /**
     * Reports an array of two {@code int}s with the smallest and the largest
     * integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return an array of two {@code int}s with the smallest and the largest
     *         integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * { minAndMax[0], minAndMax[1] } is subset of entries(q) and
     * for all x: integer
     *     where (x in in entries(q))
     *   (minAndMax[0] <= x <= minAndMax[1])
     * </pre>
     */
    private static int[] minAndMax2(Queue<Integer> q) {
        int n = q.length();
        int[] arr = new int[n];
        int big = 0;
        int small = 0;

        int min = arr[0];
        int max = arr[1];

        for (int i = 0; i < n; i += 2) {
            if (arr[i] > arr[i + 1]) {
                big = arr[i];
            } else {
                big = arr[i + 1];
            }

            if (small < min) {
                min = small;
            }
            if (big > max) {
                max = big;
            }
        }
        return new int[] { min, max };
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