class Solution {
   public boolean isValidSudoku(char[][] board) {
        for(int i =0;i<board.length;i++){
            if(!check(board[i])) return false;
        }
        for(int j=0;j< board[0].length;j++){
            HashSet<Integer> hm= new HashSet<>();
            for(int i =0;i<board.length;i++){
                char ch = board[i][j];
                if(ch!='.'){
                    int num = Integer.parseInt(ch+"");
                    if(num>9 || num<0 || hm.contains(num)) return false;
                    else hm.add(num);
                }
            }
        }
        for(int i =0;i<board.length;i+=3){
            for(int j =0;j<board[0].length;j+=3){
                int rs = i; int cs=j;
                int re = i+3;int ce=j+3;
                if(!checkmat(rs,re,cs,ce,board)) return false;
            }
        }
        return true;
    }

    private boolean checkmat(int rs, int re, int cs, int ce, char[][] board) {
        HashSet<Integer> hm = new HashSet<>();
        for(int i =rs;i<re;i++){
            for(int j =cs;j<ce;j++){
                char ch = board[i][j];
                if(ch!='.'){
                    int num = Integer.parseInt(ch+"");
                    if(num>9 || num<0 || hm.contains(num)) return false;
                    else hm.add(num);
                }
            }
        }
        return true;
    }

    public boolean check(char[] arr){
        HashSet<Integer> hm= new HashSet<>();
        for(int i =0;i<arr.length;i++){
            char ch = arr[i];
            if(ch!='.'){
                int num = Integer.parseInt(ch+"");
                if(num>9 || num<0 || hm.contains(num)) return false;
                else hm.add(num);
            }
        }
        return true;
    }
}