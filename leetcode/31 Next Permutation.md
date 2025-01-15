https://leetcode.com/problems/next-permutation/

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = getGrater(nums)-1;

        if (pivot != -1) {
            int nextGrater = getGraterThan(nums, nums[pivot]);
            swap(nums, pivot, nextGrater);
        }

        reverse(nums, pivot+1, nums.length-1);
    }

    private int getGrater(int[] nums) {
        for (int i=nums.length-1 ; i>0 ; i--) {
            if (nums[i-1]<nums[i]) {
                return i;
            }
        }
        return 0;
    }

    private int getGraterThan(int[] nums, int pivot) {
        for (int i=nums.length-1 ; i>0 ; i--) {
            if (pivot<nums[i]) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i<j) {
            swap(nums, i++, j--);
        }
    }
}
```
