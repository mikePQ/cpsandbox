package week1.problem6;

import mooc.EdxIO;

public class Triangle {
    static double computeAverageDistance(int a, int b, int c) {
        double ax = a / 2.0;
        double ay = 0.0;

        double cosAB = (a * a + b * b - c * c) / (2.0 * a * b);
        double sinAB = Math.sqrt(1 - cosAB * cosAB);

        double bx = b * cosAB / 2.0;
        double by = b * sinAB / 2.0;

        double cosAC = (a * a + c * c - b * b) / (2.0 * a * c);
        double sinAC = Math.sqrt(1 - cosAC * cosAC);

        double cx = a - c * cosAC / 2.0;
        double cy = c * sinAC / 2.0;

        return (distance(ax, ay, bx, by) + distance(ax, ay, cx, cy) + distance(bx, by, cx, cy)) / 3.0;
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            int a = io.nextInt();
            int b = io.nextInt();
            int c = io.nextInt();

            double avgDistance = computeAverageDistance(a, b, c);
            io.println(avgDistance);
        }
    }
}
