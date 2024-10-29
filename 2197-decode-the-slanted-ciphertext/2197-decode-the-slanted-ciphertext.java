class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;
        if(encodedText.length()==0) return "";
        StringBuilder out = new StringBuilder();
        int col = encodedText.length() / rows;

        for (int j = 0; j < col; j++) {
            int temp = j;
            for (int i = 0; i < rows; i++, temp++) {
                if (temp < col && i < rows) {
                    out.append(encodedText.charAt(col * i + temp));
                }
            }
        }
        if(out.charAt(0)==' '){
            for(int i=out.length()-1;i>=0;i--){
                if(out.charAt(i)!=' '){
                    return out.toString().substring(0,i+1);
                }
            }
        }
        return out.toString().trim();
    }
}
