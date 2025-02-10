```java
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> ignore = Set.of(".", "", "..");
        String[] paths = path.split("/");

        for (String p : paths) {
            if ("..".equals(p) && !stack.isEmpty()) {
                stack.pop();
            } else if (!ignore.contains(p)) {
                stack.add(p);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + "/" + result;
        }
        return "/" + result.substring(0, result.length()-1);
    }
}
```
