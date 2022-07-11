88. Merge Sorted Array

https://leetcode.com/problems/merge-sorted-array/

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m ; i<m+n ; i++) {
            nums1[i] = nums2[i-m];
        }

        Arrays.sort(nums1);
    }
}
```

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length;
        int i = m-1;
        int j = n-1;

        while(index > 0) {
            index--;

            if (j < 0) {
                nums1[index] = nums1[i];
                i--;
            } else if (i < 0) {
                nums1[index] = nums2[j];
                j--;
            } else if (nums2[j] < nums1[i]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }
        }
    }
}
```
