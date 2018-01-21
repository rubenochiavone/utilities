package cf.nebur.util;

public class BinarySearchTreeTest extends TreeTest {

    @Override
    protected <T extends Comparable> Tree<T> createTree() {
        Tree<T> tree = new BinarySearchTree<>();
        return tree;
    }
}
