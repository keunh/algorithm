39. Combination Sum

https://leetcode.com/problems/combination-sum/

```java
class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        dfs(candidates, target, new ArrayList<Integer>(), 0, 0);
        
        return result;
    }
    
    public void dfs(int[] candidates, int target, List<Integer> list, int sum, int idx) {
        if (sum == target) {
            result.add(new ArrayList(list));
            return;
        }

        for (int i=idx ; i<candidates.length ; i++) {
            if (sum+candidates[i] > target) {
                break;
            }

            list.add(candidates[i]);
            dfs(candidates, target, list, sum+candidates[i], i);
            list.remove(list.size()-1);
        }
    }
}
```
