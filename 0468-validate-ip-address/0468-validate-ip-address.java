class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP.chars().filter(ch -> ch == '.').count() == 3){
            return isIPv4(queryIP) ? "IPv4" : "Neither";
        }else if(queryIP.chars().filter(ch -> ch == ':').count() == 7){
            return isIPv6(queryIP) ? "IPv6" : "Neither";
        }else{
            return "Neither";
        }
    }

    private boolean isIPv4(String queryIP){
        String[] arr = queryIP.split("\\.", -1);
        if(arr.length != 4) return false;

        for(String s : arr){
            if(s.length() == 0 || s.length() > 3) return false;
            if(s.charAt(0) == '0' && s.length()>1) return false;

            for(char c : s.toCharArray()){
                if(!Character.isDigit(c)) return false;
            }

            int num = Integer.parseInt(s);
            if(num<0 || num>255) return false;
        }
        return true;
    }

    private Boolean isIPv6(String queryIP){
        String[] arr = queryIP.split(":", -1);
        if(arr.length != 8) return false;

        for(String s : arr){
            if(s.length()<1 || s.length()>4) return false;

            for(char c : s.toCharArray()){
                boolean isHex = (c >= '0' && c <= '9') || 
                (c >= 'a' && c <= 'f') || 
                (c >= 'A' && c <= 'F'); 

                if(!isHex) return false;
            }
        }
        return true;
    }
}