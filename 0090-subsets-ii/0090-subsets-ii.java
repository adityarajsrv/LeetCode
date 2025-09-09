class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<(1<<n); i++){
            List<Integer> subset = new ArrayList<>();
            for(int j=0; j<n; j++){
                if((i & (1<<j)) != 0){
                    subset.add(nums[j]);
                }
            }
            String subsetStr = subset.toString();
            if(seen.add(subsetStr)){
                result.add(subset);
            }
        }
        return result;
    }
}