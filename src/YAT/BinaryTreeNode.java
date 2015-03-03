package YAT;

public class BinaryTreeNode<E> extends ArrayListTreeNode<E> {
    public BinaryTreeNode(E element) {
        super(element);
    }

    @Override
    public TreeNode<E> addChild(TreeNode<E> node) {
        if (this.getChilds().size() > 2)
            throw new UnsupportedOperationException();
        else
            return super.addChild(node);
    }

    @Override
    public TreeNode<E> addChild(E element) {
        if (this.getChilds().size() > 2)
            throw new UnsupportedOperationException();
        else
            return super.addChild(element);
    }
}
