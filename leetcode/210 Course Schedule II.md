210. Course Schedule II

https://leetcode.com/problems/course-schedule-ii/

못 풀어서 솔루션 봤는데 아래와 같은 방법으로 푸는 위상정렬 문제.

Solution
```java
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> preMap = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        
        for (int i=0 ; i<prerequisites.length ; i++) {
            int dest = prerequisites[i][0];
            int pre = prerequisites[i][1];
            List<Integer> dests = preMap.getOrDefault(pre, new ArrayList<>());
            
            dests.add(dest);
            preMap.put(pre, dests);
            
            indegree[dest]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i=0 ; i<numCourses ; i++) {
            if (indegree[i]==0) {
                q.add(i);
            }
        }
        
        int index = 0;
        int[] topologicalOrder = new int[numCourses];
        
        while (!q.isEmpty()) {
            int pre = q.poll();
            
            if (preMap.containsKey(pre)) {
                for(int dest : preMap.get(pre)) {
                    indegree[dest]--;

                    if (indegree[dest]==0) {
                        q.add(dest);
                    }
                }
            }
            
            topologicalOrder[index] = pre;
            index++;
        }
        
        if (index==numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }
}
```
