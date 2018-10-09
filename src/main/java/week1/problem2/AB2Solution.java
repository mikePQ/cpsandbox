package week1.ab2;

import mooc.EdxIO;

public class AB2Solution {
    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            long a = io.nextLong();
            long b = io.nextLong();

            io.println(a + b * b);
        }
    }
}
