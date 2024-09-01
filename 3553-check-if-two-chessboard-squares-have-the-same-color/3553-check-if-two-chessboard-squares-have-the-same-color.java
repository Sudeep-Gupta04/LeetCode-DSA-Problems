class Solution {
   public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        char a = coordinate1.charAt(0);
        char b = coordinate2.charAt(0);
        int v1 = coordinate1.charAt(1);
        int v2 = coordinate2.charAt(1);
        if(((a+0)%2==0 && (b+0)%2==0) || ((a+0)%2!=0 && (b+0)%2!=0)){
            if((v1%2==0 && v2%2==0)||(v1%2!=0 && v2%2!=0)){
                return true;
            }
            else return false;
        }
        else {
            if((a+0)%2==0 && (b+0)%2!=0){
                if((v1%2==0 && v2%2==0) || (v2%2!=0 && v1%2!=0)) return false;
                else return true;
            }else {
                if((v1%2==0 && v2%2==0) || (v2%2!=0 && v1%2!=0)) return false;
                else return true;
            }
        }
    }
}