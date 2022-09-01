import components.set.Set;
import components.set.Set1L;

/**
 * Layered implementations of secondary methods {@code add} and {@code remove}
 * for {@code Set}.
 *
 * @param <T>
 *            type of {@code Set} elements
 */
public final class SetSecondary1L<T> extends Set1L<T> {

    /**
     * No-argument constructor.
     */
    public SetSecondary1L() {
        super();
    }

    @Override
    public Set<T> remove(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        Set<T> temp = s.newInstance();

        for (T x : s) {
            if (this.contains(x)) {
                temp.add(this.remove(x));
            }
        }
        return temp;
    }

    @Override
    public void add(Set<T> s) {
        assert s != null : "Violation of: s is not null";
        assert s != this : "Violation of: s is not this";

        int i = 0;
        while (i < s.size()) {
            T val = s.removeAny();

            if (!this.contains(val)) {
                this.add(val);
            } else {
                s.add(val);
            }
            i++;
        }
    }

}