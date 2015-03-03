package YAT;

import java.util.*;

public class ArrayListTreeNode<E> extends AbstractTreeNode<E>  {
    ArrayList<TreeNode<E>> children;
    public ArrayListTreeNode(E element) {
        this.data = element;
        this.children = new ArrayList<TreeNode<E>>();
        this.parent = null;
    }

    @Override
    public TreeNode<E> remove(E element) {
        for (TreeNode<E> item : getChilds()) {
            if (item.getValue() == element) {
                TreeNode<E> ans = item;
                this.children.remove(item);
                return ans;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public TreeNode<E> addChild(TreeNode<E> node) {
        // Найдем корень данного дерева
        TreeNode<E> tree_root = find_root(this);
        // Поищем добавляемый узел в дереве
        TreeNode<E> res = seachNodeFor(node.getValue());
        if (res != null)
            throw new UnsupportedOperationException("Cycle found");

        ArrayListTreeNode<E> element_node = (ArrayListTreeNode<E>)node;
        this.children.add(element_node);
        element_node.parent = this;
        return element_node;
    }

    @Override
    public Collection<TreeNode<E>> getChilds() {
        return new ArrayList<TreeNode<E>>(this.children);
    }

    @Override
    public TreeNode<E> addChild(E element) {
        // Проблем с зацикливанием нет так как данные могут повторяться
        ArrayListTreeNode<E> element_node = new ArrayListTreeNode(element);
        this.children.add(element_node);
        element_node.parent = this;
        return element_node;
    }


    @Override
    public Collection<TreeNode<E>> removeAll(E element) {
        ArrayList<TreeNode<E>> ans = new ArrayList<TreeNode<E>>();
        for (TreeNode<E> item: this.children){
            if (item.getValue() == element) {
                ans.add(item);
                this.children.remove(item);
            }
        }
        return ans;
    }

    @Override
    public Collection<TreeNode<E>> getNodesFor(E element) {
        ArrayList<TreeNode<E>> ans = new ArrayList<TreeNode<E>>();
        for (TreeNode<E> item: this.children){
            if (item.getValue() == element) {
                ans.add(item);
            }
        }
        return ans;
    }

    @Override
    public Collection<TreeNode<E>> seachNodesFor(E element) {
        ArrayList<TreeNode<E>> ans = new ArrayList<TreeNode<E>>();
        Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
        queue.add(this);
        while(!queue.isEmpty()){
            TreeNode<E> node = queue.remove();
            if (node.getValue() == element)
                ans.add(node);
            for (TreeNode<E> elem: node.getChilds()) {
                queue.add(elem);
            }
        }
        return ans;
    }

    private TreeNode<E> find_root(TreeNode<E> node){
        // Находим корень дерева
        TreeNode<E> curr = node;
        while (curr.getParent() != null)
            curr = curr.getParent();
        return curr;
    }
}
