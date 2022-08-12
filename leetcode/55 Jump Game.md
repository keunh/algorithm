55. Jump Game

https://leetcode.com/problems/jump-game/

```java
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length==1) {
            return true;
        }
        
        if (nums[0]==0) {
            return false;
        }
        
        boolean[] check = new boolean[nums.length];  
        check[0] = true;
        
        for(int i=0 ; i<nums.length-1 ; i++) {
            if (nums[i]==0 || !check[i]) {
                continue;
            }
            
            for(int j=i+nums[i] ; j>i ; j--) {
                if (j>=(nums.length-1)) {
                    return true;
                }
                
                if (check[j]) {
                    break;
                }
                
                check[j] = true;
            }
        }

        return check[nums.length-1];
    }
}
```

https://leetcode.com/problems/jump-game/discuss/20974/3ms-simple-JAVA-solution
```java
class Solution {
    public boolean canJump(int[] nums) {
        int dis = 0;
        for (int i = 0; i <= dis; i++) {
            dis = Math.max(dis, i + nums[i]);
            if (dis >= nums.length-1) {
                return true;
            }
        }
        return false;
    }

}
```
