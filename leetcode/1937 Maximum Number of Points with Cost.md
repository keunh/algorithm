1937. Maximum Number of Points with Cost

https://leetcode.com/problems/maximum-number-of-points-with-cost/

시간초과....
```
class Solution {
    public long maxPoints(int[][] points) {
        long dp[][] = new long[points.length][points[0].length];

        for (int n=0 ; n<points[0].length ; n++) {
            dp[0][n] = points[0][n];
        }

        for (int n=1 ; n<points.length ; n++) {
            for (int m=0 ; m<points[0].length ; m++) {
                long sum = 0;

                for (int i=0 ; i<points[0].length ; i++) {
                    long tmp = points[n][m] + dp[n-1][i] - Math.abs(m-i);
                    sum = Math.max(sum, tmp);
                }
                dp[n][m] = sum;
            }
        }

        long result = 0;
        for (int n=0 ; n<points[0].length ; n++) {
            result = Math.max(result, dp[points.length-1][n]);
        }
        return result;
    }
}
```

Discuss
https://leetcode.com/problems/maximum-number-of-points-with-cost/discuss/1344908/C%2B%2BJavaPython-3-DP-Explanation-with-pictures-O(MN)-Time-O(N)-Space
