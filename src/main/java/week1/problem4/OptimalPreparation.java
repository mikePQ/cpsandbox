package week1.problem4;

import mooc.EdxIO;

public class OptimalPreparation {
    static int computeMaxGain(int[] theoryGains, int[] practiceGains) {
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        int minDiffIndex = -1;
        boolean theoryUsed = false;
        boolean practiceUsed = false;

        for (int i = 0; i < theoryGains.length; i++) {
            int theoryGain = theoryGains[i];
            int practiceGain = practiceGains[i];

            int diff = Math.abs(theoryGain - practiceGain);
            if (diff < minDiff) {
                minDiff = diff;
                minDiffIndex = i;
            }

            if (theoryGain > practiceGain) {
                theoryUsed = true;
                result += theoryGain;
            } else {
                practiceUsed = true;
                result += practiceGain;
            }
        }

        if (practiceUsed && theoryUsed) {
            return result;
        }

        int theoryGain = theoryGains[minDiffIndex];
        int practiceGain = practiceGains[minDiffIndex];

        int greater = Math.max(theoryGain, practiceGain);
        int less = Math.min(theoryGain, practiceGain);
        return result + less - greater;
    }

    private static int[] readArray(int size, EdxIO io) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = io.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            int n = io.nextInt();
            int[] practiceGains = readArray(n, io);
            int[] theoryGains = readArray(n, io);

            int maxGain = computeMaxGain(theoryGains, practiceGains);
            io.println(maxGain);
        }
    }
}
