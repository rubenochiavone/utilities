package cf.nebur.util;

import java.util.Iterator;

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

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node<T> root;

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

    @Override
    public T get(int n) {
        // TODO: get(n)
        return null;
    }

    @Override
    public int rand(T object) {
        if (object == null) {
            throw new NullPointerException();
        }
        // TODO: rand(object)
        return 0;
    }

    @Override
    public int height() {
        // TODO: height()
        return -1;
    }

    @Override
    public T[] flatten() {
        // TODO: flatten()
        return (T[]) new Object[0];
    }

    @Override
    public Iterator<T> iterator() {
        // TODO: iterator()
        return null;
    }
}
