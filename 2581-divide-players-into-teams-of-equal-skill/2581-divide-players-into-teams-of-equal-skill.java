class Solution {
     public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        if(n==2) return skill[0]*skill[1];
        long p = skill[0]*skill[n-1];
        long c = skill[0]+skill[n-1];
        int s = 1;
        int e = n-2;
        while(s<e){
            if(skill[s]+skill[e]!=c) return -1;
            else{
                p += (skill[s]*skill[e]);
                s++;
                e--;
            }
        }
        return p;
    }
} 