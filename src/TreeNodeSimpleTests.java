/**
 * Created by danmir on 23.02.15.
 */

public class TreeNodeSimpleTests {
    public static void main(String[] args) {
        TreeNodeSimple root = new TreeNodeSimple<String>("0");
        TreeNodeSimple l1 = new TreeNodeSimple<String>("1");
        TreeNodeSimple l2 = new TreeNodeSimple<String>("2");

        root.add(l1);
        l1.add(l2);

        // root.remove(l1);

        boolean a = root.isRoot();
        boolean b = l2.isRoot();

        int d1 = root.depth();
        int d2 = l2.depth();
        int d3 = l1.depth();

        boolean ans = root.search(l1);
    }
}
