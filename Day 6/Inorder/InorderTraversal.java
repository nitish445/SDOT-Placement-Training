class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class InorderTraversal {

    // Recursive function for inorder traversal
    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            // Traverse the left subtree
            inorderTraversal(root.left);

            // Visit the current node (print its value)
            System.out.print(root.val + " ");

            // Traverse the right subtree
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Perform inorder traversal and print the result
        System.out.print("Inorder traversal: ");
        inorderTraversal(root); // Output: 4 2 5 1 3
        System.out.println(); //add a newline for better formatting
    }
}