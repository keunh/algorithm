22. Generate Parentheses
https://leetcode.com/problems/generate-parentheses/

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recurcive(n, 0, new char[n*2], result);
        return result;
    }
    
    public void recurcive(int n, int d, char[] chars, List<String> result) {
        if ((n*2) == d) {
            if (isWellFormedParentheses(chars)) {
                result.add(String.valueOf(chars));
            }
            return;
        }
        
        chars[d] = '(';
        recurcive(n, d+1, chars, result);
        
        chars[d] = ')';
        recurcive(n, d+1, chars, result);
    }
    
    public boolean isWellFormedParentheses(char[] chars) {
        Stack<Character> stack = new Stack<>();
        
        for (int i=0 ; i<chars.length ; i++) {
            if (chars[i] == '(') {
                stack.add(chars[i]);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            stack.pop();
        }
    
        return stack.isEmpty();
    }
}
```

Solution
```
class Solution {
    private List<String> result = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        recurcive(n, 0, new char[n*2], 0, 0);
        return result;
    }
    
    public void recurcive(int n, int d, char[] chars, int open, int close) {
        if ((n*2) == d) {
            result.add(String.valueOf(chars));
            return;
        }
        
        if (open < n) {
            chars[d] = '(';
            recurcive(n, d+1, chars, open+1, close);
        }
        
        if (close < open) {
            chars[d] = ')';
            recurcive(n, d+1, chars, open, close+1);
        }
    }
}
```
