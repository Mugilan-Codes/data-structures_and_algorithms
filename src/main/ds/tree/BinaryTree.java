package main.ds.tree;

public class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Pre-Order Traversal");
        tree.preorder(tree.root);
        System.out.println();

        System.out.println("In-Order Traversal");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Post-Order Traversal");
        tree.postorder(tree.root);
        System.out.println();

        if (tree.isFullBinaryTree(tree.root)) {
            System.out.println("Tree is a Full Binary Tree");
        } else {
            System.out.println("Not a Full Binary Tree");
        }

        if (tree.isPerfectBinaryTree(tree.root)) {
            System.out.println("Tree is a Perfect Binary Tree");
        } else {
            System.out.println("Not a Perfect Binary Tree");
        }
    }

    static int depth(Node root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }

    void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Every parent node/internal node has either two or no children.
    boolean isFullBinaryTree(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.right != null) {
            return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);
        }

        return false;
    }

    // Every internal node has exactly two child nodes and all the leaf nodes are at the same level.
    private boolean isPerfectBinaryTree(Node root, int depthOfTree, int currentLevel) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return depthOfTree == currentLevel + 1;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        return isPerfectBinaryTree(root.left, depthOfTree, currentLevel + 1) && isPerfectBinaryTree(root.right, depthOfTree, currentLevel+1);
    }

    boolean isPerfectBinaryTree(Node root) {
        int depthOfTree = depth(root);
        return isPerfectBinaryTree(root, depthOfTree, 0);
    }

    static class Node {
        int data;
        Node left = null, right = null;

        Node(int data) {
            this.data = data;
        }
    }

}
