class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int x=0;
    for(int i =low;i<=high;i++){
            String st = i +"";
             x += count(st);
        }
        return x;
    }
    public static int count(String st){
        int result =0;
        if(st.length()%2==0){
            result += is_correct(st);
        }
        return result;
    }
    public static int is_correct(String st){
        int ans=0;
        int x = st.length();
        int sum =0,sum1=0;
        for(int i=0;i<x/2;i++){
            sum+=Integer.parseInt(String.valueOf(st.charAt(i)));
        }
        for(int i=x/2;i<x;i++){
           sum1+=Integer.parseInt(String.valueOf(st.charAt(i)));
        }
        if(sum==sum1){
            ans++;
            return ans;
        }
        return 0;

    }
     
  
}