package week1.threebonacci;

import mooc.EdxIO;

import java.util.HashMap;
import java.util.Map;

public class Threebonacci {
    private final int a0;
    private final int a1;
    private final int a2;

    private final Map<Integer, Long> values = new HashMap<>();

    Threebonacci(int a0, int a1, int a2) {
        this.a0 = a0;
        this.a1 = a1;
        this.a2 = a2;
    }

    long value(int n) {
        Long value = values.get(n);
        if (value == null) {
            value = compute(n);
            values.put(n, value);
        }
        return value;
    }

    private long compute(int n) {
        switch (n) {
            case 0:
                return a0;
            case 1:
                return a1;
            case 2:
                return a2;
            case 3:
                return a2 + a1 - a0;
            default:
                return 2 * value(n - 2) - value(n - 4);
        }
    }

    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            int a0 = io.nextInt();
            int a1 = io.nextInt();
            int a2 = io.nextInt();

            Threebonacci threebonacci = new Threebonacci(a0, a1, a2);
            int n = io.nextInt();
            io.println(threebonacci.value(n));
        }
    }
}
