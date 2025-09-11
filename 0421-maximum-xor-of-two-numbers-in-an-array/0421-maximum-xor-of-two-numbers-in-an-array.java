class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i=31; i>=0; i--){
            mask |= (1<<i);
            Set<Integer> prefixes = new HashSet<Integer>();
            for(int num : nums){
                prefixes.add(num & mask);
            }
            int candidate = max | (1<<i);
            for(int prefix : prefixes){
                if(prefixes.contains(prefix ^ candidate)){
                    max = candidate;
                    break;
                }
            }
        }
        return max;
    }
}