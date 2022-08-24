322. Coin Change

https://leetcode.com/problems/coin-change/

다시 폴어보기!
아래는 유툽보고 참고해서 풂..
https://www.youtube.com/watch?v=H9bfqozjoqs

재귀로 
```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount==0) {
            return 0;
        }
        
        int[] counts = new int[amount+1];
        
        Arrays.sort(coins);
        
        int tmp = recursive(coins, amount, counts);
        return (tmp==0) ? -1 : tmp;
    }
    
    private int recursive(int[] coins, int amount, int[] counts) {
        if (amount==0) {
            return 0;
        }
        if (counts[amount]!=0) {
            return counts[amount];
        }
        
        int min = Integer.MAX_VALUE;
        for (int i=0 ; i<coins.length ; i++) {
            if (amount-coins[i] < 0) {
                break;
            }
            
            int tmp = recursive(coins, amount-coins[i], counts) + 1;
            if (tmp>0 && min>tmp) {
                min = tmp;
            }
        }
        counts[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return counts[amount];
    }
}
```

dp로
```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;
        
        for (int i=1 ; i<=amount ; i++) {
            for (int j=0 ; j<coins.length ; j++) {
                if (i < coins[j]) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
            }
        }
        
        return (dp[amount] == Integer.MAX_VALUE-1) ? -1 : dp[amount];
    }
}
```
