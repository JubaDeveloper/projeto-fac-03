class BinaryTree {
    int value;
    BinaryTree left, right;

    BinaryTree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {

    public static void main(String[] args) {
        int[] values = {10, 5, 8, 12, 21, 50, 64, 24, 89};
        BinaryTree bt = new BinaryTree(values[0]);

        // Inserting the values into the binary tree
        for (int x = 1; x < values.length; x++) {
            int value = values[x];
            BinaryTree subTree = bt;
            BinaryTree parent = null;

            // Find the correct position to insert the new node
            while (subTree != null) {
                parent = subTree;
                if (value < subTree.value) {
                    subTree = subTree.left;
                } else {
                    subTree = subTree.right;
                }
            }

            // Insert the new node
            BinaryTree newNode = new BinaryTree(value);
            if (value < parent.value) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }

        // Look-up section
        int lookUpItem = 50;
        BinaryTree subTree = bt;
        int rounds = 0;

        while (true) {
            if (subTree == null) {
                System.out.println("Item not found");
                break;
            }
            if (lookUpItem == subTree.value) {
                System.out.printf("Item found after %d rounds%n", rounds);
                break;
            }
            if (lookUpItem < subTree.value) {
                subTree = subTree.left;
            } else {
                subTree = subTree.right;
            }
            rounds++;
        }
    }
}
