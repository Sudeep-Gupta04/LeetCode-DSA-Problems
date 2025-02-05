class Solution {
     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord)) return 0;

    // Create a set of words for O(1) lookup
    Set<String> wordSet = new HashSet<>(wordList);
    wordSet.add(beginWord);

    // Build the wildcard map
    HashMap<String, List<String>> wildcardMap = new HashMap<>();
    for (String word : wordSet) {
        for (int i = 0; i < word.length(); i++) {
            String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
            wildcardMap.putIfAbsent(pattern, new ArrayList<>());
            wildcardMap.get(pattern).add(word);
        }
    }

    // BFS setup
    Queue<String> q = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    q.add(beginWord);
    visited.add(beginWord);
    int level = 1; // start from the beginWord

    // BFS to find the shortest transformation sequence
    while (!q.isEmpty()) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            String currentWord = q.poll();
            for (int j = 0; j < currentWord.length(); j++) {
                String pattern = currentWord.substring(0, j) + "*" + currentWord.substring(j + 1);
                if (wildcardMap.containsKey(pattern)) {
                    for (String neighbor : wildcardMap.get(pattern)) {
                        if (neighbor.equals(endWord)) {
                            return level + 1;
                        }
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            q.add(neighbor);
                        }
                    }
                }
            }
        }
        level++;
    }

    return 0;
}

}