public class Application {
    public static void main(final String[] args) throws Exception {
        final Solver solver = new Solver();
        final Test test = new Test(solver::run);

        test.run();
    }
}
