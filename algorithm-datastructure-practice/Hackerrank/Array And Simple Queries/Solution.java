import java.util.Scanner;

public class Solution {

	static class ResponseWrapper {
		Object ll;
		Object rr;

		public ResponseWrapper(Object ll, Object rr) {
			this.ll = ll;
			this.rr = rr;
		}

		public Object getLeft() {
			return ll;
		}

		public Object getRight() {
			return rr;
		}

	}

	static class Node<T> {
		int priority;
		int key;
		T value;
		Node<T> left;
		Node<T> right;
		int size;

		public String toString() {
			return "[key: " + key + "value: " + value + "]";
		}

		public Node(int key, T value, int priority, Node<T> left, Node<T> right, int size) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
			this.priority = priority;
			this.size = size;
		}

		public Node(int key, T value) {
			this.key = key;
			this.value = value;
			// Random value for maintaining heap property 
			this.priority = (int) (Integer.MAX_VALUE * Math.random());
			this.size = 1;
		}

		private Node<T> leftRotate(Node<T> root) {
			Node<T> temp = root.right;
			root.right = temp.left;
			temp.left = root;

			// update the sub-tree sizes
			root.updateSize();
			temp.updateSize();
			return temp;
		}

		private Node<T> rightRotate(Node<T> root) {
			Node<T> temp = root.left;
			root.left = temp.right;
			temp.right = root;

			// update the sub-tree sizes
			root.updateSize();
			temp.updateSize();
			return temp;
		}

		public void updateSize() {
			int leftSize = left != null ? left.size : 0;
			int rightSize = right != null ? right.size : 0;

			// total of left subtree, plus right subtree, plus one for the current node
			this.size = leftSize + rightSize + 1;
		}

		public Node<T> merge(Node<T> left, Node<T> right) {
			if (left == null) {
				return right;
			} else if (right == null) {
				return left;
			}

			Node<T> newNode = null;
			// need to keep our tree in a valid heap as well, where left < right 
			if (left.priority > right.priority) {
				Node<T> newRight = merge(left.right, right);
				newNode = new Node<T>(left.key, left.value, left.priority, left.left, newRight, 1);
			} else {
				Node<T> newLeft = merge(left, right.left);
				newNode = new Node<T>(right.key, right.value, right.priority, newLeft, right.right, 1);
			}

			// update the size of the new node and the current node to account for any changes
			newNode.updateSize();
			return newNode;
		}

		// the last parameter, index, is used for implicit indexing to find a given key
		public ResponseWrapper split(boolean implicitIndex, int key, T value, int index) {
			Node<T> newTree = null;
			Node<T> newLeft = null;
			Node<T> newRight = null;

			// calculate the size of the left subtree for implicit indexing
			int leftSize = this.left != null ? this.left.size : 0;
			int currentKey = 0;

			// If we are splitting based upon an implicit index then we compare against 
			// 		a current key and (leftSize + Index)
			// If we are not looking by implicit index then we look based upon the key with currentKey
			boolean result;

			if (implicitIndex) {
				// calculate the implict index
				currentKey = leftSize + index;
				result = currentKey <= key;
			} else {
				// just compare based upon the key of the current node
				result = this.key <= key;
			}

			// is the key in the current node smaller the key being passed in?
			// If so then we need to add this node to the left tree, and split along the right
			if (result) {
				if (this.right == null) {
					newRight = null;
				} else {
					ResponseWrapper wr = this.right.split(implicitIndex, key, value, currentKey + 1);
					newTree = (Node<T>) wr.getLeft();
					newRight = (Node<T>) wr.getRight();
				}

				// make sure we update our new left node with the correct subtree size
				newLeft = new Node<T>(this.key, this.value, priority, this.left, newTree, 1);
				newLeft.updateSize();
			} else {
				if (this.left == null) {
					newLeft = null;
				} else {
					ResponseWrapper wr = this.left.split(implicitIndex, key, value, index);
					newLeft = (Node<T>) wr.getLeft();
					newTree = (Node<T>) wr.getRight();
				}
				// make sure we update our new right node with the correct subtree size
				newRight = new Node<T>(key, this.value, priority, newTree, right, 1);
				newRight.updateSize();
			}
			return new ResponseWrapper(newLeft, newRight);
		}

		public Node<T> add(int key, T value) {
			// when adding a node we are not using an implicit index
			ResponseWrapper wr = split(false, key, value, 0);
			Node<T> left = (Node<T>) wr.getLeft();
			Node<T> right = (Node<T>) wr.getRight();

			Node<T> m = new Node<T>(key, value);
			return merge(merge(left, m), right);
		}

		public Node<T> getIndex(Node<T> node, int index) {
			Node<T> foundNode = null;

			if (node != null) {
				// if the index is less than or equal to the size of the left sub-tree, then
				// we should traverse down that path with the index unchanged
				int leftSize = node.left != null ? node.left.size : 0;

				// if our current index is smaller than the size of the left subtree then
				// continue further down the left subtree to find the index we are looking for
				if (index < leftSize) {
					foundNode = getIndex(node.left, index);
				} else if (node.left != null && index == 0 || index == leftSize) {
					// return leftmost node having no children
					foundNode = node;
				} else {
					// go to right as new Index = CurrentIndex - (leftsize + root(1))]
					foundNode = getIndex(node.right, index - (leftSize + 1));
				}
			}
			return foundNode;
		}

		public Node<T> delete(Node<T> root, int key) {
			if (root == null) {
				return null;
			}

			if (key < root.key) {
				root.left = delete(root.left, key);
			} else if (key > root.key) {
				root.right = delete(root.right, key);
			} else if (key == root.key) {
				if (root.left != null && root.right != null) {
					if (root.left.priority < root.right.priority) {
						root = root.rightRotate(root);
					} else {
						root = root.leftRotate(root);
					}
				} else if (root.left != null) {
					root = root.rightRotate(root);
				} else if (root.right != null) {
					root = root.leftRotate(root);
				} else {
					return null;
				}
				root = delete(root, key);
			}
			// update the size of the root to reflect the removed node (if found)
			if (root != null)
				root.updateSize();
			return root;
		}
	}

	static class Treap<T> {
		public Node<T> root;

		public Treap(Node<T> root) {
			this.root = root;
		}

		public Treap() {
		}

		public Node<T> getRoot() {
			return root;
		}

		public int count() {
			return root != null ? root.size : 0;
		}

		public void setVal(int idx, T value) {
			root = add(idx, value);
		}

		public Node<T> get(Node<T> root, int key) {
			if (root == null) {
				return null;
			}

			if (key < root.key) {
				return get(root.left, key);
			} else if (key > root.key) {
				return get(root.right, key);
			}
			return root;
		}

		public void clear() {
			root = null;
		}

		public void merge(Treap<T> left, Treap<T> right) {
			Node<T> leftNode = left != null ? left.getRoot() : null;
			Node<T> rightNode = null != right ? right.getRoot() : null;
			root = root.merge(leftNode, rightNode);
		}

		public ResponseWrapper split(boolean implicitIndex, int key, T value) {
			ResponseWrapper wr = root.split(implicitIndex, key, value, 0);
			Node<T> tempLeft = (Node<T>) wr.getLeft();
			Node<T> tempRight = (Node<T>) wr.getRight();

			Treap<T> leftTree = tempLeft != null ? new Treap<T>(tempLeft) : null;
			Treap<T> rightTree = tempRight != null ? new Treap<T>(tempRight) : null;
			return new ResponseWrapper(leftTree, rightTree);
		}

		public Node<T> getFirst() {
			return root.getIndex(root, 0);
		}

		public Node<T> getLast() {
			return root.getIndex(root, count() - 1);
		}

		public Node<T> add(int key, T value) {
			if (root == null) {
				root = new Node<T>(key, value);
				return root;
			}
			return root.add(key, value);
		}

		public Node<T> getIndex(int index) {
			return root.getIndex(root, index);
		}

		public Node<T> delete(int key) {
			if (root == null) {
				return null;
			}
			root = root.delete(root, key);
			return root;
		}

		public void InOrder(Node<T> node) {
			if (node != null) {
				InOrder(node.left);
				System.out.print(node.value + " ");
				InOrder(node.right);
			}
		}

		public void InOrderPrinting(Node<T> node, StringBuilder op) {
			if (node != null) {
				InOrderPrinting(node.left, op);
				op.append(node.value + " ");
				InOrderPrinting(node.right, op);
			}
		}

		public String toString() {
			StringBuilder op = new StringBuilder("");
			InOrderPrinting(root, op);
			return "[" + op.toString() + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		Treap<Integer> tree = new Treap<Integer>();
		for (int i = 0; i < N; i++) {
			tree.setVal(i, sc.nextInt());
		}

		for (int i = 0; i < M; i++) {
			int query = sc.nextInt();
			int start = sc.nextInt() - 1;
			int end = sc.nextInt() - 1;

			// List = { 1, 2, 3, 4, 5, 6, 7, 8 }
			// beginTree = { 1 }
			// tempTree = { 2, 3, 4, 5, 6, 7, 8 }
			ResponseWrapper wr = tree.split(true, start - 1, 0);
			Treap<Integer> beginTree = (Treap<Integer>) wr.getLeft();
			Treap<Integer> tempTree = (Treap<Integer>) wr.getRight();

			// tempTree = { 2, 3, 4, 5, 6, 7, 8 }
			// middleTree = { 2, 3, 4 }
			// endTree = { 5, 6, 7, 8 }
			wr = tempTree.split(true, end - start, 0);
			Treap<Integer> middleTree = (Treap<Integer>) wr.getLeft();
			Treap<Integer> endTree = (Treap<Integer>) wr.getRight();

//			System.out.println("Begin:" + beginTree);
//			System.out.println("Middle:" + middleTree);
//			System.out.println("End:" + endTree);

			if (query == 1) {
				tree.merge(beginTree, endTree);
				tree.merge(middleTree, tree);
			} else if (query == 2) {
				tree.merge(beginTree, endTree);
				tree.merge(tree, middleTree);
			}
		}

		System.out.println(Math.abs(tree.getFirst().value - tree.getLast().value));
		tree.InOrder(tree.root);
		sc.close();
	}
}