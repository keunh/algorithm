53. Maximum Subarray
https://leetcode.com/problems/maximum-subarray/

```
class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = nums[0];
        
        for (int i=1 ; i<nums.length ; i++) {
            result = Math.max(result, sum);
            sum = Math.max(sum+nums[i], nums[i]);
        }
        
        return Math.max(result, sum);
    }
}
```
