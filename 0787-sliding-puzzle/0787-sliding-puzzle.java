class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        HashSet<String> hs = new HashSet<>();
        HashMap<Integer, int[]> hm = new HashMap<>();

        hm.put(0, new int[]{1, 3});
        hm.put(1, new int[]{0, 2, 4});
        hm.put(2, new int[]{1, 5});
        hm.put(3, new int[]{0, 4});
        hm.put(4, new int[]{3, 5, 1});
        hm.put(5, new int[]{4, 2});

        Queue<String> q = new ArrayDeque<>();
        String st = convertToString(board);

        hs.add(st);
        q.add(st);

        int lv = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.remove();

                if (s.equals(target)) return lv;

                int idx = s.indexOf("0");
                int[] arr = hm.get(idx);

                for (int j = 0; j < arr.length; j++) {
                    String news = swapZero(s, arr[j]);
                    if (!hs.contains(news)) {
                        q.add(news);
                        hs.add(news);
                    }
                }
            }
            lv++;
        }
        return -1;
    }

    public static String swapZero(String s, int index) {
        char[] arr = s.toCharArray();
        int zeroIndex = s.indexOf("0");
        
        if (zeroIndex != -1 && index >= 0 && index < s.length()) {
            char temp = arr[zeroIndex];
            arr[zeroIndex] = arr[index];
            arr[index] = temp;
        }

        return new String(arr);
    }

    public static String convertToString(int[][] array) {
        StringBuilder result = new StringBuilder();

        for (int[] row : array) {
            for (int element : row) {
                result.append(element);
            }
        }

        return result.toString();
    }
}
