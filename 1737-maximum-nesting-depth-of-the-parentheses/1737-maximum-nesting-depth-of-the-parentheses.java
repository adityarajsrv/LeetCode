class Solution {
    public int maxDepth(String s) {
        int maximum = 0;
        int current = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                current++;
                maximum = Math.max(maximum, current);
            }else if(c == ')'){
                current--;
            }
        }
        return maximum;
    }
}