package cf.nebur.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({
        ArrayTest.class,
        DynamicArrayTest.class,
        SinglyLinkedListTest.class,
        DoubleLinkedListTest.class,
        HashTableTest.class,
        BinarySearchTreeTest.class
})
@RunWith(Suite.class)
public class DataStrucutreTestSuite {
}
