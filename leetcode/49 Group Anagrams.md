49. Group Anagrams

https://leetcode.com/problems/group-anagrams/

얼핏 hash와 sort를 보고 풂..
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> words = new HashMap<>();
        
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedStr = String.valueOf(ch);
            
            List<String> list = words.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            
            words.put(sortedStr, list);
        }
        
        return new ArrayList(words.values());
    }
}
```
