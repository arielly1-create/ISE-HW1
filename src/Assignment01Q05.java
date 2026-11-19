public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) return 0; // If the start and end are the same, no steps are needed

        int n = m.length;
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        int[] queue = new int[n];

        int head = 0;
        int tail = enqueue(queue, visited, distance, i, 0, 0);

        while (head < tail) {
            int curr = queue[head++];
            int newTail = expandNeighbors(m, queue, visited, distance, curr, j, tail);
            
            if (newTail == -1) {
                return distance[curr] + 1;
            }
            tail = newTail;
        }

        return -1;
    }

    private static int expandNeighbors(int[][] m, int[] queue, boolean[] visited,
                                       int[] distance, int curr, int target, int tail) {
        int nextDist = distance[curr] + 1;

        for (int next = 0; next < m.length; next++) {
            if (isUnvisitedNeighbor(m, visited, curr, next)) {
                if (next == target) {
                    return -1;
                }
                tail = enqueue(queue, visited, distance, next, nextDist, tail);
            }
        }

        return tail;
    }

    private static boolean isUnvisitedNeighbor(int[][] m, boolean[] visited, int from, int to) {
        return m[from][to] == 1 && !visited[to];
    }

    private static int enqueue(int[] queue, boolean[] visited, int[] distance,
                               int vertex, int dist, int tail) {
        visited[vertex] = true;
        distance[vertex] = dist;
        queue[tail] = vertex;
        return tail + 1;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}