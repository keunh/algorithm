189. Rotate Array

https://leetcode.com/problems/rotate-array/submissions/

```java
class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        
        int[] tmpNums = new int[nums.length];
        for(int i=0 ; i<nums.length ; i++) {
            int tmpIndex = (i+k)%nums.length;
            tmpNums[tmpIndex] = nums[i];
        }
        
        for(int i=0 ; i<nums.length ; i++) {
            nums[i] = tmpNums[i];
        }
    }
}
```

Discuss 아이디어!
https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution
```java
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```
