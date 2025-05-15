class Solution {
            public int minimumOperationsToMakeEqual(int x, int y) {
            HashSet<Integer> hs = new HashSet<>();
            Queue<Integer> q = new ArrayDeque<>();
            q.add(x);
            hs.add(x);
            int c = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int num = q.remove();
                    if (num == y) return c;

                    if(num%11==0){
                        int p1 = num /11;
                        if(!hs.contains(p1)){
                            hs.add(p1);
                            q.add(p1);
                        }
                    }
                    if(num%5==0) {
                        int p2 = num /5;
                        if(!hs.contains(p2)){
                            hs.add(p2);
                            q.add(p2);
                        }
                    }
                    int p3 = num -1;
                    int p4 = num +1;

                    if(!hs.contains(p3)){
                        q.add(p3);
                        hs.add(p3);
                    }
                    if(!hs.contains(p4)){
                        q.add(p4);
                        hs.add(p4);
                    }
                }
                c++;
            }

            return c;
        }
    }