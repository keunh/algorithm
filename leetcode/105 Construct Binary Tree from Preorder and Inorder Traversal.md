105. Construct Binary Tree from Preorder and Inorder Traversal

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Solution 확인..
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursive(preorder, inorder, 0, 0, preorder.length-1);
    }
    
    public TreeNode recursive(int[] preorder, int[] inorder, int preMid, int inStart, int inEnd) {
        if (preMid >= preorder.length || inStart > inEnd) {
            return null;
        }

        int inIndex = preMid;
        TreeNode treeNode = new TreeNode(preorder[preMid]);
        for (int i=inStart ; i<=inEnd ; i++) {
            if (inorder[i] == preorder[preMid]) {
                inIndex = i;
                break;
            }
        }

        treeNode.left = recursive(preorder, inorder, preMid+1, inStart, inIndex-1);
        treeNode.right = recursive(preorder, inorder, preMid+1+inIndex-inStart, inIndex+1, inEnd);
        return treeNode;
    }
}
```
