347. Top K Frequent Elements

https://leetcode.com/problems/top-k-frequent-elements/

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int tmp = map.getOrDefault(num, 0);
            map.put(num, tmp+1);
        }
        
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            List<Integer> list = treeMap.getOrDefault(mapEntry.getValue(), new ArrayList<>());
            list.add(mapEntry.getKey());
            treeMap.put(mapEntry.getValue(), list);
        }

        int[] result = new int[k];
        int index = 0;
        for (int count : treeMap.descendingKeySet()) {
            for (int num : treeMap.get(count)) {
                result[index] = num;
                if (++index == k) {
                    break;
                }
            }
            if (index == k) {
                break;
            }
        }
        return result;
    }
}
```
