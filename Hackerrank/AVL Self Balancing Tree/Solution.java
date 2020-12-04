class Node {
  int val;
  Node left, right;
  int ht;

  public Node() {
  }
}

public class Solution {

  static Node insert(Node root, int val) {
    if (root == null) {
      root = new Node();
      root.val = val;
      root.ht = getHeight(root);
      return root;
    }
    if (val > root.val) {
      root.right = insert(root.right, val);
    } else {
      root.left = insert(root.left, val);
    }

    int balance = height(root.left) - height(root.right);

    if (balance > 1) {
      // left left
      if (height(root.left.left) >= height(root.left.right)) {
        root = rightRotation(root);
      } else { // left right
        root.left = leftRotation(root.left);
        root = rightRotation(root);
      }
    } else if (balance < -1) {
      // right right
      if (height(root.right.right) >= height(root.right.left)) {
        root = leftRotation(root);
      } else { // right left
        root.right = rightRotation(root.right);
        root = leftRotation(root);
      }
    } else {
      root.ht = getHeight(root);
    }
    return root;
  }

  private static Node leftRotation(Node root) {
    Node node = root.right;
    root.right = node.left;
    node.left = root;

    node.ht = getHeight(node);
    root.ht = getHeight(root);
    return node;
  }

  private static Node rightRotation(Node root) {
    Node node = root.left;
    root.left = node.right;
    node.right = root;

    node.ht = getHeight(node);
    root.ht = getHeight(root);
    return node;
  }

  public static int height(Node node) {
    if (node == null) {
      return -1;
    } else {
      return node.ht;
    }
  }

  public static int getHeight(Node root) {
    if (root == null) {
      return -1;
    } else {
      return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
  }

  public static void main(String[] args) {

  }
}