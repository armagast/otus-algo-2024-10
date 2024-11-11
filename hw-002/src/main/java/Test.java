import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.function.Function;

public class Test {
    private final Function<String[], String> run;

    public Test(final Function<String[], String> run) {
        Assert.notNull(run, "{run} must not be null");

        this.run = run;
    }

    public void run() throws Exception {
        int index = 0;

        while (true) {
            final Path pathIn = Paths.get(String.format("./hw-002/test/test.%d.in", index));
            final Path pathOut = Paths.get(String.format("./hw-002/test/test.%d.out", index));

            if (!Files.exists(pathIn) || !Files.exists(pathOut)) {
                break;
            }

            final String[] input = Files.readAllLines(pathIn).toArray(new String[0]);
            final String[] output = Files.readAllLines(pathOut).toArray(new String[0]);

            final String exp = output[0];
            final String act = run.apply(input);

            if (Objects.equals(act, exp)) {
                System.out.println(String.format("Тест %2d. OK: %s", index, act));
            } else {
                System.out.println(String.format("Тест %2d. Ошибка: %s, ожидалось %s", index, act, exp));
            }

            index++;
        }
    }
}
