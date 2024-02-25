Problem Link: https://leetcode.com/problems/greatest-common-divisor-traversal/description/?envType=daily-question&envId=2024-02-25

class GCDTraversal {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        DSU dsu = new DSU(n);
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int factor : primeFactors(nums[i])) {
                if (indexMap.containsKey(factor)) {
                    dsu.union(i, indexMap.get(factor));
                }
                indexMap.put(factor, i);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (!dsu.isConnected(i, i + 1)) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> primeFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
        if (num > 1) {
            factors.add(num);
        }
        return factors;
    }
}

class DSU {
    int[] parent;

    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
