package week1.problem5;

import mooc.EdxIO;

public class CreateATeam {

    static double computeMaxEfficiency(int[] andrewSkills, int[] peterSkills, int[] paulSkills) {
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < andrewSkills.length; i++) {
            for (int j = 0; j < peterSkills.length; j++) {
                for (int k = 0; k < paulSkills.length; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    double val = Math.sqrt(
                            andrewSkills[i] * andrewSkills[i] + peterSkills[j] * peterSkills[j] + paulSkills[k] * paulSkills[k]
                    );
                    max = Math.max(val, max);
                }
            }
        }

        return max;
    }

    private static int[][] readInput(EdxIO io, int x, int y) {
        int[][] result = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                result[i][j] = io.nextInt();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            int[][] input = readInput(io, 3, 3);
            double result = computeMaxEfficiency(input[0], input[1], input[2]);
            io.println(result);
        }
    }

}
