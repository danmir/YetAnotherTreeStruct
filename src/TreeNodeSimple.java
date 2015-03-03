import java.util.ArrayList;
import java.util.List;

public class TreeNodeSimple<T> {
    T data;
    private TreeNodeSimple parent;
    List<TreeNodeSimple> children = new ArrayList<TreeNodeSimple>();

    public TreeNodeSimple(T data){
        this.data = data;
    }

    public void add(TreeNodeSimple<T> child_node){
        child_node.parent = this;
        children.add(child_node);
        // Добавили ссылку на уровень выше и замкнули дерево ?
    }

    /**
     * Remove node by full compare
     * @param node
     * @return
     */
    public TreeNodeSimple remove(TreeNodeSimple<T> node){
        if (this.children.contains(node)) {
            int index_of_node = this.children.indexOf(node);
            TreeNodeSimple node_to_be_removed = this.children.get(index_of_node);
            node_to_be_removed.parent = null;
            this.children.remove(node_to_be_removed);
            return node;
        } else {
            return null;
        }
    }

    /**
     * Remove node by data in it
     * @param data
     * @return
     */
    public TreeNodeSimple remove(T data){
        for (TreeNodeSimple cur_node : this.children){
            if (cur_node.data == data){
                cur_node.parent = null;
                this.children.remove(cur_node);
                return cur_node;
            }
        }
        return null;
    }

    public boolean hasChild(TreeNodeSimple<T> node){
        if (this.children.contains(node)) {
            return true;
        } else {
            return false;
        }
    }

//    public boolean isLeaf(TreeNodeSimple<T> node){
//        for (TreeNodeSimple cur_node : node.children){
//    }

    public int depth(){
        int depth = recurseDepth(parent, 0);
        return depth;
    }

    private int recurseDepth (TreeNodeSimple node, int depth) {
        if (node == null){ // reached top of tree
            return depth;
        } else {
            return recurseDepth(node.parent, depth + 1);
        }
    }

    public boolean isRoot(){
        if (parent == null)
            return true;
        else
            return false;
    }

    public boolean search(TreeNodeSimple<T> node){ // ???
        boolean isFound = false;
        for (TreeNodeSimple cur_node : node.children){ // Go deeper from the children
            if (cur_node == node){
                isFound = true;
            } else if (cur_node != null) {
                search(cur_node);
            }
        }
        return isFound;
    }

    public List<TreeNodeSimple> getChildren(){
        return children;
    }

    public TreeNodeSimple getParent(){
        return parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNodeSimple)) return false;

        TreeNodeSimple treeNodeSimple = (TreeNodeSimple) o;

        if (!data.equals(treeNodeSimple.data)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
