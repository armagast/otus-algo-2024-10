import java.util.Objects;

public class Assert {
    public static void isTrue(boolean assertion, String message) {
        if (!assertion) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(Object object, String message) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void state(boolean assertion, String message) {
        if (!assertion) {
            throw new IllegalStateException(message);
        }
    }
}
