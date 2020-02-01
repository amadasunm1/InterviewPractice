package samples.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {
    BinaryTree binaryTree = new BinaryTree();

    @BeforeEach
    public void setUp() {
        for (Integer value: treeValues()) {
            binaryTree.insert(value);
        }
    }

    @Test
    public void insert() {
        binaryTree.insert(2);

        assertTrue(binaryTree.lookup(2));
        assertFalse(binaryTree.lookup(100));
    }

    private List<Integer> treeValues() {
        return List.of(12, 23, 4, 9, 10, 20);
    }
}
