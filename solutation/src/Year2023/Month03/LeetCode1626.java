package Year2023.Month03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/best-team-with-no-conflicts/solutions/
 *
 * @author xuchenglong
 */
public class LeetCode1626 {

    public static void main(String[] args) {
        System.out.println(34 == bestTeamScore(new int[]{1, 3, 5, 10, 15}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(16 == bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1}));
        System.out.println(6 == bestTeamScore(new int[]{1, 2, 3, 5}, new int[]{8, 9, 10, 1}));
        System.out.println(5431066 == bestTeamScore(new int[]{319776, 611683, 835240, 602298, 430007, 574, 142444, 858606, 734364, 896074}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(27 == bestTeamScore(new int[]{9, 2, 8, 8, 2}, new int[]{4, 1, 3, 3, 5}));
    }

    public static int bestTeamScore(int[] scores, int[] ages) {
        int[][] peoples = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            peoples[i] = new int[]{ages[i], scores[i]};
        }
        List<int[]> sortedPeoples = Arrays.stream(peoples).sorted((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }).collect(Collectors.toList());
        int[][] teamScores = new int[scores.length + 1][2];
        teamScores[0] = new int[]{-1, 0};
        for (int i = 0; i < sortedPeoples.size(); i++) {
            int[] currentPeople = sortedPeoples.get(i);
            int maxScore = 0;
            for (int j = i; j >= 0; j--) {
                int[] preTeamScore = teamScores[j];
                if (currentPeople[1] >= preTeamScore[0]) {
                    if (maxScore <= currentPeople[1] + preTeamScore[1]) {
                        teamScores[i + 1] = new int[]{currentPeople[1], currentPeople[1] + preTeamScore[1]};
                        maxScore = currentPeople[1] + preTeamScore[1];
                    }
                }
            }
        }
        int maxScore = 0;
        for (int[] teamScore : teamScores) {
            maxScore = Math.max(teamScore[1], maxScore);
        }
        return maxScore;
    }

}
