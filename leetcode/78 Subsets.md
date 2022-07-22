78 Subsets.md

https://leetcode.com/problems/subsets/

```java
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        recursive(nums, new boolean[nums.length], 0, 0);
        return result;
    }
    
    public void recursive(int[] nums, boolean[] check, int d, int index) {
        if (d == nums.length+1) {
            return;
        }
        
        List<Integer> added = new ArrayList<>();
        for (int i=0 ; i<check.length ; i++) {
            if (check[i]) {
                added.add(nums[i]);
            }
        }
        result.add(added);
        
        
        for (int i=index ; i<nums.length ; i++) {
            if (check[i]) {
                continue;
            }
            
            check[i] = true;
            recursive(nums, check, d+1, i+1);
            check[i] = false;
        }
    }
}
```

solution
```
class Solution {
    List<List<Integer>> output = new ArrayList();
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }
        for (int i = first; i < n; ++i) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }
}
```
