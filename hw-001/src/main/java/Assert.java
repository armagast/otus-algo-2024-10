public class Assert {
    public static void isTrue(boolean assertion, String message) {
        if (!assertion) {
            throw new IllegalArgumentException(message);
        }
    }
}
