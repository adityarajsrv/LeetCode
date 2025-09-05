class Solution {
    public int numSplits(String s) {
        int result = 0;
        int[] left = new int[26];
        int[] right = new int[26];

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            right[c - 'a']++;
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            left[c - 'a']++;
            right[c - 'a']--;

            int distinctLeft = count(left);
            int distinctRight = count(right);

            if(distinctLeft == distinctRight){
                result++;
            }
        }
        return result;
    }

    int count(int[] arr){
        int c = 0;
        for(int i : arr){
            if(i != 0){
                c++;
            }
        }
        return c;
    }
}