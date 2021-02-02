package samples.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Getter
public class BinaryTree {
    private Node root;

    @Getter
    @Setter
    @Builder
    public static class Node {
        private int value;
        private Node left;
        private Node right;
    }

    public BinaryTree() {
        this.root = null;
    }

    /* Lookup operations */
    public boolean lookup(int value) {
        return lookup(this.root, value);
    }

    private boolean lookup(Node root, int value) {
        if(Objects.isNull(root))
            return false;

        if(root.value == value) {
            return true;
        } else {
            if(root.value > value){
                return lookup(root.left, value);
            }

            return lookup(root.right, value);
        }
    }

    /* Insert Operations */
    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    private Node insert(Node node, int value) {

        if (Objects.isNull(node)){
            // Create new node
            log.info("Creating new node with value: {}", value);
            node = Node.builder().value(value).build();
        } else {
            log.info("Current node value: {}", node.value);

            // Insert to left of node
            if (node.value > value) {
                log.info("Inserting to the left of current node...");
                node.left = insert(node.left, value);
            }

            // Insert to right of node
            if (node.value < value) {
                log.info("Inserting to the right of current node...");
                node.right = insert(node.right, value);
            }
        }

        return node;
    }
}
