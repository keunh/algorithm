```java
class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new LinkedList<>(), 0);
        return result;
    }

    private void dfs(int[] candidates, int target, int idx, LinkedList<Integer> list, int sum) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i=idx ; i<candidates.length ; i++) {
            if (i > idx && candidates[i]==candidates[i-1]) {
                continue;
            }
            
            list.add(candidates[i]);
            dfs(candidates, target, i+1, list, candidates[i]+sum);
            list.removeLast();
        }
    }
}
```
