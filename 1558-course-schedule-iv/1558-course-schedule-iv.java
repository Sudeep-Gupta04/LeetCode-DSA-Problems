public class Solution {
    private void preprocess(
        int numCourses,
        int[][] prerequisites,
        Map<Integer, List<Integer>> adjList,
        boolean[][] isPrerequisite
    ) {
        for (int i = 0; i < numCourses; i++) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int adj : adjList.getOrDefault(node, new ArrayList<>())) {
                    if (!isPrerequisite[i][adj]) {
                        isPrerequisite[i][adj] = true;
                        q.offer(adj);
                    }
                }
            }
        }
    }

    public List<Boolean> checkIfPrerequisite(
        int numCourses,
        int[][] prerequisites,
        int[][] queries
    ) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : prerequisites) {
            adjList
                .computeIfAbsent(edge[0], k -> new ArrayList<>())
                .add(edge[1]);
        }
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];
        preprocess(numCourses, prerequisites, adjList, isPrerequisite);

        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(isPrerequisite[query[0]][query[1]]);
        }
        return answer;
    }
}