Problem Link: https://leetcode.com/problems/assign-cookies/description/?envType=daily-question&envId=2024-01-01

class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) ++child;
            ++cookie;
        }
        return child;
    }
}
