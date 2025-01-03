class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        ArrayList<Integer> s = new ArrayList<>();
        ArrayList<Integer> f = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();

        
        for (int i = 0; i < boxGrid.length; i++) {
            int count = 0; 
            f.add(boxGrid[i].length);

            for (int j = boxGrid[0].length - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '#') { 
                    count++;
                } else if (boxGrid[i][j] == '*') { 
                    s.add(j); 
                    f.add(j); 
                    c.add(count); 
                    count = 0;
                }

                if (j == 0) {
                    s.add(-1);
                    c.add(count); 
                }
            }

            for (int k = 0; k < c.size(); k++) {
                int start = s.get(k);
                int end = f.get(k);   
                int tc = c.get(k);    

                for (int l = end - 1; l > start; l--) {
                    if (tc > 0) { 
                        boxGrid[i][l] = '#';
                        tc--;
                    } else { 
                        boxGrid[i][l] = '.';
                    }
                }
            }
            s.clear();
            f.clear();
            c.clear();
        }
        char[][] ans = new char[boxGrid[0].length][boxGrid.length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = boxGrid[boxGrid.length - 1 - j][i];
            }
        }
        return ans;
    }
}