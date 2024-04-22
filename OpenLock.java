Problem Link: https://leetcode.com/problems/open-the-lock/description/?envType=daily-question&envId=2024-04-22

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        if (deadendSet.contains("0000")) {
            return -1; // The initial state is a deadend
        }

        queue.offer("0000");
        visited.add("0000");
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return steps; // Found the target state
                }

                // Generate next states by rotating each wheel
                for (int j = 0; j < 4; j++) {
                    for (int d = -1; d <= 1; d += 2) {
                        char[] next = current.toCharArray();
                        int digit = (next[j] - '0' + d + 10) % 10;
                        next[j] = (char) (digit + '0');
                        String nextState = new String(next);

                        if (!deadendSet.contains(nextState) && !visited.contains(nextState)) {
                            queue.offer(nextState);
                            visited.add(nextState);
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
