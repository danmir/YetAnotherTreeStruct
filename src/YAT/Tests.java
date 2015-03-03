package YAT;

import java.util.ArrayList;

public class Tests {
    public static void main(String[] args) {
        ArrayListTreeNode<String> test_tree = new ArrayListTreeNode<String>("Root");
        test_tree.addChild("l1_1");
        test_tree.addChild("l1_2").addChild("l2_1").addChild("l3_1");

        ArrayListTreeNode<String> l2_tree = new ArrayListTreeNode<String>("l2_2");
        test_tree.getNodeFor("l1_1").addChild(l2_tree);

        ArrayListTreeNode<String> ans = (ArrayListTreeNode<String>)test_tree.seachNodeFor("l3_1");
        ArrayList<TreeNode<String>> full_ans = (ArrayList<TreeNode<String>>)test_tree.seachNodesFor("l2_1");

        // Тест на зацикливание
        test_tree.addChild(test_tree);

        System.out.print(test_tree.isRoot());
    }
}
