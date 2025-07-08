
class Solution {
     public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        int[] slflife = new int[n];
        int maxdays = 0;
        for(int i =0;i<n;i++){
            if(apples[i]==0) continue;
            slflife[i] = i+days[i]-1;
            maxdays = Math.max(slflife[i],maxdays);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1]; // min heap based on second element 
            }
        });
        int c  =0;
        for(int day = 0;day<=maxdays;day++){

            if(day<n && apples[day]!=0) pq.add(new int[]{apples[day],slflife[day]});

            while(!pq.isEmpty() && pq.peek()[1] < day) pq.remove();

            if(!pq.isEmpty()){
                c++;
                int[] ele = pq.remove();
                ele[0]--;
                if(ele[0]!=0) pq.add(ele);
                
            }
        }
        return c;
    }
}