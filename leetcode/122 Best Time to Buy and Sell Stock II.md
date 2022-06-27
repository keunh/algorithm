https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/803206/PythonJSGoC%2B%2B-O(n)-by-DP-w-Visualization

DP 문제. 풀지 못했다.

```java
public int maxProfit(int[] prices) {
    int profit = 0;

    for (int i=1 ; i<prices.length ; i++) {
        if (prices[i-1] < prices[i]) {
            profit += prices[i] - prices[i-1];
        }
    }

    return profit;
}
```
