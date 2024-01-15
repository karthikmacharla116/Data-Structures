Problem Link: https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/?envType=daily-question&envId=2024-01-15

class PlayerLossAndWins {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = 100_001; //considering the constraints
        int[] losses = new int[n];
        boolean[] played = new boolean[n];

        for (int[] match : matches) {
            int loser = match[1];
            losses[loser]++;
            played[match[0]] = true;
            played[loser] = true;
        }

        List<Integer> notLost = new ArrayList<>();
        List<Integer> lostOnce = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (played[i]) {
                if (losses[i] == 0) {
                    notLost.add(i);
                } else if (losses[i] == 1) {
                    lostOnce.add(i);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(notLost);
        result.add(lostOnce);

        return result;
    }
}
