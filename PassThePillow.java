Problem Link: https://leetcode.com/problems/pass-the-pillow/description/?envType=daily-question&envId=2024-07-06

class PassThePillow {

    public int passThePillow(int n, int time) {
        int fullRounds = time / (n - 1);

        int extraTime = time % (n - 1);

        // Determine the position of the person holding the pillow
        // If fullRounds is even, the pillow is moving forward.
        // If fullRounds is odd, the pillow is moving backward.
        if (fullRounds % 2 == 0) {
            return extraTime + 1; // Position when moving forward
        } else {
            return n - extraTime; // Position when moving backward
        }
    }
}
