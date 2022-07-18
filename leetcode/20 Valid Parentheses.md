20. Valid Parentheses

https://leetcode.com/problems/valid-parentheses/

```java
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = Map.of(')', '(', '}', '{', ']', '[');
        Stack<Character> stack = new Stack<>();

        for(int i=0 ; i<s.length() ; i++) {
            char tmpChar = s.charAt(i);
            if (brackets.containsValue(tmpChar)) {
                stack.add(tmpChar);
                continue;
            }

            if (stack.isEmpty()) {
                return false;    
            }

            char openBracket = stack.pop();
            if (openBracket != brackets.get(tmpChar)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
```
