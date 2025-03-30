import java.util.LinkedList;

public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T> {

    public int height() {
        return findHeight(root);
    }

    private int findHeight(BinaryNode<T> currNode) {
        if (currNode == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(currNode.left), findHeight(currNode.right));
    }

    public T imbalance() {
        // A balanced tree is one where every node’s left and right subtrees differ in height by no more than 1. 
        // Return the value at first node you find which has a height imbalance greater than 1 between its subtrees, 
        // or null if no such node exists

        return findImbalance(root);
    }

    private T findImbalance(BinaryNode<T> currNode) {
        if (currNode == null) {
            return null;
        }

        int leftH = findHeight(currNode.left);
        int rightH = findHeight(currNode.right);

        if (Math.abs(rightH - leftH) > 1) {
            return currNode.data;
        }

        T tmp = findImbalance(currNode.left);
        if (tmp != null) {
            return tmp;
        }
        return findImbalance(currNode.right);
    }

    public T smallestGreaterThan(T t) {
        // given some generic comparable value t, find the smallest value in the BST that is larger than t.
        if (root == null) { return null; }
        BinaryNode<T> currNode = root;

        while (true) {
            if (currNode.data.compareTo(t) <= 0) 
            {
                if (currNode.right == null) {
                    return null;
                }
                currNode = currNode.right;
            } 
            else if (currNode.data.compareTo(t) > 0) 
            {
                if (currNode.left == null || currNode.left.data.compareTo(t) <= 0) {
                    return currNode.data; 
                }         
                currNode = currNode.left;
            } 
        }
    }

    public BinarySearchTree<T> mirror() {
        // return a mirrored version of the BST instance to satisfy a reversed BST condition
        BetterBST<T> mirrorBST = new BetterBST<>();
        mirrorBST.root = swap(copy(root));
        return mirrorBST;
    }

    private BinaryNode<T> swap(BinaryNode<T> currNode) {
        if (currNode == null) {
            return null;
        }

        BinaryNode<T> tmp = currNode.left;
        currNode.left = swap(currNode.right);
        currNode.right = swap(tmp);

        return currNode;
    }

    private BinaryNode<T> copy(BinaryNode<T> node) {
        if (node == null) {
            return null;
        }
        BinaryNode<T> newNode = new BinaryNode<T>(node.data);
        newNode.left = copy(node.left);
        newNode.right = copy(node.right);
        return newNode;
    }
    

    public LinkedList<BinaryNode<T>> levelOrderTraversal() {
        // return a LinkedList<BinaryNode<T>> of a level order traversal of the binary tree
        LinkedList<BinaryNode<T>> result = new LinkedList<BinaryNode<T>>();
        if (root == null) return result;

        LinkedList<BinaryNode<T>> qu = new LinkedList<BinaryNode<T>>();
        qu.add(root);

        while (!qu.isEmpty()) {
            BinaryNode<T> currNode = qu.remove();
            qu.add(currNode.left);
            qu.add(currNode.right);
            result.add(currNode);
        }
        return result;
    }
}
