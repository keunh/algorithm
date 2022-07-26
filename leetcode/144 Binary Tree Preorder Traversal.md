144. Binary Tree Preorder Traversal

https://leetcode.com/problems/binary-tree-preorder-traversal/

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        recursive(root);        
        return result;
    }
    
    private void recursive(TreeNode current) {
        if (current == null) {
            return;
        }
        
        result.add(current.val);
        
        if (current.left != null) {
            recursive(current.left);
        }
        
        if (current.right != null) {
            recursive(current.right);
        }
    }
}
```
