class Solution {
    public String removeOccurrences(String s, String part) {
        int n = part.length();
        StringBuilder result = new StringBuilder();

        for(char c : s.toCharArray()){
            result.append(c);
            if(result.length() >= n && result.substring(result.length() - n).equals(part)){
                result.delete(result.length() - n, result.length());
            }
        }
        return result.toString();
    }
}