class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] result = new int[2];

        int start = 1;
        int end = n-1;

        if(n==2){
            result[0] = 1;
            result[1] = 1;
            return result;
        }

        while(start<end){
            if((start + end == n) && start%10 != 0 && end%10 != 0 && !zero(start) && !zero(end)){
                result[0] = start;
                result[1] = end;
            }
            start++;
            end--;
        }
        return result;
    }

    boolean zero(int x){
        String s = Integer.toString(x);
        for(char c : s.toCharArray()){
            if(c == '0') return true;
        }
        return false;
    }
}