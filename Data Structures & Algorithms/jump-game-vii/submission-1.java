class Solution {

    public boolean canReach(String s,
                            int minJump,
                            int maxJump) {

        int n = s.length();

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int farthest = 0;

        while (!q.isEmpty()) {

            int curr = q.poll();

            // reached end
            if (curr == n - 1) {
                return true;
            }

            int start = Math.max(curr + minJump,
                                 farthest + 1);

            int end = Math.min(curr + maxJump,
                               n - 1);

            for (int next = start;
                 next <= end;
                 next++) {

                if (s.charAt(next) == '0' &&
                    !visited[next]) {

                    visited[next] = true;
                    q.offer(next);
                }
            }

            farthest = end;
        }

        return false;
    }
}