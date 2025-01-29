```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        int i = 0, j = 0;

        while (j<nums.length) {
            int num = nums[j];
            nums[i] = nums[j];
            i++;
            j++;
            cnt++;

            if (cnt>=2 || (j<nums.length && num!=nums[j])) {
                while (j<nums.length && num==nums[j]) {
                    j++;
                }
                cnt = 0;
            }
        }
        return i;
    }
}
```

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;        
    }
}
```
