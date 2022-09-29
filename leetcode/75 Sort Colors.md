75. Sort Colors
https://leetcode.com/problems/sort-colors/

```
class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];

        for (int i=0 ; i<nums.length ; i++) {
            counts[nums[i]]++;
        }

        int start = 0;
        for (int i=0 ; i<3 ; i++) {
            setColors(nums, i, start, counts[i]);
            start += counts[i];
        }
    }

    private void setColors(int nums[], int num, int start, int count) {
        for (int i=start ; i<start+count ; i++) {
            nums[i] = num;
        }
    }
}
```
