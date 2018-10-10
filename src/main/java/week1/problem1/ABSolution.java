package week1.problem1;

import mooc.EdxIO;

public class ABSolution {

    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            int a = io.nextInt();
            int b = io.nextInt();
            io.println(a + b);
        }
    }
}
