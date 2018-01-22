package cf.nebur.util;

/**
 * Binary Search Tree (BST)
 * @param <T>
 * @author Ruben O. Chiavone
 */
public class BinarySearchTree<T extends Comparable> implements Tree<T> {

    private class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;
    }

    private Node<T> root;

    /**
     * Adds {@code object} into this tree,
     * while maintaining a balanced tree.
     *
     * <ul>
     *     <li>Time complexity: O(logn)</li>
     *     <li>Mutates structure: Yes</li>
     * </ul>
     *
     * @param object
     * @return mutated tree
     */
    @Override
    public Tree<T> insert(T object) {
        if (object == null) {
            throw new NullPointerException();
        }
        Node<T> node = new Node<>();
        node.value = object;
        node.left = null;
        node.right = null;

        root = insertNode(root, node);

        return this;
    }

    /**
     * Goes recursive deep inside the tree to insert
     * a new node
     *
     * @param parent
     * @param node
     * @return root node
     */
    private Node<T> insertNode(Node<T> parent, Node<T> node) {
        // if parent has no value use it
        if (parent == null) {
            // base case
            return node;
        }

        if (node.value.compareTo(parent.value) < 0) {
            // insert node in left
            parent.left = insertNode(parent.left, node);
        } else {
            // insert node in right
            parent.right = insertNode(parent.right, node);
        }

        return parent;
    }

    /**
     * Finds and deletes {@code object} from this tree,
     * while maintaining a balanced tree.
     *
     * <ul>
     *     <li>Time complexity: O(logn)</li>
     *     <li>Mutates structure: Yes</li>
     * </ul>
     *
     * @param object
     * @return mutated tree
     */
    @Override
    public Tree<T> delete(T object) {
        if (object == null) {
            throw new NullPointerException();
        }

        root = deleteNode(root, object);

        return this;
    }

    /**
     * Deletes a node with value {@code object} and
     * return a modified version of {@code parent}
     *
     * @param parent
     * @param object
     * @return
     */
    private Node<T> deleteNode(Node<T> parent, T object) {
        if (parent == null) {
            // base case
            return null;
        } else if (object.compareTo(parent.value) < 0) {
            // move deeper on the left side of the tree
            parent.left = deleteNode(parent.left, object);
        } else if (object.compareTo(parent.value) > 0) {
            // move deeper on the right side of the tree
            parent.right = deleteNode(parent.right, object);
        } else {
            // found it
            // node with only one child or no child
            if (parent.left == null) {
                return parent.right;
            } else if (parent.right == null) {
                return parent.left;
            }

            // node with two children: Get the smallest
            // in the right subtree
            Node<T> minValueNode = minValueNode(parent.right);

            // copy its content to this node
            parent.value = minValueNode.value;

            // delete it
            parent.right = deleteNode(parent.right, minValueNode.value);
        }

        return parent;
    }

    /**
     * Given a non-empty binary search tree, return the
     * node with minimum key value found in that tree.
     *
     * @param node
     * @return the node with minimum key value found in
     * that tree
     */
    private Node<T> minValueNode(Node<T> node) {
        Node<T> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * Determines if {@code object} is in tree
     *
     * <ul>
     *     <li>Time complexity: O(logn)</li>
     *     <li>Mutates structure: No</li>
     * </ul>
     *
     * @param object
     * @return {@code true} if {@code object} is in tree
     *      and {@code false} otherwise
     */
    @Override
    public boolean search(T object) {
        if (object == null) {
            throw new NullPointerException();
        }
        return findNode(object) != null;
    }

    /**
     * Finds the first node that is equals to
     * {@code object}
     *
     * @param object
     * @return the first node that is equals to
     * {@code object}
     */
    private Node<T> findNode(T object) {
        if (root == null) {
            // empty tree
            return null;
        }
        Node<T> node = root;
        while (object.compareTo(node.value) != 0) {
            if (object.compareTo(node.value) < 0) {
                // search node on left side
                node = node.left;
            } else {
                // search node on right side
                node = node.right;
            }
            if (node == null) {
                // unable to find it
                return null;
            }
        }
        return node;
    }

    /**
     * Selects the {@code n}th highest object
     *
     * <ul>
     *     <li>Time complexity: O(logn)</li>
     *     <li>Mutates structure: No</li>
     * </ul>
     *
     * @param n
     * @return the {@code n}th highest object
     *      or {@code null} if there is no such
     *      object
     */
    @Override
    public T get(int n) {
        // TODO: get(n)
        return null;
    }

    /**
     * Returns the number of nodes in this three
     * that are less than or {@code object}. {@code object}
     * does not have to appear in the tree.
     *
     * <ul>
     *     <li>Time complexity: O(logn)</li>
     *     <li>Mutates structure: No</li>
     * </ul>
     *
     * @param object
     *      random object
     * @return the number of nodes in this three
     * that are less than or {@code object}. {@code object}
     * does not have to appear in the tree.
     */
    @Override
    public int rand(T object) {
        if (object == null) {
            throw new NullPointerException();
        }
        // TODO: rand(object)
        return -1;
    }

    @Override
    public int height() {
        // TODO: height()
        return -1;
    }

    /**
     * Returns an array containing the nodes in sorted order
     *
     * <ul>
     *     <li>Time complexity: O(logn)</li>
     *     <li>Mutates structure: No</li>
     * </ul>
     *
     * @return an array containing the nodes in sorted order
     */
    @Override
    public T[] flatten() {
        // TODO: flatten()
        return (T[]) new Object[0];
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iterator();
    }

    private class Iterator implements java.util.Iterator<T> {

        /**
         * maps a tree node and whether it was checked or not
         */
        private HashTable<Node<T>, Boolean> checked = new HashTable<>();
        /**
         * maps a tree node to its parent
         */
        private HashTable<Node<T>, Node<T>> parents = new HashTable<>();
        private Node<T> node = root;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            try {
                return node.value;
            } finally {
                nextNode();
            }
        }

        private void nextNode() {
            // move to next node
            if (node.left != null && (!checked.containsKey(node.left) || !checked.get(node.left))) {
                parents.put(node.left, node);
                node = node.left;
            } else if (node.right != null && (!checked.containsKey(node.right) || !checked.get(node.right))) {
                parents.put(node.right, node);
                node = node.right;
            } else {
                // mark as checked
                checked.put(node, true);

                // return to parent to check other nodes
                node = parents.get(node);

                if (node != null) {
                    nextNode();
                }
            }
        }
    }
}
