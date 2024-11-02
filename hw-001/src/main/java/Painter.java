import java.util.function.BiFunction;

public class Painter {
    private final int w;
    private final int h;
    private final char[][] pixels;

    public Painter(final int w, final int h) {
        Assert.isTrue(w > 0, "{w} must be greater than 0");
        Assert.isTrue(h > 0, "{h} must be greater than 0");

        this.w = w;
        this.h = h;
        this.pixels = new char[w][h];
        clear();
    }

    public void clear() {
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                pixels[x][y] = ' ';
            }
        }
    }

    public void pointSet(int x, int y, char c) {
        Assert.isTrue(0 <= x && x < w, "{x} is out of bounds");
        Assert.isTrue(0 <= y && y < h, "{y} is out of bounds");
        Assert.isTrue(0x20 <= c && c <= 0xff, "{c} is out of bounds");

        pixels[x][y] = c;
    }

    public void fillPredicate(BiFunction<Integer, Integer, Boolean> predicate, char ct, char cf) {
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                pointSet(x, y, predicate.apply(x, y) ? ct : cf);
            }
        }
    }

    public void prettyPrint() {
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                System.out.print(pixels[x][y] + " ");
            }

            System.out.println();
        }
    }
}
