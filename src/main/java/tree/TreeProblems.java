package tree;

public class TreeProblems {
    //https://leetcode.com/problems/subtree-of-another-tree/description/

    /**
     * T O(N*M)
     * S =O(N)
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubTree (TreeNode root, TreeNode subRoot){
        if(root==null || subRoot == null){
            return root==subRoot;
        }
        return isSame(root, subRoot) ||
                isSubTree(root.left, subRoot)||
                isSubTree(root.right, subRoot);
    }

    private boolean isSame(TreeNode root, TreeNode subRoot) {
        if(root ==null || subRoot == null){
            return root == subRoot;
        }
        return root.val == subRoot.val && isSame(root.left, subRoot.left) && isSame(root.right,  subRoot.right);
    }
}
