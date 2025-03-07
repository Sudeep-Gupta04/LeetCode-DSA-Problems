class Solution {
    public int punishmentNumber(int n) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i =1;i<=1000;i++){
            if(check(i)) al.add(i);
        }
        System.out.println(al);
        al.add(1001);
        int ans =0;
        int k =0;
        for(int i =0;i<=n;i++){
            if(al.get(k)<=n) {
                ans += (al.get(k)*al.get(k));
                k++;
            }
            else break;
        }
        return ans;
    }

    public boolean check(int n){
        int tar = n;
        String st = n*n + "";
        return check(1,tar,st,0,st.length());
    }
    public boolean check(int k ,int tar,String st,int x,int size){
        
        if(tar==0 && x==size) return true;
        boolean ans = false;
        for(int i =k;i<=st.length();i++){
            String sub = st.substring(0,i);
            int num = Integer.parseInt(sub);
            if(num<=tar){
                if(sub.length()>1 && sub.charAt(0)=='0') continue;
                ans = ans || check(1,tar-num,st.substring(i),x+i,size);
                if(ans) return ans;
            }
        }
        return ans;
    }
}