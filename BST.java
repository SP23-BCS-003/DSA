// File: BST.java

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {
    Node root;

    // Insert a new node into the BST
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Delete a node from the BST
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node to be deleted found
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = findMinValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Find the minimum value node
    private int findMinValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Find the maximum value node
    private int findMaxValue(Node root) {
        int maxValue = root.data;
        while (root.right != null) {
            maxValue = root.right.data;
            root = root.right;
        }
        return maxValue;
    }

    // Delete the minimum value node
    public void deleteMin() {
        if (root != null) {
            root = deleteMinRec(root);
        }
    }

    private Node deleteMinRec(Node root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMinRec(root.left);
        return root;
    }

    // Delete the maximum value node
    public void deleteMax() {
        if (root != null) {
            root = deleteMaxRec(root);
        }
    }

    private Node deleteMaxRec(Node root) {
        if (root.right == null) {
            return root.left;
        }
        root.right = deleteMaxRec(root.right);
        return root;
    }

    // In-order traversal of the BST
    public void inOrderTraversal() {
        inOrderTraversalRec(root);
        System.out.println();
    }

    private void inOrderTraversalRec(Node root) {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print(root.data + " ");
            inOrderTraversalRec(root.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        // Test insertions
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        // In-order traversal
        System.out.print("In-order traversal: ");
        tree.inOrderTraversal(); // Output: 20 30 40 50 60 70 80

        // Test deletions
        tree.deleteMin(); // Delete the minimum value node
        System.out.print("After deleting min: ");
        tree.inOrderTraversal(); // Output: 30 40 50 60 70 80

        tree.deleteMax(); // Delete the maximum value node
        System.out.print("After deleting max: ");
        tree.inOrderTraversal(); // Output: 30 40 50 60 70

        tree.delete(50); // Delete the root node
        System.out.print("After deleting root (50): ");
        tree.inOrderTraversal(); // Output: 30 40 60 70
    }
}
