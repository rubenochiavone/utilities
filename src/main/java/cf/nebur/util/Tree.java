package cf.nebur.util;

/**
 * A tree is a data structure composed of parent and
 * child nodes.
 *
 * <p>
 *     Each node contains a value and a list of references
 *     to its child nodes. Trees borrow a lot of language
 *     from nature (each tree has a root node and leaf nodes)
 *     and from family trees (there are parent and child nodes).
 * </p>
 *
 * <p>
 *     <h2>Strengths</h2>
 *     <ul>
 *         <li>Trees are very memory-efficient and do not use more
 *         memory than they need to.</li>
 *         <li>Trees are more flexible than simple arrays because we
 *         can balance the tree (find the best organization for the
 *         expected use of the data).</li>
 *         <li>Trees can naturally grow to hold an arbitrary number of
 *         objects.</li>
 *         <li>By keeping the height of the tree small in a sorted tree,
 *         searches can be very fast (searches start at the root, and in
 *         a sorted tree and look at O(tree height) nodes when searching).</li>
 *         <li>The heirarchy of a tree is reflected in many problems we
 *         would try and model (such as representing a company heirarchy,
 *         or files on a computer, or breaking down expenses by categories
 *         followed by subcategories and line-items).</li>
 *         <li>Decision trees are a special type of tree used to model the
 *         effects of different choices. The nodes are the state of the system;
 *         a node Y is a child of X if it is possible to make a single decision
 *         from state X to transform to state Y. Decision trees are often used
 *         when analyizing strategy games, such as Chess.</li>
 *     </ul>
 *
 *     <h2>Weaknesses</h2>
 *     <ul>
 *         <li>Is harder to debug.</li>
 *         <li>Manipulations can require through understanding of recursion.</li>
 *         <li>Have to make decisions how to balance the data based on expected
 *         use case, and rearranging the tree completely (e.g. sorting on a
 *         different attribute) is expensive. For example, it wouldn't be the
 *         best data structure for storing information about people if you expected
 *         users to sort frequently by either name or age.</li>
 *     </ul>
 * </p>
 *
 * @param <T>
 * @author Ruben O. Chiavone
 * @see https://codefights.com/interview-practice/topics/trees-basic/tutorial
 */
public interface Tree<T extends Comparable> extends Iterable<T> {

    /**
     * Adds {@code object} into this tree,
     * while maintaining a balanced tree.
     *
     * @param object
     * @return mutated tree
     */
    Tree<T> insert(T object);

    /**
     * Finds and deletes {@code object} from this tree,
     * while maintaining a balanced tree.
     *
     * @param object
     * @return mutated tree
     */
    Tree<T> delete(T object);

    /**
     * Determines if {@code object} is in tree
     *
     * @param object
     * @return {@code true} if {@code object} is in tree
     *      and {@code false} otherwise
     */
    boolean search(T object);

    /**
     * Selects the {@code n}th highest object
     *
     * @param n
     * @return the {@code n}th highest object
     *      or {@code null} if there is no such
     *      object
     */
    T get(int n);

    /**
     * Returns the number of nodes in this three
     * that are less than or {@code object}. {@code object}
     * does not have to appear in the tree.
     *
     * @param object
     *      random object
     * @return the number of nodes in this three
     * that are less than or {@code object}. {@code object}
     * does not have to appear in the tree.
     */
    int rand(T object);

    /**
     * Returns the maximum level in this tree
     * (i.e. the level of the node furthest
     * from the root).
     *
     * @return the maximum level in this tree
     */
    int height();

    /**
     * Returns an array containing the nodes in sorted order
     *
     * @return an array containing the nodes in sorted order
     */
    T[] flatten();
}
