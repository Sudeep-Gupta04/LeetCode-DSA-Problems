class Solution {
    public boolean canBeValid(String s, String locked) {

        int n = locked.length();
        if(n%2!=0) return false;
        int lockedc = 0;
        int unlock = 0;
        int c = 0;
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(locked.charAt(i)=='1'){
                if(ch==')'){
                    if(lockedc >0) lockedc--;
                    else if(unlock>0) unlock--;
                    else{
                        c=1;
                        break;
                    }
                }else{
                    lockedc ++;
                }
            }else{
                unlock++;
            }
        }
        if(c==1) return false;
        unlock=0;c=0;
        int lockedd = 0;

        for(int i =n-1;i>=0;i--){
            char ch = s.charAt(i);
            if(locked.charAt(i)=='1'){
                if(ch=='('){
                    if(lockedd >0) lockedd--;
                    else if(unlock>0) unlock--;
                    else{
                        c=1;
                        break;
                    }
                }else{
                    lockedd ++;
                }
            }else{
                unlock++;
            }
        }
        if(c==1) return false;
        return true;
    }
}