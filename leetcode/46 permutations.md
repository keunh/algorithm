https://leetcode.com/problems/permutations/

```java
class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        dfs(results, nums, 0, new boolean[nums.length], new int[nums.length]);
        
        return results;
    }
    
    private void dfs(List<List<Integer>> results, int[] nums, int d, boolean[] check, int[] list) {
        if (d == nums.length) {
            results.add(toList(list));
            return;
        }
        
        for (int i=0 ; i<check.length ; i++) {
            if (check[i]) {
                continue;
            }
            
            check[i] = true;
            list[d] = nums[i];
            
            dfs(results, nums, d+1, check, list);
            
            check[i] = false;
        }
    }
    
    private List<Integer> toList(int[] list) {
        List<Integer> result = new ArrayList<>();
        for(int num : list) {
            result.add(num);
        }
        return result;
    }
}
```
