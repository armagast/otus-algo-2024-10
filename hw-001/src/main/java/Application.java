import java.util.function.BiFunction;

public class Application {
    private static final int w = 25;
    private static final int h = 25;
    
    private static final int mx = w - 1;
    private static final int my = h - 1;

    private static final Painter painter = new Painter(w, h);

    private static final BiFunction<Integer, Integer, Boolean> pic01 = (x, y) -> x > y;
    private static final BiFunction<Integer, Integer, Boolean> pic02 = (x, y) -> x == y;
    private static final BiFunction<Integer, Integer, Boolean> pic03 = (x, y) -> x == (my - y);
    private static final BiFunction<Integer, Integer, Boolean> pic04 = (x, y) -> x + y < 30;
    private static final BiFunction<Integer, Integer, Boolean> pic05 = (x, y) -> y == x / 2;
    private static final BiFunction<Integer, Integer, Boolean> pic06 = (x, y) -> x < 10 || y < 10;
    private static final BiFunction<Integer, Integer, Boolean> pic07 = (x, y) -> x > 15 && y > 15;
    private static final BiFunction<Integer, Integer, Boolean> pic08 = (x, y) -> x == 0 || y == 0;
    private static final BiFunction<Integer, Integer, Boolean> pic09 = (x, y) -> (y - 10) > x || x > (y + 10);
    private static final BiFunction<Integer, Integer, Boolean> pic10 = (x, y) -> y < x && x <= y * 2 + 1;
    private static final BiFunction<Integer, Integer, Boolean> pic11 = (x, y) -> x == 1 || y == 1 || x == (w - 2) || y == (h - 2);
    private static final BiFunction<Integer, Integer, Boolean> pic12 = (x, y) -> x * x + y * y <= 400;
    private static final BiFunction<Integer, Integer, Boolean> pic13 = (x, y) -> (y - 5) < (mx - x)  && (mx - x) < (y + 5);
//    private static final BiFunction<Integer, Integer, Boolean> pic14 = ??? Окружность и гипербола не подходят, хотя гипербола очень близка!
    private static final BiFunction<Integer, Integer, Boolean> pic15 = (x, y) -> Math.abs((x - y) % 21) >= 10;
    private static final BiFunction<Integer, Integer, Boolean> pic16 = (x, y) -> x < y + 10 && x > y - 10 && x > (my - 10 - y) && x < (my + 10 - y);
//    private static final BiFunction<Integer, Integer, Boolean> pic17 = (x, y) -> y >= Math.sin((x.floatValue() / 10 * Math.PI)) * 7.5 + 16; // Нужно играть с константами, кривая повторяет рисунок неточно!
    private static final BiFunction<Integer, Integer, Boolean> pic18 = (x, y) -> (x < 2 || y < 2) && !(x == 0 && y == 0);
    private static final BiFunction<Integer, Integer, Boolean> pic19 = (x, y) -> x == ((h - 1) - y);
    private static final BiFunction<Integer, Integer, Boolean> pic20 = (x, y) -> (x + y) % 2 == 0;
    private static final BiFunction<Integer, Integer, Boolean> pic21 = (x, y) -> x == 0 || x % (y + 1) == 0;
    private static final BiFunction<Integer, Integer, Boolean> pic22 = (x, y) -> (x + y) % 3 == 0;
    private static final BiFunction<Integer, Integer, Boolean> pic23 = (x, y) -> x % 2 == 0 && y % 3 == 0;
    private static final BiFunction<Integer, Integer, Boolean> pic24 = (x, y) -> x == y || x == (my - y);
    private static final BiFunction<Integer, Integer, Boolean> pic25 = (x, y) -> x % 6 == 0 || y % 6 == 0;

    public static void main(String[] args) {
        painter.fillPredicate(pic25, '#', '.');
        painter.prettyPrint();
    }
}
