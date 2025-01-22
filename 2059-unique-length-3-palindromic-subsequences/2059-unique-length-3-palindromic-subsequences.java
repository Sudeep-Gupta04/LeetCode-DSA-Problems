class Solution {
     public int countPalindromicSubsequence(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-97]++;
        }
        System.out.println(Arrays.toString(arr));
        int ans=0;
        for(int i =0;i<26;i++){
            if(arr[i]>=2){
                HashSet<Character> hs = new HashSet<>();
                int st =0;int e=n-1;
                for(st=0;st<n;st++){
                    if(s.charAt(st)==(char)(i+97)) break;
                }
                for(e = n-1;e>=0;e--){
                    if(s.charAt(e)==(char)(i+97)) break;
                }
                for(int j =st+1;j<e;j++){
                    hs.add(s.charAt(j));
                }
                ans+=hs.size();
            }
        }
        return ans;
    }
}