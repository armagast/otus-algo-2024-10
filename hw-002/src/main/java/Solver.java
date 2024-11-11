import java.util.HashMap;
import java.util.Map;

public class Solver {
    public String run(String[] input) {
        final int n = Integer.parseInt(input[0]);
        return String.valueOf(tickets(n));
    }

    private long tickets(int n) {
        long count = 0;

        for (int i = 0; i <= n * 9; i++) {
            final long s = sums(new HashMap<>(), n, i);
            count += s * s;
        }

        return count;
    }

    private long sums(final Map<Integer, Map<Integer, Long>> memo, final int n, final int s) {
        if (!memo.containsKey(n)) {
            memo.put(n, new HashMap<>());
        }

        if (!memo.get(n).containsKey(s)) {
            long count = 0;

            if (n == 1) {
                count = s <= 9 ? 1 : 0;
            } else {
                for (int i = 0; i <= Math.min(9, s); i++) {
                    count += sums(memo, n - 1, s - i);
                }
            }

            memo.get(n).put(s, count);
        }

        return memo.get(n).get(s);
    }
}
