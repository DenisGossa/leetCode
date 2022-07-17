class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){return false;}
        String s=String.valueOf(x);
        int i=0,j=s.length()-1;
        while(j>i){
            if(s.charAt(j--)!=s.charAt(i++)){return false;}
        }
               return true;
    }
}