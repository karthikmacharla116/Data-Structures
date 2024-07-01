Problem Link: https://leetcode.com/problems/three-consecutive-odds/description/?envType=daily-question&envId=2024-07-01

class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n=arr.length;

        int cnt = 0;

        for(int i=0;i<n;i++) {
            if(arr[i]%2==1) {
                cnt++;
                if(cnt == 3)
                    return true;
            } else {
                cnt = 0;
            }

        }
        return false;
    }
}
