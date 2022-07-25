102. Binary Tree Level Order Traversal

https://leetcode.com/problems/binary-tree-level-order-traversal/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        result.add(List.of(root.val));
        
        while (!queue.isEmpty()) {
            
            List<Integer> tmpList = new ArrayList<>();
            int size = queue.size();
            
            for (int i=0 ; i<size ; i++) {
                TreeNode current = queue.poll();

                if (current.left != null) {
                    tmpList.add(current.left.val);
                    queue.add(current.left);
                }
                
                if (current.right != null) {
                    tmpList.add(current.right.val);
                    queue.add(current.right);
                }
            }
                
            if (!tmpList.isEmpty()) {
                result.add(tmpList);
            }
        }
        
        return result;
    }
}
```
