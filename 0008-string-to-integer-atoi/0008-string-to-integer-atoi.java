class Solution {
    public int myAtoi(String s) {
        int i = 0, sign = 1, total = 0;
        int n = s.length();
        while(i<n && s.charAt(i) == ' '){
            i++;
        }
        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            if(total>(Integer.MAX_VALUE - digit ) /10){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;
            i++;
        }
        return total * sign;
    }
}