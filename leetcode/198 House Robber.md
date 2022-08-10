198. House Robber

https://leetcode.com/problems/house-robber/

처음 풀지 못하고 DP인 것 확인하고 어렵게 풂
```java
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int tmp[][] = new int[nums.length][2];
        tmp[0][0] = nums[0];
        
        for (int i=1 ; i<nums.length ; i++) {
            if (i-3 >= 0) {
                tmp[i][0] = Math.max(tmp[i-3][0] + nums[i], tmp[i-1][1] + nums[i]);
            } else {
                tmp[i][0] = tmp[i-1][1] + nums[i];
            }
            tmp[i][1] = tmp[i-1][0];
        }
        
        return Math.max(tmp[nums.length-1][0], tmp[nums.length-1][1]);
    }
}
```

Discuss 에서 있던 더 간단하게 푼 풀이
```
class Solution {
    public int rob(int[] num) {
        int rob = 0; //max monney can get if rob current house
        int notrob = 0; //max money can get if not rob current house
        
        for(int i=0; i<num.length; i++) {
            int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
            notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);
    }
}
```
