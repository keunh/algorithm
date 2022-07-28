34. Find First and Last Position of Element in Sorted Array

https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        
        if (nums.length == 0) {
            return result;
        }
        
        int left = 0;
        int right = nums.length-1;
        int index = 0;

        while(left <= right) {
            index = left + ((right - left)/2);

            if (nums[index] == target) {
                break;
            }

            if (nums[index] < target) {
                left = index+1;
            } else {
                right = index-1;
            }
        }

        for (int i=index ; i>=0 ; i--) {
            if (target == nums[i]) {
                result[0] = i;
            } else {
                break;
            }
        }

        for (int i=index ; i<nums.length ; i++) {
            if (target == nums[i]) {
                result[1] = i;
            } else {
                break;
            }
        }

        return result;
    }
}
```
