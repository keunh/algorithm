17. Letter Combinations of a Phone Number
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

```
class Solution {
    private Map<Character, List<Character>> map = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );
    private List<String> result = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0) {
            return Collections.emptyList();
        }
        
        recursive(0, digits.toCharArray(), new char[digits.length()]);
        return result;
    }
    
    public void recursive(int d, char[] chars, char[] res) {
        if (d==chars.length) {
            result.add(String.valueOf(res));
            return;
        }

        List<Character> characters = map.get(chars[d]);
        for (int i=0 ; i<characters.size() ; i++) {
            res[d] = characters.get(i);
            recursive(d+1, chars, res);
        }
    }
}
```
