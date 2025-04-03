class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class PreorderTraversal {

    // Function to perform preorder traversal recursively
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return; // Base case: If the node is null, return
        }

        System.out.print(root.val + " "); // Process the current node (print its value)
        preorderTraversal(root.left);    // Recursively traverse the left subtree
        preorderTraversal(root.right);   // Recursively traverse the right subtree
    }

    public static void main(String[] args) {
        // Constructing a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.print("Preorder Traversal: ");
        preorderTraversal(root); // Call the preorder traversal function
        System.out.println(); // Print a newline for better readability
    }
}