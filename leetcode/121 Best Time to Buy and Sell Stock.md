121. Best Time to Buy and Sell Stock

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/

```java
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;
        
        if (prices.length == 1) {
            return result;
        }
        
        for(int i=1 ; i<prices.length ; i++) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(prices[i], min);
        }
        
        return result;
    }
}
```
