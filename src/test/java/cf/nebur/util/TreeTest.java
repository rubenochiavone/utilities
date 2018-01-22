package cf.nebur.util;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Random;

public abstract class TreeTest extends TestCase {

    protected abstract <T extends Comparable> Tree<T> createTree();

    @Test
    public void testIntegerGenericInsert() {
        // insert node 1
        Tree<Integer> tree = createTree();
        tree.insert(2)
                .insert(1)
                .insert(3)
                .insert(4);

        assertTrue(tree.search(1));
        assertTrue(tree.search(2));
        assertTrue(tree.search(3));
        assertTrue(tree.search(4));

        // insert node 2
        tree = createTree();
        tree.insert(5)
                .insert(2)
                .insert(18)
                .insert(-4)
                .insert(3);

        assertTrue(tree.search(5));
        assertTrue(tree.search(18));
        assertTrue(tree.search(2));
        assertTrue(tree.search(-4));
        assertTrue(tree.search(3));
    }

    @Test
    public void testIntegerGenericDelete() {
        // remove node without children [1]
        // [1] case 1
        Tree<Integer> tree = createTree();
        tree.insert(2);

        assertTrue(tree.search(2));

        tree.delete(2);

        assertFalse(tree.search(2));

        // [1] case 2
        tree = createTree();
        tree.insert(2)
                .insert(1);

        tree.delete(1);

        assertFalse(tree.search(1));
        assertTrue(tree.search(2));

        // [1] case 3
        tree = createTree();
        tree.insert(2)
                .insert(1)
                .insert(3);

        tree.delete(3);

        assertFalse(tree.search(3));
        assertTrue(tree.search(2));
        assertTrue(tree.search(1));

        // [1] case 4
        tree = createTree();
        tree.insert(5)
                .insert(2)
                .insert(18)
                .insert(-4)
                .insert(3);

        tree.delete(-4);

        assertFalse(tree.search(-4));
        assertTrue(tree.search(5));
        assertTrue(tree.search(2));
        assertTrue(tree.search(18));
        assertTrue(tree.search(3));

        // remove node with one child [2]
        // [2] case 1
        tree = createTree();
        tree.insert(2)
                .insert(1);

        tree.delete(2);

        assertFalse(tree.search(2));
        assertTrue(tree.search(1));

        // [2] case 2
        tree = createTree();
        tree.insert(5)
                .insert(2)
                .insert(18)
                .insert(3);

        tree.delete(2);

        assertFalse(tree.search(2));
        assertTrue(tree.search(5));
        assertTrue(tree.search(18));
        assertTrue(tree.search(3));

        // [2] case 3
        tree = createTree();
        tree.insert(5)
                .insert(2)
                .insert(18)
                .insert(3)
                .insert(-4)
                .insert(21)
                .insert(19)
                .insert(25);

        assertTrue(tree.search(18));

        tree.delete(18);

        assertFalse(tree.search(18));
        assertTrue(tree.search(5));
        assertTrue(tree.search(2));
        assertTrue(tree.search(-4));
        assertTrue(tree.search(3));
        assertTrue(tree.search(21));
        assertTrue(tree.search(19));
        assertTrue(tree.search(25));

        // remove node with two child [3]
        // [3] case 1
        tree = createTree();
        tree.insert(2)
                .insert(1)
                .insert(3);

        tree.delete(2);

        assertFalse(tree.search(2));
        assertTrue(tree.search(1));
        assertTrue(tree.search(3));

        // [3] case 2
        tree = createTree();
        tree.insert(5)
                .insert(2)
                .insert(12)
                .insert(-4)
                .insert(3)
                .insert(9)
                .insert(21)
                .insert(19)
                .insert(25);

        assertTrue(tree.search(12));

        tree.delete(12);

        assertFalse(tree.search(12));
        assertTrue(tree.search(5));
        assertTrue(tree.search(2));
        assertTrue(tree.search(-4));
        assertTrue(tree.search(3));
        assertTrue(tree.search(19));
        assertTrue(tree.search(25));
        assertTrue(tree.search(21));
    }

    @Test
    public void testIntegerGenericSearch() {
        Tree<Integer> tree = createTree();

        Random random = new Random();

        int n = 1000;
        int[] array = new int[n];
        int value;
        int head = 0;
        int farNode = -1;

        for (int i = 0; i < n; i++) {
            value = java.lang.Math.abs(random.nextInt());
            array[i] = value;
            tree.insert(value);
            if (i == 0) {
                head = value;
            } else if (i >= 989 && value != head) {
                farNode = value;
            }
        }

        assertFalse(farNode == -1);
        assertTrue(farNode != head);
        assertTrue(tree.search(head));
        assertTrue(tree.search(farNode));

        for (int i = 0; i < n; i++) {
            tree.delete(array[i]);
        }

        assertFalse(tree.search(head));
        assertFalse(tree.search(farNode));
    }

    @Test
    public void testIntegerGenericGet() {
        fail("TODO: test tree.get(n) method");
    }

    @Test
    public void testIntegerGenericRand() {
        fail("TODO: test tree.rand(object) method");
    }

    @Test
    public void testIntegerGenericHeight() {
        Tree<Integer> tree = createTree();

        assertEquals(0, tree.height());

        tree.insert(2)
                .insert(1)
                .insert(3)
                .insert(4);

        assertTrue(tree.search(1));
        assertTrue(tree.search(2));
        assertTrue(tree.search(3));
        assertTrue(tree.search(4));

        assertEquals(3, tree.height());

        //
        tree = createTree();

        assertEquals(0, tree.height());

        tree.insert(2);

        assertEquals(1, tree.height());

        tree.insert(1);

        assertEquals(2, tree.height());

        tree.insert(3);

        assertEquals(2, tree.height());

        tree.insert(4);

        assertEquals(3, tree.height());

        tree.delete(4);

        assertEquals(2, tree.height());

        tree.delete(3);

        assertEquals(2, tree.height());

        tree.delete(1);

        assertEquals(1, tree.height());

        tree.delete(2);

        assertEquals(0, tree.height());

        //
        tree = createTree();

        assertEquals(0, tree.height());

        tree.insert(5)
                .insert(2)
                .insert(12)
                .insert(-4)
                .insert(3)
                .insert(9)
                .insert(21)
                .insert(19)
                .insert(25);

        assertEquals(4, tree.height());
    }

    @Test
    public void testIntegerGenericFlatten() {
        Tree<Integer> tree = createTree();
        tree.insert(2)
                .insert(1)
                .insert(3)
                .insert(4);

        Integer[] array = tree.flatten(Integer.class);

        assertEquals(4, array.length);

        fail("TODO: check that array contains each node");
    }

    @Test
    public void testIntegerGenericIterator() {
        Tree<Integer> tree = createTree();
        tree.insert(2)
                .insert(1)
                .insert(3)
                .insert(4);

        for (Integer i : tree) {
            assertNotNull(i);
        }

        fail("TODO: check that iterator contains each value");
    }
}
