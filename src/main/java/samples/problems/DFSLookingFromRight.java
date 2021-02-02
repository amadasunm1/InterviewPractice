/*    Binary Tree:

            1            <---
            /   \
            2     3         <---
            \
            5              <---


    You should return [1, 3, 5].


    Binary Tree:

            1            <---
            /   \
            2     3         <---
            /  \  /  \
            0  5  2   5     <---
            / \
            9  10

    You should return [1, 3, 5, 10].*/
package samples.problems;

import samples.util.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DFSLookingFromRight {

    public int depth = 0;
    public BinaryTree binaryTree;

    public DFSLookingFromRight(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

    private List<Integer> dfs(BinaryTree.Node node) {
        List<Integer> returnList = new ArrayList<>();
        returnList.add(node.getValue()); // {1, }
        returnList.addAll(lookupRight(node.getRight()));
        returnList.addAll(lookupLeft(node.getLeft()));

        return returnList;
    }

    private List<Integer> lookupRight(BinaryTree.Node node) {
        List<Integer> values = new ArrayList<>();

//        if(Objects.nonNull(node)){
//            if(node.right != null){
//                depth++;
//                values.add(node.right.value); //3 , 5
//                values.addAll(lookupRight(node.getRight()));
//            } else if(node.left != null){
//                values.addAll(lookupRight(node.getLeft()));
//            }
//        }

      return values;
    }

    private List<Integer> lookupLeft(BinaryTree.Node node) {
        List<Integer> values = new ArrayList<>();

//        if(node.depth > depth) {
//            node = node.getNodeAtDepth(depth);
//            values.addAll(lookupRight(node.getRight()));
//        }

        return values;
    }

}
