class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == 0) return 0;
        if(dividend == Integer.MIN_VALUE && divisor == 0) return Integer.MAX_VALUE;

        int sign = (dividend<0) == (divisor<0) ? 1 : -1;

        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long quotient = 0;

        while(ldividend>=ldivisor){
            long temp = ldivisor;
            long multiple = 1;
            while((temp<<1) <= ldividend){
                temp <<= 1;
                multiple <<= 1;
            }
            ldividend -= temp;
            quotient += multiple;
        }
        quotient = sign * quotient;

        if(quotient > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(quotient < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) quotient;
    }
}