150. Evaluate Reverse Polish Notation

https://leetcode.com/problems/evaluate-reverse-polish-notation/

```java
class Solution {
    private Map<String, BiFunction<Integer, Integer, Integer>> operators = 
        Map.of("+", (a, b) -> a+b, 
               "-", (a, b) -> a-b, 
               "*", (a, b) -> a*b,
               "/", (a, b) -> a/b);
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String token : tokens) {
            if (!operators.containsKey(token)) {
                stack.push(Integer.valueOf(token));
                continue;                
            }
            
            int num1 = stack.pop();
            int num2 = stack.pop();
            int result = operators.get(token).apply(num2, num1);
            
            stack.push(result);
        }
        
        return stack.pop();
    }
}
```
