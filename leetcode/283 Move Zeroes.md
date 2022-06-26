283. Move Zeroes

https://leetcode.com/problems/move-zeroes/

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int zeroCnt = 0;
        
        for(int i=0 ; i<nums.length ; i++) {
            if (nums[i]==0) {
                zeroCnt++;
                continue;
            }
            
            nums[index] = nums[i];
            index++;
        }
        
        for(int i=nums.length-1 ; i>=nums.length-zeroCnt ; i--) {
            nums[i] = 0;
        }
    }
}
```
