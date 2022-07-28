26. Remove Duplicates from Sorted Array

https://leetcode.com/problems/remove-duplicates-from-sorted-array/

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        
        for (int i=1 ; i<nums.length ; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }
}
```
